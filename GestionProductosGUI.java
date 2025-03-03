//Sergio J. Velez Rosario
//Proyecto Final OOP
//07/12/2024
package example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionProductosGUI  extends JFrame{
	//Creacion de el arreglo
	private ArrayList<Productos> productos;
	
	
	private DefaultTableModel tableModel;
	
	public GestionProductosGUI() {
		productos = new ArrayList<Productos>();
		
		//Titulo
		setTitle("Gestion De Productos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tamaño del interaz
		setSize(800,600);
		
		setLayout(new BorderLayout());
		
		JPanel inputPanel = new JPanel(new GridLayout( 6,2,10,10));
		inputPanel.setBorder(BorderFactory.createTitledBorder("Agregar Producto"));
		
		//Creamos los campos de texto
		JTextField nombreField = new JTextField();
		JTextField precioField = new JTextField();
		JTextField cantidadField = new JTextField();	//Creacion de arreglo para el combo box
		JComboBox<String>tipoCombo = new JComboBox(new String[] {"Fisico", "Digital"});
		JTextField costoExtraField = new JTextField();
		
		//Creamos los botones de agregar e eliminar
		JButton addButton = new JButton("Agregar");
		JButton deleteButton = new JButton("Eliminar");
		
		//Añadimos los labels a los campos de texto 
		inputPanel.add(new JLabel("Nombre: "));
		inputPanel.add(nombreField);
		inputPanel.add(new JLabel("Precio: "));
		inputPanel.add(precioField);
		inputPanel.add(new JLabel("Cantidad: "));
		inputPanel.add(cantidadField);
		inputPanel.add(new JLabel("Tipo: "));
		inputPanel.add(tipoCombo);
		inputPanel.add(new JLabel("Envio/Licencia: "));
		inputPanel.add(costoExtraField);
		
		//Creamos la tabla 
		tableModel = new DefaultTableModel(new String[] {"Productos", "Costo Total"},0);
		
		JTable table = new JTable(tableModel);
		//Creacion de el scroll en la tabla
		JScrollPane scroll = new JScrollPane(table);
		
		
		//Aqui comienza la accion del boton de agregar la cual llama al metodo de agregar productos
		addButton.addActionListener(e -> agregarProducto(nombreField, precioField, cantidadField, tipoCombo, costoExtraField));
			
			
		//El delete boton realiza la accion de llamar a la funcion eliminarProducto
		deleteButton.addActionListener(e -> eliminarProducto(table));
		
		//Creamos un panel para los botones
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		
		//Añadimos el panel de input, el scroll, y las tablas
		add(inputPanel,BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		
	}
	
	//Esta funcion se encarga de actualizar las tablas
	private void actualizarTabla() {
		tableModel.setRowCount(0);
		for(Productos productos : productos) {
			tableModel.addRow(new Object[] {productos.getNombre(),productos.calcularCostoFinal()});
		}
	}
	
	
	//Este metodo se encarga de agregar los productos
	private void agregarProducto(JTextField nombreField, JTextField precioField, JTextField cantidadField, JComboBox<String> tipoCombo, JTextField costoExtraField) {
		try 
		{
			
			// Si el usuario entra una variable que no corresponde en el campo
			// El programa le enviara una alerta customizada dependiendo de el campo
			// Utilizando el try Catch podemos atrapar el error e informarle
			String nombre = nombreField.getText().trim();
			if(nombre.isEmpty()) {
				throw new IllegalArgumentException("El nombre no puede estar en blanco");
			}
			
	        double precio = Double.parseDouble(precioField.getText().trim());
	        if (precio < 0) {
	            throw new IllegalArgumentException("El precio no puede ser negativo.");
	        }
			
			
			int cantidad = Integer.parseInt(cantidadField.getText().trim());	
			if(cantidad < 0) {
				throw new IllegalArgumentException("La cantidad no puede ser negativa");
			}
			
			
			String tipo = (String) tipoCombo.getSelectedItem();
			
			double costoExtra = Double.parseDouble(costoExtraField.getText().trim());
			if (costoExtra < 0) {
				throw new IllegalArgumentException("El costo extra no puede ser negativo");
			}
			
			
			//Aqui se determina si el producto es fisico o digital
			if(tipo.equals("Fisico")) {
				productos.add(new ProductoFisico(nombre,precio,cantidad,costoExtra));
			} else {
				productos.add(new ProductoDigital(nombre,precio,cantidad,costoExtra));
			}
			
			//Actualizamos la tabla
			actualizarTabla();
			
			//Aqui se ponen en blanco los campos 
			nombreField.setText("");
			precioField.setText("");
			cantidadField.setText("");
			costoExtraField.setText("");
		
		}
		//Un catch por si hay valores invalidos
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese datos validos", "Error",JOptionPane.ERROR_MESSAGE);
			
			
		}
		//Otro catch para mostrar errores dependiendo de el campo invalido
		catch(IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error :(", JOptionPane.ERROR_MESSAGE);
		}
		
	};
		

	
	//Esta funcion se encarga de eliminar un producto de la tabla al ser seleccionado
	// Si no esta seleccionado, este le envia un mensaje de error al usuario dejandole saber 
	private void eliminarProducto(JTable table) {
		int selectedRow = table.getSelectedRow();
		
		if(selectedRow != -1) {
			productos.remove(selectedRow);
			actualizarTabla();
			JOptionPane.showMessageDialog(this, "Producto Eliminado Correctamente.", "WEPA", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(this, "Por favor seleccione un producto para eliminar.","Error :(",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
