package people;

public class Student extends People{

    private int studyYear;

    public Student(String surname, String name,University university, int age,  int studyYear) {
        super(surname, name, age, university);
        this.studyYear = studyYear;
    }

    @Override
    public String toString() {
        return "[Sd. "+  this.surname + ' ' + this.name +", Year "+this.studyYear+", Uni. "+ this.university.getAcronym()+", Age "+this.age+']';
    }

    @Override
    public String greeting() {
        return "Hi, I am Student "+this.toString();
    }

    @Override
    public String doWork() {
        return "I study!";
    }


}
