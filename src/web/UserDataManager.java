package web;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataManager {
	private Statement stmt;
	private AccountManager accountManager;
	
	public UserDataManager(Statement stmt, AccountManager accountManager) {
		this.stmt = stmt;
		this.accountManager = accountManager;
	}
	
	public ResultSet getUserMessages(String username) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT DISTINCT * FROM messages WHERE fromUser = \"" + username + "\" OR toUser = \"" + username + "\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return rs;
	}
	
	public String sendMessage(String fromUser, String toUser, String message) {
		String timeStamp = getTimeStamp();
		String returnStatus = "(" + timeStamp + ") Message successfully sent.";
		
		try {
			/* Check if the receiver exist. */
			if (!accountManager.accountExist(toUser)) {
				return "(" + timeStamp + ") The user " + toUser + " does not exist.";
			}
			

			
			/* Send message. */
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
			rs = stmt.executeQuery("SELECT DISTINCT * FROM friendRequests WHERE fromUser = \"" + username + "\" OR toUser = \"" + username + "\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return rs;
	}

	public String sendFriendRequest(String fromUser, String toUser, String message) {
		String timeStamp = getTimeStamp();
		String returnStatus = "(" + timeStamp + ") Request successfully sent to user" + toUser + ".";
		
		try {
			/* Check if the receiver exist. */
			if (!accountManager.accountExist(toUser)) {
				return "(" + timeStamp + "), The user " + toUser + " does not exist.";
			}
			
			/* Prevent user from sending request to himself. */
			if (fromUser.equals(toUser)) {
				return "(" + timeStamp + ") You cannot send a friend request to yourself.";
			}
			
			/* Check if user sent this request before. */
			ResultSet rs = stmt.executeQuery("SELECT * FROM friendRequests WHERE fromUser = \"" + fromUser + "\" AND toUser = \"" + toUser + "\";");
			if (rs.isBeforeFirst()) {
				return "(" + timeStamp + ") You have already sent a request to " + toUser + ".";
			}
			
			/* Check if receiver already sent you a request. */
			rs = stmt.executeQuery("SELECT * FROM friendRequests WHERE fromUser = \"" + toUser + "\" AND toUser = \"" + fromUser + "\";");
			if (rs.isBeforeFirst()) {
				return "(" + timeStamp + ")" + toUser + " already sent you a request.";
			}	
			
			/* Check if friendship already exist. */
			
			if (rs.isBeforeFirst()) {
				return "(" + timeStamp + ") " + toUser + " and you are already firends.";
			}
					
			/* Insert friendRequest. */
			stmt.executeUpdate("INSERT INTO friendRequests VALUES (\"" + fromUser + "\",\"" + toUser + "\",\"" + timeStamp + "\",\"" + message + "\");");
		} catch (SQLException e) {
			returnStatus = ("(" + timeStamp + ") An DB error occurred while sending request: " + e.toString() );
			e.printStackTrace();
		}
		
		return returnStatus;
	}
	
	public String acceptFriendRequest(String fromUser, String toUser) {
		String timeStamp = getTimeStamp();
		String returnStatus = "(" + timeStamp + ") You and " + fromUser + " are now friends.";
		
		try {
			/* Delete friendRequest. */
			stmt.executeUpdate("DELETE FROM friendRequests WHERE fromUser = \"" + fromUser + "\" AND toUser = \"" + toUser + "\";");
			
			/* Insert mutual friendship. */
			stmt.executeUpdate("INSERT INTO friends VALUES (\"" + fromUser + "\",\"" + toUser + "\");");
			stmt.executeUpdate("INSERT INTO friends VALUES (\"" + toUser + "\",\"" + fromUser + "\");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnStatus;		
	}
	
	public ResultSet searchUsers(String str) {
		ResultSet rs = null;
		try {
			System.out.println("SELECT * FROM accounts WHERE username LIKE \"%" + str + "%\";");
			rs = stmt.executeQuery("SELECT * FROM accounts WHERE username LIKE \"%" + str + "%\";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public boolean areFriends(String user1, String user2) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM friends WHERE fromUser = \"" + user1 + "\" AND toUser = \"" + user2 + "\";");
			return rs.isBeforeFirst();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Should not reach here. */
		assert false;
		return false;
	}
	
	private String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	
	

}
