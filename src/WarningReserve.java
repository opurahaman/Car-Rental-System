import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarningReserve extends JFrame{
	private JPanel warningPanel;
	private JLabel warningText;
	private JLabel WarningIcon;
	
	//Access my Transaction class as global declaration
	private Transaction singleTransaction = new Transaction();
	
	public WarningReserve(){
		Container pane = getContentPane();
		JPanel warningPanel = new JPanel(null);
		warningPanel.setBackground(Color.WHITE);
		
		ImageIcon warningImage = new ImageIcon("warning_icon.GIF");
		JLabel WarningIcon = new JLabel(warningImage);
		WarningIcon.setBounds(20, 35, 50, 50);
		warningPanel.add(WarningIcon);
		
		JLabel warningText = new JLabel("");
		warningText.setText("Oops Invalid");
		warningText.setFont(new Font("Serif", Font.BOLD, 15));
		warningText.setForeground(Color.RED);
		warningText.setBounds(80, 48, 100, 20);
		warningPanel.add(warningText);
		pane.add(warningPanel);
	}
}