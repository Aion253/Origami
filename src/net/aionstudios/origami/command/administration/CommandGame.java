package net.aionstudios.origami.command.administration;

import java.util.HashMap;

import net.aionstudios.ndf.util.ANDFFormats;
import net.aionstudios.origami.OrigamiInfo;
import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandGame extends OrigamiCommand {

	public CommandGame() {
		super("setgame", "Set's the bots game (user restricted).", "~setgame [STRING]");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		while(message.startsWith(" ")) {
			message = message.replaceFirst(" ", "");
		}
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		if(OrigamiInfo.isAuthorOwner(e)){
			e.getJDA().getPresence().setGame(Game.of(message));
			e.getChannel().sendMessage("Game Set: '"+message+"'").queue();
			OrigamiInfo.GAME = message;
			OrigamiInfo.andf.setValueAtPath("net.aionstudios.origami.game", message);
			OrigamiInfo.andf.assembleTo(OrigamiInfo.ORIGAMI_CONFIG, ANDFFormats.RECURSIVE_NODE);
		}
	}

}
