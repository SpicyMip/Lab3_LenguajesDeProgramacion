import java.util.Scanner;
public class NodoEvento extends Nodo {
    private String descripcion;
    private String alternativa1;
    private String alternativa2;
    private Item resultado1;
    private Item resultado2;
/*
* Constructor del nodo evento que se extiende de la super clase nodo, el nodo evento tiene
* los arrays de los cuales se elige una de las opciones al azar y se inicializa un item aleatorio con precio de 0
* Integer id: Recibe id del nodo
*/
    public NodoEvento(Integer id){
        super(id);
        tipo="Nodo Evento";
        Integer moneda=(int)(Math.random()*2);
        String[] descripciones ={
            "Luego de recorrer un arduo camino, llegas a un pasillo, ¿hacia que lado vas?",
            "Mientras caminabas encontraste un extraño emblema",
            "Encontraste una llave",
            "Un no muerto atacara a un anciano y a un gato, a quien salvas"
        };
        String[] alternativas1 ={
            "Vas a la izquierda",
            "Se lo das a un mercader",
            "Abres el cofre de la derecha",
            "Al anciano"
        };
        String[] alternativas2 ={
            "Vas a la derecha",
            "Se lo das al extraño caballero",
            "Abres el cofre de la izquierda",
            "Al gato"
        };

        descripcion=descripciones[moneda];
        alternativa1=alternativas1[moneda];
        alternativa2=alternativas2[moneda];
        resultado1=new Item(0);
        resultado2= new Item(0);
    }
/*
* Le da al jugador las opciones para elegir, dependiendo de que eliga sera la recompensa que obtendra
* Jugador jugador: Recibe al jugador el cual tendra que elegir y se le aplicara la recompensa
* Scanner input: Recibe el scanner para recibir los inputs del jugador
*/
    @Override
    public void interactuar(Jugador jugador, Scanner input) {
        System.out.println(descripcion);
        System.out.println("1) "+alternativa1);
        System.out.println("2) "+alternativa2);
        System.out.println("Seleccione una opcion: ");
        int inputh=input.nextInt();
        String opcion;
        if (inputh==1){
            System.out.println("Te haz encontrado el siguiente item: ");
            System.out.println("Recuperar HP: "+resultado1.getRecuperar_hp());
            System.out.println("Aumentar HP: "+resultado1.getAumentar_hp());
            System.out.println("Aumentar daño: "+resultado1.getAumentar_danio());
            System.out.println("Aumentar defensa: "+resultado1.getAumentar_defensa());
            System.out.println("¿Quieres aplicarlo? (y/n)");
            opcion=input.next();
            if(opcion.equals("y")||opcion.equals("Y")){
                jugador.aplicarItem(resultado1);
                System.out.println("Sus nuevas estadisticas son: ");
                jugador.verEstado();
            }

        }else if(inputh==2){
            System.out.println("Te haz encontrado el siguiente item: ");
            System.out.println("Recuperar HP: "+resultado2.getRecuperar_hp());
            System.out.println("Aumentar HP: "+resultado2.getAumentar_hp());
            System.out.println("Aumentar daño: "+resultado2.getAumentar_danio());
            System.out.println("Aumentar defensa: "+resultado2.getAumentar_defensa());
            System.out.println("¿Quieres aplicarlo? (y/n)");
            opcion=input.next();
            if(opcion.equals("y")||opcion.equals("Y")){
                jugador.aplicarItem(resultado1);
                System.out.println("Sus nuevas estadisticas son: ");
                jugador.verEstado();
            }
            
        }
    }
}
