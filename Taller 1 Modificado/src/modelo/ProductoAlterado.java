package modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAlterado implements Producto{
	// ***********************************************************************
	// Atributos
	// ***********************************************************************
	private Producto productoInicial;
	private ArrayList<Ingrediente> adiciones;
	private ArrayList<Ingrediente> sustracciones;
	private String nombre;
	private double precio;
	private String textoFactura;
	private double cal;
	
	
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	public ProductoAlterado(Producto basico, ArrayList<Ingrediente> extra, ArrayList<Ingrediente> menos)
	{
		this.productoInicial = basico;
		this.adiciones = extra;
		this.sustracciones = menos;
		String nombreCompleto = productoInicial.darNombre();
		for (Ingrediente ingrediente : adiciones) {
			String nombreIng = ingrediente.daringrediente();
			nombreCompleto += " con adición de " + nombreIng;	
		}
		
		for (Ingrediente ingrediente : sustracciones) {
			String nombreIng = ingrediente.daringrediente();
			nombreCompleto += " sin " + nombreIng;
			
		}
		
		this.nombre = nombreCompleto;
		
		double precioAdiciones = 0;
		double calAdiciones = 0;
		for(Ingrediente adicion : extra) {
			precioAdiciones += adicion.darPrecio();
			calAdiciones+= adicion.darCal();
		}
		
		for (Ingrediente sustraccion: menos) {
			calAdiciones -= sustraccion.darCal();
			
		}
		this.precio = basico.darPrecio() + precioAdiciones;
		this.cal = basico.darCal() + calAdiciones;
		this.textoFactura = nombre + " | $" + precio +" | cals." + cal;
	}

	// ************************************************************************
	// Métodos
	// ************************************************************************
	
	public String darNombre()
	{
		return nombre;
	}
	
	public double darPrecio()
	{
		return precio;
	}

	public String darTextoFactura() {
		return textoFactura;
	}

	public double darCal( ) {
		return cal;
	}
}


