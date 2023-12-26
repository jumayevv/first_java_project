package Dars.ikkinchi_oy;

import java.util.ArrayList;
import java.util.Map;

public class Person {
    private String ismi;
    private String kursi;
    private double payment;

    public Person(String ismi, String kursi, double payment) {
        this.ismi = ismi;
        this.kursi = kursi;
        this.payment = payment;
    }

    public String getKursi() {
        return kursi;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ismi='" + ismi + '\'' +
                ", kursi='" + kursi + '\'' +
                ", payment=" + payment +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Xasan","Java",100D));
        persons.add(new Person("Xusan","Python",800D));
        persons.add(new Person("Zuhra","Go",700D));
        persons.add(new Person("Fotim","Java",100D));
        persons.add(new Person("Akmal","Java",100D));
        persons.add(new Person("Bobur","JavaScript",200D));
        double result = persons.stream().
                filter(x->x.getKursi().equals("Java"))
                .mapToDouble(x->{
                    double r = x.getPayment() - ((x.getPayment()*10)/100);
                    x.setPayment(r);
                return x.getPayment();
        }).sum();
        System.out.println(Math.round(result));

    }
}
