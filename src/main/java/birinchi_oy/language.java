package Dars;

public class language {
    String name;
    String working;
    public language(String name, String working) {
        this.name = name;
        this.working = working;
    }

    @Override
    public String toString() {
        return "name=" + this.name +
                ", working='" + working;
    }
}
