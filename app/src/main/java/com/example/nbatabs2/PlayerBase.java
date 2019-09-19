package com.example.nbatabs2;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class PlayerBase {
    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<Integer> iconList = new ArrayList<>();

    static Player PG=new Player("Paul George",35000000,29,"LAC",R.drawable.lacicon,1);
    static Player KL = new Player("Kawhi Leonard",32500000,27,"LAC",R.drawable.lacicon,1);
    static Player LS=new Player("Landry Shamet", 9700000,22,"LAC",R.drawable.lacicon,1);
    static Player GH=new Player("Gordon Hayward",35000000,30,"BOS",R.drawable.bosicon,0);
    static Player KW = new Player("Kemba Walker",32500000,26,"BOS",R.drawable.bosicon,0);
    static Player MS=new Player("Marcus Smart", 8600000,25,"BOS",R.drawable.bosicon,0);
    static Player TY=new Player("Trae Young",10000000,21,"ATL",R.drawable.atlicon,2);
    static Player KH = new Player("Kevin Huerter",7800000,22,"ATL",R.drawable.atlicon,2);
    static Player DH=new Player("DeAndre Hunter", 7600000,19,"ATL",R.drawable.atlicon,2);

    int lacicon = R.drawable.lacicon;
    int atlicon = R.drawable.atlicon;
    int bosicon=R.drawable.bosicon;

    public static void initPlayers() {
        PG = new Player("Paul George",35000000,29,"LAC",R.drawable.lacicon,1);
        KL = new Player("Kawhi Leonard",32500000,27,"LAC",R.drawable.lacicon,1);
        LS = new Player("Landry Shamet", 9700000,22,"LAC",R.drawable.lacicon,1);
        GH = new Player("Gordon Hayward",35000000,30,"BOS",R.drawable.bosicon,0);
        KW = new Player("Kemba Walker",32500000,26,"BOS",R.drawable.bosicon,0);
        MS = new Player("Marcus Smart", 8600000,25,"BOS",R.drawable.bosicon,0);
        TY = new Player("Trae Young",10000000,21,"ATL",R.drawable.atlicon,2);
        KH = new Player("Kevin Huerter",7800000,22,"ATL",R.drawable.atlicon,2);
        DH = new Player("DeAndre Hunter", 7600000,19,"ATL",R.drawable.atlicon,2);
    }

    public PlayerBase(){
        playerList.add(PG);
        playerList.add(KL);
        playerList.add(LS);
        playerList.add(GH);
        playerList.add(KW);
        playerList.add(MS);
        playerList.add(TY);
        playerList.add(KH);
        playerList.add(DH);
        iconList.add(bosicon);
        iconList.add(lacicon);
        iconList.add(atlicon);

    }
}
