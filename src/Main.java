import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(419054, "Marco", "500 Bloomingdale Dr.");
        students[1] = new Student(236705, "Linus", "462 Metro Blvd.");
        students[2] = new Student(900320, "Miranda", "7462 Beachway St.");
        students[3] = new Student(502134, "Fiona", "903 Murphy Rd.");
        students[4] = new Student(100385, "Esther", "34 Ohms St." );

        printStudents(students);

    }

    public void sortByRollNo(Student[] students){
        //selection sort
        Comparator<Student> studentComparator;
        for(int i = 0; i < students.length - 1; i++){
            int min = i; // minimum index = to the current iteration of the outer loop.
            for (int j = i + 1; j < students.length; j++) { //for each element, in unsorted part of array
                if (studentComparator.compare(students[j], students[min])) { //check if element in question is smaller than current minimum
                    min = j; //update minimum element to be this value in question
                }
            }
            //swap with element at the beginning of sub array
            double temp = arr[i]; // set value of temp equal to index i
            arr[i] = arr[min]; //set element i = to element min which was the updated minimum element
            arr[min] = temp; // set the value of arr @ min = temp
        }

    }

    public static void printStudents(Student[] students){
        for(int i = 0; i < students.length; i++){
            System.out.println("Student Number: " + (i + 1)  + ", " +students[i]);
            System.out.println();
        }

    }
}