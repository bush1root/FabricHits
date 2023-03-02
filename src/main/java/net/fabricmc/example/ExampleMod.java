package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.conf.config;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		config.setSize(0.3);
	}
}
