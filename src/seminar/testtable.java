package seminar;

import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.impinj.octane.Tag;

import GUI.GUI_scan;


public class testtable {
public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
	
	GUI_scan sc=new GUI_scan();
	sc.setLocationRelativeTo(null);
	sc.setVisible(true);
	
}
}
