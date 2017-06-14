package net.aionstudios.origami.command.commands;

import net.aionstudios.origami.command.OrigamiCommand;
import net.aionstudios.origami.modules.stocks.Stock;
import net.aionstudios.origami.modules.stocks.StockFetcher;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 * A command that returns information from a NASDAQ stock if one exists with the provided symbol.
 * @author Winter Roberts
 *
 */
public class CommandStock extends OrigamiCommand {

	public CommandStock() {
		super("stock", "Returns information about the stock with the given symbol with Yahoo Finance.", "~stock [SYMBOL]");
	}

	@Override
	public void publicCall(String[] args, String message, MessageReceivedEvent e) {
		if(!e.isFromType(ChannelType.PRIVATE)) {
			e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
		}
		Stock s = StockFetcher.getStock(args[1]);
		String change;
		if(s.getPercentChange().contains("-")) {
			change = "down "+s.getPercentChange();
		} else {
			change = "up "+s.getPercentChange();
		}
		if(s.getName()==null||s.getName()=="") {
			e.getChannel().sendMessage("Stock ("+args[1]+"): NO SUCH STOCK").queue();
		} else {
			e.getChannel().sendMessage("Stock ("+args[1]+"): "+s.getName()+"  "+s.getPrice()+" "+s.getCurrency()+"  "+change).queue();
		}
	}

}
