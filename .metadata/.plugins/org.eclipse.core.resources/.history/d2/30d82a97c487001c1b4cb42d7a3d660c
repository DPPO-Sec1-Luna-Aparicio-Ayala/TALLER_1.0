package loader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;

public class Restaurante {
	
		private ArrayList<Combo> combos;
		private ArrayList <Ingrediente> ingredientes;
		private ArrayList<ProductoMenu> menu;
		
		// ************************************************************************
		// Constructores
		// ************************************************************************




		public Restaurante(Map<String, Combo> combo, Map<String, Ingrediente> ingredientes, Map<String, ProductoMenu> menu)
		{
			this.combos = new ArrayList<Combo>(combo.values());
			this.ingredientes = new ArrayList<Ingrediente>(ingredientes.values());
			this.menu = new ArrayList<ProductoMenu>(menu.values());
		}
		
		public ArrayList darCombo()
		{
			return combos;
		}
		
		public ArrayList darIngredientes()
		{
			return ingredientes;
		}
		public ArrayList darMenu()
		{
			return menu;
		}

		}
