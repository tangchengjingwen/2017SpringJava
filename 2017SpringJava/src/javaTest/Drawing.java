package javaTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Drawing extends JFrame { // edu.stevens.Drawing
	private DrawingArea d;
	public Drawing() {
		super("Drawing");
		setSize(800, 600);
		Container c = getContentPane();
		Font f = new Font("Helvetica", Font.BOLD, 25);
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 0, 255));
		p.setLayout(new GridLayout(5, 2, 5, 10));
		JButton b = new JButton("clear");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.clear();
			}});
		p.add(b);
		for (int i = 0; i < 9; i++) {
			b = new JButton("ok");
			b.setFont(f);
			p.add(b);
		}
		c.add(p, BorderLayout.WEST);
		d = new DrawingArea();
		c.add(d, BorderLayout.CENTER);
		addWindowListener(new MyWindowListener());
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Drawing();
	}
}

class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class DrawingArea extends JPanel {
	private ArrayList<Shape> shapes;
	public DrawingArea() {
		shapes = new ArrayList<Shape>();
		//shapes.add(new Circle(200,300, 150));
		//shapes.add(new Rect(100,50, 200,100));
		//shapes.add(new Circle(300,200,100));
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		MyMouseListener m = new MyMouseListener();
		addMouseListener(m   );
		addMouseMotionListener(m);
	}
	public void clear() {
		shapes.clear();
		repaint();
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
//		for (int i = 0; i < shapes.size(); i++)
//			shapes.get(i).paint(g);
		for (Shape s : shapes) {
			s.paint(g);
		}
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {
		private int x, y;
		private int lastX, lastY;
		@Override public void mouseClicked(MouseEvent e) {
		}
		@Override public void mousePressed(MouseEvent e) {
			x = e.getX(); y = e.getY();
			lastX = x; lastY = y;			
		}
		@Override public void mouseReleased(MouseEvent e) {
			Graphics g = getGraphics();
			g.drawLine(x, y, e.getX(), e.getY());
			shapes.add(new Line(x, y, e.getX(), e.getY()));
		}

		@Override public void mouseEntered(MouseEvent e) {
		}

		@Override public void mouseExited(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {
			Graphics g = getGraphics();
			g.setXORMode(Color.WHITE);
			g.drawLine(x, y, lastX, lastY);
			g.drawLine(x, y, e.getX(), e.getY());
			lastX = e.getX();
			lastY = e.getY();
		}
		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
}

abstract class Shape {
	protected double x,y;
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public abstract void paint(Graphics g);
}

class Line extends Shape {
	private double x2, y2;
	public Line(double x, double y, double x2, double y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void paint(Graphics g) {
		g.drawLine((int)x, (int)y, (int)x2, (int)y2);
	}
}
