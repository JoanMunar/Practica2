<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.BufferedReader" %>

<html>
    <head>
        <title>File Uploading Form</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        <br/>
        <P>ERROR EN EL EMAIL O LA CONSTRASENYA, TORNA-HO A PROVAR</p>
        <form action="Logs.LogIn" method="POST">
            <p>Email:</p>
            <input type="email" name="email">
            <br/>
            <p>Password:</p>
            <input type="password" name="password">
            <input type="checkbox" name="box" value="cookie">
            Remember me
            <br/>
            <input type="submit">
        </form>


    </body>
</html>
