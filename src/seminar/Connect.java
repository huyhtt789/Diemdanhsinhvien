package seminar;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	        public Connection getConnection(){
	            Connection conn=null;
	            try{
	                String url = "jdbc:mysql://localhost/seminar-quanlisinhvien";
	                String user = "root";
	                String password = "";
	                Class.forName("com.mysql.jdbc.Driver");
	                conn=DriverManager.getConnection(url, user, password);
	             if (conn != null) {
	                System.out.println("thanh cong");
	                }
	            }catch(Exception ex){
	                System.out.println(ex.toString());
//	                System.out.println("ngu");
	            }
	            return conn;
	        }
	        public static void main (String[] args) {
	        	Connect cn=new Connect();
	        	cn.getConnection();
	        }
	    }
	    

