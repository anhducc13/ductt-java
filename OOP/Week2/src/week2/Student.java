package week2;

class Student {
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
        this("000","Student","K62-C-L","uet@vnu.edu.vn");
    }

    Student(Student sv) {
        this(sv.id,sv.name,sv.group,sv.email);
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getGroup() {
        return group;
    }

    void setGroup(String group) {
        this.group = group;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }    
    
    void getInfo(){
        System.out.print(id + "\t" + name + "\t" + group + "\t" + email + "\n");
    }
}
