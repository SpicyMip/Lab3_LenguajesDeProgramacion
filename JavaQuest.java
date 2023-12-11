import java.util.Scanner;
class JavaQuest {
    public static void main(String[] args) throws Exception {
        Scanner inputs = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("Bienvenid@ a JavaQuest");
        System.out.println("Ingrese su username para comenzar: ");
        String name = inputs.next();
        Jugador protagonista = new Jugador(name);
        System.out.println("=======================================");
        System.out.println("Ingrese la cantidad de pisos que quiere que tenga su aventura: ");
        Integer nivelesMapa= inputs.nextInt();
        System.out.println("=======================================");
        Mapa mapa=new Mapa(nivelesMapa);
        Nodo nodo_actual=mapa.getNodoActual();
        nodo_actual.interactuar(protagonista, inputs);
        boolean flagVida=true;
        boolean flagPisos=true;
        Integer pisos=0;
        Integer inputI;
        while(flagVida && flagPisos){
            inputI=0;
            while(inputI!=1){
                System.out.println("=======================================");
                System.out.println("Sus opciones son: \n 1) Avanzar\n 2) Ver Mapa\n 3) Ver estado\n 4) Ver items aplicados");
                inputI=inputs.nextInt();
                if(inputI==1){
                    mapa.avanzar(inputs);
                    nodo_actual=mapa.getNodoActual();
                    System.out.println("=======================================");
                    System.out.println(nodo_actual.getTipo());
                    nodo_actual.interactuar(protagonista, inputs);
                    pisos+=1;
                }else if(inputI==2){
                    mapa.verMapa();
                }else if(inputI==3){
                    protagonista.verEstado();
                }else if(inputI==4){
                    protagonista.verItems();
                }else{
                    System.out.println("Opcion invalida");
                }
            }
            if(protagonista.getHp_actual()<=0){
                flagVida=false; 
            }
            if(nivelesMapa<pisos){
                flagPisos=false;
            }
        }
        System.out.println("=======================================");
        if(flagVida){
            System.out.println("Enhora buena, haz logrado derrotar al jefe final\ny salvado a este mundo de su miseria,\ntu "+protagonista.getNombre()+" seras recordado por siempre en este mundo.");
        }else{
            System.out.println("Game over\nEl mundo ha sido sometido ante el jefe final");
        }
        System.out.println("=======================================");
        inputs.close();

    }
}
