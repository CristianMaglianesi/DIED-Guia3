package Ejercicio2;

public class Temperatura {
	private double grados;
	private Escala escala;

	public Temperatura() {
		this.setGrados(0f);
		this.setEscala(Escala.CELCIUS);
	}

	public Temperatura(double grados, Escala escala) {
		this.setGrados(grados);
		this.setEscala(escala);

	}

	public double getGrados() {
		return grados;
	}
	public void setGrados(double grados) {
		this.grados = grados;
	}
	public Escala getEscala() {
		return escala;
	}
	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public String toString() {
		if (escala == Escala.CELCIUS)
		{
			return (Double.toString(grados) + " C°");
		}
		else {
			return (Double.toString(grados) + " F°");
		}
	}

	public double asCelcius(){
		double ret;
		if (escala == Escala.CELCIUS) {
			ret = grados;
		}
		else {
			ret = ((grados -32) *5/9);
		}
		return ret;
	}

	public double asFahrenheit(){
		double ret;
		if (escala == Escala.FAHRENHEIT) {
			ret = grados;
		}
		else {
			ret = ((grados *9/5)+32);
		}
		return ret;
	}

	public void aumentar(Temperatura modifica) {
		if (modifica.getGrados() > 0f) {
			if(this.getEscala() == Escala.CELCIUS) {
				this.setGrados(this.getGrados()+modifica.asCelcius());
			}
			else {
				this.setGrados(this.getGrados()+modifica.asFahrenheit());
			}
		}
	}

	public void disminuir(Temperatura modifica) {
		if (modifica.getGrados() > 0f) {
			if(this.getEscala() == Escala.CELCIUS) {
				this.setGrados(this.getGrados()-modifica.asCelcius());
			}
			else {
				this.setGrados(this.getGrados()-modifica.asFahrenheit());
			}
		}
	}
}
