package net.aionstudios.origami.command.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that returns the current time on the server in the form of '12:00 AM Pacific Standard Time -0800'.
 * @author Winter Roberts
 *
 */
public class CommandTime extends OrigamiCommand {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("h:mm a zzzz Z");

	public CommandTime() {
		super("time", "Returns the current server time.", "~time");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		e.getChannel().sendMessage("The current server time is: "+sdf.format(new Date())).queue();
	}

}
