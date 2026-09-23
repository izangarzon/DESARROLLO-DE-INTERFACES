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

    //Menu general
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

    //Combate
    public void combatir() {
        Zombie zombie = new Zombie(habitacionActual);
        System.out.println("¡Aparece un zombie!");
        System.out.println("Vida del zombie: " + zombie.getVida());
        System.out.println("Ataque del zombie: " + zombie.getAtaque());


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
            System.out.println("Tu vida: " + superviviente.getVidaActual());

        }

    }

    //Haces Ruido
    public void hacerRuido() {

        int resultado = random.nextInt(100) + 1;

        System.out.println("Tirada por el ruido y sale: " + resultado);

        if (resultado <= 40) {
            System.out.println("No ha pasado nada");

        } else if (resultado <= 80) {
            System.out.println("Ha aparecido un Zombie");
            zombiesActivos++;

        } else {
            System.out.println("Han aparecido dos Zombies");
            zombiesActivos = zombiesActivos + 2;
        }

    }

    //Busqueda
    public void buscar() {
        busquedas--;

        int resultado = random.nextInt(100) + 1;

        System.out.println();
        System.out.println("Buscando...");
        System.out.println("Has sacado " + resultado);

        if (resultado <= 75) {
            System.out.println("¡Has hecho RUIDO!");
            //hacerRuido();

        } else if (resultado <= 90) {

            if (!superviviente.isTieneBotiquin()) {
                superviviente.cogerBotiquin();
                System.out.println("Has encontrado un botiquin");
            } else {
                System.out.println("Has encontrado un botiquin, pero ya tenias uno.");
            }

        } else if (resultado <= 95) {
            superviviente.cogerProteccion();
            System.out.println("Has conseguido una proteccion");
            System.out.println("Tienes: " + superviviente.getProtecciones() + " protecciones");

        } else {
            superviviente.cogerArma();
            System.out.println("Has encontrado un arma");
            System.out.println("Tienes " + superviviente.getArmas() + " armas");

        }

    }

    //Curarse
    public void curarse(){

    }

    //Main Prueba
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        Partida prueba = new Partida();
        prueba.elegirDificultad();
        prueba.mostrarMenu();
        prueba.combatir();
        prueba.buscar();
        prueba.hacerRuido();
    }
}
