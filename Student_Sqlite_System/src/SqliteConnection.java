import java.sql.*;
import javax.swing.*;
public class SqliteConnection {
	//code for database connectivity
	public static Connection ConnectionDb() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AAMIR\\eclipse-workspace\\Student_Sqlite_System\\Student.db");
			JOptionPane.showMessageDialog(null,"Database Connected");

			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

}
