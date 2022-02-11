package modelo;

public class ProductoMenu implements Producto {
	
	// ************************************************************************
			// Atributos
			// ************************************************************************

			private String plato;
			private double precio;
			private String textoFactura;
			private double cal; 

	public ProductoMenu(String plate, String price, String cal) 
	{
		this.plato =plate;
		double precioDouble = Double.parseDouble(price);
		this.precio = precioDouble;
		double calnum= Double.parseDouble(cal);
		this.cal = calnum;
		this.textoFactura = plato + " | $" + precio + " | cals." + cal;
	}
	
	// ************************************************************************
	// Métodos para consultar los atributos
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
	
	public double darCal( ) {
		return cal;
	}



}
