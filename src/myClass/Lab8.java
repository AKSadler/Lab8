package myClass;

import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) {
		
		String choice = "y";
		Scanner scan1 = new Scanner(System.in);
		
		
		
		while (choice.equalsIgnoreCase("y")) {	

		System.out.println("Welcome to Batting Average Calculator!");
		System.out.println("Enter number of times at bat: ");

		double userInput = scan1.nextInt();
		double atBat[] = new double[(int) userInput];
		int result = 0;
		double hits = 0;
		double sum = 0;
		
		
		System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");

		

			for (int i = 0; i < userInput; i++) {

				result += 1;

				System.out.print("Enter Result for at-bat " + result + ": ");

				hits = numHitsAtBat(scan1, atBat, result, hits, i);

			}
			sluggingPercentage(atBat, result, hits, sum);

			scan1.nextLine();

			System.out.println("Another batter? (y/n): ");

			choice = scan1.nextLine();
		}
		if (choice.equalsIgnoreCase("n"))
		{ System.out.println("Goodbye!");
			
			}
		
		scan1.close();
	}

	public static double numHitsAtBat(Scanner scan1, double[] atBat, int result, double hits, int i) {
		atBat[i] = scan1.nextInt();
		if (atBat[i] > 0) {
			hits += 1;
		}

		while (atBat[i] < 0 || atBat[i] > 4) {
			System.out.println("You must enter a number between 0 and 4, please try again"
					+ "\nEnter Result for at-bat " + result + ": ");
			atBat[i] = scan1.nextInt();

		}
		return hits;
	}

	public static void sluggingPercentage(double[] atBat, int result, double hits, double sum) {
		double average = hits / result;
		System.out.println("Batting average: " + average);

		for (double j : atBat) {
			sum += j;
		}
		System.out.println("Slugging Percentage: " + sum / result);
	}
}

