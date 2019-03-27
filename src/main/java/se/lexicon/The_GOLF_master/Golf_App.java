package se.lexicon.The_GOLF_master;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Random;

public class Golf_App {
	
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	static inputNumberScann sc = new inputNumberScann();
	static ArrayList<Shot> shotList = new ArrayList<Shot>();

	public static int distanceToHole = random.nextInt(320) + 80;
	public static int shotCountMax = 5;
	public static int velocity;
	public static int angle;
	public static String playAgain;
	public static int ballPosition;

	public static void main(String[] args) {

		boolean run = true;
		System.out.println("\t\tWelcome to My golf");

		while (run) {

			System.out.println("\n===============================================\n");

			while (run) {

				System.out.println("Distance to hole is: " + distanceToHole);

				System.out.print("Input shot velocity between 1 - 60: ");
				getVelocity();
				System.out.print("Input shot angle between 1 - 55: ");
				getAngle();

				Shot shot = new Shot(velocity, angle);
				int distance = shot.getDistance();
				getShotCountMax();
				distanceToHole = getNewDistance(distance, distanceToHole);
				
				shotList.add(shot);

				System.out.println("Your ball bounce: " + distance + " m ");
				System.out.println("Ball position to hole after shot is " + distanceToHole + " m ");
				System.out.println("You have " + shotCountMax + " shot left");

				if (distanceToHole < -100) {
					System.out.println("You lost");
					run = false;
				}

				if (distanceToHole < 0) {
					distanceToHole = (0 - distanceToHole);
				}
				if (shotCountMax < -1) {
					System.out.println("You lost!!!");
					run = false;
				} else if (distanceToHole <= 0.1 && distanceToHole >= -0.1) {
					System.out.println("You won");
					run = false;
				}

				System.out.println("============================================================");
			}

			System.out.println("Would you like to play again (y/n)?");
			run = false;
			
			playAgain = scan.nextLine().toLowerCase();
			if (playAgain.equals("y")) {
				run = true;
			} else {
				System.out.println("Program is terminated");
			}
		}
	}

	public static int getNewDistance(int shotDistance, int distanceToHole) {
		int newDistance = distanceToHole - shotDistance;
		return newDistance;

	}

	public static void setDistanceToHole(int distanceToHole) {
		Golf_App.distanceToHole = distanceToHole;
	}

	public static int getShotCountMax() {
		int index = 0;

		for (Shot shot : shotList) {
			index++;
			System.out.println("Shot number: " + index + " Shot length: " + shot.getDistance());
		}
		shotCountMax--;
		return shotCountMax;
	}

	public static void setShotCountMax(int shotCountMax) {
		Golf_App.shotCountMax = shotCountMax;
	}

	public static int getVelocity() {
		velocity = sc.inputNumber(1, 60);
		return velocity;
	}

	public static void setVelocity(int velocity) {
		Golf_App.velocity = velocity;
	}

	public static int getAngle() {
		angle = sc.inputNumber(1, 55);
		return angle;
	}

	public static void setAngle(int angle) {
		Golf_App.angle = angle;
	}

	public static String getPlayAgain() {
		return playAgain;
	}

	public static void setPlayAgain(String playAgain) {
		Golf_App.playAgain = playAgain;
	}

	public static int getBallPosition() {
		return ballPosition;
	}

	public static void setBallPosition(int ballPosition) {
		Golf_App.ballPosition = ballPosition;
	}
}