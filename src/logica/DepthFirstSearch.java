/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.*;

/**
 *
 * @author LuisIván
 * "Vamos a brincar hasta la cima"
 * Ana Teresa Ramírez Morones 512873
 * Josue Alexis Ramírez 513622
 * Jose María de la Garza 513097
 * Luis Iván García 1410530
 * 3er Semestre ITIC
 * 
 * Clase para implementar la buqueda del primero en anchura.
 */
public class DepthFirstSearch {
    
    //Atributos de la clase
    private Graph graph;
    /** El arreglo de padres in la busqueda del primero en anchura.*/
    private int[] parent;
    /** Bandera para indicar si el vertice ha sido visitado previamente.*/
    private boolean[] visited;
    /** El arreglo que contiene cada vertice en orden de descubrimiento.*/
    private int[] discoveryOrder;
    /** El arreglo que contiene cada vertice en orden de culminación.*/
    private int[] finishOrder;
    /** El incide que indica el orden de descubrimiento.*/
    private int discoverIndex = 0;
    /** El indice que indica el orden de culminación.*/
    private int finishIndex = 0;

    public DepthFirstSearch(Graph graph, int[] parent, boolean[] visited, int[] discoveryOrder, int[] finishOrder) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < 10; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < 10; i++) {
            if(!visited[i])
                depthFisrtSearch(i);
        }
    }
    
    /** Construye la busqueda del primero en anchura dl grafo
        seleccionando el vertice de inicio en el orden especificado.
        El primer vertice visitado es el order[0].
        @param graph El grafo.
        @param order El arreglo dando el orden en el cual los 
                     vertices de inicio deben ser seleccionados.
    */
    public DepthFirstSearch(Graph graph,int[] order){
        //El mismo constructor, pero sin la comprobación.
         this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < 10; i++) {
            parent[i] = -1;
        }
    }
    /** Recursivamente se realiza la busqueda del primero en anchura del grafo
        iniciando por el vertice "@actual".
        @param current El vertice de inicio.*/ 
    public void depthFisrtSearch(int current){
        /* Marca el vertice "@actual" como visitado. */
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        /* Examina cada vertice adyacente al vertice "@actual".*/
        Iterator<Edge> itr = graph.edgeIterator(current);
        while(itr.hasNext()){
            int neighbor = itr.next().getDest();
            /* Procesa al vecino que no ha sido visitado.*/
            if(!visited[neighbor]){
                /* Inserta (acutal,vecino) en la busqueda del primero en anchura.*/
                parent[neighbor] = current;
                /* Recursivamente aplica el algoritmo comenzando por el vecino.*/
                depthFisrtSearch(neighbor);
            }
        }
        /* Marca del actual finalizada.*/
        finishOrder[finishIndex++] = current;
    }
    
}
