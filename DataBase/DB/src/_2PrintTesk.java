import java.sql.*;

public class _2PrintTesk {
    public static void main(String[] args) {
        System.out.println("JDBC Start");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "malldb?useSSL=" + "false&serverTimeZone=Asia/Seoul",
                    "root", "mysql123");

            if (conn != null){
                System.out.println("DB 연결 완료\n");
                stmt = conn.createStatement();
                ResultSet srs1 = stmt.executeQuery("select * from userTbl");
                printData1(srs1, "userID", "name", "birthYear", "addr", "mobile1", "mobile2", "height", "mDate");
                ResultSet srs2 = stmt.executeQuery("select * from buyTbl");
                printData2(srs2, "num", "userID", "prodName", "groupName", "price", "amount");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
        }
        finally {
            try
            {
                stmt.close();
                conn.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    private  static void printData1(ResultSet srs, String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8) throws SQLException {
        System.out.println("[UserTb1]");
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print("\t" + srs.getString("userID"));
            if (!col2.equals(""))
                System.out.print(" | " + srs.getString("name"));
            if (!col3.equals(""))
                System.out.print(" | " + srs.getInt("birthYear"));
            if (!col4.equals(""))
                System.out.print(" | " + srs.getString("addr"));
            if (!col5.equals(""))
                System.out.print(" | " + srs.getString("mobile1"));
            if (!col6.equals(""))
                System.out.print(" | " + srs.getString("mobile2"));
            if (!col7.equals(""))
                System.out.print(" | " + srs.getInt("height"));
            if (!col8.equals(""))
                System.out.println(" | " + srs.getString("mDate"));
            else
                System.out.println();
            System.out.println();
        }//end of while(rs.next() )
        System.out.println();
    }

        private  static void printData2(ResultSet srs, String col1, String col2, String col3, String col4, String col5, String col6) throws SQLException {
            System.out.println("[BuyTb1]");
            while (srs.next()) {
                if (!col1.equals(""))
                    System.out.print("\t" + srs.getInt("num"));
                if (!col2.equals(""))
                    System.out.print(" | " + srs.getString("userID"));
                if (!col3.equals(""))
                    System.out.print(" | "+ srs.getString("prodName"));
                if (!col4.equals(""))
                    System.out.print(" | "+srs.getString("groupName"));
                if (!col5.equals(""))
                    System.out.print(" | "+ srs.getInt("price"));
                if (!col6.equals(""))
                    System.out.println(" | "+ srs.getInt("amount"));
                else
                    System.out.println();
                System.out.println();
            }
    }
}