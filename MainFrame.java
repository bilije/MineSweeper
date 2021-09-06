package saper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	InfoPanel iPanel;
	FieldPanel mainPanel;

	JMenuBar menuBar;
	JMenu menu;
	JMenuItem load;
	JMenuItem info;
	
	int bomb = 99;
	int row = 16;
	int line = 31;
	

	public MainFrame() throws HeadlessException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1315,813); // 1267:720 dla pól 40x40
		setTitle("W Pani domu jest Bomba v1.1");
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon icon = new ImageIcon(getClass().getResource(
	            "images/icon.png"));
		
		Image img = icon.getImage();
		
		
		setIconImage(img);
		MainFrame to = this;
		
		
		
		load = new JMenuItem("Settings");
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadFrame lFrame = new LoadFrame();
				lFrame.setVisible(true);
				lFrame.setButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							bomb = Integer.valueOf(lFrame.bombTxt.getText());
							row = Integer.valueOf(lFrame.rowTxt.getText());
							line = Integer.valueOf(lFrame.lineTxt.getText());
						}
						catch(NumberFormatException f) {
							JOptionPane.showMessageDialog(to, "You must choose a number!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						if(row*line/3 > bomb) {
							
							lFrame.dispose();
							to.remove(mainPanel);
							mainPanel = new FieldPanel(iPanel, row ,line, bomb);
							to.add(mainPanel);
							SwingUtilities.updateComponentTreeUI(to);
							
							to.setSize(new Dimension(line*43+22,row*43+80));
							
							
							
						}
						else {
							JOptionPane.showMessageDialog(to, "Number of bombs must be smaller than 1/3 of field size!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				
			}
		});
		
		
		info = new JMenuItem("Author");
		info.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(to,
					    "Minesweeper made by Tomasz Na³êcz");	
			}
		});
		
		menu = new JMenu("Menu");
		menu.add(load);
		menu.add(info);
		
		menuBar = new JMenuBar();
		menuBar.add(menu);
		
		setJMenuBar(menuBar);
		
		
		
		
		
		iPanel = new InfoPanel();
		iPanel.resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				iPanel.timer.stop();
				iPanel.setElapsedTime(0);
				iPanel.setTime(0);
				iPanel.clockLabel.setText("Time: 000");
				
				System.out.println(mainPanel.field.get(1).getSize());
				System.out.println(iPanel.getSize());
				System.out.println(to.getSize());
				
				iPanel.bombLabel.setText("Bombs: "+bomb);
				to.remove(mainPanel);
				mainPanel = new FieldPanel(iPanel, row , line, bomb);
				to.add(mainPanel);
				SwingUtilities.updateComponentTreeUI(to);
			}
		});
		
		mainPanel = new FieldPanel(iPanel, 16 ,31, 99);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(iPanel, BorderLayout.NORTH);
		
	}

	

}
