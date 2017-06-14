package net.aionstudios.origami.command.commands;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that echo's a string back to the user.
 * @author Winter Roberts
 *
 */
public class CommandEcho extends OrigamiCommand {

	public CommandEcho() {
		super("echo", "Echoes a string back to the channel.", "~echo [STRING]");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		e.getChannel().sendMessage(message).queue();
	}

}
