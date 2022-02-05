
package loader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;

public class LoaderBurgers
{

	public static calculator cargarArchivo(String archivo1, String archivo2,String archivo3) throws FileNotFoundException, IOException
	{
		Map<String, Combo> combo = new HashMap<>();
		Map<String, Ingrediente> ingredientes = new HashMap<>();
		Map<String, ProductoMenu> menu = new HashMap<>();

		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
		String linea1 = br1.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									// las columnas
		BufferedReader br2 = new BufferedReader(new FileReader(archivo2));
		String linea2 = br2.readLine();
		
		BufferedReader br3 = new BufferedReader(new FileReader(archivo3));
		String linea3 = br3.readLine();
		
		
		while (linea1 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una línea
			String[] partes = linea1.split(";");
			String nombreCombo = partes[0];
			String descuento = partes[1];
			String hamburguesa = partes[2];
			String papas = partes[3];
			String bebida = partes[4];
			

			// Si no se había encontrado antes a ese atleta, se agrega como un nuevo atleta.
			// Acá suponemos que no hay atletas con el mismo nombre
			Combo elCombo = combo.get(nombreCombo);
			if (elCombo == null)
			{
				elCombo = new Combo(nombreCombo, descuento, hamburguesa,papas,bebida);
				combo.put(nombreCombo, elCombo);
			}

			linea1 = br1.readLine(); // Leer la siguiente línea
		}

		br1.close();
		while (linea2 != null)
		{
			String[] partes2 = linea2.split(";");
			String ingrediente = partes2[0];
			String precio = partes2[1];
			Ingrediente elIngrediente = ingredientes.get(ingrediente);
			
			if (elIngrediente == null)
			{
				elIngrediente = new Ingrediente (ingrediente, precio);
				ingredientes.put(ingrediente, elIngrediente);
			}
			linea2 = br2.readLine();
			
		}
		
		br2.close();
		while (linea3 != null) 
		{
			String[] partes3=linea3.split(";");
			String plato = partes3[0];
			String precio = partes3[1];
			ProductoMenu elMenu = menu.get(plato);
			
			if (elMenu== null)
			{
				elMenu=new ProductoMenu(plato,precio);
				menu.put(plato, elMenu);
				
			}
			linea3 = br3.readLine();
		}
		br3.close();
		

		calculator calculadora = new calculator(combo, ingredientes, menu);
		return calculadora;
	}
}