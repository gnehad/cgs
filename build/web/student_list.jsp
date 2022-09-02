<!DOCTYPE html>
<%@taglib prefix="cgs" uri="WEB-INF/tlds/cgs.tld" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>Gestion des étudiants</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${studentlist.size() == 0}">
                
              <!--inclusion d'un formulaire d'ajout d'un étudiant avec include-->
              <!--Ou bien redirection vers le formulaire d'ajout d'un nouvel étudiant-->
              <h1>Ajout d'un nouvel étudiant</h1>
              <%@include file="/WEB-INF/jspf/add_form.jspf"%>
            </c:when>
            <c:otherwise>
                <h1>Liste des étudiants inscrits</h1>
                <table>
                    <tr>
                        <th>Numéro étudiant</th>
                        <th>Nom</th>
                        <th>Prénom</th> 
                        <th>Adresse</th> 
                        <th>Ville</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${studentlist}" var="student">
                     <tr>
                         <td><c:out value="${student.studentID}"/></td>
                         <td><c:out value="${student.lastName}"/></td>
                         <td><c:out value="${student.firstName}"/></td>
                         <td><c:out value="${student.address}"/></td>
                         <td><c:out value="${student.city}"/></td>
                         <td>
                             <!--On définit une variable id qui contiendra l'ID de l'étudiant à transmettre en paramètre à l'URL de la servlet student-->
                             <a href="<c:url value='student?action=update&id=${student.studentID}'/>">Modifier</a><br/>
                             <a href="<c:url value='student?action=contact&email=nehadghani@gmail.com'/>">Contacter</a><br/>
                             <a href="<c:url value='student?action=delete&id=${student.studentID}'/>">Supprimer</a>
                         </td>
                     </tr>
                    </c:forEach>
                </table>
                <p><a href="/student?action=add">Ajouter un étudiant</a></p>
            </c:otherwise>
        </c:choose>
        <!--Mettre en place ici un menu de navigation-->

        <p><a href="#">Retourner à l'écran d'accueil du système CGS</a></p>
        <p><a href="/logout">Se déconnecter</a></p>
        <p>Date de la dernière modification<cgs:CurrentDate/>, à <cgs:CurrentTime/></p>               
    </body>
</html>
