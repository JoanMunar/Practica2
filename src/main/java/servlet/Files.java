package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Files extends HttpServlet {

    private String filePath;
    private boolean primeraSessio = true;


    /**
     * Obtenim la ruta on es troba l'arxiu
     */
    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    /**
     *
     * Funcio NO finalitzada, falta crear la carpeta d'usuari i que ens mostri l'arxiu.
     * Ara tan sols mostra la ruta fins la "suposta" carpeta on l'usuari te pujat l'arxiu.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessio =  request.getSession();
        String email = (String) sessio.getAttribute("email");
        int arroba = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@'){
                arroba = i;
            }
        }

        email = email.substring(0,arroba);

        if (primeraSessio == true){

            primeraSessio = false;

            filePath += email + "/";

        }
        File file = new File(filePath);
        File[] files = file.listFiles();

        //Part a mitges...
        if (files != null) {
            for (int i = 0; i < files.length; i++) {

                if (request.getParameterMap().containsKey("delete")){
                    if (Integer.parseInt(request.getParameter("delete")) == i ){
                        files[i].delete();
                        response.sendRedirect("servlet.Files");
                        break;
                    }
                }

            }
        }

        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Els teus arxius";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                        file
        );
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}