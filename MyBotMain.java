import org.jibble.pircbot.*;

public class MyBotMain {

	public static void main(String[] args) throws Exception {

		// start bot
		MyBot bot = new MyBot();

		// debugging (keep this on for console output)
		bot.setVerbose(true);

		// connect to irc (the address the bot will connect to)
		bot.connect("irc.zandronum.com");

		// join this channel (join this channel on the above IRC channel)
		bot.joinChannel("#prtest");

	}
}
