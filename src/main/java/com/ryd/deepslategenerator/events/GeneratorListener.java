package com.ryd.deepslategenerator.events;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class GeneratorListener implements Listener {
    public int yLevel;

    public GeneratorListener(FileConfiguration config){
        yLevel = config.getInt("y-level");
    }

    @EventHandler
    public void BlockFormEvent(BlockFormEvent event) {
        BlockState blockState = event.getNewState();
        if (blockState.getY() > yLevel) {
            return;
        }

        if(blockState.getBlockData().getMaterial() == Material.COBBLESTONE) {
            event.getNewState().setType(Material.COBBLED_DEEPSLATE);
        } else if (event.getNewState().getBlockData().getMaterial() == Material.STONE) {
            event.getNewState().setType(Material.DEEPSLATE);
        }
    }
}
