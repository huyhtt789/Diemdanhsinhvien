package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.DTO_sinhvien;
import seminar.Connect;

public class DAL_hiendien {
	 Connect a=new Connect();
	    Connection conn=a.getConnection();
	    public void Kiemtratrangthai(String idcard,String trangthai)
	    {
	    	DTO_sinhvien sv=new DTO_sinhvien();
//	    	String trangthai="vao";
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		   try{
	            String qry="Select TRANGTHAI from hiendien where IDCARD="+idcard+" and NGAYVAORA="+LocalDate.now();
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while (rs.next())
	            {
	                sv.trangthai=rs.getString(1);
	                if(sv.trangthai.equalsIgnoreCase(trangthai))
	                	trangthai="ra";
	                else trangthai="vao";
	              
	            }
	        }catch (Exception e){
	            System.out.println(e.toString());
	            }
	    }
		   
		   
		public void them(String idcard,String ngayvaora,String giovaora)   {
			DTO_sinhvien sv=new DTO_sinhvien();
//			 JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        try {
	        	
	        	  String qry="INSERT INTO hiendien VALUES(";
		            qry=qry+"'"+idcard+"'";
		            qry=qry+",'"+ngayvaora+"'";
		            qry=qry+",'"+giovaora+"'";
		            
		           
		            qry=qry+")";
		            Statement st=(Statement) conn.createStatement();
		            st.executeUpdate(qry);
//	            System.out.println("id card: "+sv.idcard);
		            System.out.println("thanhcong");
//	            JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e){
//	        	System.out.println("sai");
//	        	JOptionPane.showMessageDialog(frame, "làm lại","Error Title", JOptionPane.ERROR_MESSAGE);
	        	System.out.println(e.getMessage());
	            }
	    }
	    
	    //doc du lieu hiện diện theo ngày
//	    public ArrayList docDShiendien()
//	    {
//	        ArrayList dshd=new ArrayList<DTO_sinhvien>();
//	        
//	        try{
//	            String qry="Select sinhvien.IDCARD,MASV,TENSV,THOIGIANVAORA,TRANGTHAI from hiendien,sinhvien where hiendien.IDCARD=sinhvien.IDCARD";
//	            Statement st=(Statement) conn.createStatement();
//	            ResultSet rs= st.executeQuery(qry);
//	            while (rs.next())
//	            {
//	                DTO_sinhvien sv=new DTO_sinhvien();
//	               sv.idcard=rs.getString(1);
//	                sv.masv=rs.getString(2);
//	                sv.tensv=rs.getString(3);
//	                sv.thoigianvaora=rs.getString(4);
//	                sv.trangthai=rs.getString(5);
//	            
//	                dshd.add(sv);
//	            }
//	        }catch (Exception e){
//	            System.out.println(e.toString());
//	            }
//	        return dshd;
//	    	}
}
