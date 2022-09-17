package EmpresaEnvios;

import java.util.Scanner;

public class Principal {
	
	public static int buscarPaquete(Paquete t[],int numeroPaquete,int contadorPaquete) {
		int indice=0;
		boolean encontrado=false;
		
		for(int i=0;i<contadorPaquete;i++) {
			if(t[i].getNumeroPaquete() == numeroPaquete) {
				encontrado = true;
				indice = i;
			}
		}
		if(encontrado == false) {
			indice = -1;
			
		}
		return indice;
		
	}
	
	
public static int buscarSucursal(Sucursal t[],int numeroSucursal,int contadorSucursal) {
	int indice=0;
	boolean encontrado=false;
	
	for(int i=0;i<contadorSucursal;i++) {
		if(t[i].getNumeroSucursal() == numeroSucursal) {
			encontrado = true;
			indice = i;
		}
	}
	if(encontrado == false) {
		indice = -1;
		
	}
	return indice;
	
}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int numeroSucursal, numeroPaquete, prioridad,opcionMenu;
		int contadorSucursal=0, contadorPaquete=0,indiceSucursal,indicePaquete;
		String direccion,ciudad,dni;
		double peso, precio;
		
		Sucursal sucursales[] = new Sucursal[50];
		Paquete paquetes[]= new Paquete[100];
		
		do {
			System.out.println("MENU");
			System.out.println("1-CREAR UNA NUEVA SUCURSAL");
			System.out.println("2-ENVIAR PAQUETE");
			System.out.println("3-CONSULTAR SUCURSAL");
			System.out.println("4-CONSULTAR PAQUETE");
			System.out.println("5-MOSTRAR TODAS LAS SUCURSALES");
			System.out.println("6-MOSTRAR TODOS LOS PAQUETES");
			System.out.println("7-SALIR");
			System.out.println("DIGITE LA OPCION DE MENU:");
			opcionMenu=reader.nextInt();
			
			switch(opcionMenu) {
			
			case 1: System.out.println("INGRESE EL NUMERO DE SUCURSAL:");
					numeroSucursal=reader.nextInt();	
					reader.nextLine();
					System.out.println("INGRESE LA DIRECCION:");
					direccion=reader.nextLine();
					System.out.println("INGRESE LA CIUDAD:");
					ciudad=reader.nextLine();
					
					sucursales[contadorSucursal]=new Sucursal(numeroSucursal,direccion,ciudad);
					contadorSucursal ++;
					break;
					
			case 2: System.out.println("INGRESE LA SUCURSAL DESDE LA QUE ENVIA EL PAQUETE:");
					numeroSucursal=reader.nextInt();
					indiceSucursal=buscarSucursal(sucursales,numeroSucursal,contadorSucursal);
					
					if(indiceSucursal == -1) {
						System.out.println("LA SUCURSAL NO EXISTE");
					}
					else {
						System.out.println("INGRESE EL NUMERO DE PAQUETE:");
						numeroPaquete=reader.nextInt();
						reader.nextLine();
						System.out.println("INGRESE EL DNI DE LA PERSONA QUE ENVIA EL PAQUETE:");
						dni=reader.nextLine();
						System.out.println("INGRESE EL PESO DEL PAQUETE:");
						peso=reader.nextDouble();
						System.out.println("INGRESE LA PRIORIDAD (0=NORMAL, 1=ALTA, 2 = EXPRESS) : ");
						prioridad=reader.nextInt();
						
						paquetes[contadorPaquete]= new Paquete(numeroPaquete,dni,peso,prioridad);
						
						precio=sucursales[indiceSucursal].calcular_precio(paquetes[contadorPaquete]);
						
						System.out.println("EL PRECIO DEL PAQUETE ES: $" + precio);
						
						contadorPaquete ++;
					}
					
					break;
					
			case 3: System.out.println("INGRESE EL NUMERO DE SUCURSAL:");
					numeroSucursal=reader.nextInt();
			
					
					indiceSucursal = buscarSucursal(sucursales, numeroSucursal, contadorSucursal);
					
					if(indiceSucursal == -1) {
						System.out.println("LA SUCURSAL NO EXISTE");
						
					}
					else {
						System.out.println("LOS DATOS DE LA SUCURSAL SON: "  );
						System.out.println(sucursales[indiceSucursal].mostrarDatosSucursal());
					}
					
					break;
				
			case 4: System.out.println("INGRESE EL NUMERO DE PAQUETE");
					numeroPaquete=reader.nextInt();
					
					indicePaquete = buscarPaquete(paquetes, numeroPaquete, contadorPaquete);
					
					if(indicePaquete == -1) {
						System.out.println("EL PAQUETE NO EXISTE");
					}
					else {
						System.out.println("LOS DATOS DEL PAQUETE SON:");
						System.out.println(paquetes[indicePaquete].mostrarDatosPaquete());
					}
					
					break;
					
			case 5 :
						for(int i=0;i<contadorSucursal;i++) {
							System.out.println("\n LOS DATOS DE LA SUCURSAL NUMERO" + (i+1) + "SON :");
							System.out.println(sucursales[i].mostrarDatosSucursal());
						}
						
						break;
						
			case 6 : 	for(int i=0;i<contadorPaquete;i++) {
				System.out.println("\n LOS DATOS DEL PAQUETE NUMERO" + (i+1) + "SON :");
				System.out.println(paquetes[i].mostrarDatosPaquete());
			}	
			
						break;
						
			case 7 :    break;
			
			default :  System.out.println("OPCION DE MENU INCORRECTA");
						break;
					
			}
			
			System.out.println("");
			
		}while(opcionMenu != 7);

	}

}
