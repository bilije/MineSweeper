package saper;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame {

	InfoPanel iPanel;
	FieldPanel mainPanel;

	public MainFrame() throws HeadlessException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550,650);
		setTitle("W Pani domu jest Bomba");
		setLocationRelativeTo(null);
		setResizable(false);
		MainFrame to = this;
		
		
		iPanel = new InfoPanel();
		iPanel.resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				iPanel.bombLabel.setText("Bombs: 10");
				to.remove(mainPanel);
				mainPanel = new FieldPanel(iPanel, 64, 8 ,8, 10);
				to.add(mainPanel);
				SwingUtilities.updateComponentTreeUI(to);
			}
		});
		
		mainPanel = new FieldPanel(iPanel, 64, 8, 8, 10);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(iPanel, BorderLayout.NORTH);
		
	}

	

}
