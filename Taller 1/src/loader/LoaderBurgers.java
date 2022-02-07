
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

	public static Restaurante cargarArchivo(String archivo1, String archivo2,String archivo3) throws FileNotFoundException, IOException
	{
		Map<String, Combo> combos = new HashMap<>();
		Map<String, Ingrediente> ingredientes = new HashMap<>();
		Map<String, ProductoMenu> menu = new HashMap<>();

		// Abrir el archivo y leerlo l�nea por l�nea usando un BufferedReader
		BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
		String linea1 = br1.readLine(); 
		
		BufferedReader br2 = new BufferedReader(new FileReader(archivo2));
		String linea2 = br2.readLine();
		
		BufferedReader br3 = new BufferedReader(new FileReader(archivo3));
		String linea3 = br3.readLine();
		
		linea1 = br1.readLine();
		while (linea1 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una l�nea
			String[] partes = linea1.split(";");
			String nombreCombo = partes[0];
			String descuento = partes[1];
			String hamburguesa = partes[2];
			String papas = partes[3];
			String bebida = partes[4];
			

			// Si no se hab�a encontrado antes a ese atleta, se agrega como un nuevo atleta.
			// Ac� suponemos que no hay atletas con el mismo nombre
			
			Combo elCombo = combos.get(nombreCombo);
			if (elCombo == null)
			{
				elCombo = new Combo(nombreCombo, descuento, hamburguesa,papas,bebida);
				combos.put(nombreCombo, elCombo);
			 
			}

			linea1 = br1.readLine(); // Leer la siguiente línea
		}

		br1.close();
		
		linea2 = br2.readLine();
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
<<<<<<< HEAD
		int o = 1;
=======
		
		linea3 = br3.readLine();
>>>>>>> a784944e52cc90600082aa915c58418a91fa84f0
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
				
				System.out.println(o + ". " + plato + " " + precio);
				o += 1;
			}
			linea3 = br3.readLine();
		}
		br3.close();
		/**
		for (int i = 0; i < menu.size(); i++)
		{
				
				ProductoMenu Plato = menu.get(i);
				ProductoMenu Precio = menu.get(i);
				System.out.println(Plato);
		}
		*/
	

<<<<<<< HEAD
		Restaurante calculadora = new Restaurante(combo, ingredientes, menu);
		
=======
		Restaurante calculadora = new Restaurante(combos, ingredientes, menu);
>>>>>>> a784944e52cc90600082aa915c58418a91fa84f0
		return calculadora;
	}

}

