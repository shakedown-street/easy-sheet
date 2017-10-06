package com.v2.states;

import java.awt.Graphics;

import com.v2.core.State;

public class Login implements State {
	
	public Login() {
		
	}

	@Override
	public String path() {
		return "/auth/login/";
	}

	@Override
	public void render(Graphics g) {
		
	}

}
