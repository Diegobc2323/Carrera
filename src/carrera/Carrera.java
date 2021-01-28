package carrera;

import java.util.Scanner;

public class Carrera {
	
	private String nombre;
	Coche vCoches[];
	
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
		this.vCoches = new Coche[10];
	}
	
	public void addCoches() {
		for (int i = 0; i < vCoches.length; i++) {
			Scanner leerTxt = new Scanner(System.in);
			Scanner leerNum = new Scanner(System.in);
			String nombrePiloto ="";
			int dorsal=-99;
			boolean jugador = false, dorsalRepetida=false;
			
			
			System.out.println("Dime el nombre del piloto "+(i+1));
			nombrePiloto= leerTxt.nextLine();
			
			System.out.println("Dime el dorsal del piloto "+(i+1));
			
			do {
				dorsal=leerNum.nextInt();
				for (Coche c : vCoches) {
					if (c.getDorsal()==dorsal) {
						dorsalRepetida=true;
						break;
					}
				}
				
				if (dorsalRepetida) {
					System.out.println("Esa dorsal ya esta en uso, por favor introduce otra que no lo este");
				}
			} while (dorsalRepetida==true);
			
			
			
			System.out.println("Dime si el piloto "+(i+1)+" va a ser un jugador (responde con 'si' o 'no')");
			vCoches[i] = new Coche(nombrePiloto, dorsal, jugador);
		}
	}
	
	
}
