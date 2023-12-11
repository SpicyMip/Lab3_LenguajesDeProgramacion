import GraphGenerator.GraphGenerator;
import GraphGenerator.Edge;
import java.util.SortedSet;
import java.util.List;
import java.util.Scanner;
public class Mapa {
    private Integer profundidad;
    private NodoInicial nodo_inicial;
    private Nodo nodo_actual;
    private Integer seedMap;
    private Nodo[] listaNodo;
    /*
    * Constructor de la clase mapa, gracias al codigo dado, genera un grafo que se recorre y guarda los datos en un array de nodos
    * ordenados por su id para luego asignar cada nodo siguiente correspondiente
    * Integer n: Recibe la cantidad de pisos que tendra el mapa sin contar el piso inicial, ni final
    */
    public Mapa(Integer n){
        seedMap= (int)(Math.random()*201);
        profundidad=n;
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad,seedMap);
        nodo_inicial=new NodoInicial(0);
        Integer tamanioLista=0;
        for (Edge e : edges) {
            if(tamanioLista<e.x){
                tamanioLista=e.x;
            }
            if(tamanioLista<e.y){
                tamanioLista=e.y;
            }
        }
        listaNodo=new Nodo[tamanioLista+1];
        NodoJefeFinal nodo_final=new NodoJefeFinal(tamanioLista);
        listaNodo[tamanioLista]=nodo_final;
        for (Edge e : edges) {
            if(e.x==0){
                listaNodo[0]=nodo_inicial;
            }
            Integer azar=(int)(Math.random()*100);
            if(listaNodo[e.x]==null){
                if(azar<10){
                    listaNodo[e.x]=new NodoTienda(e.x);
                }else if(azar>=10 && azar<69){
                    listaNodo[e.x]=new NodoCombate(e.x);
                }else{
                    listaNodo[e.x]=new NodoEvento(e.x);
                }
            }
            if(listaNodo[e.y]==null){
                if(azar<10){
                    listaNodo[e.y]=new NodoTienda(e.y);
                }else if(azar>=10 && azar<69){
                    listaNodo[e.y]=new NodoCombate(e.y);
                }else{
                    listaNodo[e.y]=new NodoEvento(e.y);
                }
            }
            listaNodo[e.x].agregarNodo(listaNodo[e.y]);
        }
        nodo_actual=nodo_inicial;
    }
    /*
    * Recorre el array de nodos e imprime los nodos siguientes de cada uno junto a su tipo, ademas te dice en que nodo te encuentras actualmente
    */
    public void verMapa(){
        for(int i=0; i<listaNodo.length-1;i++){
            System.out.println("=======================================");
            if(i==nodo_actual.getId()){
                System.out.println("Tu estas aqui: ");
            }
            System.out.println("Desde nodo "+listaNodo[i].getId()+" tipo "+listaNodo[i].getTipo()+", puedes ir a: ");
            for(int j=0; j<listaNodo[i].getSiguientes_nodos().size();j++){
                System.out.print("Nodo "+listaNodo[i].getSiguientes_nodos().get(j).getId()+" de tipo "+listaNodo[i].getSiguientes_nodos().get(j).getTipo()+"; ");
            }
            System.out.println("");

        }
    }
    /*
    * Imprime por pantalla los nodos siguientes a los cuales se puede ir desde el nodo actual, le pide por consola al jugador
    * que ingrese al nodo que quiere ir y el nodo actual se reemplaza por el nodo elegido por el usuario
    * Scanner input: Recibe el objeto scanner para poder ingresar bien los inputs del usuario
    */
    public void avanzar(Scanner input){
        List<Nodo> nodosSiguientes=nodo_actual.getSiguientes_nodos();
        System.out.println("Nodos disponibles: ");
        for (int i=0; i<nodosSiguientes.size(); i++){
            System.out.println((i+1)+") Nodo "+nodosSiguientes.get(i).getId()+" tipo "+nodosSiguientes.get(i).getTipo());
        }
        System.out.println("Ingrese el nodo al cual quiere ir");
        int opcion=input.nextInt();
        nodo_actual=nodosSiguientes.get(opcion-1);

    }
    /*
    * Retorna el nodo actual
    * Nodo nodo_actual: Retorna el nodo actual
    */
    public Nodo getNodoActual(){
        return nodo_actual;
    }
}
