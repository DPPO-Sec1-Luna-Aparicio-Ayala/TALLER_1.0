package Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import loader.Restaurante;
import loader.LoaderBurgers;
import loader.Restaurante;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.Producto;
import modelo.ProductoAlterado;
import modelo.ProductoMenu;


public class Aplicacion
{

	private Restaurante restaurante;
	

	public void ejecutarAplicacion()
	{
		System.out.println("Restaurante \n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opci�n"));
				if (opcion_seleccionada == 1)
					ejecutarCargarMenu();
				else if (opcion_seleccionada == 2 && restaurante != null)
					mostrarMenu();
				else if (opcion_seleccionada == 3 && restaurante != null)
					ejecutarIniciarNuevoPedido();
				else if (opcion_seleccionada == 4 && restaurante != null)
					ejecutarAdicionarAlPedido();
				else if (opcion_seleccionada == 5 && restaurante != null)
					ejecutarCerrarPedido();
				else if (opcion_seleccionada == 6 && restaurante != null)
					ejecutarConsultarPedido();
				else if (opcion_seleccionada == 7)
				{
					System.out.println("Saliendo de la aplicaci�n ...");
					continuar = false;
				}
				else if (restaurante == null)
				{
					System.out.println("Para poder ejecutar esta opci�n primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opci�n v�lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los n�meros de las opciones.");
			}
		}
	}
	
	public void mostrarMenuu()
	{
		System.out.println("\nOpciones de la aplicaci�n\n");
		System.out.println("1. Cargar men� restaurante");
		System.out.println("2. Mostrar me6n�");
		System.out.println("3. Iniciar un nuevo pedido");
		System.out.println("4. Agregar un elemento a un pedido");
		System.out.println("5. Cerrar un pedido y guardar factura");
		System.out.println("6. Consultar la informaci�n de un pedido dado su ID");
		System.out.println("7. Salir de la aplicaci�n"); 
	}
	
	

	private void ejecutarConsultarPedido() {
		String num = input("Ingrese el ID del pedido a consultar");
		num.replace(" ", "");
		int inum = Integer.parseInt(num);
		if (inum <= restaurante.darPedidos().size()) {
			Pedido pedidoConsultado = restaurante.darPedidos().get(inum-1);
			System.out.println(pedidoConsultado.darResumen());
		}
		else {
			System.out.println("El ID consultado no fue encontrado.");
		}
		
	}

	private void ejecutarCerrarPedido() {
		Pedido pedidoActual = restaurante.darPedidoActual();
		if (pedidoActual != null) {
			restaurante.finalizarPedidoActual();
			System.out.println(restaurante.darPedidos().get(restaurante.darPedidos().size()-1).darResumen());
		}
		
	}

	private void ejecutarAdicionarAlPedido() {
		Pedido pedidoActual = restaurante.darPedidoActual();
		
		if (pedidoActual != null) {
			ArrayList<Producto> menuCompleto = new ArrayList<Producto>(restaurante.darCombos());
			menuCompleto.addAll(restaurante.darMenu());
			int w = 1;
			System.out.println("\n");
			for (Producto productoActual : menuCompleto) {
				System.out.println(w + ". " + productoActual.darNombre() + " | " + productoActual.darPrecio());
				w ++;
			}
		String p = input("Por favor ingrese el n�mero de la opci�n deseada");
		int ip = Integer.parseInt(p);
		
		Producto productoElegido = menuCompleto.get(ip-1);
		
		if (ip > 3) {
			String cambiar = input("Desea modificar el producto?\n1. A�adir ingrediente\n2. Quitar ingrediente\n3. No quiero modificarlo\n");
			cambiar.replace(" ", "");
			int icambiar = Integer.parseInt(cambiar);
			if ((icambiar == 1) || (icambiar == 2)) {
					Producto alterado = alterarProducto(productoElegido, icambiar);
					pedidoActual.a�adirProducto(alterado);
					restaurante.actualizarPedidoActual(pedidoActual);				
			}
			else {
				pedidoActual.a�adirProducto(productoElegido);
				restaurante.actualizarPedidoActual(pedidoActual);
			}
			
		}
		else {
			pedidoActual.a�adirProducto(productoElegido);
			restaurante.actualizarPedidoActual(pedidoActual);
		}
		
		}
		else {
			System.out.println("Todav�a no se ha iniciado un pedido.");
		}
	}
	
			
	private Producto alterarProducto(Producto producto, int alteracion) {
		int u = 1;
		for (Ingrediente ingredienteActual : restaurante.darIngredientes()) {
			System.out.println(u + ". " + ingredienteActual.daringrediente() + " | " + ingredienteActual.darPrecio());	
			u ++;
		}
		ArrayList<Ingrediente> adiciones = new ArrayList<Ingrediente>();
		ArrayList<Ingrediente> sustracciones = new ArrayList<Ingrediente>();
		
		if (alteracion == 1) {
			String eleccion = input("Ingrese el n�mero del ingrediente que desea a�adir");
			int ieleccion = Integer.parseInt(eleccion);
			Ingrediente ingredienteElegido = restaurante.darIngredientes().get(ieleccion-1);
			adiciones.add(ingredienteElegido);
		}
		if (alteracion == 2) {
			String eleccion = input("Ingrese el n�mero del ingrediente que desea quitar");
			int ieleccion = Integer.parseInt(eleccion);
			Ingrediente ingredienteElegido = restaurante.darIngredientes().get(ieleccion-1);
			sustracciones.add(ingredienteElegido);
			}
		
		Producto productoAlterado = new ProductoAlterado(producto, adiciones, sustracciones);
		
		String seguir = input("Desea seguir modificando el producto?\n1. Agregar otro ingrediente\n2. Eliminar otro ingrediente\n3. Terminar modificaciones\n");
		int iseguir = Integer.parseInt(seguir);
		if ((iseguir == 1) || (iseguir == 2)) {
			return alterarProducto(productoAlterado, iseguir);
		}
		else {
			return productoAlterado;
		}
		
	}
	
	

	private void ejecutarIniciarNuevoPedido() {
		String nombre = input("Ingrese su nombre");
		String direcci�n = input("Ingrese su direcci�n");
		
		Pedido nuevoPedido = new Pedido(nombre, direcci�n);
		restaurante.a�adirPedido(nuevoPedido);
		System.out.println("Que desea hacer a continuaci�n? ");	
		}
		
	

	/**
	 * Este m�todo carga los archivos usando la clase Burgers y crea un objeto de tipo
	 * calculator para que sea usado por las otras opciones de la
	 * consola.
	 */
	private void ejecutarCargarMenu()
	{
		System.out.println("\n" + "Cargar la informaci�n de los archivos" + "\n");

		String archivo1 = "./data/combos.txt";
		String archivo2 = "./data/ingredientes.txt";
		String archivo3 = "./data/menu.txt";
		try
		{
			this.restaurante = LoaderBurgers.cargarArchivo(archivo1, archivo2, archivo3);
			System.out.println("Se cargaron los archivos " + archivo1 + ", " + archivo2 + ", " + archivo3 + " con informaci�n del men�.");	
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontr�.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}

	}

	private String input(String mensaje) {
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	private void mostrarMenu() {
		ArrayList<Combo> combos = restaurante.darCombos();
		
		System.out.println("\nCOMBOS");
		int n = 0;
		for (Combo comboActual: combos) {
			n ++;
			String nombre = comboActual.darNombre();
			double precio = comboActual.darPrecio();
			System.out.println(n + ". " + nombre + " | $" + precio);
		}
			
		System.out.println("\nPRODUCTOS B�SICOS");
		ArrayList<ProductoMenu> menu = restaurante.darMenu();
		
		for (ProductoMenu productoActual : menu) {
			n ++;
			String nombre = productoActual.darNombre();
			double precio = productoActual.darPrecio();
		    System.out.println(n + ". " + nombre + " | $" + precio);
		}
	}
	
	public static void main(String[] args)
	
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
}
		
	
