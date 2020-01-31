package dao;

import entity.Book;
import interfaces.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends Book implements DAO<Book> {
    enum sql {
        Get("SELECT id, title, author, book_type FROM public.books ORDER BY id"),
        Insert("INSERT INTO books (title, author, book_type) VALUES (?, ?, ?)"),
        Update("UPDATE books SET title = ?, author = ?, book_type = ? WHERE id = ?"),
        DeleteByID("DELETE FROM books WHERE id = ?");

        String query;
        sql(String query) {this.query = query;}
    }

    @Override
    public void create(final Book book) {
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(sql.Insert.query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getBookType());
            statement.executeQuery();
            System.out.println("Добавлена книга");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> read() {
        Book result = new Book();
        List<Book> list = new ArrayList<Book>();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(sql.Get.query)){
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("book_type"));
                list.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void update(Integer id, Book book) {
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(sql.Update.query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getBookType());
            statement.setInt(4, id);
            statement.execute();
            System.out.println("Изменено значение у книги   id=[" + id + "]");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(sql.DeleteByID.query)){
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Запись с id " + id + " была удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
