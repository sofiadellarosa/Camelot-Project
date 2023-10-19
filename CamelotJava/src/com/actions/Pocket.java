package com.actions;
import com.entities.Character;
import com.entities.Item;

//takes two required parameters: a Character field and an Item field

public class Pocket implements IAction{
	private Character character;
	private Item item;
	
	public Pocket(Character character, Item item) {
		this.character = character;
		this.item = item;
	}
	
	@Override
	public String getName() {
		return "Pocket";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
	}

}
