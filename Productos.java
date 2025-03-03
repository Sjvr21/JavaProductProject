package example;

public abstract class Productos {
	
	//Creamos la clase abstracta la cual tendra las variables 
	//Que heredaran las demas clases
	private String nombre;
	private double precio;
	private int cantidad;
	
	public Productos(String nombre, double precio, int cantidad) {
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	//Creamos el metodo abstracto
	public abstract double calcularCostoFinal();
	
	//Getter Nombre
	public String getNombre() {
		return nombre;
		
	}
	//Setter Nombre
	  public void setNombre(String nombre) {
		    this.nombre = nombre;
		  }
	
	  //Getter Precio
	public double getPrecio() {
		return precio;
	}
	
	//Setter Precio
	  public void setPrecio(double precio) {
		    this.precio = precio;
		  }
	
	  //Getter Cantidad
	public int getCantidad() {
		return cantidad;
	}
	//Setter Cantidad
	  public void setCantidad(int cantidad) {
		    this.cantidad = cantidad;
		  }
}
