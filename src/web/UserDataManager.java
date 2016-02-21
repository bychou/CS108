package web;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataManager {
	private Statement stmt;
	
	public UserDataManager(Statement stmt) {
		this.stmt = stmt;
	}
	
	public ResultSet getUserMessages(String username) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT DISTINCT * FROM messages WHERE fromUser = \"" + username + "\" OR toUser = \"" + username + "\";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rs;
	}
	
	public String sendMessage(String fromUser, String toUser, String message) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String returnStatus = "(" + timeStamp + ") Message successfully sent.";
		
		try {
			/* Check if the receiver exist. */
			ResultSet rs = stmt.executeQuery("SELECT * FROM accounts WHERE username = \"" + toUser + "\";");
			if (!rs.isBeforeFirst()) {
				return "(" + timeStamp + "), The receiver you entered does not exist.";
			}
			
			stmt.executeUpdate("INSERT INTO messages VALUES (\"" + fromUser + "\",\"" + toUser + "\",\"" + timeStamp + "\",\"" + message + "\");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			returnStatus = ("(" + timeStamp + ") An DB error occurred while sending meesage: " + e.toString() );
			e.printStackTrace();
		}
		
		return returnStatus;
	}
	
	public ResultSet getUserFriendRequests(String username) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT DISTINCT * FROM messages WHERE fromUser = \"" + username + "\" OR toUser = \"" + username + "\";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rs;
	}
	

}
