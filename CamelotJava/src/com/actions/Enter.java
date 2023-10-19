package com.actions;

import com.entities.Character;
import com.entities.Furniture;


public class Enter implements IAction{
	Character character;
	Furniture furniture;
	boolean fadeOut;
	
	public Enter(Character character, Furniture furniture, boolean fadeOut) {
		this.character = character;
		this.furniture = furniture;
		this.fadeOut = fadeOut;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Enter";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), character.getName(), furniture.getName(), fadeOut);
	}

}
