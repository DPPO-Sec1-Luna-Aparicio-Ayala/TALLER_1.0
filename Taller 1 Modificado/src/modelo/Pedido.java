package modelo; 

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String id;
	private double valorNeto;
	private double valorTotal;
	private ArrayList<Producto> productosPedido;
	private double cal;
	private String nombreCliente;
	private String direccionCliente;
	private String resumen;
	private ArrayList<String> pedidosHistorial;
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	public Pedido(String nombre, String direccion)	{
		this.valorNeto = 0;
		
		this.nombreCliente = nombre;
		this.direccionCliente = direccion;
		
		this.productosPedido = new ArrayList<Producto>();
		this.pedidosHistorial = new ArrayList<String>();
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
			double calproduct = productoActual.darCal();
			this.cal += calproduct;
			//productosTexto.concat(productoActual.darTextoFactura() + "\n");
			productosTexto += "-" + productoActual.darTextoFactura() + "\n";
		}
		this.valorTotal = this.valorNeto * 1.19;
		
		resumen = "RESUMEN DEL PEDIDO\n" + "ID: " + id + "\nCLIENTE: " + nombreCliente + "\nDIRECCIÓN: " + direccionCliente + "\nPRODUCTOS:\n" + productosTexto + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal + "\nCALORÍAS: "
				+ cal;
		
		pedidosHistorial.add(resumen);
		System.out.println(pedidosHistorial);
	}
	
	public String darResumen() {
		return resumen;
	}
	
	public ArrayList<String> darHistorial() {
		return pedidosHistorial;
	}
	
	// Código que añadimos a la clase Pedido. Sobreescritura del método equals ejemplo

    public boolean equals (Object obj) {

        if (obj instanceof Pedido) {

        Pedido tmbPedido = (Pedido) obj;

            if (this.resumen.equals(tmbPedido.resumen)) //&& this.apellidos.equals(tmpPersona.apellidos) &&

// this.edad == tmpPersona.edad) 
            	{ return true; } else { return false; }

    } else { return false; }

} //Cierre del método equals
}