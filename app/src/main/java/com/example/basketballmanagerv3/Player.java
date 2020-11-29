package com.example.basketballmanagerv3;

public class Player {
    private String teamname, teamtag, league, playername, position;
    private int playernumber;

    int points2 = 0;
    int points3 = 0;
    int reb = 0;
    int asis = 0;
    int block = 0;
    int steal = 0;

    public Player() {

    }

    public Player(String playername) {
        this.playername = playername;
    }

    public void name(String playername){
        this.playername = playername;
    }

    public void addrebound(){
        reb += 1;
    }

    public void addsteal(){
        steal += 1;
    }

    public void addblock(){
        block += 1;
    }

    public void addasist(){
        asis += 1;
    }

    public void add2points(){
        points2 += 1;
    }

    public void add3points(){
        points3 += 1;
    }

    public String getname(){
        return playername;
    }

    public int getreb(){
        return reb;
    }
}
