package com.v2;

import java.util.ArrayList;

import com.v2.core.State;

public class AppRouter {
	
	public String url;
	private ArrayList<State> states;
	
	private State errorState;
	
	public AppRouter(String _home) {
		url = _home;
		states = new ArrayList<State>();
	}
	
	public void registerStates(State... _states) {
		for (State state : _states) {
			states.add(state);
		}
	}
	
	private State getStateAtPath(String _path) {
		for (State state : states) {
			if (state.path().equals(_path)) {
				return state;
			}
		}
		return null;
	}
	
	private boolean isStateValid(String _path) {
		if (getStateAtPath(_path) != null) {
			return true;
		}
		return false;
	}
	
	public State getState() {
		State currentState = getStateAtPath(url);
		if (isStateValid(url)) {
			return currentState;
		} else {
			url = errorState.path();
			return errorState;
		}
	}
	
	public void setErrorState(String _path) {
		errorState = getStateAtPath(_path);
	}

}
