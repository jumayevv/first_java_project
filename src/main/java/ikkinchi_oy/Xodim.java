package Dars.ikkinchi_oy;

public class Xodim {
    public String name;
    public double oyligi;

    public int yoshi;

    public Xodim(String name, double oyligi, int yoshi) {
        this.name = name;
        this.oyligi = oyligi;
        this.yoshi = yoshi;
    }

    @Override
    public String toString() {
        return "Xodim{" +
                "name='" + name + '\'' +
                ", oyligi=" + oyligi +
                ", yoshi=" + yoshi +
                '}';
    }
}
