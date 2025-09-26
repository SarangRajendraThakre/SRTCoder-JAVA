

public class Employee {

    private int studentid ;
    
    private String studentName;

    


    public Employee(int studentid, String studentName) {
        this.studentid = studentid;
        this.studentName = studentName;
    }

    
    public int getStudentid() {
        return studentid;
    }
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
   

    

}
