package modelo; 

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	private String resumenBueno;
	
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
		
	public void finalizarPedido() throws IOException {
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
		
		this.resumen = "RESUMEN DEL PEDIDO\n" + "ID: " + id + "\nCLIENTE: " + nombreCliente + "\nDIRECCIÓN: " + direccionCliente + "\nPRODUCTOS:\n" + productosTexto + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal + "\nCALORÍAS: "
				+ cal;
		
		
		//System.out.println(pedidosHistorial);
		
		String separadocomas = "RESUMEN DEL PEDIDO\n" + "ID: " + id + ";" + "\nCLIENTE: " + nombreCliente + "\nDIRECCIÓN: " + direccionCliente + ";" + "\nPRODUCTOS:\n" + productosTexto + ";" + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal + "\nCALORÍAS: "+ cal ;
		this.resumenBueno = "RESUMEN DEL PEDIDO\n" + "\nPRODUCTOS:\n" + productosTexto + "VALOR NETO: $" + valorNeto + "\nVALOR TOTAL: $" + valorTotal; 
		pedidosHistorial.add(resumenBueno);
		Comparar(resumenBueno);
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
	
	public ArrayList<String> darHistorial() {
		return pedidosHistorial;
		
	}
	
	public void Comparar(String resumenBueno) {
		
		int x = 0;
		for (String pedido: pedidosHistorial) {
			
			if (resumenBueno.equals(pedido)) {
				
				
				x = 1;
			
		}
			
	}
	
		if (x == 0) {
			System.out.println("No hay un pedido identico, eres muy original!");
		}
		else {
			System.out.println("Si existe un pedido identico");
		}
	}
	// Código que añadimos a la clase Pedido. Sobreescritura del método equals ejemplo

    public boolean equals (Object obj) {

        if (obj instanceof Pedido) {

        Pedido tmbPedido = (Pedido) obj;

            if (this.resumenBueno.equals(tmbPedido.resumenBueno)) 
            	{ return true; } else { return false; }

    } else { return false; }

} //Cierre del método equals
}