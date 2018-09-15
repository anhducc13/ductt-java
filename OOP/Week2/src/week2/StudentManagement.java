package week2;

import java.util.*;

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static StudentManagement sm = new StudentManagement();
    
    
    ArrayList <Student> sList = new ArrayList <>();
    
    Boolean sameGroup(Student s1, Student s2) {
        return (s1.getGroup()).equals(s2.getGroup());
    }
    
    void studentsByGroup() {
        ArrayList <Student> data = sList; // tạo một danh sách mới và làm việc trên đó
        
        while (!data.isEmpty()) {
            int i = 0;
            String thisGroup = data.get(i).getGroup();
            System.out.println("Student of group " + thisGroup + ": ");
            for (int j = 0; j < data.size(); ) {
                if(data.get(j).getGroup().equals(thisGroup)) {
                    data.get(j).getInfo();
                    data.remove(j);
                }
                j++;
            }
        }
    }
    
    void removeStudent(String id) {
        for (int i = 0; i < sList.size(); ) {
            if (sList.get(i).getId().equals(id)) {
                sList.remove(i);
            }
            else i++;
        }
    }
    
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.print("a: ");
            String s = sc.nextLine();
            Student sv = new Student("00","name",s,"asfdfd");
            sm.sList.add(sv);
        }
        sm.studentsByGroup();
    }
    
}
