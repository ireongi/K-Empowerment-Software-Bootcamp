import java.sql.*;

public class _7AsExample {
    public static void main(String[] args) {
        System.out.println("--- JDBC Start ---\n");

        Connection conn = null;
        Statement stmt = null;
        ResultSet srs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "malldb?useSSL=" + "false&serverTimeZone=Asia/Seoul",
                    "root", "mysql123");

            if (conn != null){
                System.out.println("[DB 연결 완료]");
                stmt = conn.createStatement();

//                stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('10004', '에어팟', '300000', 'AP')" );
//                stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('10005', '아이맥', '3000000', 'AP')" );
//                stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('10006', '비스포크', '8000000', 'SS')" );
//                stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('10007', '드라이기', '700000', 'DS')" );
//                stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('10008', '그램', '1500000', 'LG')" );
//                stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('10009', '청소기', '400000', 'DE')" );

                System.out.println("[Insert]");
                printData(stmt);

                System.out.println("[Select]");
                srs = stmt.executeQuery("select * from goodsinfo");
                printDataSelect(srs);

                System.out.println("[Sum]");
                srs = stmt.executeQuery("select maker, sum(price) as sum_price from goodsinfo group by maker");
                printDataConditions(srs, "maker", "sum_price");

                System.out.println("[Avg]");
                srs = stmt.executeQuery("select maker, avg(price) as avg_price from goodsinfo group by maker having avg(price)>=300000");
                printDataConditions(srs, "maker", "avg_price");



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
        ResultSet srs = pstmt.executeQuery("select * from goodsinfo");
        while (srs.next()) {
            System.out.println(String.format("%5s | %-8s| %-10s| %s", srs.getString("code"), srs.getString("name"), srs.getString("price"), srs.getString("maker")));
        }
    }

    private  static void printDataSelect(ResultSet srs) throws SQLException {
        while (srs.next()) {
            System.out.println(String.format("%5s | %-8s| %-10s| %s", srs.getString("code"), srs.getString("name"), srs.getString("price"), srs.getString("maker")));
        }
    }

    private  static void printDataConditions(ResultSet srs, String maker, String result) throws SQLException {
        while (srs.next()) {
            System.out.println(String.format("%5s | %-8d", srs.getString(maker), srs.getInt(result)));
        }
    }


}
