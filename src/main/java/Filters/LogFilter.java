package Filters;// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class
public class LogFilter implements Filter  {

    /**
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config)
            throws ServletException {
        // Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    /**
     *
     * Funcio que fa de filtre per si l'email existeix avançar a fileupload.
     *
     * @param request
     * @param response
     * @param chain
     * @throws java.io.IOException
     * @throws ServletException
     */
    public void  doFilter(ServletRequest request,
                          ServletResponse response,
                          FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        if(session.getAttribute("email") != null){

            servletResponse.sendRedirect("fileupload.jsp");
            return;

        }else{
            chain.doFilter(request,response);
        }

    }

    public void destroy() {

    }

}