import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {
    private List<Integer> disponibles;

    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public void preparaNumero() {
        super.preparaNumero(); 
        // disponibles: [0, 2, 4, 6, 8, 10]
        this.numeroAAdivinar = new Random().nextInt(6) * 2;
        disponibles = new ArrayList<>();
        for (int i = 0; i <= 10; i += 2) {
            disponibles.add(i);
        }
    }

    @Override
    public void mostrarReglas() {
        System.out.println("REGLAS:");
        System.out.println("1. Adivina el número PAR secreto.");
        System.out.println("2. Si fallas, ese número se elimina de la lista.");
        System.out.println("Disponibles iniciales: " + disponibles);
    }

    @Override
    public boolean validaNumero(int n) {
        if (n >= 0 && n <= 10 && n % 2 == 0) {
            if (!disponibles.contains(n)) {
                System.out.println("Ese número ya lo intentaste. Elige otro de la lista: " + disponibles);
                return false;
            }
            return true;
        }
        System.out.println("Error: El número debe ser PAR entre 0 y 10.");
        return false;
    }

    public void eliminarDeDisponibles(int n) {
        disponibles.remove(Integer.valueOf(n));
        System.out.println("Lista actualizada: Disponibles = " + disponibles);
    }
}