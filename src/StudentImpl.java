import java.util.Comparator;

class RollNoCompare implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getRollno() == s2.getRollno()){
            return 0;
        }
        else if (s1.getRollno() < s2.getRollno()){
            return -1;
        }
        else{
            return 1;
        }

    }

}

class StudentNameCompare implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

}

class StudentAddressCompare implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        return s1.getAddress().compareTo(s2.getAddress());
    }

}
