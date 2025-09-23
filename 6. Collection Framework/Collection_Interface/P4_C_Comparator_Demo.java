import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {

    private String name;
    private Integer studentId;
    private String emailId;
    private Long phoneNo;

    Student(String name, Integer studentId, String emailid, Long phoneNo) {
        this.name = name;
        this.studentId = studentId;
        this.emailId = emailid;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return this.name;

    }

    public String getEmailId() {
        return this.emailId;

    }

    public Integer getStudentId() {
        return this.studentId;

    }

    public Long getPhoneNo() {
        return this.phoneNo;

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;

    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;

    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;

    }

    @Override
    public String toString() {
        return "Student name : " + getName() + " " +
                "Phone       : " + getPhoneNo() + " "  +
                "StudentId   : " + getStudentId() + " "  +
                "email       : " + getEmailId() + " "+"\n";

    }

}

class sortByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
class sortByPhoneNoAscending implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getPhoneNo().compareTo(o2.getPhoneNo());
    }

}
class sortByPhoneNoDescending implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getPhoneNo().compareTo(o1.getPhoneNo());
    }

}
class sortByNameDescending implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getName().compareTo(o1.getName());
    }

}




public class P4_C_Comparator_Demo {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student("Sarang", 3243, "Sarangyvt9@gmail.com", 5168864917l));
        list.add(new Student("Yadnesh", 3243, "Yadnesh@gmail.com", 2168864917l));
        list.add(new Student("Ayush", 3243, "Ayush@gmail.com", 9168864917l));
        list.add(new Student("Ganesh", 3243, "Ganesh@gmail.com", 1168864917l));

      
        // Collections.sort(list, new sortByNameDescending());
        Collections.sort(list, new sortByPhoneNoDescending());
        // Collections.sort(list, new sortByPhoneNoAscending());

          Collections.sort(list, new sortByName());

        System.out.println(list);

    }
}
