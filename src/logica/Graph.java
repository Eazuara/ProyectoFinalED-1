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
 */
public interface Graph {
        //Métodos de acceso
    /**
    * Devuelve el número de vértices
    * @return La cantidad de vértices
    */
    int getNumV();
    /**
    * Determina si es un grafo dirigido
    * @return verdadero si este es un grafo dirigido
    */
    boolean isDirected();
    /**
     * Determina si una arista existe
     * @param edge la nueva arista
     */
    void insert(Edge edge);
    /**
     * Obtiene la arista entre dos vértices
     * @param source es el vértice origen
    * @param dest es el vértince destino
     * @return verdadero si existe una arista desde un origen
    * a un destino dados
     */
    boolean isEdge (int source, int dest);

    /**
     * Obtiene la arista entre dos vértices
     * @param source el vértice origen
     * @param dest el vértice destino
     * @return La arista entre los dos vétices
     */
    Edge getEdge(int source, int dest);
    /**
    * Devuelve un iterador de aristas conectadas a un vértice dado
    * @param source el origen del vértice
    * @return Un iterador<Edge> a los vértices conectados al origen.
    */
    Iterator<Edge> edgeIterator(int source);
}
