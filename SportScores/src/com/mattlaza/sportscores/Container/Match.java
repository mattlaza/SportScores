package com.mattlaza.sportscores.Container;

/**
 * Created by matthew on 6/14/13.
 */
public class Match {

    private String location;
    private int crowdSize;
    private String flag; //either inprogress or recent

    private AflTeam team1;
    private Score team1Score;

    private AflTeam team2;
    private Score team2Score;

    public Match()
    {

    }

    public Match(String location, int crowdSize, AflTeam team1, Score team1Score, Score team2Score, AflTeam team2) {
        this.location = location;
        this.crowdSize = crowdSize;
        this.team1 = team1;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.team2 = team2;
    }

    public Score getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(Score team1Score) {
        this.team1Score = team1Score;
    }

    public Score getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(Score team2Score) {
        this.team2Score = team2Score;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCrowdSize() {
        return crowdSize;
    }

    public void setCrowdSize(int crowdSize) {
        this.crowdSize = crowdSize;
    }

    public AflTeam getTeam1() {
        return team1;
    }

    public void setTeam1(AflTeam team1) {
        this.team1 = team1;
    }

    public AflTeam getTeam2() {
        return team2;
    }

    public void setTeam2(AflTeam team2) {
        this.team2 = team2;
    }
    

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Match [location=" + location + ", crowdSize=" + crowdSize
				+ ", team1=" + team1 + ", team1Score=" + team1Score
				+ ", team2=" + team2 + ", team2Score=" + team2Score + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crowdSize;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((team1 == null) ? 0 : team1.hashCode());
		result = prime * result
				+ ((team1Score == null) ? 0 : team1Score.hashCode());
		result = prime * result + ((team2 == null) ? 0 : team2.hashCode());
		result = prime * result
				+ ((team2Score == null) ? 0 : team2Score.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (crowdSize != other.crowdSize)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (team1 == null) {
			if (other.team1 != null)
				return false;
		} else if (!team1.equals(other.team1))
			return false;
		if (team1Score == null) {
			if (other.team1Score != null)
				return false;
		} else if (!team1Score.equals(other.team1Score))
			return false;
		if (team2 == null) {
			if (other.team2 != null)
				return false;
		} else if (!team2.equals(other.team2))
			return false;
		if (team2Score == null) {
			if (other.team2Score != null)
				return false;
		} else if (!team2Score.equals(other.team2Score))
			return false;
		return true;
	}
    
	
    
}
