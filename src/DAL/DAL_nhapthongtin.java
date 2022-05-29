package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import DTO.DTO_sinhvien;
import seminar.Connect;

public class DAL_nhapthongtin {
	 	Connect a=new Connect();
	    Connection conn=a.getConnection();
	    public ArrayList docMasinhvien()
	    {
	        ArrayList dssv=new ArrayList<DTO_sinhvien>();
	        
	        try{
	            String qry="Select IDCARD from sinhvien";
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while (rs.next())
	            {
	                DTO_sinhvien sv=new DTO_sinhvien();
	               sv.idcard=rs.getString(1);
	              
	                dssv.add(sv);
	            }
	        }catch (Exception e){
	            System.out.println(e.toString());
	            }
	        return dssv;
	    	}
	 public void ThemPT(DTO_sinhvien sv)
	    {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        try {
	            String qry="INSERT INTO sinhvien VALUES(";
	            qry=qry+"'"+sv.idcard+"'";
	            qry=qry+",'"+sv.tensv+"'";
	            qry=qry+")";
	            Statement st=(Statement) conn.createStatement();
	            st.executeUpdate(qry);
	          
	            JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e){
	        	JOptionPane.showMessageDialog(frame, "ma giam thi da co yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
	        	System.out.println(e.getMessage());
	            }
	    }
	 
	 public void Sua(String idcard,String tensv) {
		 
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	
		   try {
			   String qry="Update sinhvien set TENSV='";
	           qry=qry+tensv+"'";
	           qry=qry+"where IDCARD='"+idcard+"'";
	           Statement st=conn.createStatement();
	           st.executeUpdate(qry);
			   
		   }catch (Exception e) {
			   JOptionPane.showMessageDialog(frame, e.getMessage(),"Error Title", JOptionPane.ERROR_MESSAGE);
		}
         
	   }
	 
	  public void Xoa(String idcard) {
		  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        try {
	            String qry = "Delete from  sinhvien where IDCARD='" + idcard + "'";
	            Statement st = conn.createStatement();
	            st.executeUpdate(qry);
	        } catch (Exception e) {
	        	 JOptionPane.showMessageDialog(frame, e.getMessage(),"Error Title", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	  
		 public  ArrayList docTimkiemsinhvien(String idcard, String tensv) {
		        ArrayList dssv = new ArrayList<DTO_sinhvien>();
		        try {
		        	 String qry;
		        	if(tensv.equalsIgnoreCase(""))
		        		qry="Select IDCARD,TENSV from sinhvien  Where IDCARD like '" + idcard + "'  ";
		        	else if(idcard.equalsIgnoreCase(""))
		        		qry = "Select IDCARD,TENSV from sinhvien  Where TENSV like '" + tensv + "'  ";
		        	else {
		             qry = "Select IDCARD,TENSV from sinhvien Where IDCARD like '%" 
		        + idcard + "%' and TENSV like '" + tensv + "'";}
		            Statement st = conn.createStatement();
		            ResultSet rs = st.executeQuery(qry);
		            while (rs.next()) {
		                DTO_sinhvien sv = new DTO_sinhvien();
		                sv.idcard = rs.getString(1);
		                sv.tensv = rs.getString(2);
		               
		                dssv.add(sv);
		            }

		        } catch (Exception e) {
		            System.out.println(e.toString());
		        }
		        return dssv;
		    }
}
