# Seguimiento-Final-Discretas

David Esteban Peñaranda Scarpetta. A00375827

El método prim() retorna la estructura del árbol:

Con cada nodo agregado y su padre se puede construir el árbol generador mínimo.
		
Los métodos funcionan para grafo por matriz y por lista de adyacencia. Se puede comentar una de las inicializaciones para usar una u otra implementación. Como en ambos casos el grafo se llama graph si se comenta una implementación debe dejarse la otra sin comentar y viceversa. 

La clase Main ya tiene un grafo agregado para probar el método.

Anexo el ejemplo usado:

![image](https://user-images.githubusercontent.com/93486651/170165719-1323bf32-7bc4-4ce7-b360-0a6fb1740f55.png)

Este ejemplo de grafo se encuentra en la página 45 de las últimas diapositivas de clase.

Para crear un grafo nuevo se tiene que llamar el método addVertex() tantas veces como vértices haya y luego agregar las aristas con addEdge(nodo inicial, nodo destino, peso de la arista). Ambos constructores de grafo requieren un booleano que determina si el grafo es dirigido o no, los nombres de los métodos son los mismos, sólo es comentar una inicialización u otra para usar MatrixGraph o ListGraph.
