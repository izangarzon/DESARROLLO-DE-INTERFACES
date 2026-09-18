import java.util.*;

public class Zombie {

    //Attributes
    private int vida;
    private int ataque;

    //Constructor
    public Zombie(int habitacion) {
        this.vida = (int) (Math.random() * 2) + 2 + (habitacion - 1);
        this.ataque = (int) (Math.random() * 2) + 2 + (habitacion - 1);
    }

    //Recibe Daño
    public void recibirDanio(int danio) {
        vida = vida - danio;
        if (vida < 0) {
            vida = 0;
        }
    }

    //Getters
    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    //Setters
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
