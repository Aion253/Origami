package net.aionstudios.origami.command.commands;

import net.aionstudios.origami.command.OrigamiCommand;
import net.aionstudios.origami.command.OrigamiCommandManager;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that DM's a user a list of commands provided by the bot.
 * @author Winter Roberts
 *
 */
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
		String helpString = "";
		for(OrigamiCommand oc:OrigamiCommandManager.getPublicCommands()) {
			helpString += "  Command: "+oc.getCommand()+"\n    - "+oc.getDesc()+"\n      USAGE: "+oc.getUse()+"\n";
		}
		if(!e.getAuthor().hasPrivateChannel()) {
			e.getAuthor().openPrivateChannel().queue();
		}
		for(PrivateChannel pc : e.getJDA().getPrivateChannels()) {
			//I'm probably doing this wrong but JDA doesn't cover this like, at all.
			if(e.getAuthor().getIdLong()==pc.getUser().getIdLong()) {
				pc.sendMessage("```You asked for some help! Here's what you can do:\n"+helpString+"```").queue();
			}
		}
	}

}
