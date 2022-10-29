package people;

public abstract class People implements Human,Comparable<People>{
    protected String surname;
    protected String name;
    protected int age;
    protected University university;

    public People(String surname, String name, int age, University university) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.university = university;
    }

    @Override
    public int compareTo(People o) {
        return  this.age > o.age ? 1 : this.age < o.age ? -1 : 0;
    }
}
