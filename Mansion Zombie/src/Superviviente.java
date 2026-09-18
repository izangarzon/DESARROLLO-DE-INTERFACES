public class Superviviente {

    //Attributes
    private int vidaMaxima;
    private int vidaActual;
    private int ataque;
    private boolean tieneBotiquin;
    private int armas;
    private int protecciones;

    //Constructor
    public Superviviente() {
        this.vidaMaxima = 20;
        this.vidaActual = vidaMaxima;
        this.ataque = 4;
        this.tieneBotiquin = false;
        this.armas = 0;
        this.protecciones = 0;
    }

    //Recibes Daño
    public void recibirDanio(int danio) {
        vidaActual = vidaActual - danio;
        if (vidaActual < 0) {
            vidaActual = 0;
        }
    }

    //Curacion
    public void curarse(){
        vidaActual=vidaActual+4;
        if (vidaActual>vidaMaxima){
            vidaActual=vidaMaxima;
        }
    }

    //Getters
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getAtaque() {
        return ataque;
    }

    public boolean isTieneBotiquin() {
        return tieneBotiquin;
    }

    public int getArmas() {
        return armas;
    }

    public int getProtecciones() {
        return protecciones;
    }


    //Setters
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setTieneBotiquin(boolean tieneBotiquin) {
        this.tieneBotiquin = tieneBotiquin;
    }

    public void setArmas(int armas) {
        this.armas = armas;
    }

    public void setProtecciones(int protecciones) {
        this.protecciones = protecciones;
    }
}
