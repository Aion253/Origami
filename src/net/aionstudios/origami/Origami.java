package net.aionstudios.origami;

import javax.security.auth.login.LoginException;

import net.aionstudios.ndf.ANDFTree;
import net.aionstudios.ndf.util.ANDFFormats;
import net.aionstudios.origami.command.OrigamiListener;
import net.aionstudios.origami.command.administration.CommandGame;
import net.aionstudios.origami.command.administration.CommandOwner;
import net.aionstudios.origami.command.commands.CommandDate;
import net.aionstudios.origami.command.commands.CommandEcho;
import net.aionstudios.origami.command.commands.CommandHeap;
import net.aionstudios.origami.command.commands.CommandHelp;
import net.aionstudios.origami.command.commands.CommandInfo;
import net.aionstudios.origami.command.commands.CommandPing;
import net.aionstudios.origami.command.commands.CommandRandom;
import net.aionstudios.origami.command.commands.CommandStock;
import net.aionstudios.origami.command.commands.CommandTD;
import net.aionstudios.origami.command.commands.CommandTime;
import net.aionstudios.origami.command.commands.CommandUptime;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 * 
 * An instance of Origami bot that manages everything else.
 * @author Winter Roberts
 *
 */
public class Origami {

	private static JDA jda;
	
	/**
	 * Creates a new instance of the Origami Bot.
	 * @param token The token used to connect to the server.
	 */
	public Origami() {
		try {
			OrigamiInfo.andf = new ANDFTree();
			OrigamiInfo.andf.parseFrom(OrigamiInfo.ORIGAMI_CONFIG, ANDFFormats.RECURSIVE_NODE);
			OrigamiInfo.OWNER = OrigamiInfo.andf.getValueAtPath("net.aionstudios.origami.owner");
			OrigamiInfo.GAME = OrigamiInfo.andf.getValueAtPath("net.aionstudios.origami.game");
			OrigamiInfo.TOKEN = OrigamiInfo.andf.getValueAtPath("net.aionstudios.origami.token");
			if(OrigamiInfo.TOKEN.length()<2) {
				System.err.println("Token not set, Please populate token in the config/origami.andf");
				OrigamiInfo.andf.setValueAtPath("net.aionstudios.origami.token", "t");
				OrigamiInfo.andf.assembleTo(OrigamiInfo.ORIGAMI_CONFIG, ANDFFormats.RECURSIVE_NODE);
				System.exit(0);
			}
			jda = new JDABuilder(AccountType.BOT).setToken(OrigamiInfo.TOKEN).buildBlocking();
			jda.setAutoReconnect(true);
			jda.addEventListener(new OrigamiListener());
			if(OrigamiInfo.GAME.length()>0) {
				jda.getPresence().setGame(Game.of(OrigamiInfo.GAME));
			}
			new CommandPing();
			new CommandEcho();
			new CommandGame();
			new CommandHelp();
			new CommandTime();
			new CommandDate();
			new CommandTD();
			new CommandUptime();
			new CommandStock();
			new CommandOwner();
			new CommandInfo();
			new CommandHeap();
			new CommandRandom();
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return The instance of JDA bound to this instance of Origami.
	 */
	public static JDA getJda() {
		return jda;
	}
	
}
