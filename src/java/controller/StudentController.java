package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoimp.StudentDaoImp;
import java.util.List;
import java.util.ArrayList;
import model.Student;
/**
 *
 * @author Ghani
 */
@WebServlet(name = "StudentController", urlPatterns = {"/student"})
public class StudentController extends HttpServlet {
    private StudentDaoImp studentDaoImp;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init(){
        studentDaoImp = new StudentDaoImp();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            List<Student> studentList = null;
            /**
             * La servelet aura un comportement différent selon l'action qui figure dans l'URL
             * Par défaut (action == null) affichage de la liste des étudiant
             * action = modify : modification d'un étudiant (le rechercher avant)
             * action = delete : suppression d'un étudiant
             * Ne pas oublier de gérer les erreurs pour le paramètre action de l'URL : une valeur autre que add, modify et delete
             * L'ajout d'un étudiant se fait via un formulaire : méthode POST
             */
            String action = request.getParameter("action");
            String id = request.getParameter("id");
            String url="/student_list.jsp";
            String erreur = "Action non définie";
            String email = request.getParameter("email");
            if(action == null){
                //On affiche la liste des étudiants
                studentList = studentDaoImp.findAll();
                request.setAttribute("studentlist", studentList);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }else if(action.equals("delete") || action.equals("update")){
                request.setAttribute("action", action);
                int studentID = 0;
                try{
                    studentID = Integer.parseInt(id);
                }catch(NumberFormatException e){
                   //On cas d'exception, on affiche un message d'erreur
                   erreur = "L'identifiant \"" + id + "\" n'est pas au format numérique";
                   request.setAttribute("message", erreur);
                   url = "/erreur.jsp";
                   //Il est impératif de forwarder ici car l'exception arrête tout
                   request.getServletContext().getRequestDispatcher(url).forward(request, response);
                }
                if(action.equals("delete")){
                    /*
                    * Ici, il faut vérifier s'il existe des lignes dans la table Result qui font référence
                    * à l'étudiant à supprimer et les supprimer le cas échéant
                    * Pour le moment, la table Result est vide et sa DAO n'a pas encore été implémentée
                    
                    */
                    studentDaoImp.delete(studentID);
                    //On met à jour la vue de la liste des étudiants
                    studentList = studentDaoImp.findAll();
                    request.setAttribute("studentlist", studentList);
                    url = "/student_list.jsp";
                    request.getServletContext().getRequestDispatcher(url).forward(request, response);
                }else{
               
                    /*
                    * Ici, il faut vérifier s'il existe des lignes dans la table Result qui font référence
                    * à l'étudiant à mettre à jour et les mettre à jour le cas échéant
                    */
                    
                    /*
                    * Ici, on doit d'abord vérifier que l'étudiant existe avant de faire la mise à jour
                    */
                    Student student = studentDaoImp.findById(studentID);
                    if(student == null){
                        erreur = "L'étudiant que vous essayer de modifier n'existe pas dans notre système";
                        request.setAttribute("message", erreur);
                        url = "/erreur.jsp";
                    }else{
                        /*
                        * On transmet l'étudiant à modifier à la JSP update.jsp
                        */
                        request.setAttribute("student", student);
                        url = "/update.jsp";
                        request.getServletContext().getRequestDispatcher(url).forward(request, response);
                    }
                }
                //request.setAttribute("id", id);
                //url = "/test.jsp";
                
            }else if(action.equals("contact") && email != null){
                 request.setAttribute("email", id);
                 url="/contact.jsp";
            }
            else{
                //Ici c'est un cas d'erreur. La servlet a été appelé avec une valeur erronée pour le paramètre action
                request.setAttribute("message", erreur);
                url = "/erreur.jsp";
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            //request.getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
