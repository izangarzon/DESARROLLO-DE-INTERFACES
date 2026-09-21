import java.util.*;

public class Partida {


    //Atributes
    private int maxHabitaciones;
    private int habitacionActual;
    private int busquedas;
    private int zombiesActivos;
    private Superviviente superviviente;
    private Scanner teclado;
    private Random random;

    //Constructor
    public Partida() {
        this.habitacionActual = 1;
        this.busquedas = 3;
        this.zombiesActivos = 1;
        this.superviviente = new Superviviente();
        this.teclado = new Scanner(System.in);
        this.random = new Random();
    }

    //Menu para decidir la dificultad
    public void elegirDificultad() {

        int opcion;

        do {
            System.out.println("--------------------------");
            System.out.println("------MANSION ZOMBIE------");
            System.out.println("--------------------------");
            System.out.println("Elige la dificultad");
            System.out.println("1. Facil - 5 habitaciones");
            System.out.println("2. Dificil - 10 habitaciones");

            opcion = teclado.nextInt();

            if (opcion != 1 && opcion != 2) {
                System.out.println("¡¡Opcion incorrecta!!");
            }

        } while (opcion != 1 && opcion != 2);

        if (opcion == 1) {
            maxHabitaciones = 5;
        } else {
            maxHabitaciones = 10;
        }

    }

    public void mostrarMenu() {
        System.out.println("--------------------------");
        System.out.println("habitacion: " + habitacionActual + "/" + maxHabitaciones);
        System.out.println("vida: " + superviviente.getVidaActual());
        System.out.println("zombies: " + zombiesActivos);
        System.out.println("busquedas: " + busquedas);
        System.out.println("--------------------------");

        if (zombiesActivos > 0) {
            System.out.println("1.Combatir");
        } else if (busquedas > 0) {
            System.out.println("2.Buscar");
        }

        if (habitacionActual < maxHabitaciones && zombiesActivos == 0) {
            System.out.println("3.Avanzar/pasar habitacion");
        }
        if (superviviente.isTieneBotiquin()) {
            System.out.println("4.Curarse");
        }

        System.out.println("--------------------------");

    }

    public void combatir() {
        Zombie zombie = new Zombie(habitacionActual);
        System.out.println("¡Aparece un zombie!");
        System.out.println("Vida del zombie: " + zombie.getVida());
        System.out.println("Vida del zombie: " + zombie.getAtaque());


        while (zombie.estaVivo() && superviviente.estaVivo()) {
            //Ataque superviviente
            int danioJugador = random.nextInt(superviviente.getAtaque()) + 1 + superviviente.getArmas();

            System.out.println("Atacas al zombie");
            System.out.println("Realizas " + danioJugador + " de danio");

            zombie.recibirDanio(danioJugador);
            System.out.println("vida del zombie: " + zombie.getVida());

            if (!zombie.estaVivo()) {
                System.out.println("¡Has matado al zombie!");
                zombiesActivos--;
                break;
            }

            //Ataque zombie
            int danioZombie = random.nextInt(zombie.getAtaque()) + 1 - superviviente.getProtecciones();

            if (danioZombie < 0) {
                danioZombie = 0;
            }

            System.out.println("El zombie ataca");
            System.out.println("Realiza " + danioZombie + " de danio");

            superviviente.recibirDanio(danioZombie);
            System.out.println("vida: " + superviviente.getVidaActual());

        }

    }


    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        Partida prueba = new Partida();
        prueba.elegirDificultad();
        prueba.mostrarMenu();
    }
}
