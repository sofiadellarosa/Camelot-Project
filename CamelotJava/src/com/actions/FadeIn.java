package com.actions;

public class FadeIn implements IAction {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FadeIn";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}
}
