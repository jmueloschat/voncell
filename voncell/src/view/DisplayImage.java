package view;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import	 javax.swing.*;

import org.opencv.core.Mat;

import controller.IMU;

public class DisplayImage extends JFrame {
  
	private static final long serialVersionUID = 1L;
	Mat source;
	ImageIcon imageSource;

	public DisplayImage(String file){		
	    JFrame frame = new JFrame("My GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		 
		// Inserts the image icon
		source = IMU.load(file);
		
		imageSource = new ImageIcon(IMU.MatToImage(source));

		frame.setSize(500,250);
		  
		// Draw the Image data into the BufferedImage
		JLabel label1 = new JLabel(" ", imageSource, JLabel.CENTER);

		Panel panelImage = new Panel();		
		panelImage.setLayout(new BoxLayout(panelImage, BoxLayout.LINE_AXIS));
		panelImage.add(label1);
		
		JButton btDilate = new JButton("Dilate +");
		btDilate.setVisible(true);	
		frame.getContentPane().repaint();
		
		btDilate.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  System.out.println("dilate +");
				  source = IMU.dilate(source, 5);
				  IMU.save(file, source);
			  }
			});	
		
		Panel panelButton = new Panel();		
		panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.LINE_AXIS));
		panelButton.add(btDilate);		

		Panel panelMaster = new Panel();
		panelMaster.setLayout(new BoxLayout(panelMaster, BoxLayout.Y_AXIS));

		panelMaster.add(panelButton);
		panelMaster.add(panelImage);
		
		frame.getContentPane().add(panelMaster);
		frame.validate();
		frame.setVisible(true);
	}
}