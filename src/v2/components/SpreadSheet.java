package v2.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class SpreadSheet extends JComponent {

	public SpreadSheet() {
		
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 200, 200);
	}

}
