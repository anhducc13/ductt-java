package bt;

import java.util.*;

public class B4 {
    public static void main(String[] args) {
        Queue pq = new PriorityQueue(30, new StudentComparator());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String query = (String)sc.next();
            if(query.equals("ENTER")) {
                String name = (String)sc.next();
                Double cgpa = sc.nextDouble();
                int id = sc.nextInt();
                pq.add(new Student(id, name, cgpa));
            } else if(query.equals("SERVED")) {
                if(pq.isEmpty()) {
                    break;
                } else {
                    pq.poll();
                }
            }
        }
        
        for(Object ele : pq) {
            Student s = (Student)ele;
            System.out.println(s.getFname());
        }
    }

}

class Student {

    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student x, Student y) {
        // Cgpa
        double sub = x.getCgpa() - y.getCgpa();
        if (sub != 0) {
            return (sub < 0 ? 1 : -1);
        }

        //Fname;
        if (x.getFname().compareTo(y.getFname()) != 0) {
            return x.getFname().compareTo(y.getFname());
        }

        //ID
        int subId = x.getId() - y.getId();
        if (subId != 0) {
            return (subId < 0 ? -1 : 1);
        } else {
            return 0;
        }
    }
}
