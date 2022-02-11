package loader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Bebidas;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.ProductoMenu;

public class Restaurante {
	
		private ArrayList<Combo> combos;
		private ArrayList<Ingrediente> ingredientes;
		private ArrayList<ProductoMenu> menuBase;
		private ArrayList<Pedido> pedidos;
		private Pedido pedidoEnCurso;
		private ArrayList<Bebidas> bebidas;
		
		// ************************************************************************
		// Constructor
		// ************************************************************************

		public Restaurante(Map<String, Combo> combo, Map<String, Ingrediente> ingredientes, Map<String, ProductoMenu> menu, Map<String,Bebidas>bebida)
		{
			this.combos = new ArrayList<Combo>(combo.values());
			this.ingredientes = new ArrayList<Ingrediente>(ingredientes.values());
			this.bebidas = new ArrayList<Bebidas>(bebida.values());
			this.menuBase = new ArrayList<ProductoMenu>(menu.values());
			this.pedidos = new ArrayList<Pedido>();
		}
		
		
		// M�todos 
		
		public ArrayList<Bebidas> darBebidas()
		{
			return bebidas;
		}
		
		public ArrayList<Combo> darCombos()
		{
			return combos;
		}
		
		public ArrayList<Ingrediente> darIngredientes()
		{
			return ingredientes;
		}
		public ArrayList<ProductoMenu> darMenu()
		{
			return menuBase;
		}
		public ArrayList<Pedido> darPedidos()
		{
			return pedidos;
		}
		
		public void a�adirPedido(Pedido nuevoPedido) {
			nuevoPedido.asignarID(pedidos.size()+1);
			this.pedidos.add(nuevoPedido);
			this.pedidoEnCurso = nuevoPedido;
			
		}
		
		public Pedido darPedidoActual(){
			if (pedidos.size() > 0) {
				return pedidoEnCurso;
			}
			
			else {
				return null;
			}
		}
		
		public void actualizarPedidoActual(Pedido pedido) {
			this.pedidoEnCurso = pedido;
			pedidos.set(pedidos.size()-1, pedido);
			
		}
		
		public void finalizarPedidoActual() {
			this.pedidoEnCurso.finalizarPedido();
			pedidos.set(pedidos.size()-1, pedidoEnCurso);
			this.pedidoEnCurso = null;
		}

	}
