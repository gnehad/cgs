<%-- 
    Document   : erreur
    Created on : 2022-08-30, 21:55:39
    Author     : Ghani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Erreur!</title>
  </head>
  <body>
    <h1>L'erreur suivante s'est produite</h1>
    <!--Mettre ici un système de choix pour les messages d'erreur-->
    <p>${message}</p>
    <p><a href="/student">Retourner à la page de gestion des étudiants</a></p>
    <p><a href="/logout">Se déconnecter</a></p>
  </body>
</html>
