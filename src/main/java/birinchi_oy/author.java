package Dars;

public class author implements Cloneable{
    String name,city;
    public author(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "\nauthor name: " + this.name +
                "\ncity: " + this.city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
