package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import com.example.sdksamples.ReadTags;
import com.toedter.calendar.JDateChooser;

import DAL.DAL_baocao;
import DAL.DAL_nhapthongtin;
import DTO.DTO_sinhvien;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class GUI_baocao extends JFrame {

	private JPanel contentPane;
	private JTable tb_diemdanh;
	public JDateChooser date;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_baocao frame = new GUI_baocao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_baocao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tb_diemdanh = new JTable();
		
		
		
		JLabel lblNewLabel = new JLabel("Ba\u0301o ca\u0301o");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		 date = new JDateChooser();
		date.setDateFormatString("yyyy-MM-dd");
		JButton btn_diemdanh = new JButton("Ki\u00EA\u0309m tra");
		btn_diemdanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate=((JTextField)date.getDateEditor().getUiComponent()).getText();
				load_table(selectdate);
				
			}
		});
		JButton btn_xuatbaocao = new JButton("Xu\u00E2\u0301t ba\u0301o ca\u0301o");
		btn_xuatbaocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAL_baocao baocao=new DAL_baocao();
				baocao.exportExcel(tb_diemdanh);
			}
		});
		
		JButton btn_thoat = new JButton("Thoa\u0301t");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ReadTags rt=new ReadTags();
				setVisible(false);
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(date, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btn_diemdanh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_xuatbaocao)
							.addGap(18)
							.addComponent(btn_thoat))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(tb_diemdanh, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(300)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btn_diemdanh)
									.addComponent(btn_xuatbaocao)
									.addComponent(btn_thoat))
								.addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(tb_diemdanh, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void load_table(String selectdate) {
		 Vector header = new Vector();
	        header.add("ID card");
	        header.add("Ten sinh vien");
	        header.add("Ngay");
	        header.add("Gio vao");
	        header.add("Gio ra");
	        header.add("Trang thai");
	        header.add("so lan vao");
	        header.add("so lan ra");
	        
	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
	        
	        
		ArrayList<DTO_sinhvien> dssv=new ArrayList<DTO_sinhvien>();
		DAL_baocao baocao=new DAL_baocao();
		
	
		dssv=baocao.docDSsinhvienhiendien(selectdate);
		HashMap<String, String> hmp=new HashMap<>();
		for(DTO_sinhvien sv1:dssv) {
			hmp.put(sv1.idcard,sv1.tensv);
		}
		
		 for(String i:hmp.keySet()) {
			 ArrayList<DTO_sinhvien> ds=new ArrayList<DTO_sinhvien>();
			 ds= baocao.trangthai(i, selectdate);
			 for(DTO_sinhvien sv2:ds) {
				String trangthai=sv2.trangthai;
				Vector row = new Vector();
			 	row.add(i);
		     
	            row.add(hmp.get(i));
	            row.add(selectdate);
	            row.add(sv2.giovao);
	            row.add(sv2.giora);
	            
	            row.add(trangthai);
	            row.add(sv2.solanvao);
	            row.add(sv2.solanra);
	    
	            model.addRow(row);
			 } }
		 
		 ArrayList<DTO_sinhvien> dsvang=new ArrayList<DTO_sinhvien>();

		dsvang=baocao.docDSsinhvienvang(selectdate);
		for(DTO_sinhvien sv2:dsvang) {
			Vector row = new Vector();
		 	row.add(sv2.idcard);
	     
            row.add(sv2.tensv);
            row.add(selectdate);
            row.add(sv2.giovao);
            row.add(sv2.giora);
            row.add(sv2.trangthai);
    
            model.addRow(row);
		}
		 
		 
	        tb_diemdanh.setModel(model);
	        tb_diemdanh.getColumnModel().getColumn(0).setPreferredWidth(135);
	        tb_diemdanh.getColumnModel().getColumn(1).setPreferredWidth(80);
	        tb_diemdanh.getColumnModel().getColumn(2).setPreferredWidth(50);
	        tb_diemdanh.getColumnModel().getColumn(3).setPreferredWidth(30);
	        tb_diemdanh.getColumnModel().getColumn(4).setPreferredWidth(30);
	        tb_diemdanh.getColumnModel().getColumn(5).setPreferredWidth(40);
	        tb_diemdanh.getColumnModel().getColumn(6).setPreferredWidth(30);
	        tb_diemdanh.getColumnModel().getColumn(7).setPreferredWidth(20);
	    
	}
}
