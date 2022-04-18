package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

import Ejercicio2.Escala;
import Ejercicio2.Temperatura;

public class Registro {
	////vars
	static  int MAX_REGISTROS = 30;
	private String ciudad;
	private List<Temperatura> historico;
	
	////g&s
	
	public String getCiudad() {
		return ciudad;
	}

	////constructores

	public Registro(String ciudad, List<Temperatura> historico) {
		this.ciudad = ciudad;
		this.historico = historico;
	}

	public Registro (String ciudad) {
		this(ciudad, new ArrayList<>());
	}

	public Registro() {
		this("-");
	}

	////metodos
	
	public void imprimir() {
		int i= 1;
		System.out.println("TEMPERATURAS REGISTRADAS EN :" + this.ciudad);
		for (Temperatura unaTemperatura:historico) {
			System.out.println(i + " " +unaTemperatura.asCelcius() +" Cº");
			i++;
		}
	}
	
	public void agregar(Temperatura nueva) {
		if (historico.size()<MAX_REGISTROS) {
			historico.add(nueva);
		}
	}
	
	public Temperatura mediaAsCelcius() {
		float sumatoria = 0;
		int cant = historico.size();
		
		for (Temperatura unaTemperatura : historico) {
			sumatoria += unaTemperatura.asCelcius();
		}
		Temperatura media = new Temperatura(sumatoria / cant, Escala.CELCIUS);
		
		return media;
	}
	
	public Temperatura mediaAsFahrenheit() {
		float sumatoria = 0;
		int cant = historico.size();
		
		for (Temperatura unaTemperatura : historico) {
			sumatoria += unaTemperatura.asFahrenheit();
		}
		Temperatura media = new Temperatura(sumatoria / cant, Escala.FAHRENHEIT);
		
		return media;
	}
	
	private Temperatura maximo(List<Temperatura> lista) {
		Temperatura ret;
		//Caso base, lista vacia;
		if (lista == null || lista.isEmpty()) {
			ret = null;		
		}
		//Caso base, unica temperatura;
		if (lista.size()==1) {
			ret = lista.get(0);
		}
		//caso recursivo
		else {
			int medio = lista.size()/2;
			List <Temperatura> izq = lista.subList(0, medio);
			List <Temperatura> der = lista.subList(medio, lista.size());
			Temperatura maxizq = maximo(izq);
			Temperatura maxder = maximo (der);
			
			ret = (maxizq.asCelcius() > maxder.asCelcius()) ? maxizq : maxder;
		}
		return ret;
	}
	
	public Temperatura maximo() {
		Temperatura ret = this.maximo(historico);
		return ret;
	}
}
