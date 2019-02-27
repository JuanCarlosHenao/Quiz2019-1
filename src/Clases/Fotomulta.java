package Clases;

public abstract class Fotomulta {
	private String fecha;
	private	Camara camara;
	private String carpeta;
	private String tipo;
	private boolean pagada;
	private double precio;
	
	private String matricula;
	
	public Fotomulta(String fecha, Camara camara, String carpeta, String tipo,String matricula ) {
		super();
		this.fecha = fecha;
		this.camara = camara;
		this.carpeta = carpeta;
		this.tipo = tipo;
		this.matricula=matricula;
		pagada=false;
		precio=0;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Camara getCamara() {
		return camara;
	}
	public void setCamara(Camara camara) {
		this.camara = camara;
	}
	public String getCarpeta() {
		return carpeta;
	}
	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isPagada() {
		return pagada;
	}
	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

}
