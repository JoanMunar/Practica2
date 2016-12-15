package Logs;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LogOut extends HttpServlet {
    public void init(){

    }

    /**
     *
     * Funcio que fa posible la redirecció a la pagina principal.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().invalidate();
        response.sendRedirect("index.jsp");

    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}