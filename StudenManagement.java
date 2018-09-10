import java.util.*;
public class StudenManagement {

    static class Student {
        private String id;
        private String name;
        private String group;
        private String email;

        Student(String _id, String _name, String _group, String _email) {
            this.id = _id;
            this.name = _name;
            this.group = _group;
            this.email = _email;
        }

        Student() {
            this("000","Student","K60CC","uet@vnu.edu.vn");
        }

        Student(Student sv) {
            this(sv.id,sv.name,sv.group,sv.email);
        }
        
        void setId(String _id){
            this.id = _id;
        }

        String getId(){
            return this.id;
        }

        void setName(String _name){
            this.name = _name;
        }

        String getName(){
            return this.name;
        }

        void setGroup(String _group){
            this.group = _group;
        }

        String getGroup(){
            return this.group;
        }

        void setEmail(String _email){
            this.email = _email;
        }

        String getEmail(){
            return this.email;
        }

        void getInfo(){
            System.out.print(id + "\t" + name + "\t" + group + "\t" + email + "\n");
        }
    }
    
    static boolean sameGroup(Student s1, Student s2){
        return (s1.getGroup()).equals(s2.getGroup());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = Integer.parseInt(sc.nextLine());

        Student [] list = new Student[x];
        // ArrayList<Student> list = new ArrayList<Student>(3);

        for(int i = 0; i < x; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String group = sc.nextLine();
            String email = sc.nextLine();
            list[i] = new Student(id,name,group,email);
           // list.add(sv);
        }
        

        for(Student ele : list){
            ele.getInfo();

        }

        sc.close();

    }
}
