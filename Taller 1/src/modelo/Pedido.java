package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String id;
	private double valorNeto;
	private double valorTotal;
	private ArrayList<Combo> combos;
	private ArrayList<ProductoMenu> productosBasicos;
	private ArrayList<ProductoAlterado> productosAlterados;
	private double calorias;
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	public Pedido(String id, ArrayList<Combo> combos, ArrayList<ProductoMenu> basicos, ArrayList<ProductoAlterado> modificados)
	{
		for (Combo comboActual : combos)
		{
			
		}
		this.productoInicial = basico;
		this.adiciones = extra;
		this.sustracciones = menos;
	}

}
