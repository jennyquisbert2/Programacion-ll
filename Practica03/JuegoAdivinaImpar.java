import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
	 private List<Integer> disponibles;

	    public JuegoAdivinaImpar(int numeroDeVidas) {
	        super(numeroDeVidas);
	    }

	    @Override
	    public void preparaNumero() {
	        super.preparaNumero(); 
	        // disponibles: [1, 3, 5, 7, 9]
	        this.numeroAAdivinar = new Random().nextInt(5) * 2 + 1;
	        disponibles = new ArrayList<>();
	        for (int i = 1; i <= 9; i += 2) {
	            disponibles.add(i);
	        }
	    }

	    @Override
	    public void mostrarReglas() {
	    	System.out.println("REGLAS:");
	        System.out.println("1. Adivina el número IMPAR secreto.");
	        System.out.println("2. Si fallas, ese número se elimina de la lista.");
	        System.out.println("Disponibles iniciales: " + disponibles);
	    }
	    
	    @Override
	    public boolean validaNumero(int n) {
	        if (n >= 0 && n <= 10 && n % 2 != 0) {
	            if (!disponibles.contains(n)) {
	                System.out.println("Ese número ya lo intentaste. Elige otro de la lista: " + disponibles);
	                return false;
	            }
	            return true;
	        }
	        System.out.println("Error: El número debe ser IMPAR entre 1 y 9.");
	        return false;
	    }

	    public void eliminarDeDisponibles(int n) {
	        disponibles.remove(Integer.valueOf(n));
	        System.out.println("Lista actualizada: Disponibles = " + disponibles);
	    }

}