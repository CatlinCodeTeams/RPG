package janus.engine;

import janus.engine.pens.SimplePen;
import janus.engine.pens.SimplestPen;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class SimpleGraphics implements SimpleGraphicalInterface {
	private final class WindowListner extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			if (endProgramOnClose) {
				System.exit(0);
			}
			SimpleGraphics.this.onClose();
			that.mainFrame.dispose();
			that.mainFrame.setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			SimpleGraphics.this.onOpen();
		}
	}

	class GamePanel extends Canvas {
		private final class TimerListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				final Graphics gotten = GamePanel.this.getGraphics();
				if (gotten != null) {
					if (!that.gamePanel.isVisible()) {
						System.exit(0);
					}
					GamePanel.this.updateComponent();
					GamePanel.this.drawCan();
					passedFrames++;
				}
			}

		}

		final class GamePanelComponentListener extends ComponentAdapter {
			@Override
			public void componentResized(ComponentEvent event) {
				if (gamePanel.getGraphics() != null) {
					final BufferStrategy b = that.gamePanel.getBufferStrategy();
					if (b != null) {
						myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
					}
					SimpleGraphics.this.onResize(myPen);
				}
			}
		}

		final class KeyListner implements KeyListener {

			@Override
			public void keyPressed(KeyEvent e) {
				ispresed.put(e.getKeyCode(), true);
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onKeyPressed(e, myPen);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				ispresed.put(e.getKeyCode(), false);
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onKeyReleased(e, myPen);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onKeyTyped(e, myPen);
			}

		}

		final class MouseListner implements MouseListener {
			@Override
			public void mouseClicked(MouseEvent event) {
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onMouseClicked(event, myPen);
			}

			@Override
			public void mouseEntered(MouseEvent event) {
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onMouseEntered(event, myPen);
			}

			@Override
			public void mouseExited(MouseEvent event) {
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onMouseExited(event, myPen);
			}

			@Override
			public void mousePressed(MouseEvent event) {
				mousePressed = true;
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onMousePressed(event, myPen);
			}

			@Override
			public void mouseReleased(MouseEvent event) {
				mousePressed = false;
				final BufferStrategy b = that.gamePanel.getBufferStrategy();
				if (b != null) {
					myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
				}
				SimpleGraphics.this.onMouseReleased(event, myPen);
			}
		}

		private static final long serialVersionUID = 1294739584;

		public void makeBuffer() {
			this.createBufferStrategy(2);
		}

		protected final void drawCan() {
			Graphics pen = null;
			final BufferStrategy b = this.getBufferStrategy();
			if (b != null) {
				pen = b.getDrawGraphics();
			}
			if (pen != null) {
				myPen.simplePen.pen = (Graphics2D) pen;
				pen.setColor(background);
				pen.fillRect(0, 0, panelWidth, panelHeight);
				pen.setColor(Color.BLACK);
				try {
					that.draw(myPen);
				} catch (final Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}

		protected final void updateComponent() {
			final BufferStrategy b = that.gamePanel.getBufferStrategy();
			if (b != null) {
				myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
			}
			if (myPen.simplePen.pen != null) {
				if (first) {
					try {
						that.start(myPen);
					} catch (final Exception e) {
						e.printStackTrace();
						System.exit(1);
					}
					first = false;
				}
				try {
					that.update(myPen);
				} catch (final Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}

		private GamePanel(int frames) {
			this.addMouseListener(new MouseListner());
			this.addComponentListener(new GamePanelComponentListener());
			this.addKeyListener(new KeyListner());
			new Timer((int) 1000f / frames, new TimerListener()).start();
			new Timer((int) 1000f / 70, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					final BufferStrategy b = GamePanel.this.getBufferStrategy();
					if (b != null) {
						b.show();
					}
				}
			}).start();
			this.setFocusable(true);
		}
	}

	public Color background = Color.BLACK;

	public HashMap<String, Clip> clips = new HashMap<String, Clip>();

	public boolean endProgramOnClose = false;

	public HashMap<String, Font> fonts = new HashMap<String, Font>();

	public HashMap<String, BufferedImage> imgs = new HashMap<String, BufferedImage>();
	public final HashMap<Integer, Boolean> ispresed = new HashMap<Integer, Boolean>();
	public final JFrame mainFrame;
	public boolean mousePressed = false;
	public int passedFrames = 0;
	public int panelHeight;
	public int panelWidth;
	public HashMap<String, AudioInputStream> sounds = new HashMap<String, AudioInputStream>();
	public final long startTime = System.nanoTime();
	public int xOff, yOff;
	public int xsOff, ysOff;
	public boolean camPause = false;
	protected final GamePanel gamePanel;
	protected final SimplestPen myPen = new SimplestPen(new SimplePen(null),
			this);
	protected final SimpleGraphics that = this;
	private boolean first = true;

	public void draw() {
		final BufferStrategy b = gamePanel.getBufferStrategy();
		if (b != null) {
			myPen.simplePen.pen = (Graphics2D) b.getDrawGraphics();
		}
		this.draw(myPen);
	}

	public void onClose() {
	}

	@Override
	public void onKeyPressed(KeyEvent event, SimplestPen pen) {
	}

	@Override
	public void onKeyReleased(KeyEvent event, SimplestPen pen) {
	}

	@Override
	public void onKeyTyped(KeyEvent event, SimplestPen pen) {
	}

	@Override
	public void onMouseClicked(MouseEvent event, SimplestPen pen) {
	}

	@Override
	public void onMouseEntered(MouseEvent event, SimplestPen pen) {
	}

	@Override
	public void onMouseExited(MouseEvent event, SimplestPen pen) {
	}

	@Override
	public void onMousePressed(MouseEvent event, SimplestPen pen) {
	}

	@Override
	public void onMouseReleased(MouseEvent event, SimplestPen pen) {
	}

	public void onOpen() {
	}

	@Override
	public void onResize(SimplestPen pen) {
	}

	protected SimpleGraphics(int width, int height, String name) {
		this(width, height, name, 60);
	}

	protected SimpleGraphics(int width, int height, String name, int frames) {
		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		gamePanel = new GamePanel(frames);
		panelWidth = width;
		panelHeight = height;
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		mainFrame = new JFrame();
		mainFrame.setName(name);
		mainFrame.setTitle(name);
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setSize(width, height);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowListner());
		gamePanel.makeBuffer();

	}
}
