
package tarea7;


import java.util.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;


public class ejer3 {
    //Array de tipo int que guardar las islas ya visitadas para no caer en un ciclo
    static ArrayList<Integer> isla_visitada = new ArrayList<>();
    
    
    //El metodo recorrerIslas tratara de ir a todos los vertices posibles a partir del vertice actual,
    //En cada llamado, va a iterar a traves de todas las aristas salientes de dicho vertice

    public static void recorrerIslas(Integer v, Graph<Integer, DefaultEdge> g) throws Exception{
        //Se comprueba primeramente si no existe un ciclo
        if(isla_visitada.contains(v))
            throw new Exception("Existe un ciclo");//en el caso de que haya un ciclo se lanza una excepcion
        else
            isla_visitada.add(v);//en el caso que no agregamos al array de islas visitadas

        //Se recorre, de forma recursiva, por todas las aristas salientes para saber a que isla ir
        for (DefaultEdge e : g.outgoingEdgesOf(v))
            recorrerIslas(g.getEdgeTarget(e), g);
        
        
        //Si no hay ninguna arista saliente, se imprime la isla en la que puede quedarse atrapado el usuario
        if(g.outgoingEdgesOf(v).size() == 0)
            System.out.print(v+" ");
    
        isla_visitada.clear();//limpiamos el arraylist
    }

    public static void main(String[] args)throws Exception{
        //Creamos el grafo del caso de prueba numero 1
        Graph<Integer, DefaultEdge> grafo1 = new SimpleDirectedGraph<>(DefaultEdge.class);

        //Variables que usaremos para el caso del ejemplo del PDF
        int k;
        int cantidadIslas = 5;
        int cantidadPuentes = 4;
        int islaInicial = 1;
        
        
        //Agregamos los vertices( o las islas) al grafo
        for(k = 0; k < cantidadIslas; k++){
            grafo1.addVertex(k);
        }
        
        //Agregamos las aristas al grafo (o puentes)
        
        grafo1.addEdge(1, 3, new DefaultEdge());
        grafo1.addEdge(1, 0, new DefaultEdge());
        grafo1.addEdge(1, 4, new DefaultEdge());
        grafo1.addEdge(0, 2, new DefaultEdge());
        
        
        
        //Llamamos al metodo para listar las islas en la que pueda quedar atrapado
        //Pasamos como parametro el numero de nuestra isla inicial y el grafo
        System.out.println("Lista de islas del grafo 1: ");
        recorrerIslas(islaInicial, grafo1);
        
        
        
        System.out.println("\n");
        
        
        
        //Creamos el grafo del caso de prueba numero 2
        Graph<Integer, DefaultEdge> grafo2 = new SimpleDirectedGraph<>(DefaultEdge.class);

        //Variables que usaremos para el caso del ejemplo del PDF

        cantidadIslas = 10;
        cantidadPuentes = 8;
        islaInicial = 2;
        
        
        //Agregamos los vertices( o las islas) al grafo
        for(k = 0; k < cantidadIslas; k++){
            
            grafo2.addVertex(k);
        }
        
        //Agregamos las aristas al grafo (o puentes)
        
        grafo2.addEdge(1, 3, new DefaultEdge());
        grafo2.addEdge(1, 0, new DefaultEdge());
        grafo2.addEdge(1, 4, new DefaultEdge());
        grafo2.addEdge(0, 2, new DefaultEdge());
        
        grafo2.addEdge(3, 7, new DefaultEdge());
        grafo2.addEdge(1, 8, new DefaultEdge());
        grafo2.addEdge(6, 9, new DefaultEdge());
        grafo2.addEdge(5, 7, new DefaultEdge());
        
        
        //Llamamos al metodo para listar las islas en la que pueda quedar atrapado
        //Pasamos como parametro el numero de nuestra isla inicial y el grafo
        System.out.println("Lista de islas del grafo 2: ");
        recorrerIslas(islaInicial, grafo2);
        
        
        
        System.out.println("\n");
        
        
        //Creamos el grafo del caso de prueba numero 3
        Graph<Integer, DefaultEdge> grafo3 = new SimpleDirectedGraph<>(DefaultEdge.class);

        //Variables que usaremos para el caso del ejemplo del PDF

        cantidadIslas = 7;
        cantidadPuentes = 6;
        islaInicial = 1;
        
        
        //Agregamos los vertices( o las islas) al grafo
        for(k = 0; k < cantidadIslas; k++){
            grafo3.addVertex(k);
        }
        
        //Agregamos las aristas al grafo (o puentes)
        
        grafo3.addEdge(0, 3, new DefaultEdge());
        grafo3.addEdge(1, 3, new DefaultEdge());
        grafo3.addEdge(1, 4, new DefaultEdge());
        grafo3.addEdge(0, 2, new DefaultEdge());
        
        grafo3.addEdge(4, 5, new DefaultEdge());
        grafo3.addEdge(5, 6, new DefaultEdge());
        
        
        //Llamamos al metodo para listar las islas en la que pueda quedar atrapado
        //Pasamos como parametro el numero de nuestra isla inicial y el grafo
        System.out.println("Lista de islas del grafo 3: ");
        recorrerIslas(islaInicial, grafo3);
        System.out.println();
        
    }
    
}
