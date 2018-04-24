package com.thought.works;

import java.util.HashMap;

public class BattleShip {

	

	enum ShipType {
		P("P"), Q("Q");
		ShipType(String type) {
			this.type = type;
		}
		String type;
	};
	
	Queue<String>missileSequence ;

	HashMap<String, Integer> shipsWithPower = new HashMap<String, Integer>();
	
	public void addMissileSequence(String location)
	{
		missileSequence = (Queue<String>)new  LinkedList( (Arrays.asList(location.split(" "))));
		System.out.println(missileSequence);

	}

	public void addShips(String location, ShipType type) {
		if (type.equals(ShipType.P))
			shipsWithPower.put(location, 1);
		if (type.equals(ShipType.Q))
			shipsWithPower.put(location, 2);

	}

	public boolean fire(String location) {
		if (shipsWithPower.containsKey(location)) {
			if (shipsWithPower.get(location) > 1)
				shipsWithPower.put(location, 1);
			else
				shipsWithPower.remove(location);

			return true;
		}
		return false;
	}

	static class Dimension {
		int width;

		public Dimension(int width, char height) {
			super();
			this.width = width;
			this.height = height;
		}

		char height;
	};

}
