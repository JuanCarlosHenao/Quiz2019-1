package Clases;

public class Semaforo extends Fotomulta {
	private String cCamara;
	private String cExtremo;
	
	
	public Semaforo(String fecha, Camara camara, String carpeta, String tipo, String cCamara,
			String cExtremo,String matricula) {
		super(fecha, camara, carpeta, tipo, matricula);
		
		// TODO Auto-generated constructor stub
		
		this.cCamara=cCamara;
		this.cExtremo=cExtremo;
	}
	
	
	
	
	
	

}
