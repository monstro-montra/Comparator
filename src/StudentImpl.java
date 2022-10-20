import java.util.Comparator;

class RollNoCompare implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollno(), s2.getRollno());
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
