package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


/**
 *
 * @author Ghani
 */
@WebServlet(urlPatterns = {"/contact"})
public class EmailController extends HttpServlet {



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
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String messageBody = request.getParameter("message");
        try {
            Properties props = new Properties();
            props.put("smtp.gmail.com", "www.google.ca");
            Session session = Session.getDefaultInstance(props);
            Message message = new MimeMessage(session);
            message.setSubject(subject);
            message.setText(messageBody);
            Address fromAddress = new InternetAddress("fazianehad@gmail.com");
            Address toAddress = new InternetAddress(email);
            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            Transport.send(message);
        } catch (MessagingException e) {
            log(e.toString());
        }
        getServletContext().getRequestDispatcher("/student_list.jsp").forward(request, response);
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
