import java.util.ArrayList;
import java.util.List;

public class LoggingPrueba {

	public static void main(String[] args) {
		Persona cliente1 = new Persona("Martin", 1000);
		Persona cliente2 = new Persona("Manu", 300);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("yerba", 250));
		productos.add(new Producto("cerveza", 150));
		productos.add(new Producto("cerveza", 150));
		productos.add(new Producto("cerveza", 150));
		
		Tienda tienda = new Tienda(productos);
		
		tienda.comprar(cliente1, "yerba");
		tienda.comprar(cliente2, "yerba");
		tienda.comprar(cliente2, "cerveza");
		tienda.comprar(cliente2, "cerveza");
		tienda.comprar(cliente2, "cerveza");
		
		
	}
	
	
}
