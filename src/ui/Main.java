package ui;

import dataStructures.ListGraph;
import dataStructures.MatrixGraph;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	public Main() {
		start();
	}
	
	public void start() {
		/*El metodo retorna la estructura del árbol.
		Con cada nodo agregado y su padre se puede construir
		un árbol n-ario
		
		Los métodos funcionan para grafo por matriz y por lista
		de adyacencia.
		
		Se puede comentar una de las inicializaciones para usar una
		o otra implementación, una a la vez porque se llaman igual.
		*/
		
		//ListGraph graph = new ListGraph(true);
		MatrixGraph graph = new MatrixGraph(true);
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 5, 4);
		graph.addEdge(2, 8, 2);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 8, 6);
		graph.addEdge(6, 7, 1);
		
		System.out.println("MST producido por prim:");
		graph.prim();
	}
}
