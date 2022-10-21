import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Student[] students = new Student[5];
    RollNoCompare rollCompare = new RollNoCompare();
    StudentNameCompare nameCompare = new StudentNameCompare();
    StudentAddressCompare addressCompare = new StudentAddressCompare();




    public static void main(String[] args) {
        Main run = new Main();
        run.students[0] = new Student(419054, "Marco", "500 Bloomingdale Dr.");
        run.students[1] = new Student(236705, "Linus", "462 Metro Blvd.");
        run.students[2] = new Student(900320, "Miranda", "7462 Beachway St.");
        run.students[3] = new Student(502134, "Fiona", "903 Murphy Rd.");
        run.students[4] = new Student(100385, "Esther", "34 Ohms St." );

        run.menuOptions(0);

    }
    public void sort(Student[] students, Comparator<Student> comparator){
        //selection sort algorithm
        for(int i = 0; i < students.length - 1; i++){
            int min = i; // minimum index = to the current iteration of the outer loop.
            for (int j = i + 1; j < students.length; j++) { //for each element, in unsorted part of array
                if(comparator.compare(students[j], students[min]) < 0)  { //check if element in question is smaller than current minimum
                    min = j; //update minimum element to be this value in question
                }
            }
            //swap with element at the beginning of sub array
            swap(students, i, min);
        }

    }
    public void printStudents(Student[] students){
        for(int i = 0; i < students.length; i++){
            System.out.println("Student Number: " + (i + 1)  + ", " +students[i]);
            System.out.println();
        }
    }

    public void swap(Object[] objects, int i, int min){ //generic swap method (this will be used for selection sort algo)
        Object temp = objects[i]; // set value of temp equal to index i
        objects[i] = objects[min]; //set element i = to element min which was the updated minimum element
        objects[min] = temp; // set the value of arr @ min = temp
    }

    public static void showMenu(){
        System.out.println("1.) Print Student List");
        System.out.println("2.) Sort by Roll number");
        System.out.println("3.) Sort by Name");
        System.out.println("4.) Sort by Address");
        System.out.println("5.) Exit");
    }

    public void menuOptions(int menuChoice){
        Main run = new Main();
        Scanner in = new Scanner(System.in); //create new scanner object called 'in'
        do{
            showMenu(); //call showMenu method
            try{
                if(in.hasNextInt()){ // if in has an int
                    menuChoice = in.nextInt();
                    switch(menuChoice) {
                        case 1: //run printStudents method
                            run.printStudents(students);
                            break;
                        case 2: //run sort method with rollCompare comparator
                            run.sort(students, rollCompare);
                            System.out.println("Sorted by Roll number!\n");
                            break;
                        case 3: //run sort method with nameCompare comparator
                            run.sort(students, nameCompare);
                            System.out.println("Sorted by name!\n");
                            break;
                        case 4: //run sort method with addressCompare comparator
                            run.sort(students, addressCompare);
                            System.out.println("Sorted by address!\n");
                            break;
                        case 5: //exit the program
                            System.exit(0);
                            break;
                        default:
                            if (menuChoice > 6 || menuChoice < 1){
                                throw new Exception("Invalid menu option.");
                            }
                    }
                }
                else {
                    throw new InputMismatchException("Not an integer!");
                }
            } catch (InputMismatchException excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Please try again");
                in.next();

            } catch (Exception er){
                System.out.println(er.getMessage());
                System.out.println("Please try again");
            }
        }while (menuChoice !=5);

    }
}