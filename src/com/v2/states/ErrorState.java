package com.v2.states;

import java.awt.Color;
import java.awt.Graphics;

import com.v2.core.State;

public class ErrorState implements State {

	@Override
	public String path() {
		return "/app/error/";
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("Error: you should not see this page", 20, 20);
	}

}
