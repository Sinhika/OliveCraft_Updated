package joserichi.olivecraft.common;

import joserichi.olivecraft.common.block.BlockOliveLeaves;
import joserichi.olivecraft.common.block.BlockOliveLog;
import joserichi.olivecraft.common.block.ItemBlockOliveLog;
import joserichi.olivecraft.common.item.ItemOil;
import joserichi.olivecraft.common.item.ItemOlive;
import joserichi.olivecraft.common.item.ItemRod;
import joserichi.olivecraft.common.item.ItemToast;
import joserichi.olivecraft.common.worldgen.OliveGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="olivecraft", name="OliveCraft Updated", version="1.6.4a")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class OliveCraft
{
  public int oliveLogID;
  public static Block oliveLog;
  public int oliveLeavesID;
  public static Block oliveLeaves;
  public int oliveID;
  public static Item olive;
  public int oilID;
  public static Item oil;
  public int toastID;
  public static Item toast;
  public int rodID;
  public static Item rod;
  
  public static CreativeTabs oliveTab = new CreativeTabs("oliveTab")
  {
    public ItemStack getIconItemStack()
    {
      return new ItemStack(OliveCraft.olive, 1, 0);
    }
  };
  
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event)
  {
    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    config.load();
    this.oliveLogID = config.getBlock("Olive Log", 500).getInt();
    this.oliveLeavesID = config.getBlock("Olive Leaves", 501).getInt();
    this.oliveID = (config.getItem("Olive", 5000).getInt() - 256);
    this.oilID = (config.getItem("Oil", 5001).getInt() - 256);
    this.toastID = (config.getItem("Toast", 5002).getInt() - 256);
    this.rodID = (config.getItem("rod", 5003).getInt() - 256);
    config.save();
  }
  
  @Mod.EventHandler
  public void load(FMLInitializationEvent event)
  {
    LanguageRegistry.instance().addStringLocalization("itemGroup.oliveTab", "en_US", "OliveCraft");
    

    oliveLog = new BlockOliveLog(this.oliveLogID, Material.wood);
    
    GameRegistry.registerBlock(oliveLog, ItemBlockOliveLog.class, "oliveLog");
    Block.setBurnProperties(this.oliveLogID, 5, 5);
    MinecraftForge.setBlockHarvestLevel(oliveLog, "axe", 0);
    LanguageRegistry.instance().addNameForObject(new ItemStack(oliveLog, 1, 0), "en_US", "Fertilized olive log");
    LanguageRegistry.instance().addNameForObject(new ItemStack(oliveLog, 1, 0), "es_ES", "Madera de olivo fertilizada");
    LanguageRegistry.instance().addNameForObject(new ItemStack(oliveLog, 1, 15), "en_US", "Olive log");
    LanguageRegistry.instance().addNameForObject(new ItemStack(oliveLog, 1, 15), "es_ES", "Madera de olivo");
    

    oliveLeaves = new BlockOliveLeaves(this.oliveLeavesID, Material.leaves);
    GameRegistry.registerBlock(oliveLeaves, "oliveLeaves");
    Block.setBurnProperties(this.oliveLeavesID, 30, 60);
    LanguageRegistry.instance().addNameForObject(oliveLeaves, "en_US", "Olive leaves");
    LanguageRegistry.instance().addNameForObject(oliveLeaves, "es_ES", "Hojas de olivo");
    

    olive = new ItemOlive(this.oliveID);
    LanguageRegistry.instance().addNameForObject(olive, "en_US", "Olive");
    LanguageRegistry.instance().addNameForObject(olive, "es_ES", "Aceituna");
    

    oil = new ItemOil(this.oilID);
    LanguageRegistry.instance().addNameForObject(oil, "en_US", "Olive oil");
    LanguageRegistry.instance().addNameForObject(oil, "es_ES", "Aceite de oliva");
    

    toast = new ItemToast(this.toastID);
    LanguageRegistry.instance().addNameForObject(toast, "en_US", "Oil toast");
    LanguageRegistry.instance().addNameForObject(toast, "es_ES", "Tostada de aceite");
    

    rod = new ItemRod(this.rodID);
    LanguageRegistry.instance().addNameForObject(rod, "en_US", "Rod");
    LanguageRegistry.instance().addNameForObject(rod, "es_ES", "Vara");
    

    ItemStack oilCr = new ItemStack(oil, 1, 0);
    ItemStack oliveCr = new ItemStack(olive, 1, 0);
    ItemStack boneCr = new ItemStack(Item.dyePowder, 1, 15);
    GameRegistry.addRecipe(new ItemStack(oliveLog, 1, 0), new Object[] { " b ", "blb", " b ", Character.valueOf('b'), boneCr, Character.valueOf('l'), new ItemStack(oliveLog, 1, 15) });
    GameRegistry.addShapelessRecipe(oilCr, new Object[] { oliveCr, oliveCr, oliveCr, new ItemStack(Item.glassBottle, 1, 0) });
    GameRegistry.addShapelessRecipe(new ItemStack(toast, 1, 0), new Object[] { oilCr, new ItemStack(Item.bread, 1, 0) });
    for (int i = 0; i < 4; i++) {
      GameRegistry.addRecipe(new ItemStack(rod, 1, 0), new Object[] { "  s", " s ", "w  ", Character.valueOf('s'), new ItemStack(Item.stick, 1, 0), Character.valueOf('w'), new ItemStack(Block.planks, 1, i) });
    }
    GameRegistry.registerWorldGenerator(new OliveGen());
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.OliveCraft
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */