package dizkonnekted.cheesy.common;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import dizkonnekted.cheesy.common.CheesyCommonProxy;
import dizkonnekted.cheesy.common.blocks.Cheese;
import dizkonnekted.cheesy.common.handlers.CheesyServerPacketHandler;
import dizkonnekted.cheesy.common.handlers.CheesyClientPacketHandler;


@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Cheesy"}, packetHandler = CheesyClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Cheesy"}, packetHandler = CheesyServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="Cheesy",name="Cheesy",version="Alpha")


public class Cheesy {

 @Instance("Cheesy") //The instance, this is very important later on
 public static Cheesy instance = new Cheesy();

 @SidedProxy(clientSide = "dizkonnekted.cheesy.client.CheesyClientProxy", serverSide = "dizkonnekted.cheesy.common.CheesyCommonProxy") //Tells Forge the location of your proxies
 public static CheesyCommonProxy proxy;

 //BLOCKS
 public static Block Cheese;
 
 @EventHandler
 public void PreInit(FMLPreInitializationEvent e){

 //BLOCKS
 Cheese = new Cheese(3000).setUnlocalizedName("Cheese"); //3000 is its ID
 GameRegistry.registerBlock(Cheese, "Cheese");
 
 }

 @EventHandler
 public void InitCheesy(FMLInitializationEvent event){ //Your main initialization method

 //BLOCKS (METHOD)
 proxy.registerBlocks(); //Calls the registerBlocks method -- This wasn't here before, so don't skip over this!
  
 //MULTIPLAYER ABILITY
 //NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

 } 
}