
package tarea7;


import java.util.ArrayList;
import java.util.Arrays;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class ejer4 {
    
    //Funcion que comprueba si el grafo es bipartito
    //Recibe como parametros el grafo y el vertice por el que v1 empieza
    public static void verificarbipartito(Vertice vertice, Graph<Vertice, DefaultEdge> grafo){
        int cantidadColores = Colorear.colorearGrafo(vertice, grafo); //obtenemos la cantidad de colores llamando a la funcion
        //de colorear el grafo
        
        int banderaBipartitoCompleto = 1; //Variable tipo bandera que verifica si el grafo es bipartito completo
        //por defecto la dejamos en 1, o verdadero.
        
        //Si el grafo tiene mas de 2 colores, no es bipartito e imprimimos el mensaje de indicacion
        if(cantidadColores > 2)
            System.out.println("No es bipartito");
        else{//caso contrario es bipartito, solo nos falta comprobar si es bipartito normal
            //o bipartito completo, ademas de mostrar en pantalla los elementos de v1 y v2
            //que iremos agregando a los 2 arraylist de abajo
            
            //Creamos 2 arraylist con los subconjuntos de vertices
            ArrayList<Vertice> v1 = new ArrayList<>();
            ArrayList<Vertice> v2 = new ArrayList<>();

            //Se recorre sobre todos los vertices y se agrega dicho vertice al conjunto v1 o v2
            for (Vertice x : grafo.vertexSet()) {
                if(x.color == 0)
                    v1.add(x);//si el color es 0 agregamos al conjunto v1
                else
                    v2.add(x);//caso contrario al conjunto v2
            }
            
            //Para saber si el grafo es bipartito completo, se recorren v1 y v2, y si cada vertice tiene la misma cantidad de
            //aristas que elementos del otro subconjunto, entonces el grafo es bipartito completo
            for (Vertice x : v1) {
                //Si se encuentra una diferencia de valores, el grafo ya no puede ser Bipartito Completo
                if(grafo.edgesOf(x).size() != v2.size()){
                    banderaBipartitoCompleto = 0;//no es bipartito completo, por lo que ponemos en 0
                    break;
                }
            }
            //Si en v1 no se verifico que sea bipartito completo, entonces se repite el proceso en v2
            if(banderaBipartitoCompleto == 1){
                for (Vertice x : v2) {
                    //Si se encuentra una diferencia de valores, el grafo ya no puede ser Bipartito Completo
                    if(grafo.edgesOf(x).size() != v1.size()){
                        banderaBipartitoCompleto = 0;//no es bipartito completo, por lo que ponemos en 0
                        break;
                    }
                } 
            }

            //Verificamos como quedo nuestra variable bandera, e imprimimos
            if(banderaBipartitoCompleto == 1)
                System.out.println("Es bipartito completo");
            else
                System.out.println("Es bipartito");
            
            
            //Imprimimos los datos correspondientes de V1 y V2 
            System.out.println("Los elementos de V1 son: "+v1);
            System.out.println("Los elementos de V2 son: "+v2);
            
            //vaciamos los arraylist para posterior uso
            v1.clear();
            v2.clear();
        }
    }


    public static void main(String[] args) {
        //Variables de tipo "Vertice"      
        Vertice v1, v2, v3 ,v4, v5, v6;

        //Primer caso de prueba
        //creamos el grafo
        Graph<Vertice, DefaultEdge> grafo1 = new DefaultUndirectedGraph<>(DefaultEdge.class);

        //Damos valores a las variables de tipo vertice, solo pasandole como parametro su dato, en el constructor le asignara un color -1 por defecto
        v1 = new Vertice("a");
        v2 = new Vertice("b");
        v3 = new Vertice("c");
        v4 = new Vertice("d");
        v5 = new Vertice("e");
        v6 = new Vertice("f");

        //Agregamos los vertices al grafo
        grafo1.addVertex(v1);
        grafo1.addVertex(v2);
        grafo1.addVertex(v3);
        grafo1.addVertex(v4);
        grafo1.addVertex(v5);
        grafo1.addVertex(v6);

        //Agregamos las aristas al grafo
        grafo1.addEdge(v1, v2, new DefaultEdge());
        grafo1.addEdge(v2, v3, new DefaultEdge());
        grafo1.addEdge(v3, v5, new DefaultEdge());
        grafo1.addEdge(v5, v4, new DefaultEdge());
        grafo1.addEdge(v5, v6, new DefaultEdge());

        //Imprimimos los vertices del grafo, y las aristas correspondientes a este
        System.out.println("Vertices del Grafo 1: {"+grafo1.vertexSet()+ "}");
        System.out.println("Aristas del Grafo 1: {"+grafo1.edgeSet()+ "}");
        
        
        //verificamos si el grafo es verificarbipartito en la funcion, pasandole como parametro el primer vertice y el grafo
        System.out.print("El Grafo 1 : ");
        verificarbipartito(v1, grafo1);

        
        System.out.println();
        System.out.println();
        
        
        
        
        
        
        
        
        
        //Segundo caso de prueba
        //Creamos el grafo
        Graph<Vertice, DefaultEdge> grafo2 = new DefaultUndirectedGraph<>(DefaultEdge.class);
        
        //Damos valores a las variables de tipo vertice, solo pasandole como parametro su dato, en el constructor le asignara un color -1 por defecto
        v1 = new Vertice("a");
        v2 = new Vertice("b");
        v3 = new Vertice("c");
        v4 = new Vertice("d");
        v5 = new Vertice("e");
        v6 = new Vertice("f");
        
        //Agregamos los vertices al grafo
        grafo2.addVertex(v1);
        grafo2.addVertex(v2);
        grafo2.addVertex(v3);
        grafo2.addVertex(v4);
        grafo2.addVertex(v5);
        grafo2.addVertex(v6);
        
        //Agregamos las aristas al grafo
        grafo2.addEdge(v1, v5, new DefaultEdge());
        grafo2.addEdge(v1, v6, new DefaultEdge());
        grafo2.addEdge(v2, v5, new DefaultEdge());
        grafo2.addEdge(v2, v6, new DefaultEdge());
        grafo2.addEdge(v3, v5, new DefaultEdge());
        grafo2.addEdge(v3, v6, new DefaultEdge());
        grafo2.addEdge(v4, v5, new DefaultEdge());
        grafo2.addEdge(v6, v5, new DefaultEdge());
        grafo2.addEdge(v4, v6, new DefaultEdge());        

        //Imprimimos los vertices del grafo, y las aristas correspondientes a este
        System.out.println("Vertices del Grafo 2: {"+grafo2.vertexSet()+ "}");
        System.out.println("Aristas del Grafo 2: {"+grafo2.edgeSet()+ "}");
        
        //verificamos si el grafo es verificarbipartito en la funcion, pasandole como parametro el primer vertice y el grafo
        System.out.print("El Grafo 2 : ");
        verificarbipartito(v1, grafo2);
        
        System.out.println();
        System.out.println();
        
        
        
        
        
        
        
        
        
        
        
        //Tercer caso de prueba
        //Creamos el grafo
        Graph<Vertice, DefaultEdge> grafo3 = new DefaultUndirectedGraph<>(DefaultEdge.class);

        //Damos valores a las variables de tipo vertice, solo pasandole como parametro su dato, en el constructor le asignara un color -1 por defecto
        v1 = new Vertice("a");
        v2 = new Vertice("b");
        v3 = new Vertice("c");
        v4 = new Vertice("d");
        v5 = new Vertice("e");
        v6 = new Vertice("f");
        
        
        //Agregamos los vertices al grafo
        grafo3.addVertex(v1);
        grafo3.addVertex(v2);
        grafo3.addVertex(v3);
        grafo3.addVertex(v4);
        grafo3.addVertex(v5);
        grafo3.addVertex(v6);
        
        //Agregamos las aristas al grafo
        grafo3.addEdge(v1, v5, new DefaultEdge());//1 5
        grafo3.addEdge(v1, v6, new DefaultEdge());//1 6
        grafo3.addEdge(v2, v5, new DefaultEdge());//2 5
        grafo3.addEdge(v2, v6, new DefaultEdge());//2 6
        
        grafo3.addEdge(v3, v5, new DefaultEdge());//3 5
        grafo3.addEdge(v3, v6, new DefaultEdge());//3 6
        grafo3.addEdge(v4, v5, new DefaultEdge());//4 5
        grafo3.addEdge(v4, v6, new DefaultEdge());//4 6 
        

        //Imprimimos los vertices del grafo, y las aristas correspondientes a este
        System.out.println("Vertices del Grafo 3: {"+grafo3.vertexSet()+ "}");
        System.out.println("Aristas del Grafo 3: {"+grafo3.edgeSet()+ "}");
        
        //verificamos si el grafo es verificarbipartito en la funcion, pasandole como parametro el primer vertice y el grafo
        System.out.print("El Grafo 3 : ");
        verificarbipartito(v1, grafo3);
        
        System.out.println();
        System.out.println();
        
        
    }
    
}
