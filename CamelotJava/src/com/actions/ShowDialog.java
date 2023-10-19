package com.actions;

public class ShowDialog implements IAction {

	@Override
	public String getName() {
		return "ShowDialog";
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
