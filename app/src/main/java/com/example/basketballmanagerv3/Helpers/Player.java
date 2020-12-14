package com.example.basketballmanagerv3.Helpers;

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

    public Player(String playername, int playernumber) {
        this.playername = playername;
        this.playernumber = playernumber;
    }

    public Player setname(String playername){
        this.playername = playername;
        return null;
    }

    public void addrebound(){
/*        final ConnectionsClass conect = new ConnectionsClass();
        if(conect.CONN() != null){
            Statement statement = null;
            try {
                statement = conect.CONN().createStatement();
                ResultSet temp = statement.executeQuery("SELECT Rebounds_off AS total FROM Match_stats WHERE id_player =(SELECT id_player FROM Players WHERE playername =')"+playername+"'");
                int temp2 = 0;
                while(temp.next()){
                    temp2 = temp.getInt("total");
                    temp2 += 1;
                }
                ResultSet result = statement.executeQuery("INSERT INTO Match_stats (Rebounds_off) VALUES ('"+temp2+"'");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
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
    public int getnumber(){
        return playernumber;
    }

    public int getreb(){
        return reb;
    }
    public int getasis(){
        return asis;
    }
    public int getsteal(){
        return steal;
    }
    public int get2points(){
        return points2;
    }
    public int get3points(){
        return points3;
    }
}
