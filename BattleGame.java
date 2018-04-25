package com.thought.works;

import java.io.File;
import java.util.Scanner;

import com.thought.works.BattleShip.Dimension;
import com.thought.works.BattleShip.ShipType;



public class BattleGame {


	public static void main(String[] args) {

		// File file = new File("Input.txt");
		Scanner scanner = new Scanner(System.in);

		int widthOfBattleArea = scanner.nextInt();
		char heightOfBattleArea = scanner.next().charAt(0);
		Dimension battleAreaDimension = new Dimension(widthOfBattleArea,
				heightOfBattleArea);
		BattleShip player1 = new BattleShip("Player-1");
		BattleShip player2 = new BattleShip("Player-2");

		int battleShipCount = scanner.nextInt();

		for (int i = 1; i <= battleShipCount; i++) {

			String shipType = scanner.next();
			int widthOfShip = scanner.nextInt();
			char heightOfShip = scanner.next().charAt(0);
			String player1Cordinates = scanner.next();
			String player2Cordinates = scanner.next();

			for (int height = 0; height < heightOfShip - 48; height++) {
				for (int width = 0; width < widthOfShip; width++) {
					String key1 = String.valueOf((char) (player1Cordinates
							.charAt(0) + height))
							+ (int) (player1Cordinates.charAt(1) - 48 + width);
					String key2 = String.valueOf((char) (player2Cordinates
							.charAt(0) + height))
							+ (int) (player2Cordinates.charAt(1) - 48 + width);

					player1.addShips(key1, ShipType.valueOf(shipType));
					player2.addShips(key2, ShipType.valueOf(shipType));
				}
			}
		}
		scanner.nextLine();
		player1.addMissileSequence(scanner.nextLine());
		player2.addMissileSequence(scanner.nextLine());
		fight(player1, player2);
	}

	private static void fight(BattleShip player1, BattleShip player2) {
		String isHit = null;
		while ((player1.missileCount() != 0 || player2.missileCount() != 0)
				&& player1.getShipsLocation().size() != 0
				&& player2.getShipsLocation().size() != 0) {
			if (player1.missileCount() == 0)
				System.out.println(player1.getPlayerName()
						+ " has no more missiles left to launch ");
			else {
				do {
					String loc = player1.nextMissile();
					isHit = player2.fire(loc);
					System.out.println(player1.getPlayerName()
							+ " fires a missile with target " + loc
							+ " which got " + isHit);
					if (player2.getShipsLocation().size() == 0) {
						System.out.println("p1 wins");
						break;
					}
				} while (isHit.equals("hit"));
			}

			if (player2.missileCount() == 0)
				System.out.println(player2.getPlayerName()
						+ " has no more missiles left to launch ");
			else {

				do

				{
					String loc = player2.nextMissile();
					isHit = player1.fire(loc);
					System.out.println(player2.getPlayerName()
							+ " fires a missile with target " + loc
							+ " which got " + isHit);
					if (player1.getShipsLocation().size() == 0) {
						System.out.println("p2 wins");
						break;
					}

				}

				while (isHit.equals("hit"));
			}

		}

	}

}

/*
5 E
2
Q 1 1 A1 B2
P 2 1 D4 C3
A1 B2 B2 B3
A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
*/
