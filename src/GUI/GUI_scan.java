package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;


import DAL.DAL_docthongtinsinhvien;
import DAL.DAL_hiendien;
import DTO.DTO_sinhvien;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import seminar.ReadTags;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
public class GUI_scan extends JFrame {
	public DefaultTableModel model;
	DefaultTableModel model1;
	private JPanel contentPane;
	public JTable tb_scan;
	ImpinjReader reader;
	TagReport report;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_quetsinhvien frame = new GUI_quetsinhvien();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_scan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tb_scan = new JTable();
//		String[] columnNames = {"EPC", "Reader_name", "Reader_ip","antenna","firsttime","lasttime","count"};
//		
		JButton btn_scan = new JButton("Scan");
		btn_scan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					load_data();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btn_luu = new JButton("Thêm");
		btn_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			    System.out.println("Stopping");
//	            try {
//					reader.stop();
//				} catch (OctaneSdkException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
//
//	            // Disconnect from the reader.
//	            System.out.println("Disconnecting");
//	            reader.disconnect();
			DAL_hiendien hd=new DAL_hiendien();
			 JFrame frame = new JFrame("JOptionPane showMessageDialog example");

			 try {
				for(int count = 0; count < model.getRowCount(); count++){

				      hd.them(model.getValueAt(count, 0).toString(),model.getValueAt(count, 1).toString(), model.getValueAt(count, 2).toString());
				      
				}
				JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
				model.setRowCount(0);

//				JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
////				load_datasinhvien();
//				model.setRowCount(0);
//				load_data();
				
			 }catch(Exception e1){
//		        	System.out.println("sai");
//		        	JOptionPane.showMessageDialog(frame, "làm lại","Error Title", JOptionPane.ERROR_MESSAGE);
//					JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
//					model.setRowCount(0);
		            }
			
			
			}
		});
//		JScrollPane jsp = new JScrollPane(tb_thongtinsv);
		

//        JScrollPane js=new JScrollPane(tb_thongtinsv);
//        js.setVisible(true);
//        add(js);
//		new JScrollPane(tb_thongtinsv, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		tb_thongtinsv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
//		try {
//			load_datasinhvien();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		JButton btn_baocao = new JButton("Báo cáo");
		btn_baocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_baocao baocao=new GUI_baocao();
				baocao.setVisible(true);
				baocao.setLocationRelativeTo(null);
			}
		});
		
		JButton btn_thongtin = new JButton("Thông tin");
		btn_thongtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_nhapthongtinsinhvien thongtin=new GUI_nhapthongtinsinhvien();
				thongtin.setLocationRelativeTo(null);
				thongtin.setVisible(true);
			
			}
		});
		
		JLabel lblNewLabel = new JLabel("Quản lý học sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("Scan: quét ID giờ vào ra của học sinh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Thêm: thêm dữ liệu scan vào database");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin: xem hoặc sửa thông tin học sinh ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Báo cáo: xuất báo cáo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(34))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btn_thongtin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_scan, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btn_baocao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_luu, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tb_scan, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(247))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_thongtin)
								.addComponent(btn_baocao)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_scan)
								.addComponent(btn_luu)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(tb_scan, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	 private void load_data() throws SQLException {
//		 	ReadTags rt=new ReadTags();
//		 	rt.read();
//			List<Tag> tags = report.getTags();
			
	        Vector header = new Vector();
	        header.add("ID card");
	        header.add("Ngày vào ra");
	        header.add("Giờ vào ra");

	        
	    	
//			 for (Tag t : tags) {
//				System.out.println("huy--"+t.getEpc().toString());
//			              
//			 }
//			 
			 
//	        readScan(tags);
	        
	        //fix
	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
	       
	        
//	        for (Tag t : tags)  {
//	            Vector row = new Vector();
//	            row.add(t.getEpc().toString());
//	            row.add(LocalDate.now().toString());
//	            row.add(LocalTime.now().toString());
//	    
//	          model.addRow(row);
//	        }
//	        tb_scan.setModel(model);
//	    
	 }
//	 private void readScan(List<Tag> tags) {
////		 ReadTags rt=new ReadTags();
//		 DAL_hiendien dL_hd=new DAL_hiendien();
//			
//			HashMap<String,String> hmp=new HashMap<String,String>();
//			
//			 for (Tag t : tags) {
//				 for(String i:hmp.keySet()) {
//				 if(!t.getEpc().toString().equalsIgnoreCase(i)) 
//					 hmp.put(t.getEpc().toString(), LocalTime.now().toString());
//			 }}
//			 
//			 for(String i:hmp.keySet()) {
//				 dL_hd.ThemHD( i);
//			 }
//			 
////			return hmp;
//	 }
	 
	 
	 private void load_datasinhvien() throws SQLException {
		 	DAL_docthongtinsinhvien doc=new DAL_docthongtinsinhvien();
	        Vector header = new Vector();
	        header.add("ID card");
	        header.add("Ten sinh vien");

	        model1 = new DefaultTableModel(header,0);
	        model1.addRow(header);
	       
	        ArrayList <DTO_sinhvien> dssv=new ArrayList<>();
	        dssv=doc.docDSsinhvien();
	        
	        for (DTO_sinhvien sv : dssv) {
	            Vector row = new Vector();
	            row.add(sv.idcard);
	            row.add(sv.tensv);
	            model1.addRow(row);
	        }
	    
	 }
}
