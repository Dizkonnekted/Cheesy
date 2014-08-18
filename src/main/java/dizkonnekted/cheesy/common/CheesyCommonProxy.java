package dizkonnekted.cheesy.common;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dizkonnekted.cheesy.common.blocks.Cheese;

public class CheesyCommonProxy { //implements IGuiHandler { //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!

 public void registerRenderInformation() //Client side texture registering
 {
 }
 //@Override
 //public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
 //return null;
 //}
 //@Override
 //public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
 //return null;
 //}

 public void registerTiles(){ //For registering TileEntities
 }

 public void registerBlocks(){ //For registering Blocks
 //Cheese
 GameRegistry.registerBlock(Cheesy.Cheese, "Cheese"); //Needed for all blocks
 LanguageRegistry.addName(Cheesy.Cheese, "Cheese"); //In-game name
 }

 public void registerItems(){ //For registering Items

 }
}