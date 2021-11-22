package bct.loadupstudios.DeathPing;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.PlayerDeathEvent;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.dependencies.jda.api.entities.User;
import github.scarsz.discordsrv.util.DiscordUtil;


public class MyListener implements Listener
{
	private FileConfiguration config;
	//TextChannel textChannel = DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName("global");
	TextChannel textChannel = DiscordSRV.getPlugin().getMainTextChannel();
	
	//private final Plugin plugin;
	
	MyListener(FileConfiguration conf)
	{
		config = conf;
		//System.out.println("DeathPing Listener");
	}
	
	public void reload(FileConfiguration conf)
	{
		config = conf;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event)
	{
		if(textChannel == null)
		{
			textChannel = DiscordSRV.getPlugin().getMainTextChannel();
		}
		if(event.getEntity() != null)
		{
			String discordId = DiscordSRV.getPlugin().getAccountLinkManager().getDiscordId(event.getEntity().getUniqueId());
			if(discordId != null)
			{
				User user = DiscordUtil.getJda().getUserById(discordId);
				//User test = DiscordUtil.convertMentionsToNames(message)
				//textChannel.sendMessage("DeathPing: Test").queue();;
				textChannel.sendMessage("[DeathPing] " + user.getAsMention() + " has died.").queue();
			}
		}
	}
}
