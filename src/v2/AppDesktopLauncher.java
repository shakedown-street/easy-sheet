package v2;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AppDesktopLauncher extends JFrame {

	private App app;

	public AppDesktopLauncher(App _app) {
		super(String.format("$s - Revision: $d - $s MODE", AppConfig.NAME,
				AppConfig.REVISION, AppConfig.ENV));
		app = _app;
		
		add(app);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AppDesktopLauncher(new App(800, (800 / 16) * 9));
	}

}
