package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import src.models.FacturaLinea;
import src.models.comun.DbObject;

public class menuFacturaLinea implements crud{

	
	List<DbObject>	facturaLineaLista = new ArrayList<>();
	FacturaLinea facLin = new FacturaLinea();
	public static Scanner keyboard = new Scanner(System.in);
	
	
	public menuFacturaLinea() {
		
	}
	
	public static menuFacturaLinea menu = new menuFacturaLinea();

	
	public static void mostrarFacturaLinea() {
		
		
	
		boolean salida = true;
		
		
		int opcion;
		
		System.out.print("\n Elige una opcion sobre Facturas En Linea \n");
		
		
		System.out.print("1 para Ver\n");
		System.out.print("2 para Crear\n");
		System.out.print("3 para Borrar\n");
		System.out.print("4 para Modificar\n");
		System.out.print("5 para Volver al menu Principal\n");
		
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
			System.out.println("Has elegido volver al Menu Principal");
			menuPrincipal.iniciaMenu();
			break;
		default:
			break;
		}
		
	}while(salida);
 
	System.out.print("Gracias por usar la apliacion");

} 

	@Override
	public  void ver() {
		
		if(!facturaLineaLista.isEmpty()) {
			
		facturaLineaLista = facLin.list();
		
		for(int i = 0 ; i < facturaLineaLista.size(); i++) {
			
			System.out.println(i+" = "+ facturaLineaLista.get(i));
			
			menuFacturaLinea.mostrarFacturaLinea();
		}

	}else {
		System.out.println("Esta categoria esta vacia");
		menuFacturaLinea.mostrarFacturaLinea();
	}
	}
	

	@Override
	public void modificar() {

		
		
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String eleccion;
		sdf.setLenient(false);
		
		System.out.println("Dime la posicion del Articulo que quieres Modificar");
		eleccion = keyboard.nextLine();
		int opcion = Integer.parseInt(eleccion);
		facturaLista.get(opcion);
		int id =facturaLista.get(opcion).getId();	
		fac= (Factura) fac.getByid(id);
		
		System.out.println("Dime la fecha de Factura");
		String nuevaFechaFactura = keyboard.nextLine();
		try {
			fecha = sdf.parse(nuevaFechaFactura);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fac.setFecha(fecha);
		System.out.println("Dime el ID del cliente");
		int nuevoIdCliente = Integer.parseInt(keyboard.nextLine());
		fac.setId_cliente(nuevoIdCliente);
		System.out.println("Dime la Serie de la Factura");
		int nuevaSerieCliente = Integer.parseInt(keyboard.nextLine());
		fac.setSerie(nuevaSerieCliente);
	
		fac.save();
		

		menuFacturaLinea.mostrarFacturaLinea();
		
	}

	@Override
	public void borrar() {
		keyboard.reset();
		
		String eleccion;
		System.out.println("Dime la posicion de la Factura en linea que quieres Borrar");
		eleccion = keyboard.nextLine();
		int opcion = Integer.parseInt(eleccion);
		
		 
		facturaLineaLista.get(opcion).delete();
		menuFacturaLinea.mostrarFacturaLinea();

		
	}

	@Override
	public void crear() {
		
		
		
		keyboard.reset();
	
		System.out.println("Dime el Nombre de la Factura en linea");
		
		String nombreFacturaLinea = keyboard.nextLine();
		facLin.setNombre(nombreFacturaLinea);
		
		
		System.out.println("Dime el ID de la Factura en Linea");
		int idFacturaLinea = Integer.parseInt(keyboard.nextLine());
		facLin.setId_factura(idFacturaLinea);
		System.out.println("Dime  el precio para la Factua en Linea");
		int nuevoPrecio = Integer.parseInt(keyboard.nextLine());
		facLin.setPrecio(nuevoPrecio);
		
		facLin.save();
		
		
		
		System.out.println("Se ha insertado el nuevo cliente");
		
		menuFacturaLinea.mostrarFacturaLinea();

		
		
	}
	
}
