package saper;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.IllegalFormatConversionException;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel bombLabel;
	JLabel clockLabel;
	JLabel emptyL;
	JLabel emptyL2;
	
	JButton resetButton;

	int time = 0;
	int elapsedTime = 0;
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(final ActionEvent e) {
			elapsedTime = elapsedTime+1000;
			time = (elapsedTime/1000);
			try {
				clockLabel.setText("Time: "+String.format("%03d", time));
			}catch(IllegalFormatConversionException f) {
				f.getStackTrace();
			}
		}
	});	

	
	
	public InfoPanel() {
		bombLabel = new JLabel("Bombs: "+"99");
		clockLabel = new JLabel("Time: "+"000");
		resetButton = new JButton("Reset");
		emptyL = new JLabel("   ");
		emptyL2 = new JLabel("   ");
		
		this.add(bombLabel);
		this.add(emptyL);
		this.add(resetButton);
		this.add(emptyL2);
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

}
