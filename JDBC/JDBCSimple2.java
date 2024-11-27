import java.sql.*;
class JDBCSimple2 {
    public static void main(String[] args) {
        String u_name = "root";
        String u_pass = "mayank2512";
        String db_url = "jdbc:mysql://localhost:3306/temp";

        Connection con = null;
        Statement st = null;
        try {
          // register the driver
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          con = DriverManager.getConnection(db_url, u_name, u_pass);

          st = con.createStatement();
          String query = "INSERT INTO employees (emp_id, emp_name, salary) VALUES (9, 'James Doe', 50000);";

          int rowsAffected = st.executeUpdate(query);

          if (rowsAffected > 0) {
            System.out.println("New employee was inserted");
          }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
            }

            try {
                if (st != null) st.close();
            } catch (SQLException e) {
            }
        }
    }
}
