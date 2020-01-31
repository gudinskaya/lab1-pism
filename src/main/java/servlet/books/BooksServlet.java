package servlet.books;

import dao.*;
import dao.impl.BookImpl;
import entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private BookImpl impl;
    private static String Index = "/books.jsp";

    public void init(ServletConfig servletConfig) {
        try {
            BookDAO CL = new BookDAO();
            impl = new BookImpl(CL);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            //response.setContentType("text/html;charset=utf-8");
            List<Book> books = impl.getBooks();
            req.setAttribute("books", books);
            RequestDispatcher dispatcher = req.getRequestDispatcher(Index);
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String book_type = request.getParameter("book_type");

            Book book = new Book(title, author, book_type);
            impl.addBooks(book);
            response.sendRedirect("books");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
