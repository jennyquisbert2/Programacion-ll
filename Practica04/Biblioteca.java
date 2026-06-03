import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	 private String nombre;
	    private List<Libro> libros = new ArrayList<>();
	    private List<Autor> autores = new ArrayList<>();
	    private List<Prestamo> prestamos = new ArrayList<>();
	    private Horario horario; // Composición
	    
	    public class Horario {
	        private String dias;
	        private String apertura;
	        private String cierre;

	        public Horario(String dias, String apertura, String cierre) {
	            this.dias = dias;
	            this.apertura = apertura;
	            this.cierre = cierre;
	        }

	        public void mostrarHorario() {
	            System.out.println("Horario: " + dias + " de " + apertura + " a " + cierre);
	        }
	    }

	    public Biblioteca(String nombre, String dias, String ap, String cier) {
	        this.nombre = nombre;
	        this.horario = new Horario(dias, ap, cier);
	    }

	    public void agregarLibro(Libro l) { libros.add(l); }
	    public void agregarAutor(Autor a) { autores.add(a); }

	    public void prestarLibro(Estudiante e, Libro l, String fP, String fD) {
	        prestamos.add(new Prestamo(e, l, fP, fD));
	    }

	    public void mostrarEstado() {
	        System.out.println("\n--- BIBLIOTECA " + nombre + " ---");
	        horario.mostrarHorario();
	        System.out.println("Libros: " + libros.size() + " | Préstamos: " + prestamos.size());
	    }

	    public void cerrarBiblioteca() {
	        System.out.println("Cerrando...");
	        prestamos.clear(); // Los préstamos dependen de la biblioteca abierta
	    }


}
