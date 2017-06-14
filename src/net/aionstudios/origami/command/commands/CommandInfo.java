package net.aionstudios.origami.command.commands;

import java.awt.Color;

import net.aionstudios.origami.OrigamiInfo;
import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandInfo extends OrigamiCommand {

	public CommandInfo() {
		super("info", "Provides information about Origami Bot", "~info");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(new Color(100, 13, 140));
		eb.addField("Origami Version", OrigamiInfo.ORIGAMI_VERSION, true);
		eb.addField("Java Version", "["+OrigamiInfo.JAVA_VERSION+"](http://www.oracle.com/technetwork/java/index.html)", true);
		eb.addField("JDA Version", "["+OrigamiInfo.JDA_VERSION+"](https://github.com/DV8FromTheWorld/JDA)", true);
		eb.addField("About Origami", "Origami is a Discord bot written by "
		+"["+OrigamiInfo.AUTHOR+"](https://github.com/Aion253). Origami comes with a bunch of random features and is being constantly updated.\n\n"
		+"Origami is written in Java with the help of the JDA, java-json and ANDF libraries. It is not yet available on github (soon).\n\n"
		+ "This instance is owned by *"+OrigamiInfo.OWNER+"*", false);
		e.getChannel().sendMessage(eb.build()).queue();
	}

}
