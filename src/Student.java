public class Student {
    private final int rollno;
    private final String name;
    private final String address;

    public Student (int studentNumber, String studentName, String studentAddress){ //student constructor
        rollno = studentNumber;
        name = studentName;
        address = studentAddress;
    }




    //getters only as this will be read-only. no write
    public int getRollno(){

        return this.rollno;
    }

    public String getName(){

        return this.name;
    }

    public String getAddress(){

        return this.address;
    }

    @Override
    public String toString(){ //this will be used in main when we attempt to print the student
        return  "Roll Number: " + rollno + ", " +
                "Student Name: " + name + ", " +
                "Student Address: " + address;
    }
}
