package net.aionstudios.origami.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * An abstract class used to design commands that the bot can handle.
 * @author Winter Roberts
 *
 */
public abstract class OrigamiCommand {
	
	private String command;
	private String desc;
	private String usage;
	
	/**
	 * Creates a new command.
	 * @param command The command that will activate the called method. Note: this should not include!
	 * @param commandAccess Public, Private or Both. 1, 2, and 3 respectively or from OrigamiCommandManager.
	 */
	public OrigamiCommand(String command, String desc, String usage) {
		this.command = command;
		this.desc = desc;
		this.usage = usage;
		OrigamiCommandManager.getPublicCommands().add(this);
	}

	/**
	 * @return The string that must me provided to call this command.
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * @return Returns the description.
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * @return Returns the usage.
	 */
	public String getUse() {
		return usage;
	}
	
	/**
	 * How to handle the command called publicly. Public commands are by extension also private.
	 * @param args Arguments paired with their respective variables.
	 * @param e The message that was received including information about it.
	 */
	public abstract void publicCall(String[] args, String message, MessageReceivedEvent e);

}
