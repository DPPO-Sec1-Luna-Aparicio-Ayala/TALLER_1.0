package modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAlterado {
	// ***********************************************************************
	// Atributos
	// ***********************************************************************
	private ProductoMenu productoInicial;
	private ArrayList<Ingrediente> adiciones;
	private ArrayList<Ingrediente> sustracciones;
	
	
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	public ProductoAlterado(ProductoMenu basico, ArrayList<Ingrediente> extra, ArrayList<Ingrediente> menos)
	{
		this.productoInicial = basico;
		this.adiciones = extra;
		this.sustracciones = menos;
	}

	// ************************************************************************
	// Métodos
	// ************************************************************************
}
