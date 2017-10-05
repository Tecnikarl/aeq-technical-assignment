package com.aeq.castle;

public class TheCastleCompany {

	public static void main(String[] args) {
		int[] terrain = {2,6,6,6,3}; // 2 castle
//		int[] terrain = {6,1,4}; // 2 castle
//		int[] terrain = {2,6,6,6,3,7,7,7,3}; // 4 castles
//		int[] terrain = {2,6,6,6,7,5,3}; // 3 castles
//		int[] terrain = {6,9,12,14,16}; // 1 castle
//		int[] terrain = {2,4}; // 1 castle
//		int[] terrain = {4}; // 1 castle
//		int[] terrain = {}; // 0 castles
		
		System.out.println("Number of Castle(s) to build: " + castleCount(terrain));
	}
	
	private static int castleCount(int[] terrain) {
		if (terrain.length == 0) {
			return 0;
		}

		int numberOfCastles = 1;
		
		for (int i = 1; i < terrain.length - 1; i++) {
			if (terrain[i] == terrain[i-1]) {
				//Series
				continue;
			}
			else if (terrain[i] < terrain[i-1]) {
				if (terrain[i] > terrain [i+1]) {
					continue;
				}
				
				numberOfCastles++;
				
				if (terrain[i] == terrain[i+1]) {
					continue;
				}
				
			}
			else if (terrain[i] > terrain[i-1]) {
				if (terrain[i] < terrain [i+1]) {
					continue;
				}
				
				numberOfCastles++;
				
				if (terrain[i] == terrain[i+1]) {
					//Series
					continue;
				}
			}
		}		
		return numberOfCastles;
	}

}
