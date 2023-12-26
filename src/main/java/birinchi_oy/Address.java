package Dars;

public class Address {
        private String countryName;
        private String cityName;
        private String roadName;

        Address(){
            this("Uzbekistan");
        }
        Address(String name){
            this(name,"Tashkent");
        }
        Address(String name,String name2){
            this.countryName = name;
            this.cityName = name2;
            this.roadName = "Chilanzar";
        }


        public String toString(){
            return "Country name: "+ this.countryName + "\nCity name: " + this.cityName + "\nRoad name: " + this.roadName;
        }

    public static void main(String[] args) {
        Address ad = new Address();

        System.out.println(ad);
        System.out.println("________");

    }
}
