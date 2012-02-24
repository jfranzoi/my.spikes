package my.roleplaygame;

public class HealthLevel {
	private static final int MINIMUN_POINTS_ALLOWED = 0;
	private static final int MAXIMUM_POINTS_ALLOWED = 100;
	
	private int itsPoints;
	
	public HealthLevel() {
		this(MAXIMUM_POINTS_ALLOWED);
	}
	
	public HealthLevel(int points) {
		this.itsPoints = points;
	}

	public int points(){
		return itsPoints;
	}

	@Override
	public boolean equals(Object obj) {
		HealthLevel healthLevel = (HealthLevel)obj;
		return healthLevel.itsPoints == itsPoints;
	}
	
	public void decreaseBy(int points) {
		this.itsPoints -= points;
		resetIfNegative();
	}
	
	private void resetIfNegative() {
		if(itsPoints < MINIMUN_POINTS_ALLOWED){
			itsPoints = 0;
		}
	}

	public void increaseBy(int points) {
		this.itsPoints += points;
		resetIfTooMuch();
	}
	
	private void resetIfTooMuch() {
		if(itsPoints > MAXIMUM_POINTS_ALLOWED){
			itsPoints = MAXIMUM_POINTS_ALLOWED;
		}
	}

	public boolean isEmpty() {
		return itsPoints == 0;
	}

}
