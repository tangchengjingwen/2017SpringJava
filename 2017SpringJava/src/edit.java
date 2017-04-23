
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class edit extends JFrame {
	private JTextArea t;
	public edit() {
		super("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton b = new JButton("Clear");
		JButton b1 = new JButton("Translate");
		t = new JTextArea(30,80);
		c.add(t, BorderLayout.CENTER);
		c.add(b, BorderLayout.NORTH);
		c.add(b1, BorderLayout.WEST);
		b.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.setText("");
					}
				} );
		b1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Scanner input = new Scanner(t.getText());
						String chinese = "";
						try {
							dic d = new dic();
							while (input.hasNext()) {
								String word = input.next();
								String chineseword = d.trans(word);
								if (chineseword != null) {
									chinese += chineseword;
								}
								else {
									chinese += word;
								}
							}
							t.setText(chinese);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				} );
		
		setSize(800,600);
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("file");
		JMenuItem item1 = new JMenuItem("open");
		JMenuItem item2 = new JMenuItem("save");
		JMenuItem item3 = new JMenuItem("quit");
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		bar.add(menu);
		this.setJMenuBar(bar);
		item1.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
			                String encoding="GBK";
			                File file=new File("dict.dat");	
			                if(file.isFile() && file.exists()){
			                    InputStreamReader read = new InputStreamReader(
			                    new FileInputStream(file),encoding);
			                    BufferedReader bufferedReader = new BufferedReader(read);
			                    String lineTxt = null;
			                    while((lineTxt = bufferedReader.readLine()) != null){
			                        t.setText(lineTxt);
			                    	//System.out.println(lineTxt);
			                    }
			                    read.close();
			        }else{
			            System.out.println("error");
			        }
			        } catch (Exception e1) {
			            System.out.println("cannot be read");
			            e1.printStackTrace();
			        }
						
					}
			
		});
		
		item2.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						File fp=new File("b.txt");
				        String str=t.getText();
				       PrintWriter pfp;
					try {
						pfp = new PrintWriter(fp);
						 pfp.print(str);
					       pfp.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      
						
					}
			
		});
		
		item3.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
			
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new edit();
	}
}

class dic {
	private Properties p;
	private FileReader r;
	
	public dic() throws Exception {
		p = new Properties();
		r = new FileReader("dict.dat");
		p.load(r);
		r.close();
	}
	
	public String trans(String word) {
		return p.getProperty(word);
	}
}