/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.*;
/**
 *
 * @author Jumpstarters
 * "Vamos a brincar hasta la cima"
 * Ana Teresa Ramírez Morones 512873
 * Josue Alexis Ramírez 513622
 * Jose María de la Garza 513097
 * Luis Iván García 1410530
 * 3er Semestre ITIC
 * 
 *  Clase par implementar la busqueda en el primero de Profundidad.
 */
public class BreadthFisrtSearch{
    /** Realiza una busqueda en el primero de profundiad en un grafo.
        posterior: El arreglo padre será el contenedor del predecesor
        de cada vertice en la busqueda por primero de profundidad
        del árbol.
        @param g El grafo a realizar la busqueda.
        @param stsart El vertice de inicio.
        @return El arreglo de padres.*/
    
    public static int[] bfs(Graph g, int start){
        Queue<Integer>theQueue = new LinkedList<Integer>();
        //Declara el arrego padre y se inizialican sus elementos en -1.
        int[]parent = new int[g.getNumV()];
        for (int i = 0; i < g.getNumV(); i++) {
            parent[i]= -1;
        }
        //Declara el arreglo identificado y se inicializan los elementos a falso;
        boolean[]identified = new boolean[g.getNumV()];
        /* Marca el vertice de inicio como identificado y lo inserta en la cola.(queue)*/
        identified[start] = true;
        theQueue.offer(start);
        /*Mientras que la cola(queue) no esté vacia*/
        while(!theQueue.isEmpty()){
            /*Toma el vertice, "@actual", afuera de la cola.(Comienza visitando al "@actual").*/
            int current = theQueue.remove();
            /*Examina cada vertice,vecino, adyacente hasta el "@actual"*/
            Iterator<Edge> itr = g.edgeIterator(current);
                while(itr.hasNext()){
                    Edge edge = itr.next();
                    int neighbor = edge.getDest();
                    //Sí el vecino no es identificado.
                    if(!identified[neighbor]){
                        //Marcar como identificado.
                        identified[neighbor] = true;
                        //Añadirlo a la cola(queue).
                        theQueue.offer(neighbor);
                        /*Inserta el Arista (actual,vecino en el árbol)*/
                        parent[neighbor] = current;
                    }
                }
            //Fin visitando al actual.    
        }
        return parent;
    }
    
}
