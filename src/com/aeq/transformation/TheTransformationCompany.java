package com.aeq.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheTransformationCompany {

	public static void main(String[] args) {
		List<Transformer> robotsInDisguise = new ArrayList<Transformer>();
//		robotsInDisguise.add(new Transformer("Optimus Prime", 'A', 4,4,2,4,4,3,4,4));
//		robotsInDisguise.add(new Transformer("Predaking", 'D', 10,5,0,8,7,9,9,8));
		
		robotsInDisguise.add(new Transformer("Soundwave", 'D', 8,9,2,6,7,5,6,10));
		robotsInDisguise.add(new Transformer ("Bluestreak", 'A', 6,6,7,9,5,2,9,7));
		robotsInDisguise.add(new Transformer("Hubcap", 'A', 4,4,4,4,4,4,4,4));
//		robotsInDisguise.add(new Transformer("Ramjet", 'D', 8,5,9,9,5,8,7,6));
//		robotsInDisguise.add(new Transformer("Weirdwolf", 'D', 6,10,6,10,6,9,5,6));
//		robotsInDisguise.add(new Transformer("Sandstorm", 'A', 7,9,6,7,6,10,6,9));

		sortTransformersByRatingAndTeams(robotsInDisguise);
	}
	
	private static void sortTransformersByRatingAndTeams(List<Transformer> robotsInDisguise) {
		List<Transformer> autobots = new ArrayList<Transformer>();
		List<Transformer> decepticons = new ArrayList<Transformer>();

		for(Transformer t : robotsInDisguise) {
			if (t.getTeam() == Transformer.TEAM_AUTOBOTS) {
				autobots.add(t);
			}
			else {
				decepticons.add(t);
			}
		}
		
		Collections.sort(autobots);
		Collections.sort(decepticons);
		
		battleForCybertron(autobots, decepticons);
	}
	
	private static void battleForCybertron(List<Transformer> autobots, List<Transformer> decepticons) {
		int numberOfBattles = -1;
		int autobotBattlesWon = 0;
		int decepticonBattlesWon = 0;
		boolean isCompleteAnnihalation = false;
		
		Transformer autobot = new Transformer();
		Transformer decepticon = new Transformer();
		
		/* Battle */
		while (true) {
			numberOfBattles++;
			
			if (autobots.size() == numberOfBattles || decepticons.size() == numberOfBattles) {
				break;
			}
			
			autobot = autobots.get(numberOfBattles);	
			decepticon = decepticons.get(numberOfBattles);	
			
			// Optimus Prime and Predaking Special Rules
			if ((autobot.getName().equals("Optimus Prime") && (decepticon.getName().equals("Predaking")))) {
				isCompleteAnnihalation = true;
				break;
			}
			else if (autobot.getName().equals("Optimus Prime")) {
				autobotBattlesWon++;
			}
			else if (decepticon.getName().equals("Predaking")) {
				decepticonBattlesWon++;
			}
			
			// Courage and Strength Rules
			if ((autobot.getCourage() - decepticon.getCourage()) >= 4 
					&& (autobot.getStrength() - decepticon.getStrength() >= 3)) {
				autobotBattlesWon++;
				continue;
			}
			else if ((autobot.getCourage() - decepticon.getCourage()) <= -4 
					&& (autobot.getStrength() - decepticon.getStrength() <= -3)) {
				decepticonBattlesWon++;
				continue;
			}
			else if ((autobot.getSkill() - decepticon.getSkill()) >= 3) {
				autobotBattlesWon++;
				continue;
			}
			else if ((autobot.getSkill() - decepticon.getSkill()) <= -3) {
				decepticonBattlesWon++;
				continue;
			}
			
			// Overall Rating Rule
			if (autobot.getOverallRating() == decepticon.getOverallRating()) {
				continue;
			}
			else if (autobot.getOverallRating() > decepticon.getOverallRating()) {
				autobotBattlesWon++;
				continue;
			}
			else {
				decepticonBattlesWon++;
				continue;
			}
		}
		
		/* Final Result of Battles */
		if (isCompleteAnnihalation) {
			System.out.println("No one wins");
		}
		else {
			String winningTeam = "";
			String winningTransformer = "";
			String losingTeam = "";
			String survivingTransformer = "";
			
			if (autobotBattlesWon == decepticonBattlesWon && autobots.size() == decepticons.size()) {
				System.out.println("The battles are tie");
			}
			else {
				if (autobotBattlesWon > decepticonBattlesWon) {
					winningTeam = "Autobots";
					winningTransformer = autobot.getName();
					losingTeam = "Decepticons";
					
					if (autobots.size() < decepticons.size()) {
						for (int i = numberOfBattles; i < decepticons.size(); i++) {
							if (survivingTransformer.isEmpty()) {
								survivingTransformer = decepticons.get(i).getName();
							}
							else {
								survivingTransformer = survivingTransformer + ", " + decepticons.get(i).getName();	
							}
						}
					}
				}
				else {
					winningTeam = "Decepticons";
					winningTransformer = decepticon.getName();
					losingTeam = "Autobots";
					
					if (decepticons.size() < autobots.size()) {
						for (int i = numberOfBattles; i < autobots.size(); i++) {
							if (survivingTransformer.isEmpty()) {
								survivingTransformer = autobots.get(i).getName();
							}
							else {
								survivingTransformer = survivingTransformer + ", " + autobots.get(i).getName();	
							}
						}
					}
				}
				
				System.out.println(numberOfBattles + " battle");
				System.out.println("Winning Team (" + winningTeam + "): " + winningTransformer);
				
				if (survivingTransformer != "") {
					System.out.println("Survivors from the losing team (" + losingTeam + "): " + survivingTransformer);	
				}
			}
		}
	}
}
