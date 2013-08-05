package com.mattlaza.sportscores;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;
import com.mattlaza.sportscores.Adaptor.ListViewAdaptor;
import com.mattlaza.sportscores.Container.Match;

public class MainActivity  extends SherlockActivity implements Callback, OnSharedPreferenceChangeListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
//    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
//    ViewPager mViewPager;

    ListView list;
    private Handler handler;
//    private int updateHandler;
    private Timer t;
    private OnSharedPreferenceChangeListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
       
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
        
        handler = new Handler();
        
//        updateHandler = this.getUpdateInterval();
//        Log.i("UPDATE INT SETTINGS", "" + updateHandler);

    	t = new Timer();

    	 SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	
    	 
    	 
    	 listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
    	             @Override
    	             public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
//    	                Log.i("CHANGE", "CHANGE");
//    	                Toast.makeText(MainActivity.this, "Change main querp", Toast.LENGTH_SHORT).show();
    	            	 if(getUpdateInterval() < 0)
    	            	 {
    	            		 t.cancel();
    	            		 Log.i("timer", "timer cancelled");
    	            	 }
    	            	 else
    	            	 {
    	            		 startTimer();
    	            	 }
    	            	 
    	                
    	             }
    	         };

    	         prefs.registerOnSharedPreferenceChangeListener(listener);
    	
        startTimer();
//        update();
        
    }
    
    public void update()
    {
    	//setSupportProgressBarIndeterminateVisibility(Boolean.TRUE);
        
        try
        {
        	
        	if (isNetworkAvailable())
        	{
        		 RetrievalAsync async = new RetrievalAsync(getSherlock(), MainActivity.this, this);
        		
                 Log.i("async", "starting...");  
                 async.execute("");    
        	}
        	else
        	{
        		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        		dlgAlert.setMessage("No Internet Connection");
        		dlgAlert.setTitle("Afl Scores");
        		dlgAlert.setPositiveButton("Ok",
        			    new DialogInterface.OnClickListener() {
        			        public void onClick(DialogInterface dialog, int which) {
        			          //dismiss the dialog  
        			        }
        			    });
        		dlgAlert.setCancelable(true);
        		dlgAlert.create().show();
        	}
           
        	
        }
        catch (Exception ex)
        {
            Log.e("MainPage", "Exception ", ex);
        }

    }
    
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager 
              = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

	/* (non-Javadoc)
	 * @see com.mattlaza.sportscores.Callback#onScoreCollected()
	 */
	@Override
	public void onScoreCollected(ArrayList<Match> matches) {
		// TODO Auto-generated method stub
//		 ArrayList<Match> matchList = new ArrayList<Match>();
//       matchList = async.get();
       Log.i("async", "finished...");
//       setSupportProgressBarIndeterminateVisibility(false);

       list = (ListView)findViewById(R.id.mainPageList);
       ListViewAdaptor adaptor = new ListViewAdaptor(this.getApplicationContext(), matches);

       list.setAdapter(adaptor);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getSupportMenuInflater();
       inflater.inflate(R.menu.main_page, menu);
       return super.onCreateOptionsMenu(menu);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_refresh:
	        	update();
	        	return true;
	        case R.id.action_settings:
	        	Intent settingsActivity = new Intent(getBaseContext(),
	        			SettingsActivity.class);
	        	startActivity(settingsActivity);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public int getUpdateInterval()
	{
		int interval = 0;
		
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		if (sharedPref.getString(Constants.UPDATEINTERVAL, "") == "")//invalid interval
		{
			interval = 30;
		}
		else
		{
		
			interval = Integer.parseInt(sharedPref.getString(Constants.UPDATEINTERVAL, ""));
		}
		
		Log.i("HELLLLLLLLLLLLO", "value is: " + interval);
		Utilities util = new Utilities();
		
		
		
		return util.convertSecondsToMillis(interval);
		
	}
	
	public void startTimer()
	{
		t.cancel();
		t = new Timer();
		
		if(getUpdateInterval() > 0)//make sure it is valid no timer value is -1
		{

			t.scheduleAtFixedRate(
	    	    new TimerTask()
	    	    {
	    	        public void run()
	    	        {
	    	        	handler.post(new Runnable() {

	    	                public void run() {

	    	                    // TODO Auto-generated method stub
	    	                    runOnUiThread(new Runnable() {

	    	                        public void run() {
	    	                            // TODO Auto-generated method stub
	    	                           Log.i("timer", "Changing Interval to: " + getUpdateInterval());
	    	                           
	    	                           update();
	    	                        }
	    	                    });


	    	                }
	    	            });

	    	            //rg.getChildAt(cnt).setPressed(true);

	    	        }
	    	        
	    	    },
	    	    0,      // run first occurrence immediatetly
	    	    getUpdateInterval()); // run every 30 seconds
		}
	}

	/* (non-Javadoc)
	 * @see android.content.SharedPreferences.OnSharedPreferenceChangeListener#onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String)
	 */
	@Override
	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		// TODO Auto-generated method stub
		Log.e("THINGY CALLED", "PREF UPDATE: " + arg1);
	}

}


