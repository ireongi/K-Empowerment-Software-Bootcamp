// Java에서 MySQL에 코드 추가하기
import java.sql.*;

public class _4UpdateExample {

    public static void main(String[] args) {
        System.out.println("--- JDBC Start ---\n");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "sampledb?useSSL=" + "false&serverTimeZone=Asia/Seoul",
                    "root", "dngngnt010");
            if (conn != null){
                System.out.println("[DB 연결 완료]");
                stmt = conn.createStatement();
                printData(stmt);

                stmt.executeUpdate("Insert into student(name, id, dept) " +  "values('유재석', '0000000', '연극영화과');"); // Insert : MySQL 데이터 추가
                System.out.println("\n[레코드 삽입 후]");
                printData(stmt);

                System.out.println("\n[업데이트 후]");
                stmt.executeUpdate("Update student set dept= '체육학과'" + "where id = '3333333';"); // Update : MySQL 데이터 변경
                printData(stmt);

                System.out.println("\n[삭제 후]");
                stmt.executeUpdate("Delete from student where id = '0000000';"); // Delete : MySQL 데이터 삭제
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
        ResultSet srs = pstmt.executeQuery("select * from student");
        while (srs.next()) {
                System.out.print(srs.getString("name"));
                System.out.print(" | " + srs.getString("id"));
                System.out.println(" | " + srs.getString("dept"));
        }
    }
}