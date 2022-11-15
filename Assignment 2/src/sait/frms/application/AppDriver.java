package sait.frms.application;

import sait.frms.gui.MainWindow;


import java.io.FileNotFoundException;

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
		mainWindow.display();
	}

}
