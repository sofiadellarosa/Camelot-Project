package com.entities;

public class Place implements IThing {
	private String name;
	private Places template;
	private Furniture furniturePlace; 
	
	
	public enum Places{
		AlchemyShop, Blacksmith, Bridge, Camp, CastleBedroom, CastleCrossroads, City, 
		Cottage, Courtyard, DiningRoom, Dungeon, Farm, ForestPath, GreatHall, 
		Hallway, Library, Port, Ruins, SpookyPath, Storage, Tavern
	}
	
	public Place(String name, Places template) {
		this.name = name;
		this.template = template;
	}
	
	public Furniture getFurniture(String furniture) {
		furniturePlace = new Furniture(furniture);
		return furniturePlace;
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public Object getTemplate() {
		// TODO Auto-generated method stub
		return template;
	}

}
