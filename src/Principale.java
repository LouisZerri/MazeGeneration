import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Principale {
	
	public static void main(String[] args) {
		
		JFrame object = new JFrame(); //instance JFrame
		
		Maze maze = new Maze(); //instance de Maze
		
		object.setBounds(10,10,687,590); //Dimension de la fenetre
		object.setTitle("Maze Generator"); //Titre de la fenetre
		
		object.setResizable(false); //Non redimensionable
		
		object.setVisible(true); //Creation d'une fenêtre
		
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		object.add(maze);
		
	}
	
	
}
