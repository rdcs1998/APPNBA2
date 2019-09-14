package com.example.nbatabs2;

public class Team {
    String name;
    int SalaryCap;
    int TeamIcon;
    Player[] players;
    int TeamLogo;

    public Team(String name,int TeamLogo, int TeamIcon,int salaryCap){
        this.name=name;
        this.SalaryCap=salaryCap;
        this.TeamIcon=TeamIcon;
        this.TeamLogo=TeamLogo;
    }

    public String getName(){return name;}
    public void SetName(String name){this.name=name; }
    public int getTeamLogo(){return TeamLogo;}
    public void setTeamLogo(int TeamLogo){this.TeamLogo=TeamLogo;}
    public int getTeamIcon(){return TeamIcon;}
    public void setTeamIcon(int TeamIcon){this.TeamIcon = TeamIcon;}
    public int getSalaryCap(){return SalaryCap;}
    public void setSalaryCap(int SalaryCap){this.SalaryCap=SalaryCap;}
    public Player[] getPlayers(){return players;}
    public void setPlayers(Player[] players){this.players=players;}

}