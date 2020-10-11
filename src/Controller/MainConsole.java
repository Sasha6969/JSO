package Controller;

import java.io.IOException;
import View.ControllerView;

public class MainConsole {

	public static void main(String[] args) throws IOException {
		ControllerView start = new ControllerView();
		start.mainMenu();
	}

}
