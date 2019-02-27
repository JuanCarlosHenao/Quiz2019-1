package Clases;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	Camara c=new Camara();
		
		Fotomulta f1=new Soat("hoy", c, "fotosS", "soat", 5,"m1");
		Fotomulta f2=new Tecnomecanica("mañana", c, "fotosT", "tecnomecanica","m1");
		Fotomulta f3=new Velocidad("ayer", c, "fotosV", "velocidad", 156,"m2");
		Fotomulta f4=new Semaforo("antier", c, "fotosSema", "amarillo-rojo","fucsia", "indigo","m2");
		
		Fotomulta[] fms=new Fotomulta[4];
		fms[0]=f1;
		fms[1]=f2;
		fms[2]=f3;
		fms[3]=f4;

		SM s=new SM(fms);
		String ruta="C:\\Users\\LUIS FELIPE\\estructuras\\Quiz2019-1\\src\\Fotomultas.txt";
		
		try {
			s.leerPrecios(ruta);
			for (int i=0;i<s.getDatos().length;i++) {
				System.out.println(s.getDatos()[i].getTipo()+"-----"+s.getDatos()[i].getPrecio());
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println(s.asignarPrecio(f1));
		System.out.println(s.asignarPrecio(f2));
		System.out.println(s.asignarPrecio(f3));
		System.out.println(s.asignarPrecio(f4));
		System.out.println();
		System.out.println("La matricula del vehiculo de matricula m1 es: " + s.precioMultasVehiculos("m1"));
		
		
		

	}

}
