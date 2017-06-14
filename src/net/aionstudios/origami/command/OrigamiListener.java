package net.aionstudios.origami.command;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class OrigamiListener extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		OrigamiCommandManager.onMessageReceived(event);
	}
	
	@Override
	public void onReady(ReadyEvent event) {
		OrigamiCommandManager.onReady(event);
	}

}
