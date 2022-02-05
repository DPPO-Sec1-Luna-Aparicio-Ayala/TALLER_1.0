package modelo;

public class Combo
{
	// ************************************************************************
	// Atributos
	// ************************************************************************

	private String comboname;
	private String descuento;
	private String hamburguesa;
	private String papas;
	private String bebida;
	
	
	// ************************************************************************
		// Constructores
		// ************************************************************************

		public Combo(String combo,String desc, String ham,String papitas,String soda)
		{
			this.comboname = combo;
			this.descuento = desc;
			this.hamburguesa = ham;
			this.papas = papitas;
			this.bebida= soda;
		}
		
		// ************************************************************************
		// Métodos para consultar los atributos
		// ************************************************************************
		public String darCombo()
		{
			return comboname;
		}

		public String darDescuento()
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