import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Nodo {
    protected Integer id;
    protected List<Nodo> siguientes_nodos;
    protected String tipo;
    /*
    * Constructor de la clase abstracta nodo
    * Integer idh: Id del nodo
    */
    public Nodo(Integer idh){
        siguientes_nodos=new ArrayList<>();
        id=idh;
    }
    /*
    * Retorna el id del nodo
    * Integer id: Retorna id del nodo
    */
    public Integer getId(){
        return id;
    }
    /*
    * Funcion abstracta interactuar
    * Jugador jugador: jugador que interactuara con el nodo
    * Scanner input: scanner para recibir inputs
    */ 
    public abstract void interactuar(Jugador jugador, Scanner input);
    /*
    * Descripcion de la funcion
    * @param a: Descripcion del parametro a
    * @return c: Descripcion del parametro c
    */
    public void agregarNodo(Nodo nodo) {
        siguientes_nodos.add(nodo);
    }
    /*
    * Retorna la lista de los nodos siguientes
    * List<Nodo> siguientes_nodos: Retorna siguientes_nodos
    */
    public List<Nodo> getSiguientes_nodos(){
        return siguientes_nodos;
    }
    /*
    * Retorna el tipo del nodo
    * String tipo: Retorna tipo del nodo
    */
    public String getTipo(){
        return tipo;
    }
}
