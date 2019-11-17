package src;

import java.util.Scanner;

import src.models.Categoria;

public class menuCategorias implements crud {
	
	public menuCategorias() {
		
	}
	
	static menuCategorias menu = new menuCategorias();
	
	public static String mostrarCategorias() {
		
		
	
		boolean salida = true;
		String salidaTexto = null;
		
		int opcion;
		System.out.print("Elige una opcion\n");
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("1 para Ver\n");
		System.out.print("2 para Crear\n");
		System.out.print("3 para Modificar\n");
		System.out.print("4 para Borrar\n");
		System.out.print("5 para Salir\n");
		
		do {
		
		opcion = Integer.parseInt(keyboard.nextLine());
		
		switch (opcion) {
		case 1:
			System.out.println("Has elegido ver");
			menu.ver();
			break;
		case 2:
			System.out.println("Has elegido crear");
			menu.crear();
			break;
		case 3:
			System.out.println("Has elegido Borrar");
			menu.borrar();
			break;
		case 4:
			System.out.println("Has elegido modificar");
			menu.modificar();
			break;
		case 5:
			System.out.println("Has elegido Salir");
			salida = false;
			break;
		default:
			break;
		}
		
	}while(salida);
		return salidaTexto;

} 

	@Override
	public  void ver() {
		
		Categoria cat = new Categoria();
		
		
		
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crear() {
		// TODO Auto-generated method stub
		
	}
}
