package com.example.basketballmanagerv3;

public class CollectHelperClass {

    private String teamname, teamtag, league, hostname, guestname;


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
