package v2.states;

import java.awt.Color;
import java.awt.Graphics;

import v2.components.SpreadSheet;
import v2.core.State;

public class HomeState implements State {
	
	private SpreadSheet sheet;
	
	public HomeState() {
		sheet = new SpreadSheet();
	}

	@Override
	public String path() {
		return "/app/home/";
	}

	@Override
	public void render(Graphics g) {
		g.clearRect(0, 0, (int) g.getClipBounds().getWidth(), (int) g.getClipBounds().getHeight());
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, (int) g.getClipBounds().getWidth(), (int) g.getClipBounds().getHeight());
	}

}
