package modelo; 

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String id;
	private double valorNeto;
	private double valorTotal;
	private ArrayList<Producto> productosPedido;
	private double calorias;
	private String nombreCliente;
	private String direccionCliente;
	private String resumen;
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	public Pedido(String nombre, String direccion)	{
		this.valorNeto = 0;
		
		this.nombreCliente = nombre;
		this.direccionCliente = direccion;
		
		this.productosPedido = new ArrayList<Producto>();
	}
	
	public ArrayList<Producto> darProductosActuales(){
		return productosPedido;
	}
	
	public void asignarID(int numero) {
		String numId = Integer.toString(numero);
		this.id = numId;
	}
	
	public void añadirProducto(Producto nuevoProducto) {
		this.productosPedido.add(nuevoProducto);
	}
		
	public void finalizarPedido() {
		String productosTexto = "";
		for(Producto productoActual : productosPedido) {
			double valor = productoActual.darPrecio();
			this.valorNeto += valor;
			//productosTexto.concat(productoActual.darTextoFactura() + "\n");
			productosTexto += "-" + productoActual.darTextoFactura() + "\n";
		}
		this.valorTotal = this.valorNeto * 1.19;
		
		resumen = "RESUMEN DEL PEDIDO\n" + "ID: " + id + "\nCLIENTE: " + nombreCliente + "\nDIRECCIÓN: " + direccionCliente + "\nPRODUCTOS:\n" + productosTexto + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal;
	}
	
	public String darResumen() {
		return resumen;
	}
	
}