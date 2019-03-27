package se.lexicon.The_GOLF_master;

public class Shot {
	
	int angle;
	int velocity;
	int distance;
		
	public Shot(int angle, int velocity) {
		this.angle = angle;
		this.velocity = velocity;
		this.distance = count();	
	}
	
	public int count () {
		return (int) Math.round(Math.pow(velocity, 2)
				/ 9.8 * Math.sin(2 * ((Math.PI / 180) * angle)));
		
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
