package net.aionstudios.origami.command;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * Acts as a passthrough and processing center between OrigamiListener and the specified command if any.
 * @author Winter Roberts
 *
 */
public class OrigamiCommandManager {
	
	private static List<OrigamiCommand> publicCommands = new ArrayList<OrigamiCommand>();
	public static long startTime = System.currentTimeMillis();
	
	/**
	 * Derives the requested command when passed by the OrigamiListener.
	 * @param event The MessageReceivedEvent to be handled.
	 */
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
