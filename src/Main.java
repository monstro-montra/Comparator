import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    ArrayList<Student> students = new ArrayList<>();
    RollNoCompare rollCompare = new RollNoCompare();
    StudentNameCompare nameCompare = new StudentNameCompare();
    StudentAddressCompare addressCompare = new StudentAddressCompare();

    public static void main(String[] args) {
        Main run = new Main(); //allows for calling of non-static methods
        //initialize 10 students
        run.students.add(new Student(112034, "Alex", "Oaks Dr."));
        run.students.add(new Student(142706, "Melina", "Westside Way."));
        run.students.add(new Student(903345, "Johnathan", "Pine Tree Blvd."));
        run.students.add(new Student(327164, "Julia", "Murphy Rd."));
        run.students.add(new Student(620355, "Mike", "Bloomingdale Dr." ));
        run.students.add(new Student(823512, "Kevin", "Martin Luther St."));
        run.students.add(new Student(945162, "Jason", "Hollywood Blvd."));
        run.students.add(new Student(202356, "Lorenzo", "Mario Blvd."));
        run.students.add(new Student(899931, "Amber", "Riverdale Garden Rd."));
        run.students.add(new Student(322456, "Vivian", "Blue Waters St." ));

        run.menuOptions(0);

    }
    public void sort(ArrayList<Student> students, Comparator<Student> comparator){
        //selection sort algorithm
        for(int i = 0; i < students.size() - 1; i++){
            int min = i; // minimum index = to the current iteration of the outer loop.
            for (int j = i + 1; j < students.size(); j++) { //for each element, in unsorted part of array
                if(comparator.compare(students.get(j), students.get(min)) < 0)  { //check if element in question is smaller than current minimum
                    min = j; //update minimum element to be this value in question
                }
            }
            //swap with element at the beginning of sub array
            Student temp = students.get(min); //temp equals students @ minimum
            students.set(min, students.get(i)); //set min of students to students @ i
            students.set(i, temp); //set i equal to temp

        }
    }

    public boolean checkIfAscending(ArrayList<Student> students, Comparator<Student> comparator){
        for (int i = 0; i < students.size() - 1; i++){ //iterate through the entire list
            if(comparator.compare(students.get(i), students.get(i+1)) > 0){ //compare student @ i and student at i + 1
                System.out.println("List of students is not in ascending order.");
                return false; // return false if not ascending order.
            }
        }
        System.out.println("List of students is in ascending order."); //if it is in ascending, it will be true.
        return true;
    }

    public void printStudents(ArrayList<Student> students){
        //print students to the console with the format used in overridden toString in Student.java
        for(int i = 0; i < students.size(); i++){
            System.out.println("Student Number: " + (i + 1)  + ", " + students.get(i));
            System.out.println();
        }
    }

    public static void showMenu(){ //prints the main menu
        System.out.println("1.) Print Student List");
        System.out.println("2.) Sort by Roll number");
        System.out.println("3.) Sort by Name");
        System.out.println("4.) Sort by Address");
        System.out.println("5.) Check if sorted in ascending by roll number");
        System.out.println("6.) Check if sorted in ascending by name");
        System.out.println("7.) Check if sorted in ascending by address");
        System.out.println("8.) Exit");
    }

    public void menuOptions(int menuChoice){
        Main run = new Main(); //allows for running of static methods
        Scanner in = new Scanner(System.in); //create new scanner object called 'in'
        do{
            showMenu(); //call showMenu method
            try{
                if(in.hasNextInt()){ // if in has an int
                    menuChoice = in.nextInt(); //set menuChoice = user input integer
                    switch (menuChoice) {
                        case 1 -> //run printStudents method
                                run.printStudents(students);
                        case 2 -> { //run sort method with rollCompare comparator
                            sort(students, rollCompare); //call sort method
                            System.out.println("Sorted by Roll number!\n");
                        }
                        case 3 -> { //run sort method with nameCompare comparator
                            sort(students, nameCompare); //call sort method
                            System.out.println("Sorted by name!\n");
                        }
                        case 4 -> { //run sort method with addressCompare comparator
                            sort(students, addressCompare); //call sort method
                            System.out.println("Sorted by address!\n");
                        }
                        case 5 -> //run the check if ascending method to see if arraylist is sorted in ascending for roll number.
                            checkIfAscending(students, rollCompare);
                        case 6 -> //run the check if ascending method to see if arraylist is sorted in ascending for name.
                            checkIfAscending(students, nameCompare);
                        case 7 -> //run the check if ascending method to see if arraylist is sorted in ascending for address.
                            checkIfAscending(students, addressCompare);
                        case 8 -> //exit program
                                System.exit(0);
                        default -> //default case. throw an error
                                throw new Exception("Invalid menu option.");
                    }
                }
                else {
                    throw new InputMismatchException("Not an integer!"); //throws InputMismatchException since the user did not put in an integer
                }
            } catch (InputMismatchException excpt){
                System.out.println(excpt.getMessage()); //get message from InputMismatchException
                System.out.println("Please try again");
                in.next();

            } catch (Exception er){
                System.out.println(er.getMessage()); //get message from Exception
                System.out.println("Please try again");
            }
        }while (menuChoice != 8); //while the menu choice is not six. (if it is the loop closes and so does the program)

    }
}