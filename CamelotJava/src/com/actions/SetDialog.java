package com.actions;

public class SetDialog implements IAction {
	private String dialogLine;
	
	public SetDialog(String dialogLine) {
		this.dialogLine = dialogLine;
	}
	
	public String getDialog() {
		return dialogLine;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SetDialog";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(), getDialog());
	}
	
	

}
