package net.aionstudios.origami;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 * 
 * @author Winter
 *
 */
public class Main {
	
	private static Origami o;

	public static void main(String[] args) {
		o = new Origami();
	}

}
