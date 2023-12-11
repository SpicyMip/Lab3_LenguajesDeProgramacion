import java.util.Scanner;
public class NodoInicial extends Nodo {
/*
* Constructor nodo inicial que se exitende de la super clase nodo
* Integer id: Recibe id del nodo
*/
    public NodoInicial(Integer id){
        super(id);
        tipo="Nodo Inicial";
    }
/*
* El metodo interactuar del nodo inicial cuenta el lore del jueguito
* Jugador jugador: Recibe al jugador, del cual se obtiene el nombre
* Scanner input: Recibe el input, el cual en esta funcion no hace nada, pero se necesita por extenderse del metodo abstracto
*/
    @Override
    public void interactuar(Jugador jugador, Scanner input) {
        System.out.println(jugador.getNombre()+" bienvenid@ a JavaQuest");
        System.out.println("En una era distinta del mundo actual");
        System.out.println("existia un mundo lleno de criaturas magicas y peligros,");
        System.out.println(jugador.getNombre()+" tu eres el/la elegid@ para sacar al mundo de la ruina");
        System.out.println("tu aventura comienza ahora.");
    }
}
