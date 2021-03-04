package application;

import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		// Create a menu for user to make a choice and begin the program
		Menu menu = new Menu();
		try {
			menu.start();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}