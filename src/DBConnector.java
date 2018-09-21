import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {

	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:/Users/katosadchuk/Documents/Workspace/ImageInfo/src/JavaTest.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void createTable(String name){
		String url = "jdbc:sqlite:/Users/katosadchuk/Documents/Workspace/ImageInfo/src/JavaTest.db";
		
		String sql = "CREATE TABLE IF NOT EXISTS"+  name + " (\n"
                + "	name text PRIMARY KEY,\n"
                + "	integer int NOT NULL,\n"
                + "	capacity real\n"
                + ");";
		
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	public void insert(int F1, String F2) {
		String sql = "INSERT INTO Table1(Field1, Field2) VALUES(?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, F1);
			pstmt.setString(2, F2);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
