package saper;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class BombButton extends JButton {
	
	boolean bomb = false;
	boolean flagged = false;
	int bombNumber;
	int bombIteration;
	

	public BombButton() {
		// TODO Auto-generated constructor stub
		
	}

	public BombButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public BombButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public BombButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public BombButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public int getBombNumber() {
		return bombNumber;
	}

	public void setBombNumber(int bombNumber) {
		this.bombNumber = bombNumber;
	}

	public int getBombIteration() {
		return bombIteration;
	}

	public void setBombIteration(int bombIteration) {
		this.bombIteration = bombIteration;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

}
