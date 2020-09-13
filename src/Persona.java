
public class Persona {
	private String nombre;
	private float dinero;
	
	public Persona(String nombre, float dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getDinero() {
		return this.dinero;
	}
	
	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	
	public void pagar(float dinero) {
		if(this.dinero >= dinero) {
			this.dinero -= dinero;
		}
	}

}
