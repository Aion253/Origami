package net.aionstudios.origami.utils;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class ErrorEmbedGenerator {
	
	public static MessageEmbed genError(String errorText) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(new Color(183, 0, 0));
		eb.setTitle("Origami ran into an error!");
		eb.addField("ERROR: ", errorText, true);
		return eb.build();
	}

}
