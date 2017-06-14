package net.aionstudios.origami.command.commands;

import java.util.HashMap;

import net.aionstudios.origami.command.OrigamiCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class CommandPing extends OrigamiCommand {

	public CommandPing() {
		super("ping", "Pong's you back with latency in milliseconds.", "~ping");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		e.getChannel().sendMessage(":regional_indicator_p: :regional_indicator_o: :regional_indicator_n: :regional_indicator_g: ! "+e.getJDA().getPing()+"ms").queue();
	}

}