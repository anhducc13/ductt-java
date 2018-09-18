package week2;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnect {
    private final String className = "com.mysql.jdbc.Driver";
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/sinhvien";
    private final String user = "ductt";
    private final String pass = "03121997"; 
    private final String tableName = "list";
    
    private void connect(){
        
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url,user,pass);
            System.out.println("Connect Success!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found!");
        }
        catch (SQLException ex) {
            System.out.println("Error Connection!");
        }
    }
    
    private ResultSet getData() {
        ResultSet rs = null;
        String sql = "SELECT * FROM " + tableName;
        Statement st = null;        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
        return rs;
    }
    
    private void showData(ResultSet rs) {
        try {
            System.out.printf("%-10s %-20s %-10s %-20s\n","ID","Name","Group","Email");
            while(rs.next()) {
                System.out.printf("%-10s %-20s %-10s %-20s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    
    private void insertData(Student s) {
        Statement st = null; 
//        String sqlInsert = "INSERT INTO list (id,name,group,email) VALUES ('17020708','dvq','sfsd','sdfsd')";
//                            "VALUES (" + s.getId() + "," + s.getName() + "," + s.getGroup() + "," + s.getEmail() + ")";
        try {
            st = connection.createStatement();
            String sql = "INSERT INTO list(id,name,group,email) " + "VALUES(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "17020564");
            pstmt.setString(2, "fdfadf");
            pstmt.setString(3, "asfasdf");
            pstmt.setString(4, "ascsvdv");
            System.out.println(pstmt.executeUpdate());
 
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    
//    public static void main(String[] args) {
//        MyConnect connect = new MyConnect();
//        connect.connect();
//        connect.insertData(new Student("17020976","Đoàn Văn Quang","C-E","email"));
//        connect.showData(connect.getData());
//        
//    }
//    
}
