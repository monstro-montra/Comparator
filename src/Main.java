public class Main {


    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(419054, "Marco", "500 Bloomingdale Dr.");
        students[1] = new Student(236705, "Linus", "462 Metro Blvd.");
        students[2] = new Student(900320, "Miranda", "7462 Beachway St.");
        students[3] = new Student(502134, "Fiona", "903 Murphy Rd.");
        students[4] = new Student(100385, "Esther", "34 Ohms St." );

        for(int i = 0; i < students.length; i++){
            System.out.println("Student Number: " + (i + 1)  + ", " +students[i]);
            System.out.println();
        }

    }

    public void sortByRollNo(Student[] students){

    }
}