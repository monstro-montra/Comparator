public class Student {
    private int rollno;
    private String name;
    private String address;

    public Student (int studentNumber, String studentName, String studentAddress){
        rollno = studentNumber;
        name = studentName;
        address = studentAddress;
    }

    public Student(){ //empty constructor for use with the setters

    }

    public int getRollno(){
        return this.rollno;
    }

    public void setRollno(int studentNumber){
        this.rollno = studentNumber;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String studentName){
        this.name = studentName;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress (String studentAddress){
        this.address = studentAddress;
    }

    @Override
    public String toString(){
        return  "Roll Number: " + rollno + ", " +
                "Student Name: " + name + ", " +
                "Student Address: " + address;
    }
}
