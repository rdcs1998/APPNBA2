package com.example.nbatabs2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nbatabs2.ui.main.SectionsPagerAdapter;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TeamDyn.FragmentDynListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
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
        TextView textView=findViewById(R.id.textView3);
        textView.setText(Status());
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
                CelticsNewCap+=PB.playerList.get(iter).getSalary();//total
            }
            if(PB.playerList.get(iter).getIconPos()==1){
                ClippersNewCap+=PB.playerList.get(iter).getSalary();//total
            }
            if(PB.playerList.get(iter).getIconPos()==2){
                HawksNewCap+=PB.playerList.get(iter).getSalary();//total
            }
        }
        int clips=0;//outgoing
        int hawks=0;//outgoing
        int celtics=0;//outgoing
        for(int iter = 0;iter<PB.playerList.size();++iter){
            if(PB.playerList.get(iter).getTeam()=="BOS"&&PB.playerList.get(iter).getIconPos()!=0){
                celtics+=PB.playerList.get(iter).getSalary();
            }
            if(PB.playerList.get(iter).getTeam()=="LAC"&&PB.playerList.get(iter).getIconPos()!=1){
                clips+=PB.playerList.get(iter).getSalary();
            }
            if(PB.playerList.get(iter).getTeam()=="ATL"&&PB.playerList.get(iter).getIconPos()!=2){
                hawks+=PB.playerList.get(iter).getSalary();
            }
        }
        ClippersNewCap=(int)(ClippersNewCap-(clips*1.25)-ClippersCap-1000000);
        CelticsNewCap=(int)(CelticsNewCap-(celtics*1.25)-CelticsCap);
        HawksNewCap=(int)(HawksNewCap-(hawks*1.25)-HawksCap);
        String capStringClips = numberFormat.format(ClippersNewCap);
        String capStringCeltics = numberFormat.format(CelticsNewCap);
        String capStringHawks=numberFormat.format(HawksNewCap);
        if(ClippersNewCap>0){result+="Clippers will be taking in: "+capStringClips+" more than allowed.\n";}
        if(CelticsNewCap>0){result+="Celtics will be taking in: " +capStringCeltics+" more than allowed.\n";}
        if(HawksNewCap>0){result+="Hawks will be taking in: "+capStringHawks+" more than allowed.\n";}
        if(result==""){result+="All salaries are matching.";}

        return result;
    }
}