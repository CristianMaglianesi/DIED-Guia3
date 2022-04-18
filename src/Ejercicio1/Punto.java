package Ejercicio1;

public class Punto {
	/////vars
	private float x;
	private float y;
	
	/////g&s 
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	/////constructores
	
	public Punto(float x, float y) {
		this.setX(x);
		this.setY(y);
	}
	
	/////metodos
	
	public boolean equals(Object otroPunto) {
		boolean ret = false;
		if (getClass() == otroPunto.getClass()) {
			if (this.getX() == ((Punto) otroPunto).getX() &&
					this.getY() == ((Punto) otroPunto).getY()) {
				ret = true;
			}
		}
		return ret;
		
	}
	

}
