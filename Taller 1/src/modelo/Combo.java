package modelo;



public class Combo
{
	// ************************************************************************
	// Atributos
	// ************************************************************************

	private String comboName;
	private double descuento;
	private String hamburguesa;
	private String papas;
	private String bebida;
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Combo(String combo, String desc, String ham,String papitas,String soda)
	{
		String descSinPorc = desc.replace("%", "");
		double descDouble = Double.parseDouble(descSinPorc);
		double descDecimal = descDouble / 100;
		
		this.comboName = combo;
		this.descuento = descDecimal;
		this.hamburguesa = ham;
		this.papas = papitas;
		this.bebida= soda;
	}
		
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	public String darCombo()
	{
		return comboName;
	}
		public double darDescuento()
	{
		return descuento;
	}
		public String darHamburguesa()
	{
		return hamburguesa;
	}
	
	public String darPapas()
	{
		return papas;
	}
	public String darBebida()
	{
		return bebida;
	}			
}