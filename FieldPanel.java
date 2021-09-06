package saper;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class FieldPanel extends JPanel implements MouseListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<BombButton> field = new ArrayList<BombButton>();	

	boolean started = false;
	
	int fieldNumber;
	int bombs;
	int b;
	int toWin = 0;
	
	InfoPanel infTo;
	
	FieldPanel to;
	
	
	///////// 				IKONY 					///////////
	ImageIcon icon = new ImageIcon(getClass().getResource(
            "images/flag.png"));
	
	Image img = icon.getImage();  
	Image newimg = img.getScaledInstance( 43, 43,  java.awt.Image.SCALE_SMOOTH );
	ImageIcon flagIcon = new ImageIcon(newimg);
	
	
	
	ImageIcon icon2 = new ImageIcon(getClass().getResource(
            "images/clear.png"));
	
	Image img2 = icon2.getImage();  
	Image newimg2 = img2.getScaledInstance( 43, 43,  java.awt.Image.SCALE_SMOOTH );
	ImageIcon clearIcon = new ImageIcon(newimg2);
	
	
	
	ImageIcon icon3 = new ImageIcon(getClass().getResource(
            "images/bomb.png"));
	
	Image img3 = icon3.getImage();  
	Image newimg3 = img3.getScaledInstance( 57, 57,  java.awt.Image.SCALE_SMOOTH );
	ImageIcon bombIcon = new ImageIcon(newimg3);
	
	
	ImageIcon icon4 = new ImageIcon(getClass().getResource(
            "images/nobomb.png"));
	
	Image img4 = icon4.getImage();  
	Image newimg4 = img4.getScaledInstance( 57, 57,  java.awt.Image.SCALE_SMOOTH );
	ImageIcon nobombIcon = new ImageIcon(newimg4);
	/////////////////////////////////////////////////////////////////////////
	
	
	
	public FieldPanel(InfoPanel iP, int row, int line, int bmb) {
		to = this;
		infTo = iP;
		fieldNumber = row*line;
		bombs = bmb;
		b = bmb;
		
		
		
		for( int i = 0; i < fieldNumber; i++ ) {
			
			field.add(new BombButton(clearIcon));
			field.get(i).addMouseListener(this);
			
			int j = i;
			field.get(i).addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					to.clear(field, j, fieldNumber, row, line);
					
				}
			});
			this.add(field.get(i));
		}
		
		this.setLayout(new GridLayout(row,line));
	}
	
	
	
	public void clear(List<BombButton> field, int j , int fieldNumber, int row, int line ) {
		
		toWin++;
		System.out.println(toWin+"/"+fieldNumber+"/"+b);
		
		if(!started) {
			started = true;
			infTo.timer.start();
			
			Random random = new Random();
			int k;
			
			for( int i = 0; i < bombs; i++) {
				
				do {
					k = random.nextInt(row*line-1);
				}
				while( field.get(k).isBomb() || k == j);
				
				field.get(k).setBomb(true);
			}
		}
		
		if( !field.get(j).isFlagged() ) {
		
			field.get(j).setBackground(null);
			field.get(j).setEnabled(false);
			field.get(j).setIcon(null);
			
			
			if( j == 0 ) {
				int bombSum = 0;
				if(field.get(1).isBomb()) bombSum++;
				if(field.get(line).isBomb()) bombSum++;
				if(field.get(line+1).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(1).isEnabled()) this.clear(field, 1, fieldNumber, row, line);
					if(field.get(line).isEnabled()) this.clear(field, line, fieldNumber, row, line);
					if(field.get(line+1).isEnabled()) this.clear(field, line+1, fieldNumber, row, line);
				}
			}
			
			if( j == line - 1 ) {
				int bombSum = 0;
				if(field.get(line-2).isBomb()) bombSum++;
				if(field.get(2*line-1).isBomb()) bombSum++;
				if(field.get(2*line-2).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(line-2).isEnabled()) this.clear(field, line-2, fieldNumber, row, line);
					if(field.get(2*line-2).isEnabled()) this.clear(field, 2*line-2, fieldNumber, row, line);
					if(field.get(2*line-1).isEnabled()) this.clear(field, 2*line-1, fieldNumber, row, line);
				}
			}
			
			if( j == line*(row-1) ) {
				int bombSum = 0;
				if(field.get(line*(row-2)).isBomb()) bombSum++;
				if(field.get(line*(row-2)+1).isBomb()) bombSum++;
				if(field.get(line*(row-1)+1).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(line*(row-2)).isEnabled()) this.clear(field, line*(row-2), fieldNumber, row, line);
					if(field.get(line*(row-2)+1).isEnabled()) this.clear(field, line*(row-2)+1, fieldNumber, row, line);
					if(field.get(line*(row-1)+1).isEnabled()) this.clear(field, line*(row-1)+1, fieldNumber, row, line);
				}
			}
			
			if( j == row*line-1 ) {
				int bombSum = 0;
				if(field.get((row-1)*line-2).isBomb()) bombSum++;
				if(field.get((row-1)*line-1).isBomb()) bombSum++;
				if(field.get(row*line-2).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get((row-1)*line-2).isEnabled()) this.clear(field, (row-1)*line-2, fieldNumber, row, line);
					if(field.get((row-1)*line-1).isEnabled()) this.clear(field, (row-1)*line-1, fieldNumber, row, line);
					if(field.get(row*line-2).isEnabled()) this.clear(field, row*line-2, fieldNumber, row, line);
				}
			}
			
			if( j > 0 && j < line - 1 ) {
				
				int bombSum = 0;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j+line-1).isBomb()) bombSum++;
				if(field.get(j+line).isBomb()) bombSum++;
				if(field.get(j+line+1).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-1).isEnabled()) this.clear(field, j-1, fieldNumber, row, line);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1, fieldNumber, row, line);
					if(field.get(j+line-1).isEnabled()) this.clear(field, j+line-1, fieldNumber, row, line);
					if(field.get(j+line).isEnabled()) this.clear(field, j+line, fieldNumber, row, line);
					if(field.get(j+line+1).isEnabled()) this.clear(field, j+line+1, fieldNumber, row, line);
				}
				
			}
			
			
			if( j > (row-1)*line && j < row*line-1 ) {
				
				int bombSum = 0;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j-line-1).isBomb()) bombSum++;
				if(field.get(j-line).isBomb()) bombSum++;
				if(field.get(j-line+1).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-1).isEnabled()) this.clear(field, j-1, fieldNumber, row, line);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1, fieldNumber, row, line);
					if(field.get(j-line-1).isEnabled()) this.clear(field, j-line-1, fieldNumber, row, line);
					if(field.get(j-line).isEnabled()) this.clear(field, j-line, fieldNumber, row, line);
					if(field.get(j-line+1).isEnabled()) this.clear(field, j-line+1, fieldNumber, row, line);
				}
				
			}
			
			if( j%line == 0 && j != 0 && j != (row-1)*line) {
				
				int bombSum = 0;
				if(field.get(j-line).isBomb()) bombSum++;
				if(field.get(j+line).isBomb()) bombSum++;
				if(field.get(j-line+1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j+line+1).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-line).isEnabled()) this.clear(field, j-line, fieldNumber, row, line);
					if(field.get(j+line).isEnabled()) this.clear(field, j+line, fieldNumber, row, line);
					if(field.get(j-line+1).isEnabled()) this.clear(field, j-line+1, fieldNumber, row, line);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1, fieldNumber, row, line);
					if(field.get(j+line+1).isEnabled()) this.clear(field, j+line+1, fieldNumber, row, line);
				}
				
			}
			
			if( (j+1)%line == 0 && j != line-1 && j != row*line-1) {
				
				int bombSum = 0;
				if(field.get(j-line-1).isBomb()) bombSum++;
				if(field.get(j-line).isBomb()) bombSum++;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+line-1).isBomb()) bombSum++;
				if(field.get(j+line).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-line-1).isEnabled()) this.clear(field, j-line-1, fieldNumber, row, line);
					if(field.get(j-line).isEnabled()) this.clear(field, j-line, fieldNumber, row, line);
					if(field.get(j-1).isEnabled()) this.clear(field, j-1, fieldNumber, row, line);
					if(field.get(j+line-1).isEnabled()) this.clear(field, j+line-1, fieldNumber, row, line);
					if(field.get(j+line).isEnabled()) this.clear(field, j+line, fieldNumber, row, line);
				}
				
			}
			
			if( j%line > 0 && j%line < line-1 && j > line && j < (row-1)*line-1 ) {
			
				
				int bombSum = 0;
				if(field.get(j-line-1).isBomb()) bombSum++;
				if(field.get(j-line).isBomb()) bombSum++;
				if(field.get(j-line+1).isBomb()) bombSum++;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j+line-1).isBomb()) bombSum++;
				if(field.get(j+line).isBomb()) bombSum++;
				if(field.get(j+line+1).isBomb()) bombSum++;
					
				field.get(j).setText(bombSum + "");
					
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-line-1).isEnabled()) this.clear(field, j-line-1, fieldNumber, row, line);
					if(field.get(j-line).isEnabled()) this.clear(field, j-line, fieldNumber, row, line);
					if(field.get(j-line+1).isEnabled()) this.clear(field, j-line+1, fieldNumber, row, line);
					if(field.get(j-1).isEnabled()) this.clear(field, j-1, fieldNumber, row, line);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1, fieldNumber, row, line);
					if(field.get(j+line-1).isEnabled()) this.clear(field, j+line-1, fieldNumber, row, line);
					if(field.get(j+line).isEnabled()) this.clear(field, j+line, fieldNumber, row, line);
					if(field.get(j+line+1).isEnabled()) this.clear(field, j+line+1, fieldNumber, row, line);
				}
				
			}
			
			if( field.get(j).isBomb() ) {
				bomb();
				field.get(j).setEnabled(true);
				JOptionPane.showMessageDialog(this, 
					"Przegra³eœ!", "Bomba", JOptionPane.ERROR_MESSAGE);
				infTo.resetButton.doClick();
				infTo.timer.stop();
			}
		
		}
		if( !field.get(j).isBomb() && field.get(j).isFlagged() ) {
			bomb();
			JOptionPane.showMessageDialog(this, 
				"Przegra³eœ!", "Bomba", JOptionPane.ERROR_MESSAGE);
			infTo.resetButton.doClick();
			infTo.timer.stop();
		}
		
		if(toWin == fieldNumber - b) {
			
			flag();
			infTo.timer.stop();
			
			JOptionPane.showMessageDialog(this,
				    "Pokona³eœ planszê "+row+"x"+line+" w czasie "+infTo.time+"s",
				    "WYGRANA!!!",
				    JOptionPane.PLAIN_MESSAGE);
				
		}
		
	}
	
	public void flag() {
		
		for(int i = 0; i < fieldNumber;i++) {
			
			if(field.get(i).isEnabled()) {
				
				field.get(i).setIcon(flagIcon);	
			}	
		}
		
		infTo.bombLabel.setText("Bombs: 0");
	}
	
	public void bomb() {
		
		for(int i = 0; i < fieldNumber;i++) {
			
			if(field.get(i).isBomb()) {
				
				field.get(i).setIcon(bombIcon);	
			}
			else {
				if(field.get(i).isFlagged()) {
					field.get(i).setIcon(nobombIcon);
				}
			}	
		}
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON3) {
			
			
			
			for(int i = 0; i < fieldNumber; i++) {
				
				if( e.getSource() == field.get(i) ) {
					
					if(field.get(i).isEnabled()) {
					
						if(!field.get(i).isFlagged()) {
							
							field.get(i).setIcon(flagIcon);
							field.get(i).setFlagged(true);
							bombs--;
							infTo.bombLabel.setText("Bombs:" +bombs);
						}
						else {
							field.get(i).setIcon(clearIcon);
							field.get(i).setFlagged(false);
							bombs++;
							infTo.bombLabel.setText("Bombs: "+bombs);
						}
					}
					
				}
				
			}
			
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
