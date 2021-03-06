package modelo;

public class ProductoMenu implements Producto {
	
	// ************************************************************************
			// Atributos
			// ************************************************************************

			private String plato;
			private double precio;
			private String textoFactura;

	public ProductoMenu(String plate, String price) 
	{
		this.plato =plate;
		double precioDouble = Double.parseDouble(price);
		this.precio = precioDouble;
		this.textoFactura = plato + " | $" + precio;
	}
	
	// ************************************************************************
	// M?todos para consultar los atributos
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
		return textoFactura;
	}



}
