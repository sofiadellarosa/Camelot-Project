import com.actions.*;
import com.entities.Character;
import com.entities.Character.BodyType;
import com.entities.Character.Clothing;
import com.entities.Character.HairStyle;
import com.entities.Item.Items;
import com.entities.*;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.playerInput.*;
import com.playerInput.ActionChoice.Icons;
import com.sequences.CharacterCreation;
import com.storygraph.*;

public class ShortStory implements IStory{
	private Item sword;
	private Item greenKey;
	private Item coin;
	private Item bottle;
	
	private Character tom;
	private Character roomPerson;
	private Character smithMerchant;
	private Character prisoner;
	
	private Place room; 
	private Place city; 
	private Place blackSmith;
	private Place dungeon;
	
	//private Furniture door;
	//private Furniture chest;
	
	private enum NodeLabels{
		Init, Start, TalkToPerson, GoToCity, GoToBlackSmith, TalkToMerchant, OpenChest, AddCoinToList,
		CloseChest
	}
	
	@Override
	public void getThings() {
		// Character variables
		tom = new Character(ThingNames.Tom.toString(), BodyType.A, Clothing.Bandit);
		roomPerson = new Character(ThingNames.RoomPerson.toString(), BodyType.D, Clothing.Noble, HairStyle.Long);
		smithMerchant = new Character(ThingNames.SmithMerchant.toString(), BodyType.F, Clothing.Merchant, HairStyle.Spiky);
		prisoner = new Character(ThingNames.Prisoner.toString(), BodyType.B, Clothing.Bandit);
		
		// Place variables
		room = new Place(ThingNames.Room.toString(), Places.CastleBedroom);
		city = new Place(ThingNames.City.toString(), Places.City);
		dungeon = new Place(ThingNames.Dungeon.toString(), Places.Dungeon);
		blackSmith = new Place(ThingNames.Dungeon.toString(), Places.Blacksmith);
		
		// Furniture variables???
		//door = new Furniture(ThingNames.Door.toString());
		//chest = new Furniture(ThingNames.Chest.toString());
		
		// Item variables 
		sword = new Item(ThingNames.Sword.toString(), Items.Sword);
		greenKey = new Item(ThingNames.GreenKey.toString(), Items.GreenKey);
		coin = new Item(ThingNames.Coin.toString(), Items.Coin);
		bottle = new Item(ThingNames.Bottle.toString(), Items.Bottle);
		
	}
	
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(tom));
		sequence.combineWith(new CharacterCreation(roomPerson));
		sequence.add(new Create<Place>(room));
		sequence.add(new Position(tom, room));
		sequence.add(new Position(roomPerson, room, "Couch.Left"));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Create<Item>(bottle));
		sequence.add(new Position(sword, room, "Table.Left"));
		sequence.add(new Position(bottle, room, "Table.right"));
		sequence.add(new SetCameraFocus(tom));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getStartSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getTalkToPersonSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("You must choose the sword or the bottle."));
		sequence.add(new HideDialog());
		return sequence;
	}

	private ActionSequence getGoToCitySequence() {
		var sequence = new ActionSequence();
		sequence.add(new Take(tom, sword));
		sequence.add(new FadeOut());
		sequence.add(new Create<Place>(city));
		sequence.add(new Position(tom, city));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	// FIX THIS ONE
	private ActionSequence getGoToBlackSmithSequence() {
		var sequence = new ActionSequence();
		// ?? Ask about Exiting --> should this be part of action sequence, what are the roots for?
		// How do I make multiple options for the user?
		sequence.add(new Exit(tom, city.getFurniture("BrownHouseDoor"), true));
		// Create place??
		sequence.add(new Create<Place>(blackSmith));
		sequence.combineWith(new CharacterCreation(smithMerchant));
		sequence.add(new Position(smithMerchant, blackSmith, "BackDoor"));
		sequence.add(new Enter(tom, blackSmith.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getTalkToMerchantSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("To buy a key, you must have one coin."));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	
	// Can I add a parameter to be able to open chests elsewhere? 
	private ActionSequence getOpenChestSequence(Place place) {
		var sequence = new ActionSequence();
		sequence.add(new OpenFurniture(tom, place.getFurniture("Chest")));
		return sequence;
	}
	
	private ActionSequence getAddCoinToListSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pocket(tom, coin));
		sequence.add(new AddToList(coin, "This is a coin."));
		return sequence;
	}
	
	private ActionSequence getCloseChestSequence(Place place) {
		var sequence = new ActionSequence();
		sequence.add(new CloseFurniture(tom, place.getFurniture("Chest")));
		return sequence;
	}
	
	private ActionSequence getBuyKeySequence() {
		var sequence = new ActionSequence();
		// need to implement this sequence 
		return sequence; 
		
	}

	@Override
	public ActionMap getMap() {
		var map = new ActionMap();
		// Beginning of the story, the user talks to a person and chooses between two objects
		map.add(NodeLabels.Init.toString(), getInitSequence());
		map.add(NodeLabels.Start.toString(), getStartSequence());
		map.add(NodeLabels.TalkToPerson.toString(), getTalkToPersonSequence());
		
		// I want multiple options, what if they choose the bottle?
		//User chose sword, goes to city, visits blackSmith or dungeon
		map.add(NodeLabels.GoToCity.toString(), getGoToCitySequence());	
		map.add(NodeLabels.GoToBlackSmith.toString(), getGoToBlackSmithSequence());
		map.add(NodeLabels.TalkToMerchant.toString(), getTalkToMerchantSequence());
		map.add(NodeLabels.OpenChest.toString(), getOpenChestSequence(blackSmith)); // open chest in blacksmith
		map.add(NodeLabels.AddCoinToList.toString(), getAddCoinToListSequence());
		map.add(NodeLabels.CloseChest.toString(), getCloseChestSequence(blackSmith));
		
		
		
		return map;
	}

	@Override
	public INode getRoot() {
		// TODO Auto-generated method stub
		return new Node("root");
	}

	

}
