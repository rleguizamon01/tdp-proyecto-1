package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student estudiante = new Student(
            			129210, 
            			"Leguizamón Salinas", 
            			"Rodolfo Emilio", 
            			"leguizamon.rodolfo@gmail.com", 
            			"https://github.com/rleguizamon01", 
            			"/images/personal_image.jpg"
            			);
            	new SimplePresentationScreen(estudiante);
            	
            }
        });
    }
}