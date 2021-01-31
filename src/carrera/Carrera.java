package carrera;

import java.util.Scanner;

public class Carrera {
	
	private String nombre;
	int distCarrera;
	Coche vCoches[];
	
	public Carrera(String nombre, int distCarrera) {
		super();
		this.nombre = nombre;
		this.distCarrera = distCarrera;
		this.vCoches = new Coche[10];
	}
	
	
	
	public void menuCarrera() {
		
		int opc=0;
		Scanner leer = new Scanner(System.in);
		
		do {
			boolean posLibre=false;
			
			for (Coche coche : vCoches) {
				if (coche==null) {
					posLibre=true;
					break;
				}
			}
			
			
			if (posLibre==false) {
				System.out.println("ya no se pueden a√±adir mas pilotos");
				opc=2;
			} else {
			System.out.println("Si quieres a√±adir un coche pulsa 1 \nSi quieres empezar ya la carrera pulsa 2");
			opc = leer.nextInt();
			}
			
			
			if (opc<1 || opc>2) {
				System.out.println("Elige una opcion valida por favor\n\n");
			}
			
			switch (opc) {
			case 1:
				addCoches();
				break;

			case 2:
				empiezaCarrera();
				break;
			}
			
		} while ((opc<1 || opc>2));
		
		
		
	}
	
	public boolean poderRearrancar() {
		
		for (Coche coche : vCoches) {
			
			if (coche!=null && coche.getEstadoCoche().equalsIgnoreCase("TERMINADO")) {
				return false;
			}
			
		}
		return true;
	}
	
	public boolean carreraTerminada() {
		
		for (Coche coche : vCoches) {
			if (coche!=null && coche.getEstadoCoche().equalsIgnoreCase("MARCHA")) {
				return false;
			}
		}
		return true;
	}
	
	public static int pintaMenu() {
		int opc =0;
		Scanner leer = new Scanner(System.in);
		
		do {
			System.out.println("Pulsa 1 para acelerar");
			System.out.println("Pulsa 2 para frenar");
			System.out.println("Pulsa 3 para rearrancar");
			opc = leer.nextInt();
		} while (opc<1 || opc>3);
		return opc;
		
		
		
		
	}
	
	public void empiezaCarrera() {
		boolean terminada = false, romper=true;
		int trueFalse=0, opc=0;
		
		for (int i = 0; i < vCoches.length; i++) {
			if (vCoches[i]!=null) {
				vCoches[i].setEstadoCoche("MARCHA");
			}
		}
		
		do {
			
			for (int i = 0; i < vCoches.length; i++) {
				if (vCoches[i]!=null) {
					if (vCoches[i].isJugador()) {
						trueFalse=1;
					}else {
						trueFalse=2;
					}
					
					switch (trueFalse) {
						case 1:
							System.out.println("Turno de "+vCoches[i].getNombrePiloto());
							
							opc=pintaMenu();
							switch (opc) {
								case 1:
									vCoches[i].acelerar();
									System.out.println();
									break;
								case 2:
									vCoches[i].frenar();
									System.out.println();
									break;
								case 3:
									if (poderRearrancar()) {
										vCoches[i].rearrancar();
										System.out.println();
									} else {
										System.out.println("no puedes rearrancar el coche porque ya hay alguien que ha acabado la carrera");
									}
									
									break;
							}
							break;
		
						case 2:
							System.out.println("Turno de "+vCoches[i].getNombrePiloto());
							
							if (vCoches[i].getEstadoCoche().equalsIgnoreCase("ACCIDENTADO")) {
								opc=3;
							} else if(vCoches[i].getVelocidad()==0) {
								opc=1;
							}else if (vCoches[i].getVelocidad()>180) {
								opc=2;
							}
							
							switch (opc) {
							case 1:
								vCoches[i].acelerar();
								System.out.println();
								break;

							case 2:
								vCoches[i].frenar();
								System.out.println();
								break;
							
							case 3:
								if (poderRearrancar()) {
									vCoches[i].rearrancar();
									System.out.println();
								} else {
									System.out.println("no puedes rearrancar el coche porque ya hay alguien que ha acabado la carrera");
								}
								break;
							}
					}
				}
				
				if (carreraTerminada()) {
					terminada=true;
					break;
				}
			}
			
			
			
		} while (terminada==false);
		
		System.out.println("La carrera a terminado");
		System.exit(0);
		
	}
	
	
	public void addCoches() {		
		
		String nombrePiloto = "", respuesta="";
		int dorsal=-99;
		boolean jugador = false, dorRepetida=false;
		Scanner leerTxt = new Scanner(System.in);
		Scanner leerNum = new Scanner(System.in);
		
			for (int i = 0; i < vCoches.length; i++) {
				if (vCoches[i]==null) {
					
					do {
						System.out.println("El nuevo piloto va a ser un jugador (responde con si o no)");
						respuesta= leerTxt.nextLine();
					} while (!(respuesta.equalsIgnoreCase("si")  || respuesta.equalsIgnoreCase("no")));
					
					if (respuesta.equalsIgnoreCase("si")) {
						
						jugador=true;
						
						System.out.println("Dime el nombre de tu piloto");
						nombrePiloto= leerTxt.nextLine();
						
						
						do {
							dorRepetida=false;
							System.out.println("Dime la dorsal que va a usar el piloto "+nombrePiloto);
							dorsal=leerNum.nextInt();
							
							for (Coche coche : vCoches) {
								if (coche!=null && coche.getDorsal()==dorsal) {
									dorRepetida=true;
									System.out.println("Esa dorsal ya esta en uso, por favor introduce otra");
								}
							}
						} while (dorRepetida);
						
						vCoches[i]=new Coche(nombrePiloto, dorsal, jugador, this.distCarrera);
						System.out.println("el piloto "+nombrePiloto+" ha sido aÒadido");
						menuCarrera();
					}else {
						vCoches[i]= new Coche("piloto_"+(i+99), (i+99), false, this.distCarrera);
						System.out.println("el piloto "+vCoches[i].getNombrePiloto()+" ha sido aÒadido");
						menuCarrera();
					}
				}
			}
		
		}
		
		
}
	
	

