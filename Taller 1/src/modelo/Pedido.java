package modelo; 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	private String resumenBueno;
	
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
		
	public void finalizarPedido() throws IOException {
		String productosTexto = "";
		for(Producto productoActual : productosPedido) {
			double valor = productoActual.darPrecio();
			this.valorNeto += valor;
			//productosTexto.concat(productoActual.darTextoFactura() + "\n");
			productosTexto += "-" + productoActual.darTextoFactura() + "\n";
		}
		this.valorTotal = this.valorNeto * 1.19;
		
		this.resumen = "RESUMEN DEL PEDIDO\n" + "ID: " + id + "\nCLIENTE: " + nombreCliente + "\nDIRECCIÓN: " + direccionCliente + "\nPRODUCTOS:\n" + productosTexto + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal;
		this.resumenBueno = "RESUMEN DEL PEDIDO\n" + "\nPRODUCTOS:\n" + productosTexto + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal; 
		String separadocomas = "RESUMEN DEL PEDIDO\n" + "ID: " + id + ";" + "\nCLIENTE: " + nombreCliente + "\nDIRECCIÓN: " + direccionCliente + ";" + "\nPRODUCTOS:\n" + productosTexto + ";" + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal;
		String[] impresionFactura= separadocomas.split(";");
		PrintWriter pedido = new PrintWriter("pedido"+ id + ".txt", "UTF-8");
		BufferedWriter bw = new BufferedWriter(pedido);
        for (int x=0; x<4;x++ ) {
        	bw.write(impresionFactura[x]);
        	bw.newLine();
        	
        }
        bw.close();
	}
	
	
	public String darResumen() {
		return resumen;
	}
	
	/*public static void guardarFactura(String[] args) throws IOException {
		
        
    }
    */
	
}