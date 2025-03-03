//Sergio J. Velez Rosari
// Proyecto Final OOP
// Gestion De Productos

package example;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Codigo para que funcione el GUI
	SwingUtilities.invokeLater(()-> {
	GestionProductosGUI app = new GestionProductosGUI();
	app.setVisible(true);	
	});
	}

}
