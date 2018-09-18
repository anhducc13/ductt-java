package week2;

import java.util.*;

public class StudentManagement {
    ArrayList <Student> sList = new ArrayList <>();
    
    Boolean sameGroup(Student s1, Student s2) {
        return (s1.getGroup()).equals(s2.getGroup());
    }
    
    void studentsByGroup() {
        ArrayList <Student> data = new ArrayList<>(sList); // tạo một danh sách mới và làm việc trên đó
        
        while (!data.isEmpty()) {
            int i = 0;
            String thisGroup = data.get(i).getGroup();
            System.out.println(thisGroup);
            System.out.println("Student of group " + thisGroup + ": ");
            for (int j = 0; j < data.size(); ) {
                if(data.get(j).getGroup().equals(thisGroup)) {
                    data.get(j).getInfo();
                    data.remove(j);
                }
                else j++;
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
        StudentManagement sm = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 6; i++) {
            System.out.print("Scan Group: ");
            String s = sc.nextLine();
            sm.sList.add(new Student("00","name",s,"asfdfd"));
        }
        sm.studentsByGroup();
    }
    
}
