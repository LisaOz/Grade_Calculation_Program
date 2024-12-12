package GradeCalculationProgram;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PointsManagement pointsManagement = new PointsManagement();
        GradeDistribution gradeDistribution = new GradeDistribution();
        UserInterface userInterface = new UserInterface(pointsManagement, gradeDistribution);
        userInterface.start();
    }
}

// Class to handle user interactions with the program
class UserInterface {

    private PointsManagement pointsManagement;
    private GradeDistribution gradeDistribution;
    private Scanner scanner;

    public UserInterface(PointsManagement pointsManagement, GradeDistribution gradeDistribution) {
        this.pointsManagement = pointsManagement;
        this.gradeDistribution = gradeDistribution;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops: ");
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break; // exit
            }
            if (number >= 0 && number <= 100) {
                pointsManagement.addPoint(number); // add all valid points
            } else {
                continue;
            }
        }
        displayResults();
    }

    private void displayResults() {
        System.out.println("Point average (all): " + pointsManagement.calculateAverage());
        double passingAvg = pointsManagement.calculatePassingAverage();
        System.out.println("Point average (passing): " + (passingAvg == 0 ? "-" : passingAvg));
        System.out.println("Pass percentage: " + pointsManagement.calculatePassPercentage());
        System.out.println("Grade Distribution: ");
        System.out.println(gradeDistribution.getGradeDistribution(pointsManagement.getPoints()));
    }
}
// Class to manage data and perform calculations

class PointsManagement {

    private ArrayList<Integer> points;

    public PointsManagement() {
        this.points = new ArrayList<>();
    }

    public void addPoint(int point) {
        this.points.add(point);
    }

    public ArrayList<Integer> getPoints() {
        return this.points;
    }

    public double calculateAverage() {
        if (points.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return (double) sum / points.size();
    }

    public double calculatePassingAverage() {
        int sum = 0;
        int count = 0;
        for (int point : points) {
            if (point >= 50) { // calculate only the points over 50
                sum += point;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0;
    }

    public double calculatePassPercentage() {
        if (points.isEmpty()) {
            return 0;
        }
        int passingCount = 0;
        for (int point : points) {
            if (point >= 50) {
                passingCount++;
            }
        }
        return 100 * passingCount / points.size();
    }
}

// Class to manage grade assignments and distribution
class GradeDistribution {

	public String getGradeDistribution(ArrayList<Integer> points) {
	    int[] gradeCounts = new int[6]; // Grades 0 to 5

	    // Calculate the count of students in each grade
	    for (int point : points) {
	        int grade = calculateGrade(point);
	        gradeCounts[grade]++;
	    }

	    // Build the grade distribution string
	    StringBuilder distribution = new StringBuilder();
	    for (int i = 5; i >= 0; i--) {
	        for (int j = 0; j < i; j++) {
	            distribution.append("*"); // Append the stars corresponding to the grade
	        }
	        distribution.append(": ").append(gradeCounts[i]).append(" students\n");
	    }

	    return distribution.toString();
	}

	private int calculateGrade(int point) {
	    if (point < 50) {
	        return 0;
	    } else if (point < 60) {
	        return 1;
	    } else if (point < 70) {
	        return 2;
	    } else if (point < 80) {
	        return 3;
	    } else if (point < 90) {
	        return 4;
	    } else {
	        return 5;
	    }
	}
}
