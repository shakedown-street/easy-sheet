package v2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import v2.states.ErrorState;
import v2.states.HomeState;

@SuppressWarnings("serial")
public class App extends Canvas implements Runnable {
	
	private int viewWidth, viewHeight;
	private AppRouter appRouter;

	private Thread thread;
	private final static int MAX_FPS = 30;
	private final static int BUFFERS = 2;
	
	private final Font INTERFACE_FONT = new Font("Lucida Console", Font.BOLD, 10);
	
	public App(int _width, int _height) {
		setDimensions(viewWidth, viewHeight);
		setFocusable(true);
		
		appRouter = new AppRouter("/app/home/");
		appRouter.registerStates(new HomeState(), new ErrorState());
		appRouter.setErrorState("/app/error/");
	}
	
	public void setDimensions(int _width, int _height) {
		viewWidth = _width;
		viewHeight = _height;
		setMinimumSize(new Dimension(_width, _height));
		setMaximumSize(new Dimension(_width, _height));
		setSize(new Dimension(_width, _height));
	}
	
	private void update() {
		// update
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(BUFFERS);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, viewWidth, viewHeight);
		
		// Render
		renderState(g);

		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		long lastFPSTime = System.currentTimeMillis();
		int fps = 0;
		long then = System.nanoTime();
		double unprocessed = 0d;
		double nsPerFrame = 1000000000.0d / MAX_FPS;
		while (true) {
			long now = System.nanoTime();
			unprocessed += (now - then) / nsPerFrame;
			then = now;
			boolean canRender = false;
			while (unprocessed >= 1) {
				update();
				canRender = true;
				unprocessed -= 1;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (canRender) {
				render();
				fps++;
			}
			if (System.currentTimeMillis() - lastFPSTime > 1000) {
				lastFPSTime = System.currentTimeMillis();
				fps = 0;
			}
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}
	
	public void renderState(Graphics g) {
		if (appRouter.getState() != null) {
			appRouter.getState().render(g);
		}
	}

}
