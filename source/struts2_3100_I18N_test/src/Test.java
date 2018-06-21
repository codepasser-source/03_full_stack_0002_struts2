import java.util.Locale;
import java.util.ResourceBundle;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ResourceBundle res =  ResourceBundle.getBundle("app",Locale.CHINESE);
		
		System.out.println("msg:"+res.getString("welcome.msg"));
		
		
	}

}
