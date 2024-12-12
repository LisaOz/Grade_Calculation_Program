# Grade_Calculation_Program

This is a Java program that manages and analyses student grades. The program allows users to input points ranging from 0 to 100 and calculates various statistics such as:
- Overall average score
- Average score of passing student (with points >= 50)
- Passing percentage
- Grade distribution from 0 to 5.

The program is divided into classes to handle specific functionalities. The modularity of the program makes it easy to maintain the code.

## Features
1. **Input Management**: Allows users to input points interactively, invalid points are being ignored.
2. **Statistics Calculation**:
  - Average point of all students
  - Average point for passing studenta
  - Percentage of students with passing points
3. **Grade Distribution**
  - Grades range from 0 to 5, with the higher score corresponding to a higher grade.
  - The histogram of grades displays a grade and a number of students getting the grade.
4. **Modular Design**: The program is divided into three main classes for clarity and reusability:
- Main
- PointsManagement
- GradesDistribution
- UserInterface

## Class Structure
1. ***Main***
   - Entry point of the application
   - Initialises the *PointsManagement*, *GradesDistrubution*, and *UserInterface* classes.
   - Starts the program by calling *userInterfacse.start()* method.
2. ***UserInterface***
   - Manages user interactions
   - Prompts the user to input points
   - Validates the input to ensure points are within the range (0-100)
   - Displays the results including averages, pass percentage, and grade distrubution
3. ***PointsManagement***
   - Handles storage and processing of scores
   - Key methods:
     - *addPoint(int point)*: Adds a point to the list of points
     - *calculateAverage()*: Computes the average point of all students
     - *calculatePassingAverage()*: Computes the average point of students with the points >= 50
     - *calculatePass Percentage()*: Calculates the percentage of students with the passing points
4. ***GradeDistribution***
   - Generates the grade distribution histogram
   - Key methods:
     - *getGradeDistribution(ArrayList<Integer> points)*: returns a string representation of grade distribution with asterisks and the number of students per grade
     - *calculateGrade(int point)*: Determines the grade (0-5) based on the score. 

## Usage
1. Clone the project
2. Run the Main class of the program
3. Follow the prompts to enter the student points. Enter -1 to stop input and display the results.
   ### Note
 Points below 0 and above 100 are ignored. If no passing scores are entered, the program displays a dash "-" for the "Point average (passing)".

## License
This project is licensed under the MIT License. You are free to use, modify, and distribute this program.

   
     

- 
