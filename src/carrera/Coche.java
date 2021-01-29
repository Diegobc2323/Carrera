package carrera;


public class Coche {

	private String nombrePiloto;
	private int dorsal;
	private int distanciaCarrera;
	private String estadoCoche;
	private final int POTENCIA=50;
	private int velocidad;
	private int kmRecorridos;
	private boolean jugador;


	public Coche(String nombrePiloto, int dorsal, boolean jugador, int distanciaCarrera) {
		super();
		this.nombrePiloto = nombrePiloto;
		this.dorsal = dorsal;
		this.jugador = jugador;
		this.estadoCoche="PARADO";
		this.velocidad=0;
		this.kmRecorridos=0;
		this.distanciaCarrera=distanciaCarrera;
	}


	public String getNombrePiloto() {
		return nombrePiloto;
	}
	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getEstadoCoche() {
		return estadoCoche;
	}
	public void setEstadoCoche(String estadoCoche) {
		this.estadoCoche = estadoCoche;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(int kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}
	public void setDistanciaCarrera(int distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}
	public int getPOTENCIA() {
		return POTENCIA;
	}
	public boolean isJugador() {
		return jugador;
	}
	public void setJugador(boolean jugador) {
		this.jugador = jugador;
	}


	public void arrancar() {
		
		
		switch (this.estadoCoche) {
		case "PARADO":
			this.setEstadoCoche("MARCHA");
			System.out.println("Has arrancado el coche");
			break;
		case "MARCHA":
			System.out.println("Tu coche ya esta en marcha, has perdido el turno");
			break;
			
		case "ACCIDENTADO":
			System.out.println("Tu coche esta accidentado, debes rearrancarlo en el turno siguiente");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		
		}
		
	}

	public void acelerar() {
		
		switch (this.getEstadoCoche()) {
		
		case "PARADO":
			System.out.println("Para acelerar, primero debes arrancar el coche en el turno siguiente");
			break;
		
		case "MARCHA":
			double random = Math.random()*this.POTENCIA+1;
			int acel = (int)Math.floor(random);
			int vel=this.getVelocidad();
			int km=this.getKmRecorridos();
			
			vel+=acel;
			if (vel>200) {
				this.setVelocidad(0);
				this.setEstadoCoche("ACCIDENTADO");
				System.out.println("Has superado los 200 km/h y te has accidentado");
			}else {
				this.setVelocidad(vel);
				this.setKmRecorridos(km+vel);
				System.out.println("Su velocidad actual es de "+this.getVelocidad()+" km/h");
			}
			
			if (this.kmRecorridos>=this.distanciaCarrera) {
				System.out.println("Felicidades, has acabado la carrera");
			}else {
				System.out.println("Tu coche a recorrido "+this.getKmRecorridos()+" km hasta el momento, le faltan "+(this.getDistanciaCarrera()-this.getKmRecorridos())+" para terminar la carrera");
			}
			
			break;
			
		case "ACCIDENTADO":
			System.out.println("Para poder acelerar, debes rearrancar el coche en el turno siguiente");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
		
	}

	public void frenar() {
		
		switch (this.getEstadoCoche()) {
		
		case "PARADO":
			System.out.println("Para frenar, primero debes arrancar el coche en el turno siguiente");
			break;
		
		case "MARCHA":
			double random = Math.random()*this.POTENCIA+1;
			int freno = (int)Math.floor(random);
			int vel=this.getVelocidad();
			int km=this.getKmRecorridos();
			
			vel-=freno;
			if (vel<0) {
				this.setVelocidad(0);
				System.out.println("Tu coche a recorrido "+this.getKmRecorridos()+" km hasta el momento, le faltan "+(this.getDistanciaCarrera()-this.getKmRecorridos())+" para terminar la carrera");
				System.out.println("Su velocidad actual es de "+this.getVelocidad()+" km/h, si vuelves a frenar perderas un turno");
			}else {
				this.setVelocidad(vel);
				this.setKmRecorridos(km+vel);
				System.out.println("Tu coche a recorrido "+this.getKmRecorridos()+" km hasta el momento, le faltan "+(this.getDistanciaCarrera()-this.getKmRecorridos())+" para terminar la carrera");
				System.out.println("Su velocidad actual es de "+this.getVelocidad()+" km/h");
			}
			break;
			
		case "ACCIDENTADO":
			System.out.println("Para poder frenar, debes rearrancar el coche en el turno siguiente");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
	}
	
	public void rearrancar() {
		
		switch (this.estadoCoche) {
		case "PARADO":
			System.out.println("Debes arrancar el coche, no rearrancarlo, pierdes el turno");
			break;
		case "MARCHA":
			System.out.println("Tienes que rearrancar el coche, has perdido el turno");
			break;
			
		case "ACCIDENTADO":
			this.setEstadoCoche("MARCHA");
			System.out.println("Has rearrancado el coche");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		
		}
		
		
	}
	
	
}
