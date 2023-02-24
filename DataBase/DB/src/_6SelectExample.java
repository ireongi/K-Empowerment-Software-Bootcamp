
import java.sql.*;

public class _6SelectExample {

    public static void main(String[] args) {
        System.out.println("--- JDBC Start ---\n");

        Connection conn = null;
        Statement stmt = null;
        ResultSet srs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "bookdb?useSSL=" + "false&serverTimeZone=Asia/Seoul",
                    "root", "mysql123");

            if (conn != null){
                System.out.println("[DB 연결 완료]");
                stmt = conn.createStatement();
                stmt.executeUpdate("Insert into book(id, title, publisher, author)" +  "values(3, 'What Men Live By', 'Do not Know', 'Leo Tolstoy');");
                System.out.println("[책 추가]");
                printData(stmt);

                srs = stmt.executeQuery("select * from book where id = 1");
                System.out.println("\n[책 찾기]");
                printDataFind(srs, "id", "title", "publicher", "author");

                stmt.executeUpdate("Delete from book where id = 3;");
                System.out.println("\n[책 삭제]");
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
            System.out.println(String.format("%5d | %-30s| %-20s| %s", srs.getInt("id"), srs.getString("title"), srs.getString("publisher"), srs.getString("author")));
        }
    }

    private  static void printDataFind(ResultSet srsF, String id, String title, String publisher, String author) throws SQLException {
        while (srsF.next()) {
            System.out.println(String.format("%5d | %-30s| %-20s| %s", srsF.getInt("id"), srsF.getString("title"), srsF.getString("publisher"), srsF.getString("author")));
        }
    }
}