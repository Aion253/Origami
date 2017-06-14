package net.aionstudios.origami.command;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * 
 * A ListenerAdapter used to listen for specific Discord events.
 * @author Winter Roberts
 *
 */
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
