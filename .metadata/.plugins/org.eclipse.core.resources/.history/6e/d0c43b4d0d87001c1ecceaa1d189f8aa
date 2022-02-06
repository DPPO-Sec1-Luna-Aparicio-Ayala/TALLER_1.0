package Console;

import loader.calculator;

public class Aplicacion
{
	
	private  calculator calculadora;

	public void ejecutarAplicacion()
	{
		System.out.println("El men˙ es: \n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opci√≥n"));
				if (opcion_seleccionada == 1)
					ejecutarCargarMenu();
				else if (opcion_seleccionada == 2 && calculadora != null)
					ejecutarIniciarNuevoPedido();
				else if (opcion_seleccionada == 3 && calculadora != null)
					ejecutarAdicionarAlPedido();
				else if (opcion_seleccionada == 4 && calculadora != null)
					ejecutarCerrarPedido();
				else if (opcion_seleccionada == 5 && calculadora != null)
					ejecutarConsultarPedido();
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicaci√≥n ...");
					continuar = false;
				}
				else if (calculadora == null)
				{
					System.out.println("Para poder ejecutar esta opci√≥n primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opci√≥n v√°lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los n√∫meros de las opciones.");
			}
		}
	}
	
	public void mostrarMenuu()
	{
		System.out.println("\nOpciones de la aplicaci√≥n\n");
		System.out.println("1. Mostrar men˙ restaurante");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar factura");
		System.out.println("5. Consultar la informaciÛn de un pedido dado su ID");
		System.out.println("6. Salir de la aplicaciÛn");
	}
	
	

	private void ejecutarConsultarPedido() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarCerrarPedido() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarAdicionarAlPedido() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarIniciarNuevoPedido() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarCargarMenu() {
		// TODO Auto-generated method stub
		
	}

	private String input(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private void mostrarMenu() {
		// TODO Auto-generated method stub
	}
}
		
	
