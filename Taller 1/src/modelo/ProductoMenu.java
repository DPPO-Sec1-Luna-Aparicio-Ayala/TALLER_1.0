package modelo;

public class ProductoMenu {
	
	// ************************************************************************
			// Atributos
			// ************************************************************************

			private String plato;
			private String precio;

	public ProductoMenu(String plate, String price) 
	{
		this.plato =plate;
		this.precio=price;
	}
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	public String darPlato()
	{
		return plato;
	}

	public String darPrecio()
	{
		return precio;
	}



}
