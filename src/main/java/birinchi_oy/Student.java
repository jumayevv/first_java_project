package Dars;

public class Student {

    String name;
    int yoshi,toplagan_bali;
    float tolov_summa;

    public Student(String name, int yoshi, int toplagan_bali, float tolov_summa) {
        this.name = name;
        this.yoshi = yoshi;
        this.toplagan_bali = toplagan_bali;
        this.tolov_summa = tolov_summa;
    }

    public int getToplagan_bali() {
        return toplagan_bali;
    }

    public void setToplagan_bali(int toplagan_bali) {
        this.toplagan_bali = toplagan_bali;
    }

    public float getTolov_summa() {
        return tolov_summa;
    }

    public void setTolov_summa(float tolov_summa) {
        this.tolov_summa = tolov_summa;
    }

    @Override
    public String toString(){
        return "\nname: "+this.name+
                "\nyoshi: "+ this.yoshi+
                "\nto'plagan bali: "+this.toplagan_bali +
                "\nto'lov summa: "+this.tolov_summa;
    }
}
