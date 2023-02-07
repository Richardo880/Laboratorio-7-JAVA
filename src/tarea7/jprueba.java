/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7;

import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;

/**
 *
 * @author ricar
 */
public class jprueba {

    /**
     * @param args the command line arguments
     */
        public interface Graph<V,E> {
    GraphType getType();
    boolean addVertex(V v);
    boolean removeVertex(V v);
    E addEdge(V sourceVertex, V targetVertex);
    boolean removeEdge(E e);
    Set<V> vertexSet();
    Set<E> edgeSet();
    V getEdgeSource(E e);
    V getEdgeTarget(E e);
    E getEdge(V sourceVertex, V targetVertex);
    double getEdgeWeight(E e);
    void setEdgeWeight(E e, double weight);
    Set<E> edgesOf(V v);
    /* More methods omitted */
}
        
    public static void main(String[] args) {
        // TODO code application logic here
        Graph<Integer, DefaultEdge> graph =
        (Graph<Integer, DefaultEdge>) GraphTypeBuilder.<Integer, DefaultEdge> directed().allowingMultipleEdges(true).allowingSelfLoops(false).edgeClass(DefaultEdge.class).buildGraph();

    }
    


}
