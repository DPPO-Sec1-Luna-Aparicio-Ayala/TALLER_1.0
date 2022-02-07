package loader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.ProductoMenu;

public class Restaurante {
	
		private ArrayList<Combo> combos;
		private Map<String, Ingrediente> ingredientes;
		private Map<String, ProductoMenu> menu;
		private ArrayList<Pedido> pedidos;
		
		// ************************************************************************
		// Constructores
		// ************************************************************************


		public Restaurante(Map<String, Combo> combo, Map<String, Ingrediente> ingredientes, Map<String, ProductoMenu> menu)
		{
			this.combos = new ArrayList<Combo>(combo.values());
			this.ingredientes = ingredientes;
			this.menu = menu;
			this.pedidos = new ArrayList<Pedido>();
		}
		
		public ArrayList<Combo> darCombos()
		{
			return combos;
		}
		
		public Map<String, Ingrediente> darIngredientes()
		{
			return ingredientes;
		}
		public Map<String, ProductoMenu> darMenu()
		{
			return menu;
		}
		public ArrayList<Pedido> darPedidos()
		{
			return pedidos;
		}
		

		}
