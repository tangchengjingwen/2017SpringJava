import java.io.FileReader;
import java.util.Properties;


public class PropertyTest {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		FileReader r = new FileReader("dict.dat");
		p.load(r);
		String chinese = p.getProperty("big");
		System.out.println(chinese);
		String chinese1 = p.getProperty("mountain");
		System.out.println(chinese1);
		r.close();
	}

}
