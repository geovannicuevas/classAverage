import java.util.Scanner;
// Name: Geovanni Cuevas
// Class: CS 3305/#04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: IntelliJ

public class AverageGrades {
    private static int classSize;
    private static int[] grades;

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        do {
            //Main menu that prompts user with choices
            System.out.println(
                            """

                            --------MAIN MENU-------
                            1. Read class size
                            2. Read class grades
                            3. Compute class average
                            4. Exit program

                            Enter option number:""");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    readClassSize(scan);
                    break;
                case 2:
                    if (classSize == 0){
                        System.out.println("Please declare class size first");
                    }
                    else {
                    readClassGrades(scan);
                    }
                    break;
                case 3:
                    if (classSize == 0){
                        System.out.println("Please declare class size first.");
                    } if (grades == null) {
                        System.out.println("Please add grades first.");
                    }
                    else {
                    double average = findAverage(grades,classSize);

                    System.out.print(
                            "You entered class size:  " + classSize +
                            "\nYou entered grades:      " );
                    for (int i = 0; i<grades.length; i++){
                        System.out.print(grades[i] + " ");
                    }
                    System.out.println(
                            "\nClass average:           " + String.format("%.2f",average)
                    );}
                    break;
            }

        } while (option != 4);


    }
    //Method that reads the class size and checks for invalid numbers
    private static void readClassSize(Scanner scan){
        System.out.println("Enter the class size: ");
        classSize = scan.nextInt();
        while(classSize < 0){
            System.out.println("Invalid input, positive numbers only.");
            classSize = scan.nextInt();
        }

    }
    //Method that reads the class grades and stores into array
    private static void readClassGrades(Scanner scan){
        grades = new int[classSize];
        if(classSize <= 0){
            System.out.println("Please declare class size");
            return;
        }
        for (int i = 0; i < classSize; i++) {
            System.out.println("Enter grade for student " + (i+1));
            grades[i] = scan.nextInt();
            while (100 < grades[i] || 0 > grades[i]){
                System.out.println("Invalid grade. Grades must be greater than 0 and less than 100.");
                grades[i] = scan.nextInt();
            }
        }
    }
    //Method that uses recursion to find the class average
    static double findAverage(int[] grades, int index)
    {
        if (index == 1)
        {
            return grades[0];
        } else
        {
            return (findAverage(grades, index - 1) * (index - 1) + grades[index - 1]) / index;
        }

    }

}
