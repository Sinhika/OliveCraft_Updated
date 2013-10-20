package joserichi.olivecraft.common.item;

import joserichi.olivecraft.common.OliveCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemToast
  extends ItemFood
{
  public ItemToast(int id)
  {
    super(id, 0, 0.0F, false);
    setMaxStackSize(64);
    setPotionEffect(22, 60, 0, 1.0F);
    setAlwaysEdible();
    setCreativeTab(OliveCraft.oliveTab);
    setUnlocalizedName("toast");
  }
  
  public void registerIcons(IconRegister iconRegister)
  {
    this.itemIcon = iconRegister.registerIcon("OliveCraft:toast");
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.item.ItemToast
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */