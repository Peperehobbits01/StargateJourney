package net.povstalec.sgjourney.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerStargateNetworkConfig
{
	public static ForgeConfigSpec.BooleanValue auto_regenerate_network;
	public static ForgeConfigSpec.BooleanValue generate_random_addresses;
	public static ForgeConfigSpec.BooleanValue use_datapack_addresses;
	
	public static void init(ForgeConfigSpec.Builder server)
	{
		server.comment("Stargate Journey Stargate Network Config");
		
		auto_regenerate_network = server
				.comment("Stargate Network will regenerate if it detects a newer version of the Stargate Network.")
				.define("server.auto_update_network", true);
		
		use_datapack_addresses = server
				.comment("Stargate Network will use addresses from datapacks")
				.define("server.use_datapack_addresses", true);
		
		generate_random_addresses = server
				.comment("Stargate Network will generate random addresses for each world.")
				.define("server.generate_random_addresses", true);
	}
}
