import java.util.ArrayList;
import java.util.List;

public class Libro {
	private String titulo;
	private String isbn;
	private List<Pagina> paginas = new ArrayList<>();

	// RELACIÓN DE COMPOSICIÓN: Clase interna Página
	public class Pagina {
		private int numero;
		private String contenido;

		public Pagina(int numero, String contenido) {
			this.numero = numero;
			this.contenido = contenido;
		}

		public void mostrarPagina() { // Corregido según lógica de página
			System.out.println("Página " + numero + ": " + contenido);
		}
	}

	public Libro(String titulo, String isbn, String[] contenidos) {
		this.titulo = titulo;
		this.isbn = isbn;
		for (int i = 0; i < contenidos.length; i++) {
			this.paginas.add(new Pagina(i + 1, contenidos[i]));
		}
	}

	public void leer() {
		System.out.println("Libro: " + titulo + " (ISBN: " + isbn + ")");
		for (Pagina p : paginas)
			p.mostrarPagina();
	}
	

	public String getTitulo() {
		return titulo;
	}
	
	public void mostrarLibro() {
		System.out.println("Libro: " + titulo + " (ISBN: " + isbn + ")");
	}

}
