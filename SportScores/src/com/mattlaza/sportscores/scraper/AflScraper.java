package com.mattlaza.sportscores.scraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import android.util.Log;

import com.mattlaza.sportscores.Constants;
import com.mattlaza.sportscores.Container.*;

/**
 * Created by matthew on 6/6/13.
 * Uses Jsoup to connect and retrive the html code, parses the matches and stores them into a arraylist
 */
public class AflScraper {
	
	private int numItems;

    public AflScraper()
    {

    }

    public ArrayList<Match> scrape(String url) throws IOException
    {
        ArrayList<Match> matches;
        Document doc;

        matches = new ArrayList<Match>();
        String error = "none found";
        try
        {	
	        
	        doc = Jsoup.connect(url).get();
	
	        Elements tables = doc.select("div.scoresection.afl.clearfix").not("in-progress");
	        
	        Elements inprogress = doc.getElementsByClass("in-progress");
	        
//	        Log.i("scraper", "classes found: " + inprogress.size());
//	        Log.i("scraper", "tables found: " + tables.size());
	        

	        for (Element current : inprogress)
	        {
	        	Match match = new Match();
	        	
	        	match.setFlag(Constants.INPROGRESS);
	        	
	        	Elements row = current.select("tr");
	        	Elements tds = row.get(1).select("td");
	        	
	        	match.setTeam1(new AflTeam(tds.get(0).text()));
	        	String firstq;
	        	String secondq;
	        	String thirdq;
	        	String fourthq;
	        	
	        	
	        	firstq = tds.get(1).text();
	        	secondq = thirdq = fourthq = "";
	        	
//	        	Log.i("querp", "" + tds.size());
	        	if(tds.size() > 2)
	        		secondq = tds.get(2).text();
	        	
	        	if(tds.size() > 3)
	        		thirdq = tds.get(3).text();
	        	
	        	if(tds.size() > 4)
	        		fourthq = tds.get(4).text();
	        	
	        	match.setTeam1Score(new Score(firstq, secondq, thirdq, fourthq));
	        	
	        	tds = row.get(2).select("td");
	        	
	        	match.setTeam2(new AflTeam(tds.get(0).text()));
	        	firstq = tds.get(1).text();
	        	secondq = thirdq = fourthq = "";
	        	
	        	if(tds.size() > 2)
	        		secondq = tds.get(2).text();
	        	
	        	if(tds.size() >  3)
	        		thirdq = tds.get(3).text();
	        	
	        	if(tds.size() >  4)
	        		fourthq = tds.get(4).text();
	        	
	        	match.setTeam2Score(new Score(firstq, secondq, thirdq, fourthq));
//	        	Log.i("scraping", match.toString());
	        	
	        	matches.add(match);
	        	
	        }
	
	        int index = 0;
	        for (Element table: tables)
	        {
	        	
		        		Match match = new Match();
		        		match.setFlag(Constants.RECENT);
			            Elements row = table.select("tr");
			            
			            error = table.text();
			            if (!table.text().contains("Add to Calendar"))
			            {
	//			            	Log.i("ERROR", "hit the upcoming games");
				            
				            
				            Elements tds = row.get(1).select("td");
				            
	//			            error += " " +  tds.text();
				            
				            match.setTeam1(new AflTeam(tds.get(0).text()));
	//			            match.setTeam1Score(new Score(tds.get(1).text(), tds.get(2).text(), tds.get(3).text(), tds.get(4).text()));
				            
				            String firstq;
				        	String secondq;
				        	String thirdq;
				        	String fourthq;
				        	
				        	
				        	firstq = tds.get(1).text();
				        	
	//			        	error += " " +  firstq;
				        	secondq = thirdq = fourthq = "";
				        	
	//			        	Log.i("querp", "" + tds.size());
				        	if(tds.size() > 2)
				        		secondq = tds.get(2).text();
				        	
				        	if(tds.size() > 3)
				        		thirdq = tds.get(3).text();
				        	
				        	if(tds.size() > 4)
				        		fourthq = tds.get(4).text();
				        	
				        	match.setTeam1Score(new Score(firstq, secondq, thirdq, fourthq));
				            
				            tds = row.get(2).select("td");
				            match.setTeam2(new AflTeam(tds.get(0).text()));
	//			            match.setTeam2Score(new Score(tds.get(1).text(), tds.get(2).text(), tds.get(3).text(), tds.get(4).text()));
				            
				    
				        	
				        	firstq = tds.get(1).text();
				        	secondq = thirdq = fourthq = "";
				        	
	//			        	Log.i("querp", "" + tds.size());
				        	if(tds.size() > 2)
				        		secondq = tds.get(2).text();
				        	
				        	if(tds.size() > 3)
				        		thirdq = tds.get(3).text();
				        	
				        	if(tds.size() > 4)
				        		fourthq = tds.get(4).text();
				        	
				        	match.setTeam2Score(new Score(firstq, secondq, thirdq, fourthq));
	//			        	Log.i("scraping", match.toString());
				            matches.add(match);
			            }
	        	}

//	        for (int i = inprogress.size()-1; i < 0; i--)
//	        {
//	        	Log.i("async", "removing...");
//	        	matches.remove(i);
//	        }
	        
        }
        catch(Exception ex)
        {
//        	Log.i("aflScraper" ,  error);
        	Log.e("aflScraper" , "scraping", ex);
        }
        
       
        return matches;
    }

    
    
}
