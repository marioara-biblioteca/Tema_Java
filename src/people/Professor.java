package people;

public class Professor extends People  {

    private String subject;

    public Professor(String surname, String name, int age, University university, String subject) {
        super(surname, name, age, university);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "[Prof. "+this.surname+" "+this.name+", Uni. "+ this.university.getAcronym()+", Age "+Integer.toString(this.age)+", Subject "+this.subject+']';
    }

    @Override
    public String greeting() {
        return "Hi, I am Professor "+this.toString();
    }

    @Override
    public String doWork() {
        return "I teach";
    }


}