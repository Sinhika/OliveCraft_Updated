package joserichi.olivecraft.common.item;

import joserichi.olivecraft.common.OliveCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemOlive
  extends Item
{
  public ItemOlive(int id)
  {
    super(id);
    setMaxStackSize(64);
    setCreativeTab(OliveCraft.oliveTab);
    setUnlocalizedName("olive");
  }
  
  public void registerIcons(IconRegister iconRegister)
  {
    this.itemIcon = iconRegister.registerIcon("OliveCraft:olive");
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.item.ItemOlive
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */