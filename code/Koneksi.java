import java.sql.*;

public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/dne_devs";
    private static final String USER = "root";
    private static final String PASS = "";   

    public static Connection getKoneksi() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}