<html>
    <head>
        <title>File Upload</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        <form action="Servlet.UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="file" size="50" />
            <br />
            <br />
            <input type="submit" value="Upload File" />
        </form>

        <%-- Sortir de la sessio --%>
        <a href="Logs.LogOut">Log Out</a>
        <%-- Veure els arxius --%>
        <a href="Servlet.Files">Consultar arxius</a>

    </body>
</html>