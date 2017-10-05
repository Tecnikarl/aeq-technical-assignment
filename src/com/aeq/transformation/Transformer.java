package com.aeq.transformation;

public class Transformer implements Comparable<Transformer> {
	public static char TEAM_AUTOBOTS = 'A';
	public static char TEAM_DECEPTICONS = 'D';
	
	private String name;
	private char team;
	
	private int strength;
	private int intelligence;
	private int speed;
	private int endurance;
	private int rank;
	private int courage;
	private int firepower;
	private int skill;
	
	public Transformer(String name, char team, int strength, int intelligence, int speed, int endurance, int rank,
			int courage, int firepower, int skill) {
		super();
		this.name = name;
		this.team = team;
		this.strength = strength;
		this.intelligence = intelligence;
		this.speed = speed;
		this.endurance = endurance;
		this.rank = rank;
		this.courage = courage;
		this.firepower = firepower;
		this.skill = skill;
	}
	
	public Transformer() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getTeam() {
		return team;
	}
	public void setTeam(char team) {
		this.team = team;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getCourage() {
		return courage;
	}
	public void setCourage(int courage) {
		this.courage = courage;
	}
	public int getFirepower() {
		return firepower;
	}
	public void setFirepower(int firepower) {
		this.firepower = firepower;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	public int getOverallRating() {
		return this.strength + this.intelligence + this.speed + this.endurance + this.firepower;
	}
	
	@Override
	public int compareTo(Transformer compareTransformer) {
		int compareTransformerRating = compareTransformer.getOverallRating();
		
		//Descending Order
		return compareTransformerRating - this.getOverallRating();
	}
}
