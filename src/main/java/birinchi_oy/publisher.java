package Dars;

public class publisher implements Cloneable{
    String name,location;

    public publisher(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
