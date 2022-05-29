package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_sinhvien;
import seminar.Connect;

public class DAL_docthongtinsinhvien {
	 Connect a=new Connect();
	    Connection conn=a.getConnection();
	    public ArrayList docDSsinhvien()
	    {
	        ArrayList dssv=new ArrayList<DTO_sinhvien>();
	        
	        try{
	            String qry="Select * from sinhvien";
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while (rs.next())
	            {
	                DTO_sinhvien sv=new DTO_sinhvien();
	               sv.idcard=rs.getString(1);
	               sv.tensv=rs.getString(2);
	               
	                
	                dssv.add(sv);
	            }
	        }catch (Exception e){
	            System.out.println(e.toString());
	            }
	        return dssv;
	    	}
}
