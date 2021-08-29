package saper;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class FieldPanel extends JPanel implements MouseListener  {

	List<BombButton> field = new ArrayList<BombButton>();	

	int fieldN;
	int bombs;
	
	ImageIcon flagIcon=new ImageIcon(getClass().getResource(
            "images/flag.png"));
	
	//Image img = icon.getImage();  
	//Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH );
	//ImageIcon flagIcon = new ImageIcon(newimg);
	
	
	ImageIcon clearIcon=new ImageIcon(getClass().getResource(
            "images/clear.png"));
	
	
	InfoPanel infTo;
	
	public FieldPanel(InfoPanel iP, int fieldNumber, int row, int line, int b) {
		FieldPanel to = this;
		infTo = iP;
		fieldN = fieldNumber;
		bombs = b;
		
		for( int i = 0; i < fieldNumber; i++ ) {
			
			field.add(new BombButton(/*clearIcon*/i+""));
		}
		
		Random random = new Random();
		int k;
		
		for( int i = 0; i < bombs; i++) {
			
			do {
				k = random.nextInt(63);
			}
			while( field.get(k).isBomb() );
			
			field.get(k).setBomb(true);
		}
		
		
		
		for( int i = 0; i < fieldNumber; i++ ) {
			
			
			field.get(i).addMouseListener(this);
			
			int j = i;
			field.get(i).addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					to.clear(field, j);
					
				}
			});
			this.add(field.get(i));
		}
		
		this.setLayout(new GridLayout(row,line));
	}
	
	
	
	public void clear(List<BombButton> field, int j ) {
		
		if( !field.get(j).isFlagged() ) {
		
			field.get(j).setBackground(null);
			field.get(j).setEnabled(false);
			field.get(j).setIcon(null);
			
			
			if( j == 0 ) {
				int bombSum = 0;
				if(field.get(1).isBomb()) bombSum++;
				if(field.get(8).isBomb()) bombSum++;
				if(field.get(9).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(1).isEnabled()) this.clear(field, 1);
					if(field.get(8).isEnabled()) this.clear(field, 8);
					if(field.get(9).isEnabled()) this.clear(field, 9);
				}
			}
			
			if( j == 7 ) {
				int bombSum = 0;
				if(field.get(6).isBomb()) bombSum++;
				if(field.get(14).isBomb()) bombSum++;
				if(field.get(15).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(6).isEnabled()) this.clear(field, 6);
					if(field.get(14).isEnabled()) this.clear(field, 14);
					if(field.get(15).isEnabled()) this.clear(field, 15);
				}
			}
			
			if( j == 56 ) {
				int bombSum = 0;
				if(field.get(48).isBomb()) bombSum++;
				if(field.get(49).isBomb()) bombSum++;
				if(field.get(57).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(48).isEnabled()) this.clear(field, 48);
					if(field.get(49).isEnabled()) this.clear(field, 49);
					if(field.get(57).isEnabled()) this.clear(field, 57);
				}
			}
			
			if( j == 63 ) {
				int bombSum = 0;
				if(field.get(54).isBomb()) bombSum++;
				if(field.get(55).isBomb()) bombSum++;
				if(field.get(62).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(54).isEnabled()) this.clear(field, 54);
					if(field.get(55).isEnabled()) this.clear(field, 55);
					if(field.get(62).isEnabled()) this.clear(field, 62);
				}
			}
			
			if( j > 0 && j < 7 ) {
				
				int bombSum = 0;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j+7).isBomb()) bombSum++;
				if(field.get(j+8).isBomb()) bombSum++;
				if(field.get(j+9).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-1).isEnabled()) this.clear(field, j-1);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1);
					if(field.get(j+7).isEnabled()) this.clear(field, j+7);
					if(field.get(j+8).isEnabled()) this.clear(field, j+8);
					if(field.get(j+9).isEnabled()) this.clear(field, j+9);
				}
				
			}
			
			
			if( j > 56 && j < 63 ) {
				
				int bombSum = 0;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j-9).isBomb()) bombSum++;
				if(field.get(j-8).isBomb()) bombSum++;
				if(field.get(j-7).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-1).isEnabled()) this.clear(field, j-1);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1);
					if(field.get(j-9).isEnabled()) this.clear(field, j-9);
					if(field.get(j-8).isEnabled()) this.clear(field, j-8);
					if(field.get(j-7).isEnabled()) this.clear(field, j-7);
				}
				
			}
			
			if( j%8 == 0 && j != 0 && j != 56) {
				
				int bombSum = 0;
				if(field.get(j-8).isBomb()) bombSum++;
				if(field.get(j+8).isBomb()) bombSum++;
				if(field.get(j-7).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j+9).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-8).isEnabled()) this.clear(field, j-8);
					if(field.get(j+8).isEnabled()) this.clear(field, j+8);
					if(field.get(j-7).isEnabled()) this.clear(field, j-7);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1);
					if(field.get(j+9).isEnabled()) this.clear(field, j+9);
				}
				
			}
			
			if( (j+1)%8 == 0 && j != 7 && j != 63) {
				
				int bombSum = 0;
				if(field.get(j-9).isBomb()) bombSum++;
				if(field.get(j-8).isBomb()) bombSum++;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+7).isBomb()) bombSum++;
				if(field.get(j+8).isBomb()) bombSum++;
				
				field.get(j).setText(bombSum + "");
				
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-9).isEnabled()) this.clear(field, j-9);
					if(field.get(j-8).isEnabled()) this.clear(field, j-8);
					if(field.get(j-1).isEnabled()) this.clear(field, j-1);
					if(field.get(j+7).isEnabled()) this.clear(field, j+7);
					if(field.get(j+8).isEnabled()) this.clear(field, j+8);
				}
				
			}
			
			if( j%8 > 0 && j%8 < 7 && j > 8 && j < 55 ) {
			
				
				int bombSum = 0;
				if(field.get(j-9).isBomb()) bombSum++;
				if(field.get(j-8).isBomb()) bombSum++;
				if(field.get(j-7).isBomb()) bombSum++;
				if(field.get(j-1).isBomb()) bombSum++;
				if(field.get(j+1).isBomb()) bombSum++;
				if(field.get(j+7).isBomb()) bombSum++;
				if(field.get(j+8).isBomb()) bombSum++;
				if(field.get(j+9).isBomb()) bombSum++;
					
				field.get(j).setText(bombSum + "");
					
				if( bombSum == 0 ) {
					field.get(j).setText("");
					if(field.get(j-9).isEnabled()) this.clear(field, j-9);
					if(field.get(j-8).isEnabled()) this.clear(field, j-8);
					if(field.get(j-7).isEnabled()) this.clear(field, j-7);
					if(field.get(j-1).isEnabled()) this.clear(field, j-1);
					if(field.get(j+1).isEnabled()) this.clear(field, j+1);
					if(field.get(j+7).isEnabled()) this.clear(field, j+7);
					if(field.get(j+8).isEnabled()) this.clear(field, j+8);
					if(field.get(j+9).isEnabled()) this.clear(field, j+9);
				}
				
			}
			
			if( field.get(j).isBomb() ) {
				//JOptionPane.showMessageDialog(this, 
					//"Bum", "Bomba", JOptionPane.ERROR_MESSAGE);
				field.get(j).setText("B");
			}
		
		}
		if( !field.get(j).isBomb() && field.get(j).isFlagged() ) {
			//JOptionPane.showMessageDialog(this, 
				//"Bum", "Bomba", JOptionPane.ERROR_MESSAGE);
			field.get(j).setText("NB");
			field.get(j).setIcon(null);
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			
			
			
			for(int i = 0; i < fieldN; i++) {
				
				if( e.getSource() == field.get(i) ) {
					
					if(field.get(i).isEnabled()) {
					
						if(!field.get(i).isFlagged()) {
							
							field.get(i).setIcon(flagIcon);
							field.get(i).setFlagged(true);
							bombs--;
							infTo.bombLabel.setText("Bombs: "+"0"+bombs);
						}
						else {
							field.get(i).setIcon(clearIcon);
							field.get(i).setFlagged(false);
							bombs++;
							infTo.bombLabel.setText("Bombs: "+"0"+bombs);
						}
					}
					
				}
				
			}
			
		}
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
