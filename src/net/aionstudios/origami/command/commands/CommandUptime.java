package net.aionstudios.origami.command.commands;

import java.awt.Color;

import net.aionstudios.origami.command.OrigamiCommand;
import net.aionstudios.origami.command.OrigamiCommandManager;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandUptime extends OrigamiCommand {

	public CommandUptime() {
		super("uptime", "How long has the bot been running?", "~uptime");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		long seconds = ((System.currentTimeMillis()-OrigamiCommandManager.startTime) / 1000);
		long minutes = (seconds / 60);
		long hours = (minutes / 60);
		long days = (hours / 24);
		String time = days + ":" + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60;
		if(days>0) {
			time = days + " days, " + hours % 24 + " hrs, " + minutes % 60 + " min, " + seconds % 60 + " seconds ";
		} else if(hours>0) {
			time = hours % 24 + " hrs, " + minutes % 60 + " min, " + seconds % 60 + " seconds ";
		} else if(minutes>0) {
			time = minutes % 60 + " min, " + seconds % 60 + " seconds ";
		} else {
			time = seconds % 60 + " seconds ";
		}
		e.getChannel().sendMessage("Up for: "+time+" (or "+seconds*1000+"ms)").queue();
	}

}
