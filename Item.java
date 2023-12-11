public class Item {
    private Integer precio;
    private Integer recuperar_hp;
    private Integer aumentar_hp_total;
    private Integer aumentar_danio;
    private Integer aumentar_defensa;
    /*
    * Constructor de la clase, que genera un item con sus stats al azar
    */
    public Item(){
        precio=50 + (int)(Math.random()*201);
        recuperar_hp=(int)(Math.random()*20);
        aumentar_hp_total=(int)(Math.random()*6);
        aumentar_danio=(int)(Math.random()*5);
        aumentar_defensa=(int)(Math.random()*3);
    }
    /*
    * Segundo constructor de la clase, que llama al primero y setea el precio con el valor dado
    * Integer precioh: Recibe el precio del item para setearlo
    */
    public Item(Integer precioh){
        this();
        precio=precioh;
    }
    /*
    * Retorna el precio
    * Integer precio: Retorna el precio del item
    */
    public Integer getPrecio(){
        return precio;
    }
    /*
    * Retorna la vida que puede recuperar el item
    * Integer recuperar_hp: Retorna la vida que puede recuperar el item
    */
    public Integer getRecuperar_hp(){
        return recuperar_hp;
    }
    /*
    * Retorna la vida que puede aumentar el item
    * Integer aumentar_hp_total: Retorna la vida que puede aumentar el item
    */
    public Integer getAumentar_hp(){
        return aumentar_hp_total;
    }
    /*
    * Retorna el daño que aumenta el item
    * Integer aumentar_danio: Retorna el daño que aumenta el item
    */
    public Integer getAumentar_danio(){
        return aumentar_danio;
    }
    /*
    * Retorna la defensa que aumenta el item
    * Integer aumentar_defensa: Retorna la defensa que aumenta el item
    */
    public Integer getAumentar_defensa(){
        return aumentar_defensa;
    }
    /*
    * Aplica el item al jugador seteando los valores como: los antiguos+los aumentos
    * Jugador jugador: Recive como parametro a jugador, quien es a quien se le aplicara el item
    */
    public void aplicar(Jugador jugador){
        jugador.setDinero(jugador.getDinero()-precio);
        jugador.setHp_total(jugador.getHp_total()+aumentar_hp_total);
        jugador.setHp_actual(jugador.getHp_actual()+aumentar_hp_total);
        if(jugador.getHp_actual()+recuperar_hp>=jugador.getHp_total()){
            jugador.setHp_actual(jugador.getHp_total());
        }else if(jugador.getHp_actual()+recuperar_hp<jugador.getHp_total()){
            jugador.setHp_actual(jugador.getHp_actual()+recuperar_hp);
        }
        jugador.setDanio(jugador.getDanio()+aumentar_danio);
        jugador.setDefensa(jugador.getDefensa()+aumentar_defensa);
    }
}
