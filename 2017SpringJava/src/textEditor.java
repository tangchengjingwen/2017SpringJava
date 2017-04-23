import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class textEditor extends JFrame {
	private JTextField textField;

    /**
     * Create the frame.
     */
	public textEditor() {
		setTitle("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Menu1 = new JMenu("file");
		menuBar.add(Menu1);
		
		JMenuItem MenuItemOpen = new JMenuItem("open");
		MenuItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                                                                        //open
			}
		});
		Menu1.add(MenuItemOpen);
		
		JMenuItem MenuItemSave = new JMenuItem("save");
		MenuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                                                                        //save
			}
		});
		Menu1.add(MenuItemSave);
		
		
		JMenuItem MenuItemQuit = new JMenuItem("Quit");
		MenuItemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Menu1.add(MenuItemQuit);
		
		textField = new JTextField();
		this.add(textField, BorderLayout.CENTER);
		
		JButton b = new JButton("Clear");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		this.add(b, BorderLayout.NORTH);
		
		JButton b1 = new JButton("translate");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Scanner input = new Scanner(textField.getText());
				String chinese = "";
					try {
						dict d = new dict();
						while (input.hasNext()) {
							String word = input.next();
							String chineseword = d.translate(word);
							if (chineseword != null) {
								chinese = chinese + chineseword + " ";
							}
							else{
								chinese = chinese +  word + " ";
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textField.setText(chinese);
			}
		});
		this.add(b1, BorderLayout.WEST);
		
		
	}
	
    /**
     * Launch the application.
     * @param args
     */
	public static void main(String[] args) {
		textEditor te = new textEditor();
		te.setVisible(true);
	}
}

/**
 * translate word if exists in dict.
 * @author tangc
 *
 */
class dict {
	private Properties p;
	private FileReader r;
	
	public dict() throws IOException  {
		p = new Properties();
		r = new FileReader("dict.dat");
		p.load(r);
		r.close();
	}
	
	public String translate(String word) {
		return p.getProperty(word);
	}
}
