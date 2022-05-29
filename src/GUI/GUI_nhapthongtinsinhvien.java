package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import DAL.DAL_docthongtinsinhvien;
import DAL.DAL_nhapthongtin;

import DTO.DTO_sinhvien;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class GUI_nhapthongtinsinhvien extends JFrame {

	private JPanel contentPane;
	private JTextField txt_idcard;
	private JTextField txt_tensv;
	DefaultTableModel model;
	private JTable tb_thongtin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_nhapthongtinsinhvien frame = new GUI_nhapthongtinsinhvien();
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
	public GUI_nhapthongtinsinhvien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		txt_idcard = new JTextField();
		txt_idcard.setColumns(10);
		
		txt_tensv = new JTextField();
		txt_tensv.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ma\u0303 the\u0309");
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn sinh vi\u00EAn");
		
		JButton btn_them = new JButton("Th\u00EAm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				DTO_sinhvien sinhvien=new DTO_sinhvien();
				DAL_nhapthongtin thongtin=new DAL_nhapthongtin();
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				 if (txt_idcard.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap mã thẻ","Error Title", JOptionPane.ERROR_MESSAGE);}
		        	 else
		        if (txt_tensv.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap ten sinh vien","Error Title", JOptionPane.ERROR_MESSAGE);
		        } 
		        else {
		        	  ArrayList<DTO_sinhvien> dssv=new ArrayList<DTO_sinhvien>();
		        	  dssv=thongtin.docMasinhvien();
		        	  for (DTO_sinhvien sv : dssv) {
		        		  if(txt_idcard.getText().equalsIgnoreCase(sv.idcard))
		        			  i=i+1;
		  	        }
		        	  if(i>0) 	
		        		  JOptionPane.showMessageDialog(frame, "Mã thẻ đã có","Error Title", JOptionPane.ERROR_MESSAGE);
		        	  else {
		        		  sinhvien.idcard=txt_idcard.getText();
		        		  sinhvien.tensv=txt_tensv.getText();
		        		  thongtin.ThemPT(sinhvien);
		        		  txt_idcard.setText("");
		        		  txt_tensv.setText("");
		        		  try {
							load_datasinhvien();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	  }
		        	  
		        }
				
			}
		});
		
		JButton btn_sua = new JButton("S\u01B0\u0309a");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				DAL_nhapthongtin thongtin=new DAL_nhapthongtin();
				if(txt_idcard.getText().equals(""))  
					 JOptionPane.showMessageDialog(frame, "Vui long chon mã thẻ","Error Title", JOptionPane.ERROR_MESSAGE);
				else if(txt_tensv.getText().equals(""))
					JOptionPane.showMessageDialog(frame, "Vui long nhap ten sinh vien","Error Title", JOptionPane.ERROR_MESSAGE);
				else
				{
				thongtin.Sua(txt_idcard.getText(), txt_tensv.getText());
				txt_idcard.setText("");
				txt_tensv.setText("");
				JOptionPane.showMessageDialog(frame, "Sua thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
				try {
					load_datasinhvien();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			}
		});
		
		JButton btn_xoa = new JButton("Xoa\u0301");
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				DAL_nhapthongtin thongtin=new DAL_nhapthongtin();
				if(txt_idcard.getText().equals(""))  
					 JOptionPane.showMessageDialog(frame, "Vui long chon mã thẻ","Error Title", JOptionPane.ERROR_MESSAGE);
				else if(txt_tensv.getText().equals(""))
					JOptionPane.showMessageDialog(frame, "Vui long nhap ten sinh vien","Error Title", JOptionPane.ERROR_MESSAGE);
				else
				{
				thongtin.Xoa(txt_idcard.getText());
				txt_idcard.setText("");
				txt_tensv.setText("");
				JOptionPane.showMessageDialog(frame, "Xoa thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
				try {
					load_datasinhvien();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			}
		});
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		
		tb_thongtin = new JTable();
		tb_thongtin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTable();
			}
		});
		try {
			load_datasinhvien();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin sinh vien");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txt_tensv)
								.addComponent(txt_idcard, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_sua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_them, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_xoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_thoat, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(tb_thongtin, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(252, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(240))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_them)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(txt_idcard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btn_xoa))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_sua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txt_tensv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_thoat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)))
					.addGap(26)
					.addComponent(tb_thongtin, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void load_datasinhvien() throws SQLException {
	 	DAL_docthongtinsinhvien doc=new DAL_docthongtinsinhvien();
        Vector header = new Vector();
        header.add("ID card");
        header.add("Ten sinh vien");

        model = new DefaultTableModel(header,0);
        model.addRow(header);
       
        ArrayList <DTO_sinhvien> dssv=new ArrayList<>();
        dssv=doc.docDSsinhvien();
        
        for (DTO_sinhvien sv : dssv) {
            Vector row = new Vector();
            row.add(sv.idcard);
            row.add(sv.tensv);
            model.addRow(row);
        }
      
        tb_thongtin.setModel(model);
    
 }
	private void clickTable() {

        int Row = tb_thongtin.getSelectedRow();

        String idcard = (String.valueOf(tb_thongtin.getValueAt(Row, 0)));
        String tensv= (String.valueOf(tb_thongtin.getValueAt(Row, 1)));
       
        txt_idcard.setText(idcard);
        txt_tensv.setText(tensv);
        }
	
	private void load_timthisinh() throws SQLException {
        DAL_nhapthongtin thongtin = new DAL_nhapthongtin();
       

            ArrayList <DTO_sinhvien>dssv = new ArrayList<DTO_sinhvien>();
            dssv= thongtin.docTimkiemsinhvien(txt_idcard.getText(), txt_tensv.getText());
//        model = new DefaultTableModel(header,0);
//        model.addRow(header);
        for (DTO_sinhvien sv : dssv) {
            Vector row = new Vector();
            row.add(sv.idcard);
     
            row.add(sv.tensv);
            
    
            model.addRow(row);
        }
        tb_thongtin.setModel(model);
    }
}
