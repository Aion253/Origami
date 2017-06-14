package net.aionstudios.origami.command.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that returns the current date on the server in the form of 'Thursday, January 1, 1970'.
 * @author Winter Roberts
 *
 */
public class CommandDate extends OrigamiCommand {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("EEEEE, MMMMM d, yyyy");

	public CommandDate() {
		super("date", "Returns the current server date.", "~date");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		e.getChannel().sendMessage("The current server date is: "+sdf.format(new Date())).queue();
	}

}
