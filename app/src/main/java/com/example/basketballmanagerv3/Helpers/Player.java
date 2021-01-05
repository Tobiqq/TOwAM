package com.example.basketballmanagerv3.Helpers;

public class Player {
    private String teamname, teamtag, league, playername, position;
    private int playernumber;

    int points2 = 0;
    int points2try = 0;
    int points3 = 0;
    int points3try = 0;
    int reboff = 0;
    int rebdeff = 0;
    int asis = 0;
    int block = 0;
    int steal = 0;
    int loss = 0;

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

    public void addreboundoff(){
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
        reboff += 1;
    }

    public void addrebounddeff(){
        rebdeff += 1;
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

    public void add2pointstry(){
        points2try += 1;
    }

    public void add3pointstry(){
        points3try += 1;
    }

    public void addloss(){
        loss += 1;
    }

    public String getname(){
        return playername;
    }
    public int getnumber(){
        return playernumber;
    }

    public int getreboff(){
        return reboff;
    }
    public int getrebdeff(){
        return rebdeff;
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
    public int get2pointstry(){
        return points2try;
    }
    public int get3pointstry(){
        return points3try;
    }
    public int getloss(){
        return loss;
    }
    public int getblock(){
        return block;
    }

    public void remrebounddeff(){
        rebdeff -= 1;
    }

    public void remreboundoff(){
        reboff -= 1;
    }

    public void remsteal(){
        steal -= 1;
    }

    public void remblock(){
        block -= 1;
    }

    public void remasist(){
        asis -= 1;
    }

    public void rem2points(){
        points2 -= 1;
    }

    public void rem3points(){
        points3 -= 1;
    }

    public void rem2pointstry(){
        points2try -= 1;
    }

    public void rem3pointstry(){
        points3try -= 1;
    }

    public void remloss(){
        loss -= 1;
    }
}
