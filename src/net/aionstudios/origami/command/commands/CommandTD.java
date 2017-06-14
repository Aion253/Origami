package net.aionstudios.origami.command.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that returns the current time and date on the server in the form of '12:00 AM, Thursday, January 1, 1970 Pacific Standard Time -0800'.
 * @author Winter Roberts
 *
 */
public class CommandTD extends OrigamiCommand {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("h:mm a, EEEEE, MMMMM d, yyyy zzzz Z");

	public CommandTD() {
		super("timedate", "Returns the current server time and date.", "~timedate");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		e.getChannel().sendMessage("The current server time and date is: "+sdf.format(new Date())).queue();
	}

}
