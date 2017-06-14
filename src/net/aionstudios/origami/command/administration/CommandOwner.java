package net.aionstudios.origami.command.administration;

import net.aionstudios.ndf.util.ANDFFormats;
import net.aionstudios.origami.OrigamiInfo;
import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandOwner extends OrigamiCommand {

	public CommandOwner() {
		super("setowner", "Allows the owner to either switch owners, or any account to claim an unowned instance", "~setowner [USER#HASH]");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		message = message.replace(" ", "");
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		if(OrigamiInfo.isAuthorOwner(e)){
			e.getChannel().sendMessage("Owner Set: '"+message+"'").queue();
			OrigamiInfo.OWNER = message;
			OrigamiInfo.andf.setValueAtPath("net.aionstudios.origami.owner", message);
			OrigamiInfo.andf.assembleTo(OrigamiInfo.ORIGAMI_CONFIG, ANDFFormats.RECURSIVE_NODE);
		}
	}

}