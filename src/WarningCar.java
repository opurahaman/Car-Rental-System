import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarningCar extends JFrame{
	private JPanel warningPanel;
	private JLabel warningText;
	private JLabel warningIcon;
	
	//Access my Transaction class as global declaration
	private Transaction singleTransaction = new Transaction(); 
	
	public WarningCar(){
		Container pane = getContentPane();
		JPanel warningPanel = new JPanel(null);
		warningPanel.setBackground(Color.WHITE);
		
		ImageIcon warningImage = new ImageIcon("warning_icon.GIF");
		warningIcon = new JLabel(warningImage);
		warningIcon.setBounds(20, 35, 50, 50);
		warningPanel.add(warningIcon);
		
		JLabel warningText = new JLabel("");
		warningText.setText("Click a Car");
		warningText.setFont(new Font("Serif", Font.BOLD, 15));
		warningText.setForeground(Color.RED);
		warningText.setBounds(80, 48, 200, 20);
		warningPanel.add(warningText);
		pane.add(warningPanel);
	}
}