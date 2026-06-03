
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Creamos la Biblioteca (se crea automáticamente su Horario por Composición)
        Biblioteca Biblioteca = new Biblioteca("UMSA Central", "Lunes a Viernes", "08:00", "20:00");

        // 2. Creamos Autores (Agregación: existen fuera de la biblioteca)
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        Autor autor2 = new Autor("Miguel de Cervantes", "Español");
        

        // 3. Creamos Libros con sus páginas (Composición: las páginas nacen con el libro)
        String[] paginasQuijote = {
            "En un lugar de la Mancha...", 
            "De los consejos que dio Don Quijote a Sancho Panza."
        };
        Libro libro1 = new Libro("Don Quijote de la Mancha", "978-3-16", paginasQuijote);
        
        String[] paginasSoledad = {
            "Muchos años después, frente al pelotón de fusilamiento...",
            "Macondo era entonces una aldea de veinte casas de barro."
        };
        Libro libro2 = new Libro("Cien Años de Soledad", "84-204-71", paginasSoledad);

        // 4. Registramos los objetos en la biblioteca
        Biblioteca.agregarAutor(autor1);
        Biblioteca.agregarAutor(autor2);
        Biblioteca.agregarLibro(libro1);
        Biblioteca.agregarLibro(libro2);

        // 5. Creamos un Estudiante
        Estudiante alumno = new Estudiante("ID-2024", "Juan Pérez");
        System.out.println("BIBLIOTECA CENTRAL UNIVERSIDAD MAYOR DE SAN ANDRES");
        System.out.println("--------------------------------------------");
        System.out.println("!BIENVENIDO¡ INGRESE SU DATOS PORAFAVOR.....");
        alumno.mostrarInfo();
        System.out.println("INGRESE EL NOMBRE DEL LIBRO QUE REQUIERE...");
        libro1.mostrarLibro();
        System.out.println();

        // 6. Realizamos un Préstamo (Asociación entre Estudiante, Libro y Préstamo)
        System.out.println("--- Iniciando trámites de préstamo ---");
        Prestamo prestamo = new Prestamo(alumno, libro1, "01/10/2023", "15/10/2023");
        Biblioteca.prestarLibro(alumno, libro1, "01/10/2023", "15/10/2023");
        prestamo.mostrarInfo();
        

        // 7. Mostramos el estado actual
        Biblioteca.mostrarEstado();

        // 8. Probamos la lectura de un libro (muestra sus clases internas Página)
        System.out.println("--- Abriendo un libro ---");
        libro1.leer();
        System.out.println();
        autor1.mostrarInfo();

        System.out.println("\n--- Finalizando jornada ---");
        // 9. Cerramos la biblioteca (según el ejercicio, los préstamos dejan de existir)
        Biblioteca.cerrarBiblioteca();
        Biblioteca.mostrarEstado();
    }


}
