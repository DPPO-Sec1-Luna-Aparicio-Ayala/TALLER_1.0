package loader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;

public class Restaurante {

		private List<Combo> combo;
		private List <Ingrediente> ingredientes;
		private List<ProductoMenu> menu;
		
		// ************************************************************************
		// Constructores
		// ************************************************************************

		public Restaurante(Map<String, Combo> combo, Map<String, Ingrediente> ingredientes, Map<String, ProductoMenu> menu)
		{
			this.combo = new ArrayList<Combo>(combo.values());
			this.ingredientes = new ArrayList<Ingrediente>(ingredientes.values());
			this.menu = new ArrayList<ProductoMenu>(menu.values());
		}
		
		}
