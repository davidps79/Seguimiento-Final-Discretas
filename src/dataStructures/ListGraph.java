package dataStructures;
import java.util.*;

public class ListGraph implements IGraph {
	private String[] ch = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    private boolean isDirected;
    private int vertexAmount;
    private int edgeAmount;
    private HashMap<Integer, HashMap<Integer, Integer>> adj;
    private boolean[] color;
    private PriorityQueue<PrimEdge> pq;

    public ListGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.vertexAmount = 0;
        this.edgeAmount = 0;
        this.adj = new HashMap<>();
        this.pq = new PriorityQueue<>();
    }
    
    public HashMap<Integer, HashMap<Integer, Integer>> getAdy(){
    	return adj;
    }
    @Override
    public boolean isDirected() {
		return this.isDirected;
	}

	public void setIsDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

    @Override
	public int getVertexAmount() {
		return this.vertexAmount;
	}

	public void setVertexAmount(int vertexAmount) {
		this.vertexAmount = vertexAmount;
	}

    @Override
	public int getEdgeAmount() {
		return this.edgeAmount;
	}

	public void setEdgeAmount(int edgeAmount) {
		this.edgeAmount = edgeAmount;
	}

    @Override
    public void addVertex() {
    	adj.put(vertexAmount, new HashMap<>());
        vertexAmount++;
    }

    @Override
    public void removeVertex(int vertex) {
    	adj.remove(vertex);
        for (HashMap<Integer, Integer> h : adj.values()) {
            if (h.containsKey(vertex)) h.remove(vertex);
        }
        vertexAmount--;
    }

    @Override
    public void addEdge(int from, int to, int weight) {
    	adj.get(from).put(to, weight);
        if (isDirected==false) adj.get(to).put(from, weight);
        edgeAmount++;
    }

    @Override
    public void removeEdge(int from, int to) {
    	adj.get(from).remove(to);
        if (isDirected==false) adj.get(to).remove(from);
        edgeAmount--;
    }

    @Override
    public String printAdy() {
    	String s="";
        for (Integer i : adj.keySet()) {
            s+=i + " --> ";
            for (Integer j : adj.get(i).keySet()) {
                s+=j + "-" + adj.get(i).get(j) + "; ";
            }
            s+="\n";
        }
        return s;
    }

	@Override
    public void prim() {
        this.color = new boolean[vertexAmount];
		primVisit(0);

    	while(!pq.isEmpty()){
        	int adjacent = pq.poll().getAdjacent();
	    	if(!color[adjacent]){
	    		primVisit(adjacent);
	    	}
    	}
    }
    
	@Override
    public void primVisit(int currentVertex) {
    	System.out.println("visited " + ch[currentVertex]);
    	color[currentVertex] = true;
    	
    	for (Integer i : adj.get(currentVertex).keySet()) {
    		if (!color[i]) {
    			pq.add(new PrimEdge(i, adj.get(currentVertex).get(i)));
    		}
    	}
    }
}