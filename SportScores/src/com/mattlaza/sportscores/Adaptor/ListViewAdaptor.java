package com.mattlaza.sportscores.Adaptor;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mattlaza.sportscores.R;
import com.mattlaza.sportscores.Container.Match;

/**
 * Created by matthew on 7/3/13.
 */
public class ListViewAdaptor extends BaseAdapter {

    private ArrayList<Match> matches;
    private Context context;
//    private Activity activity;
//    private LayoutInflater inflater;

    public ListViewAdaptor(Context context,  ArrayList<Match> matches)
    {
        this.matches = matches;
        this.context = context;
//        this.activity = activity;
//        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return matches.size();
    }

    @Override
    public Object getItem(int i) {
        return matches.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
        View v = view;

        if (v == null)
        {
            v = inflater.inflate(R.layout.match_view, null);
        }

        
        
        TextView matchTeams = (TextView)v.findViewById(R.id.matchViewTeams);
        
        ImageView team1flag = (ImageView)v.findViewById(R.id.matchViewTeam1Flag);
        ImageView team2flag = (ImageView)v.findViewById(R.id.matchViewTeam2Flag);
        team1flag.setImageResource(getTeamFlag(matches.get(i).getTeam1().getName()));
        team2flag.setImageResource(getTeamFlag(matches.get(i).getTeam2().getName()));

        matchTeams.setText(matches.get(i).getTeam1().getName() + " VS " + matches.get(i).getTeam2().getName());
        matchTeams.setTextColor(Color.BLACK);
        
        TextView team1Rd1Score = (TextView)v.findViewById(R.id.matchViewTeam1Rd1);
        team1Rd1Score.setText(matches.get(i).getTeam1Score().getFirstQuarter());
        team1Rd1Score.setTextColor(Color.BLACK);
        
        TextView team1Rd2Score = (TextView)v.findViewById(R.id.matchViewTeam1Rd2);
        team1Rd2Score.setText(matches.get(i).getTeam1Score().getSecondQuarter());
        team1Rd2Score.setTextColor(Color.BLACK);
        
        TextView team1Rd3Score = (TextView)v.findViewById(R.id.matchViewTeam1Rd3);
        team1Rd3Score.setText(matches.get(i).getTeam1Score().getThirdQuarter());
        team1Rd3Score.setTextColor(Color.BLACK);
        
        TextView team1Rd4Score = (TextView)v.findViewById(R.id.matchViewTeam1Rd4);
        team1Rd4Score.setText(matches.get(i).getTeam1Score().getFourthQuarter());
        team1Rd4Score.setTextColor(Color.BLACK);
        
        TextView team2Rd1Score = (TextView)v.findViewById(R.id.matchViewTeam2Rd1);
        team2Rd1Score.setText(matches.get(i).getTeam2Score().getFirstQuarter());
        team2Rd1Score.setTextColor(Color.BLACK);
        
        TextView team2Rd2Score = (TextView)v.findViewById(R.id.matchViewTeam2Rd2);
        team2Rd2Score.setText(matches.get(i).getTeam2Score().getSecondQuarter());
        team2Rd2Score.setTextColor(Color.BLACK);
        
        TextView team2Rd3Score = (TextView)v.findViewById(R.id.matchViewTeam2Rd3);
        team2Rd3Score.setText(matches.get(i).getTeam2Score().getThirdQuarter());
        team2Rd3Score.setTextColor(Color.BLACK);
        
        TextView team2Rd4Score = (TextView)v.findViewById(R.id.matchViewTeam2Rd4);
        team2Rd4Score.setText(matches.get(i).getTeam2Score().getFourthQuarter());
        team2Rd4Score.setTextColor(Color.BLACK);
        
        TextView flag = (TextView)v.findViewById(R.id.matchViewFlag);
        flag.setText(matches.get(i).getFlag());
        flag.setTextColor(Color.BLACK);
        
       
        return v;
    }

	/**
	 * @param name
	 * @return
	 */
	private int getTeamFlag(String name) {
		// TODO Auto-generated method stub
		
//		Log.i("teamname", "finding.. " + name);
		
		if (name.contains("Adelaide")) { return R.drawable.adelaide; }
		else if (name.contains("Brisbane")) {return R.drawable.brisbane; }
		else if (name.contains("Bulldogs")) { return R.drawable.bulldogs; }
		else if (name.contains("Carlton"))  { return R.drawable.carlton; }
		else if (name.contains("Collingwood")) { return R.drawable.collingwood; }
		else if (name.contains("Essendon")) { return R.drawable.essendon; }
		else if (name.contains("Fremantle")) { return R.drawable.fremantle; }
		else if (name.contains("Gold Coast")) { return R.drawable.gcsuns; }
		else if (name.contains("Geelong")) { return R.drawable.geelong; }
		else if (name.contains("Giants")) { return R.drawable.giants; }
		else if (name.contains("Hawthorn")) { return R.drawable.hawks; }
		else if (name.contains("North")) { return R.drawable.north; }
		else if (name.contains("Melbourne")) { return R.drawable.melbourne; }	
		else if (name.contains("Port adelaide")) { return R.drawable.port; }
		else if (name.contains("Richmond")) { return R.drawable.richmond; }
		else if (name.contains("St Kilda")) { return R.drawable.stkilda; }
		else if (name.contains("Swans")) { return R.drawable.swans; }
		else if (name.contains("West Coast")) { return R.drawable.wce; }
		else { Log.i("image ", "non valid team name?"); return -1;}
		
		
		
	}
}
