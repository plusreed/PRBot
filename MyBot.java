import org.jibble.pircbot.*;
import java.util.*;

public class MyBot extends PircBot {
	String version = "v1.0"; // change this at will, doesn't matter and SHOULDN'T break anything
	
	// PRBot - an IRC bot based on PircBot
	public MyBot() {
		this.setName("PRBot");
		this.setVersion(version);
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		 if (message.startsWith("+"))
		 	parseCommand(channel, sender, login, hostname, message);
	}
	
	public void parseCommand(String source, String sender, String login, String hostname, String message) {
		String[] words = message.split(" ");
		List<String> list = new ArrayList<String>();
		for (String word : words)
			list.add(word);
			
		String command = list.get(0).replace("+", "");
		list.remove(0);
		
		switch (command) {
			case "time":
				String time = new java.util.Date().toString();
				sendMessage(source, sender + ": The time is now: " + time);
				
				break;
				
			case "shutdown":
				if (!sender.equalsIgnoreCase("reed")) return; // ADMIN COMMAND - CHANGE USERNAME HERE
				// test code below, for anyone who is interested I guess
				// sendMessage(channel, sender + ": Shutting down now...");
				quitServer("User " + sender + " sent shutdown command.");
				System.exit(0);
				
				break;
				
			case "testcolor" :
				sendMessage(source, sender + " Testing: " + Colors.RED + "Red text!");
				
				break;
				
			case "version":
				sendMessage(source, version);
				
				break;
				
			case "about":
		 		sendMessage(source, sender + ": PRBot was made by reed and was coded in Java using Pircbot as a base.");
			 
			 	break;
			 	
			case "source":
				sendMessage(source, sender + ": The source for PRBot is available at https://github.com/plusreed/PRBot");
				
				break;
				
			case "part":
				if (!sender.equalsIgnoreCase("reed")) return; // ADMIN COMMAND - CHANGE USERNAME HERE
				
		 		partChannel(source, "User " + sender + " has asked me to part the channel.");
		 		
		 		break;
		 		
		 	case "pm":
			 	sendMessage(sender, "I'm PMing you! (this is a test command)");
			 	
			 	break;
			 	
			case "commands":
				// TODO: find some better way to list these commands, probably don't list developer/debug commands to the channel
			 	sendMessage(source, sender + ": The available commands are time, testcolor, version, about, source, and pm. Make sure to prefix your command with a +!");
		 		sendMessage(source, sender + ": The available admin commands are part and shutdown. Only the developer (reed) can perform these commands at the moment.");
		 		
		 		break;
		}
	}
}
