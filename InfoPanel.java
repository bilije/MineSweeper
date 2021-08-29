package saper;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	JLabel bombLabel;
	JLabel clockLabel;
	JButton resetButton;
	
	public InfoPanel() {
		bombLabel = new JLabel("Bombs: "+"10");
		clockLabel = new JLabel("Time: "+"000");
		resetButton = new JButton("Reset");
				
		this.add(resetButton);
		this.add(bombLabel);
		this.add(clockLabel);
		
		
		this.setLayout(new FlowLayout());
		
		
	}

	public InfoPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public InfoPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public InfoPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
