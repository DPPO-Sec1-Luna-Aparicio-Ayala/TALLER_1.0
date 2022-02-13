package modelo;

import java.util.Map;

public class Combo implements Producto
{
	// ************************************************************************
	// Atributos
	// ************************************************************************

	private String comboName;
	private double descuento;
	private ProductoMenu hamburguesa;
	private ProductoMenu papas;
	private Bebidas bebida;
	private double precio;
	private String textoFactura;
	private double cal;
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Combo(String combo, String desc, String ham,String papitas,String soda,String cal, Map<String, ProductoMenu> menuProductos, Map<String, Bebidas> menuBebidas)
	{
		String descSinPorc = desc.replace("%", "");
		double descDouble = Double.parseDouble(descSinPorc);
		double descDecimal = descDouble / 100;
		double calnum= Double.parseDouble(cal);
		
		this.comboName = combo;
		this.descuento = descDecimal;
		this.hamburguesa = menuProductos.get(ham);
		this.papas = menuProductos.get(papitas);
		this.bebida= menuBebidas.get(soda);
		double precio1 = hamburguesa.darPrecio()* descuento;
		double precio2 = papas.darPrecio()* descuento;
		double precio3 =bebida.darPrecio()* descuento;
		double preciof= precio1 +precio2 + precio3;
		this.precio = preciof;
		this.cal = calnum;
		this.textoFactura = comboName + " | $" + precio + " | cals." + cal ;
		
	}
		
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	public String darNombre()
	{
		return comboName;
	}
	
	public String darTextoFactura()
	{
		return textoFactura;
	}
	
	public double darDescuento()
	{
		return descuento;
	}
		
	public ProductoMenu darHamburguesa()
	{
		return hamburguesa;
	}
	
		
	public ProductoMenu darPapas()
	{
		return papas;
	}
	
	public Bebidas darBebida()
	{
		return bebida;
	}		
	
	public double darPrecio()
	{
		return precio;
	}
	
	public double darCal( ) {
		return cal;
	}
}