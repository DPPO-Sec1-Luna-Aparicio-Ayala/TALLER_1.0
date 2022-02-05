package modelo;

public class Ingrediente {
	
	// ************************************************************************
		// Atributos
		// ************************************************************************

		private String ingrediente;
		private String precio;
		
		public Ingrediente(String ingre,String price)
		{
			this.ingrediente = ingre;
			this.precio = price;
		}
		
		// ************************************************************************
				// Métodos para consultar los atributos
				// ************************************************************************
				public String daringrediente()
				{
					return ingrediente;
				}

				public String darPrecio()
				{
					return precio;
				}

	
}
