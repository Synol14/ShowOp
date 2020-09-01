package fr.synol.showop;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		setOpName();
		getServer().getConsoleSender().sendMessage("§e[§4ShowOp§e]§r -> §aEnabled !");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§e[§4ShowOp§e]§r -> §4Disabled !");
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		setOpName();
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		setOpName();
	}
	@EventHandler
	public void onCommandSend(PlayerCommandSendEvent event) {
		setOpName();
	}
	@EventHandler
	public void onGameModeChange(PlayerGameModeChangeEvent event) {
		Player player = event.getPlayer();
		StringBuilder sb = new StringBuilder();
		if (player.isOp()) {
			sb.append("§e[§4op§e] §r");
		}
		if (event.getNewGameMode() == GameMode.CREATIVE) {
			sb.append("§4");
		}
		player.setPlayerListName(sb.toString()+player.getName());
	}
	
	private void setOpName() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			StringBuilder sb = new StringBuilder();
			if (player.isOp()) {
				sb.append("§e[§4op§e] §r");
			}
			if (player.getGameMode() == GameMode.CREATIVE) {
				sb.append("§4");
			}
			player.setPlayerListName(sb.toString()+player.getName());
		}
	}
}
