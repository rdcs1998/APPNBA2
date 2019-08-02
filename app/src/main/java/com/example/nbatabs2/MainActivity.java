package com.example.nbatabs2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.nbatabs2.ui.main.SectionsPagerAdapter;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TeamDyn.FragmentDynListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        Snackbar.make(findViewById(android.R.id.content),"All salaries are matching", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();


    }
    public void MakeSnackBar(){
        Snackbar.make(findViewById(android.R.id.content),Status(), Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }

    public String Status(){
        String result ="";
        int ClippersCap=76200000;
        int CelticsCap=76100000;
        int HawksCap=25400000;
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        int ClippersNewCap=0;
        int CelticsNewCap=0;
        int HawksNewCap=0;
        PlayerBase PB = new PlayerBase();
        for(int iter=0;iter<PB.playerList.size();++iter){
            if(PB.playerList.get(iter).getIconPos()==0){
                CelticsNewCap+=PB.playerList.get(iter).getSalary();
            }
            if(PB.playerList.get(iter).getIconPos()==1){
                ClippersNewCap+=PB.playerList.get(iter).getSalary();
            }
            if(PB.playerList.get(iter).getIconPos()==2){
                HawksNewCap+=PB.playerList.get(iter).getSalary();
            }
        }
        int clips= (int) (ClippersCap*1.25);
        int hawks=(int)(HawksCap*1.25);
        int celtics=(int)(CelticsCap*1.25);
        ClippersNewCap=ClippersNewCap;
        HawksNewCap=HawksNewCap;
        CelticsNewCap=CelticsNewCap;
        String capStringClips = numberFormat.format(ClippersNewCap);
        String capStringCeltics = numberFormat.format(CelticsNewCap);
        String capStringHawks=numberFormat.format(HawksNewCap);
        if(ClippersNewCap>0){result+="Clippers";}
        if(CelticsNewCap>0){result+="Celtics";}
        if(HawksNewCap>0){result+="Hawks";}
        result+=HawksNewCap;
        result+=ClippersNewCap;
        result+=CelticsNewCap;

        return result;
    }
}