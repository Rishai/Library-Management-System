import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class JavaConnect {
	
	Connection conn;
	
	public static Connection ConnecrDb() {
		try {
			Class.forName("org.sqlite.JDBC");
Connection conn =DriverManager.getConnection("jdbc:sqlite:D:\\kousik\\project\\JAVA\\Library Management System\\LibraryNew.sqlite");
	//D:\\kousik\\project\\JAVA\\Library Management System\\LibraryNew.sqlite old DATABASE
    //D:\\kousik\\project\\JAVA\\Library Management System\\LibraryNew.sqlite New DATABASE
return conn;
		}
		catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);	
		return null;
		}
		
		
	}


}
