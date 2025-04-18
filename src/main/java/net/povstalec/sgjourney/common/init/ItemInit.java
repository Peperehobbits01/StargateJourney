package net.povstalec.sgjourney.common.init;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.povstalec.sgjourney.StargateJourney;
import net.povstalec.sgjourney.common.items.*;
import net.povstalec.sgjourney.common.items.armor.FalconArmorItem;
import net.povstalec.sgjourney.common.items.armor.JackalArmorItem;
import net.povstalec.sgjourney.common.items.armor.PersonalShieldItem;
import net.povstalec.sgjourney.common.items.crystals.CommunicationCrystalItem;
import net.povstalec.sgjourney.common.items.crystals.ControlCrystalItem;
import net.povstalec.sgjourney.common.items.crystals.EnergyCrystalItem;
import net.povstalec.sgjourney.common.items.crystals.MaterializationCrystalItem;
import net.povstalec.sgjourney.common.items.crystals.MemoryCrystalItem;
import net.povstalec.sgjourney.common.items.crystals.TransferCrystalItem;
import net.povstalec.sgjourney.common.items.energy_cores.FusionCoreItem;
import net.povstalec.sgjourney.common.items.energy_cores.NaquadahGeneratorCoreItem;

public class ItemInit
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StargateJourney.MODID);
	
	// Materials
	public static final DeferredItem<Item> RAW_NAQUADAH = ITEMS.register("raw_naquadah",
			() -> new Item(new Item.Properties().fireResistant()));
	public static final DeferredItem<Item> NAQUADAH_ALLOY = ITEMS.register("naquadah_alloy",
			() -> new Item(new Item.Properties().fireResistant()));
	public static final DeferredItem<Item> NAQUADAH_ALLOY_NUGGET = ITEMS.register("naquadah_alloy_nugget",
			() -> new Item(new Item.Properties().fireResistant()));
	public static final DeferredItem<Item> REFINED_NAQUADAH = ITEMS.register("refined_naquadah",
			() -> new Item(new Item.Properties().fireResistant()));
	public static final DeferredItem<Item> PURE_NAQUADAH = ITEMS.register("pure_naquadah",
			() -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).fireResistant()));
	public static final DeferredItem<Item> NAQUADAH = ITEMS.register("naquadah",
			() -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).fireResistant()));
	
	// Crafting Items
	public static final DeferredItem<Item> NAQUADAH_ROD = ITEMS.register("naquadah_rod",
			() -> new Item(new Item.Properties().fireResistant()));
	public static final DeferredItem<Item> REACTION_CHAMBER = ITEMS.register("reaction_chamber",
			() -> new Item(new Item.Properties().fireResistant()));
	public static final DeferredItem<Item> PLASMA_CONVERTER = ITEMS.register("plasma_converter",
			() -> new Item(new Item.Properties().fireResistant()));
	
	public static final DeferredItem<Item> UNITY_SHARD = ITEMS.register("unity_shard",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> CRYSTAL_BASE = ITEMS.register("crystal_base",
			() -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16)));
	public static final DeferredItem<Item> ADVANCED_CRYSTAL_BASE = ITEMS.register("advanced_crystal_base",
			() -> new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(16)));
	
	// Food
	
	// Useful Items
	public static final DeferredItem<Item> LIQUID_NAQUADAH_BUCKET = ITEMS.register("liquid_naquadah_bucket",
			() -> new BucketItem(FluidInit.LIQUID_NAQUADAH_SOURCE.get(), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final DeferredItem<Item> HEAVY_LIQUID_NAQUADAH_BUCKET = ITEMS.register("heavy_liquid_naquadah_bucket",
			() -> new BucketItem(FluidInit.HEAVY_LIQUID_NAQUADAH_SOURCE.get(), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
	
	public static final DeferredItem<VialItem> VIAL = ITEMS.register("vial",
			() -> new VialItem(new Item.Properties().stacksTo(1)));
	
	public static final DeferredItem<Item> RING_REMOTE = ITEMS.register("ring_remote",
			() -> new RingRemoteItem(new RingRemoteItem.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	public static final DeferredItem<Item> KARA_KESH = ITEMS.register("kara_kesh",
			() -> new KaraKeshItem(new KaraKeshItem.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	
	public static final DeferredItem<Item> MATOK = ITEMS.register("matok",
			() -> new StaffWeaponItem(new StaffWeaponItem.Properties().stacksTo(1)));
	
	public static final DeferredItem<Item> PDA = ITEMS.register("pda",
			() -> new PDAItem(new PDAItem.Properties().stacksTo(1).rarity(Rarity.RARE).fireResistant()));
	
	/*public static final RegistryObject<Item> UNIVERSE_DIALER = ITEMS.register("universe_dialer", 
			() -> new DialerItem(new PDAItem.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));*/
	
	public static final DeferredItem<Item> NAQUADAH_GENERATOR_CORE = ITEMS.register("naquadah_generator_core",
			() -> new NaquadahGeneratorCoreItem(new NaquadahGeneratorCoreItem.Properties().stacksTo(1)));
	public static final DeferredItem<Item> FUSION_CORE = ITEMS.register("fusion_core",
			() -> new FusionCoreItem(new FusionCoreItem.Properties().stacksTo(1).rarity(Rarity.EPIC)));
	
	public static final DeferredItem<Item> ZPM = ITEMS.register("zero_point_module",
			() -> new ZeroPointModule(new ZeroPointModule.Properties().stacksTo(1).rarity(Rarity.EPIC)));
	
	public static final DeferredItem<Item> SYRINGE = ITEMS.register("syringe",
			() -> new SyringeItem(new SyringeItem.Properties().stacksTo(1)));
	
	// Crystals
	public static final DeferredItem<ControlCrystalItem> CONTROL_CRYSTAL = ITEMS.register("control_crystal",
			() -> new ControlCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
	public static final DeferredItem<ControlCrystalItem> LARGE_CONTROL_CRYSTAL = ITEMS.register("large_control_crystal",
			() -> new ControlCrystalItem.Large(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
	public static final DeferredItem<MemoryCrystalItem> MEMORY_CRYSTAL = ITEMS.register("memory_crystal",
			() -> new MemoryCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
	public static final DeferredItem<MaterializationCrystalItem> MATERIALIZATION_CRYSTAL = ITEMS.register("materialization_crystal",
			() -> new MaterializationCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
	public static final DeferredItem<EnergyCrystalItem> ENERGY_CRYSTAL = ITEMS.register("energy_crystal",
			() -> new EnergyCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
	public static final DeferredItem<TransferCrystalItem> TRANSFER_CRYSTAL = ITEMS.register("transfer_crystal",
			() -> new TransferCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
	public static final DeferredItem<CommunicationCrystalItem> COMMUNICATION_CRYSTAL = ITEMS.register("communication_crystal",
			() -> new CommunicationCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));

	public static final DeferredItem<ControlCrystalItem> ADVANCED_CONTROL_CRYSTAL = ITEMS.register("advanced_control_crystal",
			() -> new ControlCrystalItem.Advanced(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	public static final DeferredItem<MemoryCrystalItem> ADVANCED_MEMORY_CRYSTAL = ITEMS.register("advanced_memory_crystal",
			() -> new MemoryCrystalItem.Advanced(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	public static final DeferredItem<MaterializationCrystalItem> ADVANCED_MATERIALIZATION_CRYSTAL = ITEMS.register("advanced_materialization_crystal",
			() -> new MaterializationCrystalItem.Advanced(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	public static final DeferredItem<EnergyCrystalItem> ADVANCED_ENERGY_CRYSTAL = ITEMS.register("advanced_energy_crystal",
			() -> new EnergyCrystalItem.Advanced(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	public static final DeferredItem<TransferCrystalItem> ADVANCED_TRANSFER_CRYSTAL = ITEMS.register("advanced_transfer_crystal",
			() -> new TransferCrystalItem.Advanced(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	public static final DeferredItem<CommunicationCrystalItem> ADVANCED_COMMUNICATION_CRYSTAL = ITEMS.register("advanced_communication_crystal",
			() -> new CommunicationCrystalItem.Advanced(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

	public static final DeferredItem<StargateUpgradeItem> STARGATE_UPGRADE_CRYSTAL = ITEMS.register("stargate_upgrade_crystal",
			() -> new StargateUpgradeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	public static final DeferredItem<StargateVariantItem> STARGATE_VARIANT_CRYSTAL = ITEMS.register("stargate_variant_crystal",
			() -> new StargateVariantItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
	
	// Tools
	public static final DeferredItem<SwordItem> NAQUADAH_SWORD = ITEMS.register("naquadah_sword",
			() -> new SwordItem(ToolMaterialInit.naquadah, (new Item.Properties().fireResistant()).attributes(SwordItem.createAttributes(ToolMaterialInit.naquadah, 4, -2.4F))));
	public static final DeferredItem<PickaxeItem> NAQUADAH_PICKAXE = ITEMS.register("naquadah_pickaxe",
			() -> new PickaxeItem(ToolMaterialInit.naquadah, (new Item.Properties().fireResistant()).attributes(PickaxeItem.createAttributes(ToolMaterialInit.naquadah, 2, -2.8F))));
	public static final DeferredItem<AxeItem> NAQUADAH_AXE = ITEMS.register("naquadah_axe",
			() -> new AxeItem(ToolMaterialInit.naquadah, (new Item.Properties().fireResistant()).attributes(AxeItem.createAttributes(ToolMaterialInit.naquadah, 6, -3.0F))));
	public static final DeferredItem<ShovelItem> NAQUADAH_SHOVEL = ITEMS.register("naquadah_shovel",
			() -> new ShovelItem(ToolMaterialInit.naquadah, (new Item.Properties().fireResistant()).attributes(ShovelItem.createAttributes(ToolMaterialInit.naquadah, 2.5F, -3.0F))));
	public static final DeferredItem<HoeItem> NAQUADAH_HOE = ITEMS.register("naquadah_hoe",
			() -> new HoeItem(ToolMaterialInit.naquadah, (new Item.Properties().fireResistant()).attributes(ShovelItem.createAttributes(ToolMaterialInit.naquadah, -2, 0))));
	
	// Armor
	public static final DeferredItem<ArmorItem> NAQUADAH_HELMET = ITEMS.register("naquadah_helmet",
			() -> new ArmorItem(ArmorMaterialInit.NAQUADAH, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> NAQUADAH_CHESTPLATE = ITEMS.register("naquadah_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.NAQUADAH, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> NAQUADAH_LEGGINGS = ITEMS.register("naquadah_leggings",
			() -> new ArmorItem(ArmorMaterialInit.NAQUADAH, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> NAQUADAH_BOOTS = ITEMS.register("naquadah_boots",
			() -> new ArmorItem(ArmorMaterialInit.NAQUADAH, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
	
	public static final DeferredItem<ArmorItem> SYSTEM_LORD_HELMET = ITEMS.register("system_lord_helmet",
			() -> new ArmorItem(ArmorMaterialInit.SYSTEM_LORD, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> SYSTEM_LORD_CHESTPLATE = ITEMS.register("system_lord_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.SYSTEM_LORD, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> SYSTEM_LORD_LEGGINGS = ITEMS.register("system_lord_leggings",
			() -> new ArmorItem(ArmorMaterialInit.SYSTEM_LORD, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> SYSTEM_LORD_BOOTS = ITEMS.register("system_lord_boots",
			() -> new ArmorItem(ArmorMaterialInit.SYSTEM_LORD, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
	
	public static final DeferredItem<ArmorItem> JAFFA_HELMET = ITEMS.register("jaffa_helmet",
			() -> new ArmorItem(ArmorMaterialInit.JAFFA, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> JAFFA_CHESTPLATE = ITEMS.register("jaffa_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.JAFFA, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> JAFFA_LEGGINGS = ITEMS.register("jaffa_leggings",
			() -> new ArmorItem(ArmorMaterialInit.JAFFA, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
	public static final DeferredItem<ArmorItem> JAFFA_BOOTS = ITEMS.register("jaffa_boots",
			() -> new ArmorItem(ArmorMaterialInit.JAFFA, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
	
	public static final DeferredItem<JackalArmorItem> JACKAL_HELMET = ITEMS.register("jackal_helmet",
			() -> new JackalArmorItem(ArmorMaterialInit.JAFFA, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
	public static final DeferredItem<FalconArmorItem> FALCON_HELMET = ITEMS.register("falcon_helmet",
			() -> new FalconArmorItem(ArmorMaterialInit.JAFFA, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
	
	public static final DeferredItem<NaquadahFuelRodItem> NAQUADAH_FUEL_ROD = ITEMS.register("naquadah_fuel_rod",
			() -> new NaquadahFuelRodItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).fireResistant()));
	
	public static final DeferredItem<PersonalShieldItem> PERSONAL_SHIELD_EMITTER = ITEMS.register("personal_shield_emitter",
			() -> new PersonalShieldItem(ArmorMaterialInit.PERSONAL_SHIELD, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE).stacksTo(1).fireResistant()));
	
	public static final DeferredItem<CallForwardingDevice> CALL_FORWARDING_DEVICE = ITEMS.register("call_forwarding_device",
			() -> new CallForwardingDevice(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).fireResistant()));
	
	public static final DeferredItem<GDOItem> GDO = ITEMS.register("gdo",
			() -> new GDOItem(new Item.Properties().stacksTo(1)));
	
	// Shielding
	public static final DeferredItem<Item> STARGATE_SHIELDING_RING = ITEMS.register("stargate_shielding_ring",
			() -> new Item(new Item.Properties().stacksTo(1)));
	
	// Irises
	public static final DeferredItem<StargateIrisItem.Copper> COPPER_IRIS = ITEMS.register("copper_iris",
			() -> new StargateIrisItem.Copper(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<StargateIrisItem.Iron> IRON_IRIS = ITEMS.register("iron_iris",
			() -> new StargateIrisItem.Iron(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<StargateIrisItem.Gold> GOLDEN_IRIS = ITEMS.register("golden_iris",
			() -> new StargateIrisItem.Gold(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<StargateIrisItem.Diamond> DIAMOND_IRIS = ITEMS.register("diamond_iris",
			() -> new StargateIrisItem.Diamond(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<StargateIrisItem.Netherite> NETHERITE_IRIS = ITEMS.register("netherite_iris",
			() -> new StargateIrisItem.Netherite(new Item.Properties().stacksTo(1).fireResistant()));

	public static final DeferredItem<StargateIrisItem.NaquadahAlloy> NAQUADAH_ALLOY_IRIS = ITEMS.register("naquadah_alloy_iris",
			() -> new StargateIrisItem.NaquadahAlloy(new Item.Properties().stacksTo(1).fireResistant()));
	public static final DeferredItem<StargateIrisItem.Trinium> TRINIUM_IRIS = ITEMS.register("trinium_iris",
			() -> new StargateIrisItem.Trinium(new Item.Properties().stacksTo(1)));

	public static final DeferredItem<StargateIrisItem.Bronze> BRONZE_IRIS = ITEMS.register("bronze_iris",
			() -> new StargateIrisItem.Bronze(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<StargateIrisItem.Steel> STEEL_IRIS = ITEMS.register("steel_iris",
			() -> new StargateIrisItem.Steel(new Item.Properties().stacksTo(1)));
		
	
	public static void register(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
	}
}
