package Dars.ikkinchi_oy;

public class OpenBudget {
    public int numberOfVotes;
    public void voting(){
        this.numberOfVotes+=1;
        System.out.println("ovoz berildi");
    }

    public int getNumberOfVotes() {
        return this.numberOfVotes;
    }
}
