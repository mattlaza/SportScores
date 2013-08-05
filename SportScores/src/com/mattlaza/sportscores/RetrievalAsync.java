package com.mattlaza.sportscores;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mattlaza.sportscores.Container.Match;
import com.mattlaza.sportscores.scraper.AflScraper;
import com.actionbarsherlock.*;

/**
 * Created by matthew on 7/3/13.
 */
public class RetrievalAsync extends AsyncTask<String, Integer, ArrayList<Match>>
{
    ActionBarSherlock sherlock;
    private int numItems;
    ProgressDialog m_dialog;
    Context context;
    private Callback cb;

    /**
	 * @param sherlock2
	 */
	public RetrievalAsync(ActionBarSherlock sherlock2, Context context, Callback cb) {
		// TODO Auto-generated constructor stub
		this.sherlock = sherlock2;
		this.context = context;
		this.cb = cb;
		m_dialog = new ProgressDialog(context);
	}

	@Override
    protected void onPreExecute() {

        sherlock.setProgressBarIndeterminateVisibility(true);

        super.onPreExecute();
    }

    protected ArrayList<Match> doInBackground(String... params)
    {
        ArrayList<Match> matches = new ArrayList<Match>();

        try
        {
            AflScraper scraper = new AflScraper();
            matches = scraper.scrape(Constants.URL);
            
        }
        catch(Exception ex)
        {
            Log.e("AsyncRetrieval", ex.toString());
        }
        return matches;
    }

    @Override
    protected void onPostExecute(ArrayList<Match> matches) {
        sherlock.setProgressBarIndeterminateVisibility(false);

    	cb.onScoreCollected(matches);
        super.onPostExecute(matches);
    }
}
