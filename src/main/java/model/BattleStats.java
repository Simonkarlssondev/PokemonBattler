package model;

public class BattleStats {

    private int wins;
    private int losses;


    public void addWin(){
        wins++;
    }
    public void addLoss(){
        losses++;
    }
    public int getWins(){
        return wins;
    }
    public void setWins(int wins){
        this.wins = wins;
    }
    public int getLosses(){
        return losses;
    }
    public void setLosses(int losses){
        this.losses = losses;
    }


}
