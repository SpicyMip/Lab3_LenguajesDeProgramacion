public class Personaje {
    protected String nombre;
    protected Integer dinero;
    protected Integer hp_total;
    protected Integer hp_actual;
    protected Integer danio;
    protected Integer defensa;
/*
* Constructor de la clase personaje
* String name: Recibe el nombre que tendra el personaje
*/
    public Personaje(String name){
        nombre=name;
        dinero=500;
        hp_total=20;
        hp_actual=hp_total;
        danio=5;
        defensa=1;
    }
/*
* Segundo constructor de la clase personaje
* String name: Recibe el nombre del Personaje
* Integer hp_totalH: Recibe el hp total del Personaje
* Integer danioH: Recibe el danio que tendra el personaje
* Integer defensaH: Recibe la defensa que tendra el personaje
* Integer dineroH: Recibe el dinero que tendra el personaje
*/
    public Personaje(String name, Integer hp_totalH, Integer danioH, Integer defensaH, Integer dineroH){
        nombre=name;
        hp_total=hp_totalH;
        hp_actual=hp_total;
        danio=danioH;
        defensa=defensaH;
        dinero=dineroH;
    }
/*
* Retorna el nombre del personaje
* String nombre: Retorna el nombre del personaje
*/
    public String getNombre(){
        return nombre;
    }
/*
* Retorna el dinero del personaje
* Integer dinero: Retorna el dinero del personaje
*/
    public Integer getDinero(){
        return dinero;
    }
/*
* Setea el dinero del personaje
* Integer money: Recibe el dinero que se va a setear
*/
    public void setDinero(Integer money){
        dinero=money;
    }
/*
* Retorna el hp total del personaje
* Integer hp_total: Retorna el hp total del personaje
*/
    public Integer getHp_total(){
        return hp_total;
    }
/*
* Setea el hp total del personaje
* Integer vida: Recibe el hp total que se va a setear
*/
    public void setHp_total(Integer vida){
        hp_total=vida;
    }
/*
* Retorna el hp actual del personaje
* Integer hp_actual: Retorna el hp actual del personaje
*/
    public Integer getHp_actual(){
        return hp_actual;
    }
/*
* Setea la vida actual del personaje
* Integer vida: Recibe la vida actual que se va a setear
*/
    public void setHp_actual(Integer vida){
        hp_actual=vida;
    }
/*
* Retorna el danio del personaje
* Integer danio: Retorna el danio del personaje
*/
    public Integer getDanio(){
        return danio;
    }
/*
* Setea el danio del personaje
* Integer danioH: Recibe el danio que se va a setear
*/
    public void setDanio(Integer danioH){
        danio=danioH;
    }
/*
* Retorna la defensa del personaje
* Integer defensa: Retorna la defensa del personaje
*/
    public Integer getDefensa(){
        return defensa;
    }
/*
* Setea la defensa del personaje
* Integer defensaH: Recibe la defensa que se va a setear
*/
    public void setDefensa(Integer defensaH){
        defensa=defensaH;
    }
/*
* El combate se realiza mientras la vida del protagonista o del personaje que se pase como parametro llegue a 0
* Jugador jugador: Recibe el personaje contra el cual se realiza el combate
*/
    public void combate(Personaje personaje){
        while(hp_actual>0 && personaje.getHp_actual()>0){
            personaje.setHp_actual(personaje.getHp_actual()-(danio-personaje.getDefensa()));
            if(personaje.getHp_actual()<0){
                personaje.setHp_actual(0);
                System.out.println(nombre+" ha atacado, la vida actual de "+personaje.getNombre()+" es: "+personaje.getHp_actual());
            }else{
                System.out.println(nombre+" ha atacado, la vida actual de "+personaje.getNombre()+" es: "+personaje.getHp_actual());
                hp_actual=hp_actual-(personaje.getDanio()-defensa);
                if(hp_actual<0){
                    hp_actual=0;
                }
                System.out.println(personaje.getNombre()+" ha atacado, la vida actual de "+nombre+" es: "+hp_actual);
            }
            
        }
    }
}
