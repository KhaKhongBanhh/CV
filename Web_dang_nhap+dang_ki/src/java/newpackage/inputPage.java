/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

//inputPage
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name="inputPage", urlPatterns={"/inputPage"})
public class inputPage extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inputPage</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inputPage at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static String registerOfUsername = "";
    public static String registerOfPassword = "";
    public static String registerOfPassword1 = "";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        registerOfUsername = request.getParameter("registerOfUsername");
        registerOfPassword = request.getParameter("registerOfPassword");
        registerOfPassword1 = request.getParameter("registerOfPassword1");

        String warning = "";
        boolean check = true;
        boolean result = registerOfPassword.equals(registerOfPassword1);

        if (registerOfUsername == null || registerOfUsername.isEmpty())
            warning = "Hãy nhập tên đăng nhập";
        else if (registerOfPassword == null || registerOfPassword.isEmpty())
            warning = "Hãy nhập mật khẩu";
        else if (registerOfPassword1 == null || registerOfPassword1.isEmpty())
            warning = "Hãy nhập lại mật khẩu";
        else if (result == false && !registerOfPassword1.equals(""))
            warning = "Mật khẩu không khớp, vui lòng nhập lại";
        else if (result && !registerOfPassword1.equals(""))
            check = false;
    
        if (check) {
            request.setAttribute("notification", warning);
            request.getRequestDispatcher("registerPage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("inputJsp.jsp").forward(request, response);
        }
    }


    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
    
    public static String username = "";
    public static String password = "";
    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        username = request.getParameter("username");
        password = request.getParameter("password");
        
        String warning = "" ;
        boolean check = true;
        
        if(username == null || username.isEmpty())
            warning = "Tên đăng nhập không được để trống";
        else if(password == null || password.isEmpty())
            warning = "Mật khẩu không được để trống";
        else if( !username.equals(registerOfUsername) )
            warning = "Tên đăng nhập hoặc mật khẩu không đúng";
        else if( !password.equals(registerOfPassword))
            warning = "Tên đăng nhập hoặc mật khẩu không đúng";
        
        if(warning == null || warning.isEmpty()){
            PrintWriter out = response.getWriter();
            out.println("Dang nhap thanh cong !!");
        } else {
            request.setAttribute("notification", warning);
            request.getRequestDispatcher("inputJsp.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
