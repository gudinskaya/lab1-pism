package entity;

public class Book {

    private int id;
    private String title;
    private String author;
    private String book_type;


    public Book(int id, String title, String author, String book_type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.book_type = book_type;
    }
    public Book(String title, String author, String book_type) {
        this.title = title;
        this.author = author;
        this.book_type = book_type;
    }
    public Book() {}

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return book_type;
    }

    public void setBookType(String book_type) {
        this.book_type = book_type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title +
                ", author=" + author +
                ", type=" + book_type +
                '}';
    }
}
