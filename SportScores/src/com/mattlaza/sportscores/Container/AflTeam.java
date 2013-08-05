package com.mattlaza.sportscores.Container;

/**
 * Created by matthew on 6/14/13.
 */
public class AflTeam {

    private String name;

    public AflTeam()
    {
        name = "UNKNOWN";
    }

    public AflTeam(String inName)
    {
        name = inName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

	@Override
	public String toString() {
		return "AflTeam [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AflTeam other = (AflTeam) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
}

