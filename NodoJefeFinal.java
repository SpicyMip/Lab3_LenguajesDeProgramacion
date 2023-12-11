import java.util.Scanner;
public class NodoJefeFinal extends Nodo{
    private Personaje jefe;
/*
* Constructor de la clase nodo jefe final que se extiende de la clase nodo, estre crea un jefe final con estadisticas mas elevadas que un enemigo comun
* Integer id: Recibe el id del nodo
*/
    public NodoJefeFinal(Integer id){
        super(id);
        tipo="Nodo Jefe Final";
        String[] nombres={"Ornstein el caza dragones", "Caballero Artorias","Rey sin nombre","Caballero esclavo Gael", "Gwyn Señor de la ceniza"};
        Integer x=(int)(Math.random()*5);
        Integer hp_total=18+(int)(Math.random()*8);
        Integer danio=5+(int)(Math.random()*4);
        Integer defensa=1+(int)(Math.random()*3);
        jefe=new Personaje(nombres[x], hp_total, danio, defensa,0);
    }
/*
* Realiza el combate del protagonista contra el jefe
* Jugador jugador: Recibe a quien peleara contra el jefe final
* Scanner input: Recibe el input, el cual en esta funcion no hace nada, pero se necesita por extenderse del metodo abstracto
*/
    @Override
    public void interactuar(Jugador jugador, Scanner input) {
        System.out.println("=======================================");
        System.out.println("Te haz encontrado con "+jefe.getNombre()+" sus estadisticas son:\n Vida total: "+jefe.getHp_total()+"\n Daño: "+jefe.getDanio()+"\n Defensa: "+jefe.getDefensa());
        Integer moneda= (int)(Math.random()*100);
        if(moneda>=50){
            jugador.combate(jefe);
        }else{
            jefe.combate(jugador);
        }
        System.out.println("=======================================");
    }
}