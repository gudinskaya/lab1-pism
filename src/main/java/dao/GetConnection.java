package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    private static boolean shouldInitDB = true;
	public static Connection getConnect() throws SQLException {
        final String db_driver = "org.postgresql.Driver";
        final String url = "jdbc:postgresql://localhost:5432/books";
        final String username = "admin";
        final String password = "admin";

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());// 1
            Class.forName(db_driver); //1
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }

        final Connection conn = DriverManager.getConnection(url, username, password);

        if (conn.isClosed()) {
            System.out.println("Соединение с БД закрыто");
        }

        if (shouldInitDB) {
            shouldInitDB = false;
            conn.prepareStatement("DROP TABLE IF EXISTS \"books\";").execute();
            conn.prepareStatement("CREATE TABLE \"books\" (" +
                "id bigserial NOT NULL," +
                "title varchar (255) NOT NULL, " +
                "author varchar (255) NOT NULL, " +
                "book_type varchar (255) NOT NULL " +
            ");").execute();
            
            conn.prepareStatement("INSERT INTO books(author, title, book_type) VALUES " +
                "('Stephen King', 'Кэрри', 'novel')," +
                "('Stephen King1', 'Жребий Салема', 'novel')," +
                "('Stephen King2', 'Сияние', 'novel')," +
                "('Stephen King3', 'Ярость', 'novel')," +
                "('Stephen King4', 'Противостояние', 'novel')," +
                "('Stephen King5', 'Серая дрянь', 'novel')," +
                "('Stephen King6', 'Женщина в палате', 'novel')," +
                "('Stephen King7', 'Мясорубка', 'novel')," +
                "('Stephen King8', 'На посошок', 'novel')," +
                "('Stephen King9', 'Ночной прибой', 'novel')," +
                "('Stephen King9', 'Последняя перекладина', 'novel')").execute();
        }
        return conn;
    }
}
