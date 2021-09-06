package saper;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoadFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel rowLabel;
	JLabel lineLabel;
	JLabel bombLabel;
	
	JTextField rowTxt;
	JTextField lineTxt;
	JTextField bombTxt;
	
	JButton setButton;
	
	GridBagConstraints gbl = new GridBagConstraints();
	
	public LoadFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(225,150);
		setTitle("Custom");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridBagLayout());
		
		
		
		gbl.insets = new Insets(2,2,2,2);
		
		rowLabel = new JLabel("Height:");
		gbl.gridx = 0;
		gbl.gridy = 1;
		gbl.fill = GridBagConstraints.NONE;
		add(rowLabel, gbl);
		
		lineLabel = new JLabel("Width:");
		gbl.gridx = 0;
		gbl.gridy = 2;
		add(lineLabel, gbl);
		
		bombLabel = new JLabel("Bombs:");
		gbl.gridx = 0;
		gbl.gridy = 3;
		add(bombLabel, gbl);
		
		rowTxt = new JTextField(4);
		gbl.gridx = 1;
		gbl.gridy = 1;
		add(rowTxt, gbl);
		
		lineTxt = new JTextField(4);
		gbl.gridx = 1;
		gbl.gridy = 2;
		add(lineTxt, gbl);
		
		bombTxt = new JTextField(4);
		gbl.gridx = 1;
		gbl.gridy = 3;
		add(bombTxt, gbl);
		
		setButton = new JButton("Start");
		gbl.gridx = 0;
		gbl.gridy = 4;
		gbl.gridwidth = 4;
		gbl.fill = GridBagConstraints.CENTER;
		add(setButton, gbl);
	}

	public LoadFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public LoadFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public LoadFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	
}
