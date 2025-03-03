package example;

public class ProductoFisico extends Productos {
	
	//Inicializamos las variables que utilizaran los productosFisicos y creamos un constructor
	private double costoEnvio;
	public ProductoFisico(String nombre, double precio, int cantidad, double costoEnvio) {
		super(nombre, precio, cantidad);
		this.costoEnvio = costoEnvio;
	}

	//Colocamos la formula en el metodo abstracto para calcular el costo final
	@Override
	public double calcularCostoFinal() {
		// TODO Auto-generated method stub
		return (getPrecio() * getCantidad()) + costoEnvio;
	}
	
	//Creamos un getter para el costo de envio
	public double getCostoEnvio() {
		return costoEnvio;
	}
	
	//Creamos un setter para el costo de envio
	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}
	
}
