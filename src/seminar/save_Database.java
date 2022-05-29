package seminar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.impinj.octane.*;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;

import DAL.DAL_hiendien;
import GUI.GUI_scan;

public class save_Database implements TagReportListener{
	 GUI_scan frame=new GUI_scan();
	 HashMap<String,String> hmp=new HashMap<>();
	 public save_Database() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		 UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
}
	    @Override
	    public void onTagReported(ImpinjReader reader, TagReport report) {
	    	
	    	
	    	 List<Tag> tags = report.getTags();
	      
	        for (Tag t : tags) {
	        	
	            System.out.print(" EPC: " + t.getEpc().toString());
	           
						 hmp.put(t.getEpc().toString(), LocalTime.now().toString());
						 frame.model.setRowCount(0);
				 }
	        for(String i:hmp.keySet()) {
	        	
		            Vector row = new Vector();
		            row.add(i);
		            row.add(LocalDate.now().toString());
		            row.add(LocalTime.now().toString());
		    
		          frame.model.addRow(row);
		        }
		        frame.tb_scan.setModel(frame.model);
//	            GUI_quetsinhvien scan=new GUI_quetsinhvien();
//	            scan.setVisible(true);
//	            
	            
	            
//	            readScan(tags);
//	            if (reader.getName() != null) {
//	                System.out.print(" Reader_name: " + reader.getName());
//	            } else {
//	                System.out.print(" Reader_ip: " + reader.getAddress());
//	            }
//
//	            if (t.isAntennaPortNumberPresent()) {
//	                System.out.print(" antenna: " + t.getAntennaPortNumber());
//	            }
//
//	            if (t.isFirstSeenTimePresent()) {
//	                System.out.print(" first: " + t.getFirstSeenTime().ToString());
//	            }
//
//	            if (t.isLastSeenTimePresent()) {
//	                System.out.print(" last: " + t.getLastSeenTime().ToString());
//	            }
//
//	            if (t.isSeenCountPresent()) {
//	                System.out.print(" count: " + t.getTagSeenCount());
//	            }

//	            if (t.isRfDopplerFrequencyPresent()) {
//	                System.out.print(" doppler: " + t.getRfDopplerFrequency());
//	            }
//
//	            if (t.isPeakRssiInDbmPresent()) {
//	                System.out.print(" peak_rssi: " + t.getPeakRssiInDbm());
//	            }
//
//	            if (t.isChannelInMhzPresent()) {
//	                System.out.print(" chan_MHz: " + t.getChannelInMhz());
//	            }
//
//	            if (t.isRfPhaseAnglePresent()) {
//	                System.out.print(" phase angle: " + t.getPhaseAngleInRadians());
//	            }
//
//	            if (t.isFastIdPresent()) {
//	                System.out.print("\n     fast_id: " + t.getTid().toHexString());
//
//	                System.out.print(" model: " +
//	                        t.getModelDetails().getModelName());
//
//	                System.out.print(" epcsize: " +
//	                        t.getModelDetails().getEpcSizeBits());
//
//	                System.out.print(" usermemsize: " +
//	                        t.getModelDetails().getUserMemorySizeBits());
	            
//	        System.out.println("huy");
//
	         
	       
	        }
//	    
//	    private void readScan(List<Tag> tags) {
////			 ReadTags rt=new ReadTags();
//			 DAL_hiendien dL_hd=new DAL_hiendien();
//				
//				HashMap<String,String> hmp=new HashMap<String,String>();
//				
//				 for (Tag t : tags) {
//					 for(String i:hmp.keySet()) {
//					 if(!t.getEpc().toString().equalsIgnoreCase(i)) 
//						 hmp.put(t.getEpc().toString(), LocalTime.now().toString());
//				 }}
//				 
//				 for(String i:hmp.keySet()) {
//					 dL_hd.ThemHD( i);
//				 }
//				 
////				return hmp;
//		 }
	    }
	

	   
	


