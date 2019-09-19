package com.example.nbatabs2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.jar.Attributes;

public class TeamDyn extends Fragment {
    String Name;
    int Logo;
    int iconLogo;
    int OGSalary;
    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<Integer> iconList = new ArrayList<>();
    boolean listSet=false;
    private FragmentDynListener listener;

    public interface FragmentDynListener{void MakeSnackBar();}

    public static TeamDyn newInstance(String _name, int _logo,int _iconlogo,int _OGSalary) {

        Bundle args = new Bundle();
        TeamDyn fragment = new TeamDyn(_name,_logo,_iconlogo,_OGSalary);
        fragment.setArguments(args);
        return fragment;
    }
    public static TeamDyn newInstance(Team _team){
        Bundle args = new Bundle();
        TeamDyn fragment = new TeamDyn(_team);
        fragment.setArguments(args);
        return fragment;
    }

    public TeamDyn(String _name,int _logo,int _iconlogo,int _OGSalary){
        this.Logo=_logo;
        this.Name=_name;
        this.iconLogo = _iconlogo;
        this.OGSalary =_OGSalary;
    }

    public TeamDyn(Team _team){
        this.Logo=_team.getTeamLogo();
        this.iconLogo=_team.getTeamIcon();
        this.Name=_team.getName();
        this.OGSalary=_team.getSalaryCap();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof FragmentDynListener){
            listener=(FragmentDynListener)context;}
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_fragment, container, false);
        ImageView IV = (ImageView)view.findViewById(R.id.dynLogo) ;
        IV.setImageResource(this.Logo);
        //if(!listSet){
            PlayerBase PB = new PlayerBase();
            for(int iter=0;iter<PB.playerList.size();++iter){
                if(PB.playerList.get(iter).getTeam().equals(this.Name)){
                    this.playerList.add(PB.playerList.get(iter));
                }
            }
            iconList=PB.iconList;
            //listSet=true; }
        ListView listView =(ListView) view.findViewById(R.id.dynList);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        CustomAdapter bb = new CustomAdapter(getContext(),playerList);
        listView.setAdapter(bb);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int iconPos = 0;
                iconPos=playerList.get(i).getIconPos();
                int newPos = iconPos+1;
                if (newPos>2){newPos-=3;}
                ImageView tt = (ImageView) view.findViewById(R.id.dynView);
                if (playerList.get(i).getIconPos() <= 2) {
                    tt.setImageResource(iconList.get(newPos));

                    playerList.get(i).setIconPos(newPos);
                    playerList.get(i).setTeamIcon(iconList.get(newPos));
                }
                listener.MakeSnackBar();

            }

        });

        return view;
    }

    class CustomAdapter extends BaseAdapter {

        static final int BASE_ID  = 0x10000000;
        Context mContext;
        ArrayList<Player> mCollection;

        CustomAdapter(Context _context, ArrayList<Player> _collection){
            mContext = _context;
            mCollection = _collection;
        }
        @Override
        public int getCount()
        {
            if(mCollection!=null){
                return mCollection.size();
            }
            return 0;
        }


        @Override
        public Object getItem(int _position) {
            if(mCollection != null && _position<mCollection.size()&&_position>-1){
                return mCollection.get(_position);
            }
            return null;
        }

        @Override
        public long getItemId(int _position) {
            return BASE_ID + _position;
        }

        @Override
        public View getView(int _position, View _recycleView, ViewGroup _parentView) {
            if(_recycleView==null) {
                _recycleView = LayoutInflater.from(mContext)
                        .inflate(R.layout.playerlayout, _parentView, false);
            }
            TextView playerName=(TextView)_recycleView.findViewById(R.id.playerName);
            TextView playerAge=(TextView)_recycleView.findViewById(R.id.playerAge);
            TextView playerSalary=(TextView)_recycleView.findViewById(R.id.playerSalary);
            ImageView playerLogo=(ImageView)_recycleView.findViewById(R.id.dynView);

            Player player = (Player)getItem(_position);

            playerName.setText(player.getName());
            Integer age=player.getAge();
            Integer salary=player.getSalary();
            int icon = player.getTeamIcon();
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            String salaryString=numberFormat.format(salary);
            String ageString=age.toString();
            salaryString=String.format("%8s",salaryString);
            salaryString="Salary:"+salaryString;
            ageString="Age: "+ageString;
            playerAge.setText(ageString);
            playerSalary.setText(salaryString);
            playerLogo.setImageResource(icon);

            return _recycleView;
        }
    }

}
