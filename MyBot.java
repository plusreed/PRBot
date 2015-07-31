import org.jibble.pircbot.*;

public class MyBot extends PircBot {
	// PRBot - an IRC bot based on PircBot
	public MyBot() {
		this.setName("PRBot");
	}

	public void onMessage(String channel, String sender,
				String login, String hostname, String message) {
		 if (message.equalsIgnoreCase("+time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now: " + time);
		}
		 if (message.equalsIgnoreCase("+shutdown") && sender.equalsIgnoreCase("reed")) {
			// sendMessage(channel, sender + ": Shutting down now...");
			quitServer("User " + sender + " sent shutdown command.");
			System.exit(0);
		}
		 if (message.equalsIgnoreCase("+testcolor")) {
			sendMessage(channel, sender + " Testing: " + Colors.RED + "Red text!");
		}
		 if (message.equalsIgnoreCase("+version")) {
		 	sendMessage(channel, sender + ": v0.1 beta");
		 }
		 if (message.equalsIgnoreCase("+about")) {
		 	sendMessage(channel, sender + ": PRBot was made by reed and was coded in Java using Pircbot as a base.");
		 }
		 if (message.equalsIgnoreCase("+source")) {
		 	sendMessage(channel, sender + ": The source for PRBot will be available soon.");
		 }
		 if (message.equalsIgnoreCase("+part") && sender.equalsIgnoreCase("reed")) {
		 	partChannel(channel, "User " + sender + " has asked me to part the channel.");
		 	// this is here for debug purposes, UNCOMMENT ONLY WHEN TESTING
		 	// quitServer("the debug function for +part is enabled, quitting server.");
		 }
		 if (message.equalsIgnoreCase("+pm")) {
		 	sendMessage(sender, "I'm PMing you! (this is a test command)");
		 }
		 if (message.equalsIgnoreCase("+commands")) {
		 	sendMessage(channel, sender + ": The available commands are time, testcolor, version, about, source, and pm. Make sure to prefix your command with a +!");
		 	sendMessage(channel, sender + ": The available admin commands are part and shutdown. Only the developer (reed) can perform these commands at the moment.");
		 }
	}
}