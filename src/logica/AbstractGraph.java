/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author LuisIván
 */
public class AbstractGraph {
    private boolean directed;
    private int numV;

    public AbstractGraph(boolean directed, int numV) {
        this.directed = true;
        this.numV = numV;
    }

    public int getNumV() {
        return numV;
    }
    
    public boolean isDirected(){
        return !directed;
    }
    
    
}
