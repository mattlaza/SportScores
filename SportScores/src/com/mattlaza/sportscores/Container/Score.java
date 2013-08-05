package com.mattlaza.sportscores.Container;

/**
 * Created by matthew on 6/14/13.
 */
public class Score {

    private String firstQuarter;
    private String secondQuarter;
    private String thirdQuarter;
    private String fourthQuarter;

    public Score(String firstQuarter, String secondQuarter, String thirdQuarter, String fourthQuarter) {
        this.firstQuarter = firstQuarter;
        this.secondQuarter = secondQuarter;
        this.thirdQuarter = thirdQuarter;
        this.fourthQuarter = fourthQuarter;
    }

	public String getFirstQuarter() {
		return firstQuarter;
	}

	public void setFirstQuarter(String firstQuarter) {
		this.firstQuarter = firstQuarter;
	}

	public String getSecondQuarter() {
		return secondQuarter;
	}

	public void setSecondQuarter(String secondQuarter) {
		this.secondQuarter = secondQuarter;
	}

	public String getThirdQuarter() {
		return thirdQuarter;
	}

	public void setThirdQuarter(String thirdQuarter) {
		this.thirdQuarter = thirdQuarter;
	}

	public String getFourthQuarter() {
		return fourthQuarter;
	}

	public void setFourthQuarter(String fourthQuarter) {
		this.fourthQuarter = fourthQuarter;
	}

	@Override
	public String toString() {
		return "Score [firstQuarter=" + firstQuarter + ", secondQuarter="
				+ secondQuarter + ", thirdQuarter=" + thirdQuarter
				+ ", fourthQuarter=" + fourthQuarter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstQuarter == null) ? 0 : firstQuarter.hashCode());
		result = prime * result
				+ ((fourthQuarter == null) ? 0 : fourthQuarter.hashCode());
		result = prime * result
				+ ((secondQuarter == null) ? 0 : secondQuarter.hashCode());
		result = prime * result
				+ ((thirdQuarter == null) ? 0 : thirdQuarter.hashCode());
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
		Score other = (Score) obj;
		if (firstQuarter == null) {
			if (other.firstQuarter != null)
				return false;
		} else if (!firstQuarter.equals(other.firstQuarter))
			return false;
		if (fourthQuarter == null) {
			if (other.fourthQuarter != null)
				return false;
		} else if (!fourthQuarter.equals(other.fourthQuarter))
			return false;
		if (secondQuarter == null) {
			if (other.secondQuarter != null)
				return false;
		} else if (!secondQuarter.equals(other.secondQuarter))
			return false;
		if (thirdQuarter == null) {
			if (other.thirdQuarter != null)
				return false;
		} else if (!thirdQuarter.equals(other.thirdQuarter))
			return false;
		return true;
	}

   
}
