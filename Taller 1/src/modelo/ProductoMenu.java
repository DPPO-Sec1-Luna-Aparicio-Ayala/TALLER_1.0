package modelo;

public class ProductoMenu implements Producto {
	
	// ************************************************************************
			// Atributos
			// ************************************************************************

			private String plato;
			private double precio;

	public ProductoMenu(String plate, String price) 
	{
		this.plato =plate;
		double precioDouble = Double.parseDouble(price);
		this.precio = precioDouble;
	}
	
	// ************************************************************************
	// M�todos para consultar los atributos
	// ************************************************************************
	public String darNombre()
	{
		return plato;
	}

	public double darPrecio()
	{
		return precio;
	}
	
	public String darTextoFactura()
	{
		return "a";
	}



}
