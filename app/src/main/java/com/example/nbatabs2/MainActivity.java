package com.example.nbatabs2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nbatabs2.ui.main.SectionsPagerAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TeamDyn.FragmentDynListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.pickTeams) {
            // Logica de Pick Teams
            return true;
        }

        if (item.getItemId() == R.id.reset) {
            PlayerBase.initPlayers();

            ViewPager viewPager = findViewById(R.id.view_pager);
            TabLayout tabs = findViewById(R.id.tabs);

            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
            viewPager.setAdapter(sectionsPagerAdapter);
            tabs.setupWithViewPager(viewPager);

            MakeSnackBar();
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        MakeSnackBar();
        setupActionBar();
    }

    private void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.tabToolbar);
        setSupportActionBar(toolbar);
    }

    public void MakeSnackBar(){
        TextView textView=findViewById(R.id.textView3);
        textView.setText(Status());
    }

    public String Status(){
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

        TextView textView=findViewById(R.id.textView3);

        ArrayList<String> result = new ArrayList<>();
        if(ClippersNewCap>0){
            textView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            result.add("Clippers will be taking in: "+capStringClips+" more than allowed.");
        }
        if(CelticsNewCap>0){
            textView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            result.add("Celtics will be taking in: " +capStringCeltics+" more than allowed.");}
        if(HawksNewCap>0){
            textView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            result.add("Hawks will be taking in: "+capStringHawks+" more than allowed.");}
        if(result.isEmpty()){
            textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            result.add("All salaries are matching.");}

        return TextUtils.join("\n", result);
    }
}