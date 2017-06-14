package net.aionstudios.origami.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class OrigamiCommandManager {
	
	private static List<OrigamiCommand> publicCommands = new ArrayList<OrigamiCommand>();
	public static long startTime = System.currentTimeMillis();
	
	public static void onMessageReceived(MessageReceivedEvent event) {
		String messageText = event.getMessage().getRawContent();
		if(messageText.startsWith("~")&&!event.getAuthor().isBot()) {
			for(OrigamiCommand oc:publicCommands) {
				if(messageText.toLowerCase().startsWith("~"+oc.getCommand()+" ")||messageText.toLowerCase().equals("~"+oc.getCommand())) {
					String passMessage = messageText.substring(oc.getCommand().length()+1);
					if(passMessage.startsWith(" ")) {
						passMessage.replaceFirst(" ", "");
					}
					oc.publicCall(resolveMessage(messageText), passMessage, event);
					break;
				}
			}
		}
	}
	
	public static void onReady(ReadyEvent event) {
		
	}
	
	public static String[] resolveMessage(String message){
		String[] args = message.split(" ");
		return args;
	}

	public static List<OrigamiCommand> getPublicCommands() {
		return publicCommands;
	}
	
}
