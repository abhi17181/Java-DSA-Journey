
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}
class Mammals extends Animal{
    int legs;
}
class dog extends Mammals{
    String breed;
}
public class Inheritence {
    public static void main(String[]args){
        dog dobby=new dog();
        dobby.eat();
        dobby.legs=4;
        System.out.println(dobby.legs);

    }
}