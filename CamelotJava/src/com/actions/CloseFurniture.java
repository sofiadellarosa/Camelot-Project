package com.actions;

import com.entities.Character;
import com.entities.Furniture;

// CloseFurniture takes in two required fields, Character and Furniture
public class CloseFurniture implements IAction{
	private Character character;
	private Furniture furniture;
	
	public CloseFurniture(Character character, Furniture furniture) {
		this.character = character;
		this.furniture = furniture;
	}
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CloseFurniture";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), furniture.getName());
	}
		
}
