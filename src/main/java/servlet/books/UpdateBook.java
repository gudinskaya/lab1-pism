package servlet.books;

import dao.*;
import dao.impl.BookImpl;
import entity.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateBook")
public class UpdateBook  extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (request.getParameter("id") != null && request.getParameter("author") != null &&
                    request.getParameter("book_type") != null &&
                    request.getParameter("title") != null) {

                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");

                Integer id = Integer.parseInt(request.getParameter("id"));
                String author = request.getParameter("author");
                String book_type = request.getParameter("book_type");
                String title = request.getParameter("title");

                Book cr = new Book(id, title, author, book_type);
                impl.updateBooks(id, cr);
                response.sendRedirect("books");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
