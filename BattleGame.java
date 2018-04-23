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
		Dimension battleAreaDimension = new Dimension(widthOfBattleArea, heightOfBattleArea);
		BattleShip player1 = new BattleShip();
		BattleShip player2 = new BattleShip();

		int battleShipCount = scanner.nextInt();

		for (int i = 1; i <= battleShipCount; i++) {

			String shipType = scanner.next();
			int widthOfShip = scanner.nextInt();
			char heightOfShip = scanner.next().charAt(0);
			String player1Cordinates = scanner.next();
			String player2Cordinates = scanner.next();
			
			for (int height = 0; height < heightOfShip-48; height++) {
				for (int width = 0; width < widthOfShip; width++) {
					String key1 = String.valueOf((char)(player1Cordinates.charAt(0)+height)) + (int)(player1Cordinates.charAt(1)-48+width);
					String key2 = String.valueOf((char)(player2Cordinates.charAt(0)+height)) + (int)(player2Cordinates.charAt(1)-48+width);

					player1.addShips(key1, ShipType.valueOf(shipType));
					player2.addShips(key2, ShipType.valueOf(shipType));
				}
			}
			
		}

	}

}
