package com.lab2_1;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Alineah", urlPatterns = {"/Alineah"})

public class Alineah extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        if (username == null) {
            throw new NullPointerException("No Parameters, Username not found!");
        } else{
            try {
                // Write some content
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Alineah</title>");
                out.println("</head>");
                out.println("<body>");
                out.println(" Hi " + username + "!<br>");
    
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }   
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse res)
    throws IOException, ServletException
    {
        doGet(request, res);
    }
}
