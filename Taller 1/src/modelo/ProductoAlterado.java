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
			nombreCompleto += " con adici?n de " + nombreIng;	
		}
		
		for (Ingrediente ingrediente : sustracciones) {
			String nombreIng = ingrediente.daringrediente();
			nombreCompleto += " sin " + nombreIng;
		}
		
		this.nombre = nombreCompleto;
		
		double precioAdiciones = 0;
		for(Ingrediente adicion : extra) {
			precioAdiciones += adicion.darPrecio();
		}
		this.precio = basico.darPrecio() + precioAdiciones;
		
		this.textoFactura = nombre + " | $" + precio;
	}

	// ************************************************************************
	// M?todos
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

}


