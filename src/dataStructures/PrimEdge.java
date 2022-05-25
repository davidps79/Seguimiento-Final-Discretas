package dataStructures;

public class PrimEdge implements Comparable<PrimEdge> {
	private int parent;
	private int adjacent;
	private int weight;
 
	public PrimEdge(int adjacent, int weight, int parent) {
	    this.adjacent = adjacent;
	    this.weight = weight;
	    this.parent = parent;
    }
 
	@Override
	public int compareTo(PrimEdge other) {
	    if (this.weight > other.weight)  return 1;
	    else if (this.weight == other.weight) {
	    	return ((Integer) this.getAdjacent()).compareTo((Integer) other.getAdjacent());
	    }
	    else return -1;
	}
	
	public int getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(int adjacent) {
		this.adjacent = adjacent;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return adjacent + " -> " + weight;
	}
}