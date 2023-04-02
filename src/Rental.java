import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rental{ 

  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;


  public static void main(String[] args) {

    JFrame frame = new RentalView();
    ImageIcon iconImage = new ImageIcon("logo.GIF");
    frame.setIconImage(iconImage.getImage());
    frame.setTitle("NSU Car Rental v0.01");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setResizable(false);
   }
}
