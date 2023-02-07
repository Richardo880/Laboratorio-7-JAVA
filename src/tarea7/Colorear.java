/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7;

import java.util.Arrays;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author ricar
 */
public class Colorear {
     //Funcion que colorea el grafo y devuelve la cantidad de colores usados
    //
    public static int colorearGrafo(Vertice vertice, org.jgrapht.Graph<Vertice, DefaultEdge> grafo){
        int n = grafo.vertexSet().size(); //Cantidad de vertices 
        int cantidadColores = 0; //Cantidad de colores usados
        
        //Se crea un arreglo de booleanos que determina si que color esta disponible. 
        //Asi, disponible[3] = true significa que el color 3 esta disponible
        //(un grafo de n elementos puede tener n colores como maximo)
        boolean[] disponible = new boolean[n];
        //Se llena el arreglo de true, ya que inicialmente todos los colores estan disponibles
        Arrays.fill(disponible, true);

        //Se establece el color del primer vertice en 0
        vertice.color = 0;

        //Se itera sobre todos los vertices del grafo
        for (Vertice x : grafo.vertexSet()) {
            //Se itera sobre todas las aristas de dicho vertice
            for(DefaultEdge e : grafo.edgesOf(x)){
                //Se revisa el color de los vertices adyacentes
                if(grafo.getEdgeSource(e).equals(x)){
                    //Si el vertice adyacente ya esta coloreado, no se puede usar su color
                    if(!grafo.getEdgeTarget(e).color.equals(-1))
                        disponible[grafo.getEdgeTarget(e).color] = false;
                }
                else{
                    if(!grafo.getEdgeSource(e).color.equals(-1))
                        disponible[grafo.getEdgeSource(e).color] = false;
                }
            }

            //Se busca en la lista de disponibilidad el primer color disponible
            for(int i = 0; i < n; i++){
                if(disponible[i]){
                    //Se colorea el grafo
                    x.color = i;
                    //El color mas grande usado es igual v1 la cantidad de colores - 1, por lo que se guarda dicho valor
                    if(i > cantidadColores)
                        cantidadColores = i;
                    break;
                }
            }

            //Se vuelve v1 poner disponibles todos los colores para la siguiente iteracion
            Arrays.fill(disponible, true);
        }

        //Al finalizar la coloracion se devuelve la cantidad de colores
        return cantidadColores + 1;
         
    }
    
}
