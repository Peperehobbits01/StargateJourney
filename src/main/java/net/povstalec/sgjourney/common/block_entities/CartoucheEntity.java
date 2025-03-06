package net.povstalec.sgjourney.common.block_entities;

import net.minecraft.core.HolderLookup;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.network.PacketDistributor;
import net.povstalec.sgjourney.StargateJourney;
import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.povstalec.sgjourney.common.blocks.CartoucheBlock;
import net.povstalec.sgjourney.common.data.Universe;
import net.povstalec.sgjourney.common.init.BlockEntityInit;
import net.povstalec.sgjourney.common.misc.Conversion;
import net.povstalec.sgjourney.common.packets.ClientboundCartoucheUpdatePacket;
import net.povstalec.sgjourney.common.stargate.Address;
import net.povstalec.sgjourney.common.stargate.AddressTable;

public abstract class CartoucheEntity extends BlockEntity
{
	public static final String ADDRESS_TABLE = "address_table";
	public static final String DIMENSION = "dimension";
	public static final String SYMBOLS = "symbols";
	public static final String ADDRESS = "address";

	private boolean isNew = false;
	private ResourceLocation addressTable;
	private ResourceLocation dimension;
	
	private ResourceLocation symbols;
	private Address address = new Address();
	
	public CartoucheEntity(BlockEntityType<?> cartouche, BlockPos pos, BlockState state) 
	{
		super(cartouche, pos, state);
	}
	
	@Override
	public void onLoad()
	{
		super.onLoad();
		
		if(level.isClientSide())
			return;
		
		if(!isNew)
		{
			if(addressTable != null)
				setAddressFromAddressTable();
			else if(dimension == null && address.isEmpty())
				setDimensionFromLevel(level);
			
			if(dimension != null && address.isEmpty())
				setAddressFromDimension();
			
			if(symbols == null)
				symbolsFromLevel(level);
		}
	}
	
	@Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
    	super.loadAdditional(tag, registries);
		
    	if(tag.contains(ADDRESS_TABLE))
    		addressTable = ResourceLocation.tryParse(tag.getString(ADDRESS_TABLE));
    	if(tag.contains(SYMBOLS))
    		symbols = ResourceLocation.tryParse(tag.getString(SYMBOLS));
		
		
		if(tag.contains(ADDRESS))
			address.fromArray(tag.getIntArray(ADDRESS));
		else if(tag.contains(DIMENSION))
			dimension = ResourceLocation.tryParse(tag.getString(DIMENSION));
	}
	
	@Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries)
	{
		if(addressTable != null)
			tag.putString(ADDRESS_TABLE, addressTable.toString());
		if(symbols != null)
			tag.putString(SYMBOLS, symbols.toString());
		
		if(!address.isFromDimension())
			tag.putIntArray(ADDRESS, address.toArray());
		else if(dimension != null)
			tag.putString(DIMENSION, dimension.toString());
		
		super.saveAdditional(tag, registries);
	}
	
	public void setNew()
	{
		this.isNew = true;
	}
	
	//============================================================================================
	//************************************Getters and setters*************************************
	//============================================================================================
	
	public void setDimension(ResourceLocation dimension)
	{
		this.dimension = dimension;
	}
	
	public void setSymbols(ResourceLocation symbols)
	{
		this.symbols = symbols;
	}
	
	public ResourceLocation getSymbols()
	{
		return this.symbols;
	}
	
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	public Address getAddress()
	{
		return this.address;
	}
	
	//============================================================================================
	//****************************************Functionality***************************************
	//============================================================================================
	
	public void setAddressFromAddressTable()
	{
		AddressTable addressTable = AddressTable.getAddressTable(level, this.addressTable);
		Address address = AddressTable.randomAddress(level.getServer(), addressTable);
		
		if(address != null)
		{
			this.address = address;
			if(address.isFromDimension())
				this.dimension = address.getDimension().location();
		}
		
		this.addressTable = null;
		
		this.setChanged();
	}
	
	public void setAddressFromDimension()
	{
		this.address.fromDimension(level.getServer(), Conversion.locationToDimension(this.dimension));
	}
	
	public void symbolsFromLevel(Level level)
	{
		if(level.isClientSide())
			return;
		
		setSymbols(Universe.get(level).getSymbols(level.dimension()).location());
	}
	
	public void setDimensionFromLevel(Level level)
	{
		if(level.isClientSide())
			return;
		
		setDimension(level.dimension().location());
	}
	
	protected void updateClient()
	{
		if(level.isClientSide())
			return;
		PacketDistributor.sendToPlayersTrackingChunk((ServerLevel) level, level.getChunkAt(this.worldPosition).getPos(),
				new ClientboundCartoucheUpdatePacket(worldPosition, symbols == null ? StargateJourney.EMPTY_LOCATION : symbols, addressTable == null ? this.address.toArray() : new int[0]));
	}
	
	public void tick(Level level, BlockPos pos, BlockState state)
	{
		if(state.getValue(CartoucheBlock.HALF) == DoubleBlockHalf.LOWER)
			updateClient();
	}
	
	
	
	public static class Stone extends CartoucheEntity
	{
		public Stone(BlockPos pos, BlockState state)
		{
			super(BlockEntityInit.STONE_CARTOUCHE.get(), pos, state);
		}
		
	}
	
	public static class Sandstone extends CartoucheEntity
	{
		public Sandstone(BlockPos pos, BlockState state)
		{
			super(BlockEntityInit.SANDSTONE_CARTOUCHE.get(), pos, state);
		}
		
	}
	
	public static class RedSandstone extends CartoucheEntity
	{
		public RedSandstone(BlockPos pos, BlockState state)
		{
			super(BlockEntityInit.RED_SANDSTONE_CARTOUCHE.get(), pos, state);
		}
		
	}

}
