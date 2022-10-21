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
        //initialize the 10 students
        run.students.add(new Student(419054, "Marco", "Bloomingdale Dr."));
        run.students.add(new Student(236705, "Linus", "Metro Blvd."));
        run.students.add(new Student(900320, "Miranda", "Beach-way St."));
        run.students.add(new Student(502134, "Fiona", "Murphy Rd."));
        run.students.add(new Student(100385, "Esther", "Ohms St." ));
        run.students.add(new Student(227543, "Bruno", "Presidents Dr."));
        run.students.add(new Student(994560, "Zyra", "Hollywood Blvd."));
        run.students.add(new Student(607032, "Kent", "Beach-way St."));
        run.students.add(new Student(199943, "Parker", "Windmill City Rd."));
        run.students.add(new Student(721956, "Jolyne", "Green Dolphin St." ));

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
        System.out.println("5.) Exit");
    }

    public void menuOptions(int menuChoice){
        Main run = new Main(); //allows for running of static methods
        Scanner in = new Scanner(System.in); //create new scanner object called 'in'
        do{
            showMenu(); //call showMenu method
            try{
                if(in.hasNextInt()){ // if in has an int
                    menuChoice = in.nextInt(); //set menuChoice = user input integer
                    switch(menuChoice) {
                        case 1: //run printStudents method
                            run.printStudents(students);
                            break;
                        case 2: //run sort method with rollCompare comparator
                            sort(students, rollCompare);
                            System.out.println("Sorted by Roll number!\n");
                            break;
                        case 3: //run sort method with nameCompare comparator
                            sort(students, nameCompare);
                            System.out.println("Sorted by name!\n");
                            break;
                        case 4: //run sort method with addressCompare comparator
                            sort(students, addressCompare);
                            System.out.println("Sorted by address!\n");
                            break;
                        case 5: //exit the program
                            System.exit(0);
                            break;
                        default: //default case. throw an error
                            if (menuChoice > 6 || menuChoice < 1){
                                throw new Exception("Invalid menu option.");
                            }
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
        }while (menuChoice !=5); //while the menu choice is not five. (if it is the loop closes and so does the program)

    }
}