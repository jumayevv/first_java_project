package Dars.ikkinchi_oy;

public class Comment {
    private int likelar_soni;
    private int dislike_soni;

     public synchronized void like(){
        this.likelar_soni+=1;
        System.out.println("Like bittaga oshdi");
    }

    public synchronized void dislike(){
        this.dislike_soni+=1;
        System.out.println("Dislike bittaga oshdi");
    }

    public String getLike() {
        return  "Like lar soni: "+this.likelar_soni;
    }

    public String getDislike() {
        return "Dislike lar soni: "+dislike_soni;
    }
}
