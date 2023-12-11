import java.util.ArrayList;
import java.util.List;
public class Jugador extends Personaje {
    private List<Item> items_aplicados;
    /*
    * Constructor de la clase, extendido de la superclase personaje
    * String name: Nombre del jugador
    */
    public Jugador(String name) {
        super(name);
        items_aplicados=new ArrayList<>();
    }
    /*
    * Añade el item a la lista de items aplicados del jugador
    * Item item: Item que se añadira a la lista
    */
    public void aplicarItem(Item item){
        items_aplicados.add(item);
    }
    /*
    * Imprime por pantalla todos los atributos del jugador
    */
    public void verEstado(){
        System.out.println("=======================================");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dinero: " + dinero);
        System.out.println("Hp total: " + hp_total);
        System.out.println("Hp actual: " + hp_actual);
        System.out.println("Daño: " + danio);
        System.out.println("Defensa: " + defensa);
        System.out.println("Cantidad de items aplicados: " + items_aplicados.size());
        System.out.println("=======================================");


    }
    /*
    * Recorre la lista de items aplicados e imprime por pantalla las stats de estos
    */
    public void verItems(){
        for(int i=0; i < items_aplicados.size();i++){
            System.out.println("=====================");
            System.out.println("Item "+(i+1)+" Stats");
            System.out.println("=====================");
            System.out.println("Recuperar HP: "+items_aplicados.get(i).getRecuperar_hp());
            System.out.println("Aumentar HP: "+items_aplicados.get(i).getAumentar_hp());
            System.out.println("Aumentar daño: "+items_aplicados.get(i).getAumentar_danio());
            System.out.println("aumentar defensa: "+items_aplicados.get(i).getAumentar_defensa());
            System.out.println("=====================");
        }
    }
    
}
