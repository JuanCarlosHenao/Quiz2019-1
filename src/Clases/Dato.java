package Clases;

public class Dato {
	private String tipo;
	private String precio;
	
	public Dato(String tipo, String precio) {
		super();
		this.tipo = tipo;
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}

}
