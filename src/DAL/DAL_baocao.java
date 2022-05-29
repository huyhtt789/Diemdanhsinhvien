package DAL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.DTO_sinhvien;
import seminar.Connect;

public class DAL_baocao {
	 private static final ArrayList String = null;
	Connect a=new Connect();
	 Connection conn=a.getConnection();
	 public ArrayList docDSsinhvienhiendien(String date)
	    {
	        ArrayList dssv=new ArrayList<DTO_sinhvien>();
	        
	        try{
	            String qry="Select hiendien.IDCARD,sinhvien.TENSV from hiendien,sinhvien where  hiendien.NGAYVAORA='"+date+"' and hiendien.IDCARD=sinhvien.IDCARD ";
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
	 
	 //kiem tra trang thai dung gio hay muon gio lam
	 public ArrayList trangthai(String idcard,String date)
	    {
		 ArrayList trangthai=new ArrayList<DTO_sinhvien>();

		 int dem=0;	
		int solanvao=0;
		int solanra=0;
	        DTO_sinhvien sv=new DTO_sinhvien();
	        try{
	            String qry="Select THOIGIAN from hiendien where IDCARD= '"+idcard+"' and NGAYVAORA= '"+date+"'";
	           
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	         
	           
	            while (rs.next())
	            {
	            	
	            	dem=dem+1;
	            	if(dem==1) {
	            		solanvao=solanvao+1;
//	               sv.giovao=rs.getString(1);
	               String giovao=rs.getString(1);
	               StringTokenizer stz=new StringTokenizer(giovao,".");
	               sv.giovao=stz.nextToken();
	               Time time=Time.valueOf(sv.giovao);
	               
	               Time timecompare=Time.valueOf("7:00:00");
	               
	               if(time.compareTo(timecompare)<=0)
	            	   sv.trangthai="on time";
	               else sv.trangthai="be late";
	            	}
	            	
	            	if((dem%2==0) &&(dem>0)) {
	            	solanra=solanra+1;
	            		  String giora=rs.getString(1);
	   	               StringTokenizer stz=new StringTokenizer(giora,".");
	   	               sv.giora=stz.nextToken();
	   	               
	            	}
	            	if((!(dem%2==0))&&(dem>1)) {
	            		solanvao=solanvao+1;
	            		
	            	}
	            	 

	            }
	            sv.solanvao=solanvao;
	            sv.solanra=solanra;
	            trangthai.add(sv);
	           
	        }catch (Exception e){
	            System.out.println(e.toString());
	            }
	       
	        
	        return trangthai;
	    	}
	 
	 //loc danh sach nhung nguoi vang mat trong ngay
	 public ArrayList docDSsinhvienvang(String date)
	    {
	        ArrayList dssv=new ArrayList<DTO_sinhvien>();
	        
	        try{
	            String qry="Select * from sinhvien EXCEPT"
	            		+ "(Select hiendien.IDCARD,sinhvien.TENSV from hiendien,sinhvien where  hiendien.NGAYVAORA='"+date+"' and hiendien.IDCARD=sinhvien.IDCARD )";
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while (rs.next())
	            {
	               DTO_sinhvien sv=new DTO_sinhvien();
	               sv.idcard=rs.getString(1);
	               sv.tensv=rs.getString(2);
	               sv.trangthai="absent";
	                dssv.add(sv);
	            }
	        }catch (Exception e){
	            System.out.println(e.toString());
	            }
	        return dssv;
	    	}
	 
//	 //Xac định giờ ra
//	 public String thoigianra(String idcard,String date)
//	    {
//		 String trangthai=null;
//		 int dem=0;
//
//	        ArrayList dssv=new ArrayList<DTO_sinhvien>();
//
//	        DTO_sinhvien sv=new DTO_sinhvien();
//	        try{
//	            String qry="Select THOIGIAN from hiendien where IDCARD= '"+idcard+"' and NGAYVAORA= '"+date+"'";
//	            Statement st=(Statement) conn.createStatement();
//	            ResultSet rs= st.executeQuery(qry);
//	            while (rs.next())
//	            {
//	            	dem=dem+1;
//	               sv.giovaora=rs.getString(1);
//	               StringTokenizer stz=new StringTokenizer(sv.giovaora,".");
//	               Time time=Time.valueOf(stz.nextToken());
////	               System.out.println(time);
//	               Time timecompare=Time.valueOf("7:00:00");
//	               
//	               if(time.compareTo(timecompare)<=0)
//	            	   trangthai="on time";
//	               else trangthai="be late";
//	               break;
////	               dem=dem+1;
////	                dssv.add(sv);
//	            }
//	        }catch (Exception e){
//	            System.out.println(e.toString());
//	            }
//	       
//	        
//	        return trangthai;
//	    	}
	 
	 //xuat bao cao excel
	 public void exportExcel(JTable table) {
		 JFileChooser chooser = new JFileChooser();
		 int i = chooser.showSaveDialog(chooser);
		 if (i == JFileChooser.APPROVE_OPTION) {
		  File file = chooser.getSelectedFile();
		  try {
		   FileWriter out = new FileWriter(file + ".xls");
		   BufferedWriter bwrite = new BufferedWriter(out);
		   DefaultTableModel model = (DefaultTableModel) table.getModel();
//		    ten Cot
		   for (int j = 0; j < table.getColumnCount(); j++) {
		    bwrite.write(model.getColumnName(j) + "\t");
		   }
		   bwrite.write("\n");
		   // Lay du lieu dong
		   for (int j = 1; j < table.getRowCount(); j++) {
		    for (int k = 0; k < table.getColumnCount(); k++) {
		     bwrite.write(model.getValueAt(j, k) + "\t");
		    }
		    bwrite.write("\n");
		   }
		   bwrite.close();
		   JOptionPane.showMessageDialog(null, "Lưu file thành công!");
		  } catch (Exception e2) {
		   JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
		  }
		 }
		}
//	 public static void main(String[] args) {
//		 DAL_baocao bc=new DAL_baocao();
//		System.out.println(); bc.trangthai("4D4F 5300", "2022-04-26");
//	 }
	 
}
