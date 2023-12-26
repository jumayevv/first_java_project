package uchinchi_oy;

public class Student {
    public String name;
    public int ball;

    public Student(String name, int ball) {
        this.name = name;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ball=" + ball +
                '}';
    }
}
