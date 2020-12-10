package com.example.basketballmanagerv3.Helpers;

public class CollectHelperClass {

    private String teamname, teamtag, league, hostname, guestname, playername, position;
    private int playernumber;


/*    public void Writeteam(String team){
        teamlist.add(team);
    }

    public String CheckTeam(String team){
        Integer temp = teamlist.indexOf(team);
        return temp.toString();
    }*/



    public CollectHelperClass() {

    }

    public CollectHelperClass(String teamname, String teamtag, String league) {
        this.teamname = teamname;
        this.teamtag = teamtag;
        this.league = league;
    }

    public CollectHelperClass(String hostname, String guestname) {
        this.hostname = hostname;
        this.guestname = guestname;
    }

    public CollectHelperClass(String playername, int playernumber, String position) {
        this.playername = playername;
        this.playernumber = playernumber;
        this.position = position;
    }

    public int getPlayerNumber() {
        return playernumber;
    }

    public void setPlayerNumber(int playernumber) {
        this.playernumber = playernumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamtag() {
        return teamtag;
    }

    public void setTeamtag(String teamtag) {
        this.teamtag = teamtag;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getHostName() {
        return hostname;
    }

    public void setHostName(String hostname) {
        this.hostname = hostname;
    }

    public String getGuestName() {
        return guestname;
    }

    public void setGuestName(String guestName) {
        this.guestname = guestName;
    }
}
