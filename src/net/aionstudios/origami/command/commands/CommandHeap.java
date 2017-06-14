package net.aionstudios.origami.command.commands;

import java.awt.Color;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that returns current RAM usage information from the hosting JVM and Server.
 * @author Winter Roberts
 *
 */
public class CommandHeap extends OrigamiCommand {

	public CommandHeap() {
		super("heap", "Display's information about the RAM usage.", "~heap");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(new Color(100, 13, 140));
		eb.addField("Free Memory", Runtime.getRuntime().freeMemory()/1000000+"mb", true);
		eb.addField("Total Memory", Runtime.getRuntime().totalMemory()/1000000+"mb", true);
		eb.addField("Max Memory", Runtime.getRuntime().maxMemory()/1000000+"mb", true);
		e.getChannel().sendMessage(eb.build()).queue();
	}

}
