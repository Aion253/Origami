package net.aionstudios.origami.command.commands;

import java.util.HashMap;

import net.aionstudios.origami.command.OrigamiCommand;
import net.aionstudios.origami.command.OrigamiCommandManager;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class CommandHelp extends OrigamiCommand {

	public CommandHelp() {
		super("help", "Prints the help dialog.", "~help");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		if(!e.getAuthor().hasPrivateChannel()) {
			e.getAuthor().openPrivateChannel();
		}
		String helpString = "";
		for(OrigamiCommand oc:OrigamiCommandManager.getPublicCommands()) {
			helpString += "  Command: "+oc.getCommand()+"\n    - "+oc.getDesc()+"\n      USAGE: "+oc.getUse()+"\n";
		}
		e.getAuthor().getPrivateChannel().sendMessage("```You asked for some help! Here's what you can do:\n"+helpString+"```").queue();
	}

}
