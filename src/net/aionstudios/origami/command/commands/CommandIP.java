package net.aionstudios.origami.command.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.aionstudios.origami.command.OrigamiCommand;
import net.aionstudios.origami.utils.ErrorEmbedGenerator;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandIP extends OrigamiCommand {
	
	public CommandIP() {
		super("ip", "Returns the external IP of the Origami host server via Amazon AWS", "~ip");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		try {
			e.getChannel().sendMessage(getIp()).queue();
		} catch (Exception e1) {
			e.getChannel().sendMessage(ErrorEmbedGenerator.genError("Failed while connecting to service - 'http://checkip.amazonaws.com'")).queue();
			e1.printStackTrace();
		}
	}
	
	public static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
