package se.lexicon.The_GOLF_master;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Random;

public class Golf_App {

	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	inputNumberScann sc = new inputNumberScann();
	ArrayList<Shot> shotList = new ArrayList<Shot>();

	public int distanceToHole = random.nextInt(320) + 80;
	public int shotCountMax = 5;
	public int velocity;
	public int angle;
	public String playAgain;
	public int ballPosition;

	public void play() {

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

				} else if (distanceToHole <= 0.1 && distanceToHole >= -0.1) {
					System.out.println("You won");
					run = false;

				} else if (shotCountMax <= 0) {
					System.out.println("You lost!!!");
					run = false;
				}

				System.out.println("============================================================");
			}

			System.out.println("Would you like to play again (y/n)?");
			run = false;

			distanceToHole = random.nextInt(320) + 80;
			shotList = new ArrayList<Shot>();
			shotCountMax = 5;
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

	public int getShotCountMax() {
		int index = 0;

		for (Shot shot : shotList) {
			index++;
			System.out.println("Shot number: " + index + " Shot length: " + shot.getDistance());
		}
		shotCountMax--;
		return shotCountMax;
	}

	public int getVelocity() {
		velocity = sc.inputNumber(1, 60);
		return velocity;
	}

	public int getAngle() {
		angle = sc.inputNumber(1, 55);
		return angle;
	}

}