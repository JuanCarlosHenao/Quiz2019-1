package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SM {
	private Camara[] camaras;		
	private Vehiculo[] vehiculos;
	private Fotomulta[] fotomultas;
	private double precioVelocidad;
	private double precioAmarilloRojo;
	private double precioSoat;
	private double precioTecno;
	
	private Dato[] datos;
	
	public SM() {
		super();
	}

	public SM(Camara[] camaras, Vehiculo[] vehiculos, Fotomulta[] fotomultas) {
		super();
		this.camaras = camaras;
		this.vehiculos = vehiculos;
		this.fotomultas = fotomultas;
	}
	
	public SM(Fotomulta[] fotomultas) {
		super();
		this.fotomultas = fotomultas;
	}
	
	public Dato[] getDatos() {
		return datos;
	}

	public void setDatos(Dato[] datos) {
		this.datos = datos;
	}

	public Fotomulta[] getFotomultas() {
		return fotomultas;
	}
	public void setFotomultas(Fotomulta[] fotomultas) {
		this.fotomultas = fotomultas;
	}
	public Camara[] getCamaras() {
		return camaras;
	}
	public void setCamaras(Camara[] camaras) {
		this.camaras = camaras;
	}
	public Vehiculo[] getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(Vehiculo[] vehiculos) {
		this.vehiculos = vehiculos;
	}
	public double getPrecioVelocidad() {
		return precioVelocidad;
	}
	public void setPrecioVelocidad(double precioVelocidad) {
		this.precioVelocidad = precioVelocidad;
	}
	public double getPrecioAmarilloRojo() {
		return precioAmarilloRojo;
	}
	public void setPrecioAmarilloRojo(double precioAmarilloRojo) {
		this.precioAmarilloRojo = precioAmarilloRojo;
	}
	public double getPrecioSoat() {
		return precioSoat;
	}
	public void setPrecioSoat(double precioSoat) {
		this.precioSoat = precioSoat;
	}
	public double getPrecioTecno() {
		return precioTecno;
	}
	public void setPrecioTecno(double precioTecno) {
		this.precioTecno = precioTecno;
	}
	
	public void leerPrecios(String archivo ) throws IOException {
		File f=new File(archivo);
		FileReader fr=null;
		BufferedReader br=null;
		Dato d=null;
		
		try {
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			String linea;
			String tipo="";
			String precio="";
			String aux="";
			
			while ((linea=br.readLine())!=null && linea.compareTo("")!=0) {
				int i=0;
				while(linea.charAt(i)!=',') {
					tipo+=linea.charAt(i);
					i++;
				}
				
				for(int i2=i+2;i2<linea.length();i2++) {
					aux+=linea.charAt(i2);
					//precio=Double.parseDouble(aux);
					precio=aux;
				}
				
				d=new Dato(tipo,precio);
				if (datos==null) {
					datos=new Dato[1];
				}else {
					datos=Arrays.copyOf(datos, datos.length+1);
				}
				datos[datos.length-1]=d;
				tipo="";
				precio="";
				aux="";
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("no se abrio");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no se  leyó la linea ");
		}finally {
			br.close();
			fr.close();
		}
		
	}
	
	public Fotomulta[] buscarFMporVehiculo(String matricula) {
		Fotomulta[] fmsVehiculo=null;
		for(int i=0;i<fotomultas.length;i++) {
			if (fotomultas[i].getMatricula().compareTo(matricula)==0) {
				if (fmsVehiculo==null) {
					fmsVehiculo=new Fotomulta[1];
				}else {
					fmsVehiculo=Arrays.copyOf(fmsVehiculo, fmsVehiculo.length+1);
				}
				fmsVehiculo[fmsVehiculo.length-1]=fotomultas[i];
			}
		}
		return fmsVehiculo;
	}
	
	//1)
	public Fotomulta[] buscarNOpagadasporVehiculo(String matricula) {
		Fotomulta[] nopagadas=null;
		Fotomulta[] fmsVehiculo=buscarFMporVehiculo(matricula);
		for(int i=0;i<fmsVehiculo.length;i++) {
			if (fmsVehiculo[i].isPagada()==false) {
				if (nopagadas==null) {
					nopagadas=new Fotomulta[1];
				}else {
					nopagadas=Arrays.copyOf(nopagadas, nopagadas.length+1);
				}
				nopagadas[nopagadas.length-1]=fmsVehiculo[i];
			}
		}
		return nopagadas;
	}
		
	//nos piden este 
	public double precioMultasVehiculos(String matricula) {
		Fotomulta[] nopagadas=buscarNOpagadasporVehiculo(matricula);
		double total=0;
		for(int i=0;i<nopagadas.length;i++) {
			total+=nopagadas[i].getPrecio();
		}
		return total;
	}
	
	public double asignarPrecio(Fotomulta fotomulta) {
		int i=0;
		while(i<datos.length && datos[i].getTipo().compareTo(fotomulta.getTipo())!=0) {
			i++;
		}
		if (i<datos.length) {
			fotomulta.setPrecio(Double.parseDouble(datos[i].getPrecio()));
			return fotomulta.getPrecio();
		}else {
			return -1;
		}
	}
	
	public void addFotomulta(Fotomulta fotomulta) {
		
	}
	
	public Vehiculo buscarVehiculo(String matricula) {
		
	}
	
	
	
	
	
	

}
