package servlet.books;

import dao.*;
import dao.impl.BookImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private BookImpl impl;
    final static String Index = "/books.jsp";

    public void init(ServletConfig servletConfig) {
        try {
            BookDAO CD = new BookDAO();
            impl = new BookImpl(CD);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(request.getParameter("id"));
            impl.deleteBooks(id);
            response.sendRedirect("books");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
