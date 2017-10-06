package legacy.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import legacy.spreadsheet.Cell;
import legacy.spreadsheet.SpreadSheet;
import legacy.util.Utils;

public class Input implements KeyListener {

	private String input;

	private UserInterface ui;

	public Input(UserInterface ui) {
		this.ui = ui;
		this.input = "";
	}

	// ============================================//

	public void submitInput() {
		ui.getSpreadSheet().getSelectedCell().setFormula(input);
		input = ui.getSpreadSheet().getSelectedCell().getFormula();
	}

	// ============================================//

	public void draw(Graphics g, int x, int y) {
		int textHeight = y;
		int lineHeight = y + 10;
		int lineWidth = ui.getWidth();

		g.setColor(SpreadSheet.NORMAL_COLOR);
		g.drawLine(0, lineHeight - 25, lineWidth, lineHeight - 25);
		g.drawLine(0, lineHeight, lineWidth, lineHeight);

		g.setColor(SpreadSheet.NORMAL_COLOR);
		Cell selectedCell = ui.getSpreadSheet().getSelectedCell();
		g.drawString(selectedCell + " >> " + input + "*", x, textHeight);
	}

	// ============================================//

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			ui.getSpreadSheet().decrementSelectedRow();
			input = ui.getSpreadSheet().getSelectedCell().getFormula();
			break;
		case KeyEvent.VK_ENTER:
			submitInput();
		case KeyEvent.VK_DOWN:
			ui.getSpreadSheet().incrementSelectedRow();
			input = ui.getSpreadSheet().getSelectedCell().getFormula();
			break;
		case KeyEvent.VK_TAB:
		case KeyEvent.VK_RIGHT:
			ui.getSpreadSheet().incrementSelectedCol();
			input = ui.getSpreadSheet().getSelectedCell().getFormula();
			break;
		case KeyEvent.VK_LEFT:
			ui.getSpreadSheet().decrementSelectedCol();
			input = ui.getSpreadSheet().getSelectedCell().getFormula();
			break;
		case KeyEvent.VK_BACK_SPACE:
			input = Utils.truncateString(input, 1);
			break;
		default:
			if (Utils.charIsValid(keyChar))
				input += keyChar;
			break;
		}
		ui.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_ESCAPE:
			input = "";
			break;
		}

		ui.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// ============================================//

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	public String toString() {
		return input;
	}

}
