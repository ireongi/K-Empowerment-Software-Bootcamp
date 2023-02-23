
import java.sql.*;

public class _5InsertExample {

    public static void main(String[] args) {
        System.out.println("--- JDBC Start ---\n");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "bookdb?useSSL=" + "false&serverTimeZone=Asia/Seoul",
                    "root", "dngngnt010");

            if (conn != null){
                System.out.println("[DB 연결 완료]");
                stmt = conn.createStatement();
//                stmt.executeUpdate("Insert into book(id, title, publisher, author)" +  "values(0, 'Harry Potter', 'Bloomsbury', 'J. K. Rowling');");
//                stmt.executeUpdate("Insert into book(id, title, publisher, author)" +  "values(1, 'The Lord of the Ring', 'Allen & Unwin', 'J. R. R.Tolkein');");
//                stmt.executeUpdate("Insert into book(id, title, publisher, author)" +  "values(2, 'Pride and Prejudice', 'T Egerton Kingdom', 'Jane Austin');");
                printData(stmt);
            }
        } catch (ClassNotFoundException e) {System.out.println("[JDBC 드라이버 로드 오류]");
        } catch (SQLException e) {System.out.println("[DB 연결 오류]");}

        finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {System.out.println(e.getMessage());}
        }
    }
    private  static void printData(Statement pstmt) throws SQLException {
        ResultSet srs = pstmt.executeQuery("select * from book");
        while (srs.next()) {
            System.out.print(srs.getInt("id"));
            System.out.print(" | " + srs.getString("title"));
            System.out.print(" | " + srs.getString("publisher"));
            System.out.println(" | " + srs.getString("author"));
        }
    }
}