import java.util.Scanner;
public class NodoCombate extends Nodo {
    private Personaje enemigo;
/*
* Constructor de nodo combate que se extiende de la superclase nodo, genera a un enemigo aleatorio
* Integer id: Recibe el id del nodo
*/
    public NodoCombate(Integer id){
        super(id);
        tipo="Nodo Combate";
        String[] nombres={"Slime rojo", "Slime azul","No muerto","Lobo gris", "Ogro", "Goblin", "Elfo oscuro", "Mercenario"};
        Integer x=(int)(Math.random()*8);
        Integer hp_total=5+(int)(Math.random()*11);
        Integer danio=1+(int)(Math.random()*2);
        Integer defensa=(int)(Math.random()*3);
        Integer dinero=50+(int)(Math.random()*101);
        enemigo=new Personaje(nombres[x], hp_total, danio, defensa,dinero);
    }
    /*
    * Funcion abstracta interactuar del nodo combate, quien inicia el combate es aleatorio, y si el protagonista resulta victorioso, este gana dinero
    * Jugador jugador: jugador que combatira con el enemigo
    * Scanner input: Recibe el input, el cual en esta funcion no hace nada, pero se necesita por extenderse del metodo abstracto
    */ 
    @Override
    public void interactuar(Jugador jugador, Scanner input) {
        System.out.println("=======================================");
        System.out.println("Te haz encontrado con "+enemigo.getNombre()+" sus estadisticas son:\n Vida total: "+enemigo.getHp_total()+"\n Daño: "+enemigo.getDanio()+"\n Defensa: "+enemigo.getDefensa());
        Integer moneda= (int)(Math.random()*100);
        if(moneda>=50){
            jugador.combate(enemigo);
        }else{
            enemigo.combate(jugador);
        }
        if(jugador.getHp_actual()>0){
            System.out.println(enemigo.getNombre()+" ha soltado "+enemigo.getDinero()+" monedas");
            jugador.setDinero(jugador.getDinero()+enemigo.getDinero());
        }
        System.out.println("=======================================");
    }
}
