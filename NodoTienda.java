import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NodoTienda extends Nodo {
    private List<Item> inventario;
/*
* Constructor de la clase nodo tienda, que le añade a su inventario una cantidad al azar de items entre 5 y 8
* Integer idh: Recibe el Id del nodo
*/
    public NodoTienda(Integer idh) {
        super(idh);
        tipo="Nodo Tienda";
        Integer nItems=(int)(5+(Math.random()*3));
        inventario=new ArrayList<>();
        for(int i=0; i<nItems;i++){
            Item item= new Item();
            inventario.add(item);
        }
    }
/*
* Compra el item elegido por el jugador y lo quita del inventario de la clase
* Integer n: Recibe la poscion del item que se quiere comprar
* Jugador jugador: Recibe el jugador a quien se le aplicara el item
*/
    public void comprar(Integer n, Jugador jugador){
        inventario.get(n).aplicar(jugador);
        jugador.aplicarItem(inventario.get(n));
        inventario.remove(inventario.get(n));
    }
/*
* Le muestra todos los stats de los items del inventario y le permite comprar al jugador
* Jugador jugador: Recibe a quien se le aplicaran los items si los compra
* Scanner input: Recibe el scanner para obtener los inputs del usuario
*/
    @Override
    public void interactuar(Jugador jugador, Scanner input) {
        String inputh= "";
        while(!inputh.equals("n") && !inputh.equals("N")){
            for(int i=0; i<inventario.size(); i++){
                System.out.println("=======================================");
                System.out.println("Item "+(i+1)+" Stats");
                System.out.println("=======================================");
                System.out.println("Precio: "+inventario.get(i).getPrecio());
                System.out.println("Recuperar HP: "+inventario.get(i).getRecuperar_hp());
                System.out.println("Aumentar HP: "+inventario.get(i).getAumentar_hp());
                System.out.println("Aumentar daño: "+inventario.get(i).getAumentar_danio());
                System.out.println("Aumentar Defensa: "+inventario.get(i).getAumentar_defensa());
            }
            System.out.println("=======================================");
            System.out.println("Tienes "+jugador.getDinero()+" monedas");
            System.out.println("Desea comprar algun item? (y/n)");
            inputh=input.next();
            if(inputh.equals("y")|| inputh.equals("Y")){
                System.out.println("Que item desea comprar? (Ingrese numero)"); 
                Integer pos=(Integer)input.nextInt();
                if(jugador.getDinero() >= inventario.get(pos-1).getPrecio()){
                    comprar((pos-1), jugador);
                    System.out.println("Sus nuevas estadisticas son: ");
                    jugador.verEstado();
                }else{
                    System.out.println("No tienes suficiente dinero para este item");
                }
            }
        }
    }
}