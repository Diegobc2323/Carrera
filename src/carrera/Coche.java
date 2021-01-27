package carrera;


public class Coche {

	private String nombrePiloto;
	private int dorsal;
	private final int distanciaCarrera=300;
	private String estadoCoche;
	private final int potencia=50;
	private int velocidad;
	private int kmRecorridos;


	public Coche(String nombrePiloto, int dorsal) {
		super();
		this.nombrePiloto = nombrePiloto;
		this.dorsal = dorsal;
		this.estadoCoche="PARADO";
		this.velocidad=0;
		this.kmRecorridos=0;
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
	public int getPotencia() {
		return potencia;
	}
	
	public void arrancar() {
		
		if (this.getEstadoCoche().equals("PARADO")) {
			this.setEstadoCoche("MARCHA");
		}else {
			System.out.println("Tu coche ya esta en marcha, has perdido este turno");
		}
		
	}

	public void acelerar() {
		
		switch (this.getEstadoCoche()) {
		
		case "PARADO":
			System.out.println("Para acelerar, primero debes arrancar el coche");
			break;
		
		case "MARCHA":
			double random = Math.random()*this.potencia+1;
			int acel = (int)Math.floor(random);
			int vel=this.getVelocidad();
			int km=this.getKmRecorridos();
			
			vel+=acel;
			if (vel>200) {
				this.setVelocidad(0);
				this.setEstadoCoche("ACCIDENTADO");
			}else {
				this.setVelocidad(vel);
				this.setKmRecorridos(km+vel);
			}
			break;
			
		case "ACCIDENTADO":
			System.out.println("Para poder acelerar, debes rearrancar el coche");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
		
		
			
			
	}
}
