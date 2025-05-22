public class constructor{
    public static void main(String[]args){
        Student s1=new Student();
        s1.name="Abhi";
        s1.roll=345;
        s1.password="Abc";
        s1.marks[0]=35;
        s1.marks[1]=45;
        s1.marks[2]=67;
        Student s2=new Student(s1);
        s2.name="Abhishek";
        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }
    }
}
class Student{
    String name;
    int roll;
    String password;
    int marks[];
    Student(){
        marks=new int[3];
        System.out.println("Class constructor is called");
    }
    Student(String name, int roll, String password){
        marks=new int[3];
        this.name=name;
       
        this.roll=roll;
        this.password=password;
        this.marks=marks;
    }
    Student(Student s1){
        marks=new int[3];
        this.name=s1.name;
        System.out.println(s1.name);
        this.roll=s1.roll;
        this.password=s1.password;
        this.marks=s1.marks;
    }
    
}