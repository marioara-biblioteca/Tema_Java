package people;

import people.Human;

public class Main {
    public static void main(String[] args) {
        Student ana=new Student("Popescu","Ana", University.ATM,20,2);
        Student ion=new Student("Vasilescu","Ion", University.ATM,19,1);
        Professor togan=new Professor("Togan","Mihai",45,University.ATM,"OOP");
        System.out.println(ana.toString());
        Human elena=new Student("Alexe","Elena", University.ASE,22,4);
        System.out.println(elena.toString());
    }
}