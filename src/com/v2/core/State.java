package com.v2.core;

import java.awt.Graphics;

public interface State {

	String path();
	
	void render(Graphics g);
}
