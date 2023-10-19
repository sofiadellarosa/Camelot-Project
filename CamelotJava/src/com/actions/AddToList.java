package com.actions;
import com.entities.IEntity;

public class AddToList implements IAction{
	IEntity other;
	String description;
	
	// if no description is made
	public AddToList(IEntity other) {
		this.other = other;
	}
	
	// if there is a description for the entity
	public AddToList(IEntity other, String description) {
		this.other = other;
		this.description = description;
	}
	//Getter method for string description
	public String getDescription() {
		return description;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AddToList";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public String toString() {
		if (description == null) {
			return String.format("%s(%s)",  getName(), other.getName());
		}
		else {
			return String.format("%s(%s, %s)", getName(), other.getName(), getDescription());
		}
	}

}
