package net.aionstudios.origami.command.commands;

import java.util.concurrent.ThreadLocalRandom;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that returns a random long between the two provided numbers.
 * @author Winter Roberts
 *
 */
public class CommandRandom extends OrigamiCommand {
	
	public CommandRandom() {
		super("random", "Generates a number between a lower (inclusive) and an upper limit (exclusive).", "~random [lower] [upper]");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		long lower;
		long upper;
		try {
			lower = Long.parseLong(args[1]);
			upper = Long.parseLong(args[2]);
		} catch (NumberFormatException e1) {
			e.getChannel().sendMessage("Due to computational limitations numbers must be between: "+Long.MIN_VALUE+" and "+Long.MAX_VALUE+" ascending!").queue();
			return;
		}
		long number = ThreadLocalRandom.current().nextLong(lower, upper);
		e.getChannel().sendMessage("Random Number: "+number).queue();
	}

}
