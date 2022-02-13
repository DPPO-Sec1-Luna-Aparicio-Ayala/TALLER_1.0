package loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		// ************************************************************************
		// Constructor
		// ************************************************************************

		public Restaurante(Map<String, Combo> combo, Map<String, Ingrediente> ingredientes, Map<String, ProductoMenu> menu)
		{
			this.combos = new ArrayList<Combo>(combo.values());
			this.ingredientes = new ArrayList<Ingrediente>(ingredientes.values());
			this.menuBase = new ArrayList<ProductoMenu>(menu.values());
			this.pedidos = new ArrayList<Pedido>();
		}
		
		
		// Métodos 
		
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
		
		public void añadirPedido(Pedido nuevoPedido) {
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
		
		public void finalizarPedidoActual() throws IOException {
			this.pedidoEnCurso.finalizarPedido();
			pedidos.set(pedidos.size()-1, pedidoEnCurso);
			this.pedidoEnCurso = null;
		}

	}
