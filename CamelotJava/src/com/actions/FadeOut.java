package com.actions;

public class FadeOut implements IAction{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FadeOut";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}

}
