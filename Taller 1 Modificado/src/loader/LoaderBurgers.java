
package loader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import modelo.Bebidas;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;

public class LoaderBurgers
{

	public static Restaurante cargarArchivo(String archivo1, String archivo2,String archivo3, String archivo4) throws FileNotFoundException, IOException
	{
		Map<String, Combo> combos = new HashMap<>();
		Map<String, Ingrediente> ingredientes = new HashMap<>();
		Map<String, ProductoMenu> menu = new HashMap<>();
		Map<String, Bebidas> bebidas= new HashMap<>();

		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
		String linea1 = br1.readLine(); 
		
		BufferedReader br2 = new BufferedReader(new FileReader(archivo2));
		String linea2 = br2.readLine();
		
		BufferedReader br3 = new BufferedReader(new FileReader(archivo3));
		String linea3 = br3.readLine();
		
		BufferedReader br4 = new BufferedReader(new FileReader(archivo4));
		String linea4 = br4.readLine();
		
		while (linea4 != null) 
		{
			String[] partes4=linea4.split(";");
			String bebida = partes4[0];
			String precio = partes4[1];
			String cal= partes4[2];
			Bebidas laBebida = bebidas.get(bebida);
			
			if (laBebida == null)
			{
				laBebida=new Bebidas(bebida,precio,cal);
				bebidas.put(bebida, laBebida);
				
				//System.out.println( ". " + bebida + " " + precio + cal);
				//o += 1;
			}
			linea4 = br4.readLine();
		}
		br4.close();
		
		
		while (linea2 != null)
		{
			String[] partes2 = linea2.split(";");
			String ingrediente = partes2[0];
			String precio = partes2[1];
			String cal = partes2[2];
			Ingrediente elIngrediente = ingredientes.get(ingrediente);
			
			if (elIngrediente == null)
			{
				elIngrediente = new Ingrediente (ingrediente, precio,cal);
				ingredientes.put(ingrediente, elIngrediente);
				
				//System.out.println( ". " + ingrediente + " " + precio + " " +cal);
			}
			linea2 = br2.readLine();
			
		}
		
		br2.close();

		//int o = 1;
		while (linea3 != null) 
		{
			String[] partes3=linea3.split(";");
			//System.out.println(partes3[1]);
			String plato = partes3[0];
			String precio = partes3[1];
			String cal = partes3[2];
			ProductoMenu elMenu = menu.get(plato);
			
			if (elMenu== null)
			{
				elMenu=new ProductoMenu(plato,precio,cal);
				menu.put(plato, elMenu);
				
				//System.out.println(o + ". " + plato + " " + precio);
				//o += 1;
			}
			linea3 = br3.readLine();
		}
		br3.close();
		
		while (linea1 != null) // Cuando se llegue al final del archivo, linea tendrÃ¡ el valor null
		{
			// Separar los valores que estaban en una línea
			String[] partes = linea1.split(";");
			String nombreCombo = partes[0];
			String descuento = partes[1];
			String hamburguesa = partes[2];
			String papas = partes[3];
			String bebida = partes[4];
			String cal = partes[5];
			

			// Si no se había encontrado antes a ese atleta, se agrega como un nuevo atleta.
			// Acá suponemos que no hay atletas con el mismo nombre
			
			Combo elCombo = combos.get(nombreCombo);
			if (elCombo == null)
			{
				elCombo = new Combo(nombreCombo, descuento, hamburguesa, papas, bebida, cal, menu, bebidas);
				combos.put(nombreCombo, elCombo);
			 
			}

			linea1 = br1.readLine(); // Leer la siguiente lÃ­nea
		}

		br1.close();/**
		for (int i = 0; i < menu.size(); i++)
		{
				
				ProductoMenu Plato = menu.get(i);
				ProductoMenu Precio = menu.get(i);
				System.out.println(Plato);
		}
		*/
	
		Restaurante restaurante = new Restaurante(combos, ingredientes, menu, bebidas);
		return restaurante;
	}

}

