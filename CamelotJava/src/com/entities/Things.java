package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{ Tom, Home, Sword, City, Merchant, GreenKey, BlackSmith, Dungeon, Room, 
		RoomPerson, SmithMerchant, Prisoner, Coin, Bottle, Door, Chest} 
	private static Hashtable<ThingNames, IThing<?>> list=new Hashtable<>();
	public static boolean add(ThingNames name, IThing<?> thing) {
		if(list.containsKey(name))
			return false;
		list.put(name, thing);
		return true;
	}
	
	public static Optional<IThing<?>> get(ThingNames name) {
		return Optional.ofNullable(list.get(name));
	}
}
