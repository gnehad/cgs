<%-- 
    Document   : contact
    Created on : 2022-08-30, 23:44:02
    Author     : Ghani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulaire de contact</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
  </head>
  <body>
    <form action="contact" method="post">
      <fieldset>
        <legend>Formulaire de contact</legend>
        <div>
          <label for="email">Courriel :</label>
          <input name="email" type="email" required>
        </div>
        <div>
          <label for="object">Objet :</label>
          <input name="subject" type="text" required>
        </div
        <div>
          <label for="message">Message:</label>
          <textarea cols="50" rows="10" name="message"></textarea> 
        </div>
        <div>
          <input name="send" type="submit" value="Send">
        </div>
      </fieldset>
    </form>
  </body>
</html>
