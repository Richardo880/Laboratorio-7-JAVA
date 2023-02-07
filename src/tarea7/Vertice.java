
package tarea7;


public class Vertice {
    String dato; //dato del vertice
    Integer color; //color del vertice
    

    //Constructor del Vertice
    Vertice(String dato){
        this.dato = dato;
        this.color = -1;
    }

    //Metodo toString
    @Override
    public String toString() {
        return this.dato;
    }
}
