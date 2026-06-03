import java.util.Scanner;
import java.util.Random;

public class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    
    public void preparaNumero() {
        this.numeroAAdivinar = new Random().nextInt(11); // 0 a 10
    }

    
    public void juega() {
        reiniciaPartida();
        preparaNumero(); 
        
        Scanner sc = new Scanner(System.in);
        boolean acertado = false;
        System.out.println("\n--- Nuevo Juego: Adivina el número ---");

        while (!acertado) {
            System.out.print("Introduce un número (0-10): ");
            int intento = sc.nextInt();

            if (validaNumero(intento)) {
                if (intento == numeroAAdivinar) {
                    System.out.println("¡¡Acertaste!!");
                    actualizaRecord();
                    acertado = true;
                } else if (!quitaVida()) {
                    System.out.println("Perdiste. El número era: " + numeroAAdivinar);
                    break;
                } else {
                    String pista = (intento < numeroAAdivinar) ? "MAYOR" : "MENOR";
                    System.out.println("Pista: El número es " + pista + ". Vidas: " + numeroDeVidas);
                }
            }
 
            if (intento == numeroAAdivinar) {
                System.out.println("¡¡Acertaste!!");
                actualizaRecord();
                acertado = true;
            } else {
                if (this instanceof JuegoAdivinaPar) {
                    ((JuegoAdivinaPar) this).eliminarDeDisponibles(intento);
                } else if (this instanceof JuegoAdivinaImpar) {
                    ((JuegoAdivinaImpar) this).eliminarDeDisponibles(intento);
                }

                if (!quitaVida()) {
                    System.out.println("Perdiste. El número era: " + numeroAAdivinar);
                    break;
                }
            }
        }
    }

    public boolean validaNumero(int n) {
        return (n >= 0 && n <= 10);
    }

	@Override
	public void mostrarReglas() {
		System.out.println("REGLAS:");
        System.out.println("1. Adivina el número secreto entre 0-10.");
        System.out.println("2. Abra una pista si el numero es MAYOR o MENOR.");
		
	}
}