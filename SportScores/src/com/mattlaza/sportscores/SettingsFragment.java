/**
 * 
 */
package com.mattlaza.sportscores;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

/**
 * @author matthew
 *
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getApplicationContext());
//        OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
//             @Override
//             public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
//                Log.i("CHANGE", "CHANGE");
//                
//             }
//         };
//
//         prefs.registerOnSharedPreferenceChangeListener(listener);
    }
    
}