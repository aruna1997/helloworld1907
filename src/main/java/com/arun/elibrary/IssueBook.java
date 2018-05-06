/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arun.elibrary;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ravi Verma
 */
@WebServlet(name = "IssueBook", urlPatterns = {"/issuebook"})
public class IssueBook extends HttpServlet {
              Integer bid= null;
          Integer sid = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String button = request.getParameter("button");
        if(button.equals("searchbook")) {
            bid =searchBook(request,response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       HttpSession session = request.getSession(true);
       
      // if(session.isNew() || session.getAttribute("lemail")==null) {
      //    response.sendRedirect("librarian");
      // } else {
           RequestDispatcher nav= request.getRequestDispatcher("/navlibrarian.html");
           RequestDispatcher form = request.getRequestDispatcher("issuebookform.html");
           String email = (String)session.getAttribute("lemail");
           //LibrarianBean librarian = LibrarianDao.getLibrarianDetails(email);
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
          // out.println("<title>"+librarian.getName()+"</title>");            
           out.println("</head>");
           out.println("<body>");
           //nav.include(request, response);
          // out.println("<h1>Hi "+librarian.getName()+"</h1>");
          // form.include(request, response);

          out.println(
          "<h1>Issue Book</h1>"+
"<form action=\"\" method=\"post\">"+
    "<input type =\"number\" name=\"bookid\" value=\""+bid+ "\" readonly/> "+
    "<button type=\"submit\" value=\"searchbook\" name=\"button\" > Search Book </button>"+
    "<br />"+
    "<input type=\"number\" name =\"studentid\" readonly />"+
    "<input type=\"button\" value=\"Search Student\" />"+
    
"</form>"
            );
           out.println("<form action =\"\" method=\"post\" >");
           out.println("<input type =\"hidden\" name=\"type\" value=\"logoutform\" />");
           out.println("<input type=\"submit\" value=\"Logout\" />");
           out.println("</form>");
           out.println("</body>");
           out.println("</html>");
       //}
    }

    private Integer searchBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookid=0;
            PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<script type=\"text/javascript\">");
    out.println("var popwin = window.open(\"searchbook\")");
    out.println("setTimeout(function(){ popwin.close(); window.location.href='';},5000)");
    out.println("</script>");
        return bookid;
    }
    
    
}