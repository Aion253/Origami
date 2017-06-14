package net.aionstudios.origami;

import java.net.URISyntaxException;

import net.aionstudios.ndf.ANDFTree;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class OrigamiInfo {
	
	public static ANDFTree andf;
	public static String ORIGAMI_CONFIG = "./config/origami";
	
	public static String JAVA_VERSION = System.getProperty("java.runtime.version");
	public static String JDA_VERSION = "3.1.1_212";
	public static String ORIGAMI_VERSION = "1.0.0";
	public static String AUTHOR = "Winter Roberts";
	
	public static String OWNER = "";
	public static String GAME = "";
	public static String TOKEN = "";
	
	public static boolean isAuthorOwner(MessageReceivedEvent event) {
		if(OWNER.equals(event.getAuthor().getName()+"#"+event.getAuthor().getDiscriminator())||OWNER==""||OWNER==null) {
			return true;
		}
		return false;
	}

}
