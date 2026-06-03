
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //JuegoAdivinaNumero partida = new JuegoAdivinaNumero(3);
        //partida.juega();
		JuegoAdivinaNumero j1 = new JuegoAdivinaNumero(3);
		JuegoAdivinaNumero j2 = new JuegoAdivinaPar(3);
		JuegoAdivinaNumero j3 = new JuegoAdivinaImpar(3);
		
		j1.mostrarReglas();
		j1.juega();
		j2.mostrarReglas();
		j2.juega();
		j3.mostrarReglas();
		j3.juega();
		

	}

}

