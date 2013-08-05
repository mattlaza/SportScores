/**
 * 
 */
package com.mattlaza.sportscores;

import java.util.ArrayList;

import com.mattlaza.sportscores.Container.Match;

/**
 * @author matthew
 *
 */
public interface Callback {
	void onScoreCollected(ArrayList<Match> matches);
}
