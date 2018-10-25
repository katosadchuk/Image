import java.nio.file.attribute.FileTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.imaging.ImageInfo.ColorType;


public class DBConnector {

	 public Connection connect() {
	        Connection conn = null;
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:/Users/katosadchuk/Documents/Workspace/ImageInfo/src/Test1.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        
	        return conn;
	    }
	
	
	public static void createTable(String name){
		String url = "jdbc:sqlite:/Users/katosadchuk/Documents/Workspace/ImageInfo/src/Test1.db";
		
		String sql = "CREATE TABLE IF NOT EXISTS "+  name + " (\n"
                + "	format text PRIMARY KEY,\n"
                + "	height integer NOT NULL,\n"
                + "	width integer NOT NULL,\n"
                + "	bitsPerPixel integer NOT NULL,\n"
                + "	color text NOT NULL,\n"
                + "	lastAccessTime text NOT NULL,\n"
                + "	lastModifiedTime text NOT NULL,\n"
                + " creationTme text NOT NULL, \n"
                + "	size integer NOT NULL,\n"
                + ");";
		
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void insert(String format, Integer height, Integer width, Integer bitsPerPixel,  
			ColorType color, FileTime lastAccessTime, FileTime lastModifiedTime, FileTime creationTime, long size){
		
		String sql = "INSERT INTO ImageData(format, height, width, bitsPerPixel, color, lastAccessTime, lastModifiedTime, "
				+ "creationTime, size) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = this.connect(); PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, format);
            statement.setInt(2, height);
            statement.setInt(3, width);
            statement.setInt(4, bitsPerPixel);
            statement.setObject(5, color);
            statement.setObject(6, lastAccessTime);
            statement.setObject(7, lastModifiedTime);
            statement.setObject(8, creationTime);
            statement.setLong(9, size);
            statement.executeUpdate();
		}catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}
	
	
}
