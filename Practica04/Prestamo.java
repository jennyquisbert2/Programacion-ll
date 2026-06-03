
public class Prestamo {
	private String fechaPrestamo;
    private String fechaDevolucion;
    private Estudiante estudiante; // Referencia (Asociación)
    private Libro libro;           // Referencia (Asociación)

    public Prestamo(Estudiante estudiante, Libro libro, String fechaP, String fechaD) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaP;
        this.fechaDevolucion = fechaD;
    }

    public void mostrarInfo() {
        System.out.println("Préstamo: " + libro.getTitulo() + " a " + estudiante.getNombre());
        System.out.println("Fecha: " + fechaPrestamo + " | Devolución: " + fechaDevolucion);
    }

}
