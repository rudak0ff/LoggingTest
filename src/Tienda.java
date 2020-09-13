import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;

public class Tienda {
	
	private List<Producto> stock;
	private float dinero;
	private static Logger logger;
	
	public Tienda(List<Producto> stock) {
		this.stock = stock;
		this.dinero = 0;
		if (logger == null){
			
			logger = Logger.getLogger(Tienda.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
		
	}
	
	public void setStock(List<Producto> stock) {
		this.stock = stock;
	}
	
	public List<Producto> getStock(){
		return this.stock;
	}
	
	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	
	public float getDinero() {
		return this.dinero;
	}
	
	public Producto comprar(Persona cliente, String nombre) {
		Producto p = null;
		
		int index = this.stock.indexOf(new Producto(nombre));
		
		logger.fine(nombre + " se encuentra en posición " + index);
		if (index >= 0){
			Producto found = this.stock.get(index);
			if (cliente.getDinero() >= found.getValor()){
				p = this.stock.get(index);
				this.stock.remove(index);
				cliente.pagar(p.getValor());
				this.dinero += p.getValor();
				logger.info("saldo de la tienda " + this.dinero);
				logger.info("el cliente " + cliente.getNombre() + " ha comprado " + nombre);
			}else {	
				logger.warning("cliente " + cliente.getNombre() + " no tiene dinero sufiente"+  " para producto " + nombre);
			}
			
		}else {
			logger.warning("el producto " + nombre + " no está disponible");
		}
		
		return p;
	}
}
