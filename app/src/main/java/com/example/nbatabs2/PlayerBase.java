package com.example.nbatabs2;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class PlayerBase {
    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<Integer> iconList = new ArrayList<>();
    Player PG=new Player("Paul George",35000000,29,false,"LAC",R.drawable.lacicon,1);
    Player KL = new Player("Kawhi Leonard",32500000,27,false,"LAC",R.drawable.lacicon,1);
    Player LS=new Player("Landry Shamet", 8700000,22,false,"LAC",R.drawable.lacicon,1);
    Player GH=new Player("Gordon Hayward",35000000,30,false,"BOS",R.drawable.bosicon,0);
    Player KW = new Player("Kemba Walker",32500000,26,false,"BOS",R.drawable.bosicon,0);
    Player MS=new Player("Marcus Smart", 8600000,25,false,"BOS",R.drawable.bosicon,0);
    Player TY=new Player("Trae Young",10000000,21,false,"ATL",R.drawable.atlicon,2);
    Player KH = new Player("Kevin Huerter",7800000,22,false,"ATL",R.drawable.atlicon,2);
    Player DH=new Player("DeAndre Hunter", 7600000,19,false,"ATL",R.drawable.atlicon,2);
    int lacicon = R.drawable.lacicon;
    int atlicon = R.drawable.atlicon;
    int bosicon=R.drawable.bosicon;

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

    @Override
    public String toString() {
        return super.toString();
    }
}
