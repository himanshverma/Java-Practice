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
	private String playerName;
	private Queue<String>missileSequence;
	private HashMap<String, Integer> shipsLocation = new HashMap<String, Integer>();
	private int targetLeft;
	
	public Queue<String> getMissileSequence() {
		return missileSequence;
	}

	public HashMap<String, Integer> getShipsLocation() {
		return shipsLocation;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public BattleShip(String playerName) {
		super();
		this.playerName = playerName;
	}

	
	public void addMissileSequence(String location)
	{
		missileSequence = (Queue<String>)new  LinkedList( (Arrays.asList(location.split(" "))));

	}
	public int missileCount()
	{
		return missileSequence.size();
	}
	
	public String nextMissile()
	{
		return missileSequence.poll();
	}

	public void addShips(String location, ShipType type) {
		if (type.equals(ShipType.P))
			shipsLocation.put(location, 1);
		if (type.equals(ShipType.Q))
			shipsLocation.put(location, 2);

	}

	public String fire(String location) {
		if (shipsLocation.containsKey(location)) {
			if (shipsLocation.get(location) > 1)
				shipsLocation.put(location, 1);
			else
				shipsLocation.remove(location);

			return "hit";
		}
		return "miss";
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
