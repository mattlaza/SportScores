/**
 * 
 */
package com.mattlaza.sportscores;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

/**
 * @author matthew
 *
 */
public class SettingsActivity extends SherlockActivity{
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        // Display the fragment as the main content.
	        getFragmentManager().beginTransaction()
	                .replace(android.R.id.content, new SettingsFragment())
	                .commit();
//	        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//	        OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
//	             @Override
//	             public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
//	                Log.i("CHANGE", "CHANGE");
//	                Toast.makeText(SettingsActivity.this, key, Toast.LENGTH_SHORT).show();
//	             }
//	         };
//
//	         prefs.registerOnSharedPreferenceChangeListener(listener);
	    }	
}


