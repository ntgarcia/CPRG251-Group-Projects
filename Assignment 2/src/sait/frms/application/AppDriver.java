package sait.frms.application;

import sait.frms.gui.MainWindow;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sait.frms.gui.*;

/**
 * Application driver.
 * 
 */
public class AppDriver {
 
	/**
	 * Entry point to Java application.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());

		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		MainWindow mainWindow = new MainWindow();
		
		mainWindow.addWindowListener(new WindowAdapter() {
		    @Override
		      public void windowClosing(WindowEvent we) {
		        JOptionPane.showMessageDialog(null,"Thank you for using our service");
		        System.exit(0);
		      }
		    } );
		
		mainWindow.display();
	}

}
