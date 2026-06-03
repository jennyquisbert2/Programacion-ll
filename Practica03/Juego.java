
public abstract class Juego {
    protected int numeroDeVidas;
    protected int record = 0;
    private int vidasIniciales;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.vidasIniciales = numeroDeVidas;
    }

    public abstract void mostrarReglas();

    public void reiniciaPartida() {
        this.numeroDeVidas = vidasIniciales;
    }

    public void actualizaRecord() {
        if (numeroDeVidas > record) {
            record = numeroDeVidas;
            System.out.println("¡Nuevo récord! Tu récord es: " + record);
        }
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        if (numeroDeVidas > 0) return true;
        System.out.println("Juego Terminado.");
        return false;
    }
}

