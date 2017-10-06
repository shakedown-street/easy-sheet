package legacy;

import java.awt.Dimension;

import javax.swing.JFrame;

import legacy.ui.UserInterface;

public class Launcher {

	private JFrame frame;
	private UserInterface ui;
	
	private Launcher(UserInterface _ui) {
		ui = _ui;
		frame = new JFrame("EasySheet");
		frame.setSize(800, (800 / 16) * 9);
		frame.setMinimumSize(new Dimension(735, (735 / 16) * 9));
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(ui);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Launcher(new UserInterface());
	}
}
