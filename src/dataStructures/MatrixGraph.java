package dataStructures;

import java.util.PriorityQueue;

public class MatrixGraph implements IGraph {
	private String[] ch = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    private boolean isDirected;
    private int vertexAmount;
    private int edgeAmount;
    private int VERTEX_LIMIT = 100;
    private int adj[][];
    private boolean[] color;
    private PriorityQueue<PrimEdge> pq;
    
    public boolean isDirected() {
		return this.isDirected;
	}

	public void setIsDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public int getVertexAmount() {
		return this.vertexAmount;
	}

	public void setVertexAmount(int vertexAmount) {
		this.vertexAmount = vertexAmount;
	}

	public int getEdgeAmount() {
		return this.edgeAmount;
	}

	public void setEdgeAmount(int edgeAmount) {
		this.edgeAmount = edgeAmount;
	}
	
	public int[][] getAdj() {
		return adj;
	}

    public MatrixGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.vertexAmount = 0;
        this.edgeAmount = 0;
        this.adj = new int[VERTEX_LIMIT][VERTEX_LIMIT];
        this.color = new boolean[VERTEX_LIMIT];
        this.pq = new PriorityQueue<>();
    }  
    
    @Override
    public void addVertex() {
        vertexAmount++;
    }

    @Override
    public void removeVertex(int vertex) {
        for (int i=0; i<vertexAmount; i++) {
        	adj[i][vertex] = 0;
        }

        for (int i=0; i<vertexAmount-1-vertex; i++) {
            for (int j=0; j<vertexAmount; j++) {
                //System.out.println(i + "--> " + j);
            	adj[j][vertex+i] = adj[j][vertex+i+1];
            	adj[vertex+i][j] = adj[vertex+i+1][j];
            }
        }

        for (int i=0; i<vertexAmount-1; i++) {
        	adj[vertexAmount-1][i] = 0;
        	adj[i][vertexAmount-1] = 0;
        }

        vertexAmount--;
    }

    @Override
    public void addEdge(int from, int to, int weight) {
    	adj[from][to] = weight;
        if (isDirected==false) adj[to][from] = weight;
        edgeAmount++;
    }

    @Override
    public void removeEdge(int from, int to) {
    	adj[from][to] = 0;
        if (isDirected==false) adj[to][from] = 0;
        edgeAmount--;
    }

    @Override
    public String printAdy(){
        String s= "";
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = 0; j < vertexAmount; j++) {
                s+= adj[i][j]+" ";
            }
            s+="\n";
        }
      return s;
    }
    
	@Override
    public void prim() {
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
    	for(int i = 0; i < vertexAmount; i++){
    		if (adj[currentVertex][i] != 0 && !color[i]) {
    			pq.add(new PrimEdge(i, adj[currentVertex][i]));
    		}
    	}
    }
}