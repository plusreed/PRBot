import org.jibble.pircbot.*;

public class MyBotMain {

	public static void main(String[] args) throws Exception {

		// start bot
		MyBot bot = new MyBot();

		// debugging
		bot.setVerbose(true);

		// connect to irc
		bot.connect("irc.zandronum.com");

		// join this channel
		bot.joinChannel("#prtest");

	}
}