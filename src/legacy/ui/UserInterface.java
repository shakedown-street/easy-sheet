package legacy.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import legacy.spreadsheet.SpreadSheet;

public class UserInterface extends JComponent {

	private static final long serialVersionUID = 1L;

	private final Font INTERFACE_FONT;
	private Input input;
	private SpreadSheet spreadsheet;

	public UserInterface() {
		INTERFACE_FONT = new Font("Lucida Console", Font.BOLD, 10);
		input = new Input(this);
		spreadsheet = new SpreadSheet(this, 7, 35);

		this.setFocusable(true);
		this.addKeyListener(input);
		this.setFocusTraversalKeysEnabled(false);
	}

	public void drawBackground(Graphics g) {
		g.setColor(SpreadSheet.BACK_COLOR);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void paintComponent(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(INTERFACE_FONT);
		drawBackground(g);
		input.draw(g, 15, 15);
		spreadsheet.draw(g, 15, 45);
	}

	// ============================================//

	public Input getInput() {
		return input;
	}

	public SpreadSheet getSpreadSheet() {
		return spreadsheet;
	}

}
