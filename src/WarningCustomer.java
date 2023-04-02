import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarningCustomer extends JFrame{
	private JPanel warningPanel;
	private JLabel warningText;
	private JLabel warningLogo;
	
	//Access my Transaction class as global declaration
	private Transaction singleTransaction = new Transaction();
	
	public WarningCustomer(){
		Container pane = getContentPane();
		JPanel warningPanel = new JPanel(null);
		warningPanel.setBackground(Color.WHITE);
		
		ImageIcon warningImage = new ImageIcon("../images/warning_icon.GIF");
		JLabel warningLogo = new JLabel(warningImage);
		warningLogo.setBounds(20, 35, 50, 50);
		warningPanel.add(warningLogo);
		
		JLabel warningText = new JLabel("");
		warningText.setText("Please complete all details");
		warningText.setFont(new Font("Serif", Font.BOLD, 15));
		warningText.setForeground(Color.RED);
		warningText.setBounds(80, 48, 200, 20);
		warningPanel.add(warningText);
		pane.add(warningPanel);
	}
}