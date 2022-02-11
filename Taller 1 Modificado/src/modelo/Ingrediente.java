package modelo;

public class Ingrediente {
	
	// ************************************************************************
		// Atributos
		// ************************************************************************

		private String ingrediente;
		private double precio;
		private double cal;
		
		public Ingrediente(String ingre, String price, String cal)
		{
			this.ingrediente = ingre;
			double precioDouble = Double.parseDouble(price);
			this.precio = precioDouble;
			double calnum= Double.parseDouble(cal);
			this.cal = calnum;
		}
		
		// ************************************************************************
		// Métodos para consultar los atributos
		// ************************************************************************
		public String daringrediente()
		{
			return ingrediente;
		}
		
		public double darPrecio()
		{
			return precio;
		}
		
		public double darCal( ) {
			return cal;
		}

	
}
