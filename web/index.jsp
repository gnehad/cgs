<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="main.css" type="text/css"/>
    </head>
    <body>
        <h1>Connexion au CGS</h1>
        <form action="login" method="post">
        <label>Identifiant : </label>
        <input type="text" name="login" required><br>
        
        <label>Mot de passe :</label>
        <input type="password" name="pwd" required><br>

        <label>&nbsp;</label>
        <input type="submit" value="Se connecter" id="submit">
            
        </form>
        <p>
            ${param["message"]}
        </p>
        
    </body>
</html>
