package modelo;


public class Bebidas implements Producto {
		
		// ************************************************************************
				// Atributos
				// ************************************************************************

				private String bebida;
				private double precio;
				private String textoFactura;
				private double cal;

		public Bebidas(String drink, String price, String cal) 
		{
			this.bebida =drink;
			double precioDouble = Double.parseDouble(price);
			this.precio = precioDouble;
			double calnum= Double.parseDouble(cal);
			this.cal = calnum;
			this.textoFactura = bebida + " | $" + precio + " | cals."  + cal;
		}
		
		// ************************************************************************
		// Métodos para consultar los atributos
		// ************************************************************************
		public String darNombre()
		{
			return bebida;
		}

		public double darPrecio()
		{
			return precio;
		}
		
		public String darTextoFactura()
		{
			return textoFactura;
		}
		
		public double darCal( ) {
			return cal;

		}

	}

