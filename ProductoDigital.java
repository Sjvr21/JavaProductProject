package example;

public class ProductoDigital extends Productos {
	
	//Inicializamos las variables que utilizaran los productosDigitales y creamos un constructor
	private double costoLicencia;
	public ProductoDigital(String nombre, double precio, int cantidad, double costoLicencia) {
		super(nombre, precio, cantidad);
		this.costoLicencia = costoLicencia;
	}

	//Colocamos la formula en el metodo abstracto para calcular el costo final
	@Override
	public double calcularCostoFinal() {
		return (getPrecio() * getCantidad()) + costoLicencia;
	}
	
	//Creamos un getter para el costo de la licencia
	public double getCostoLicencia() {
		return costoLicencia;
	}
	
	//Creamos un setter para el costo de la licencia
	public void setCostoLicencia(double costoLicencia) {
		this.costoLicencia = costoLicencia;
	}

}
