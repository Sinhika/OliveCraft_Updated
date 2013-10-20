package joserichi.olivecraft.common.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOliveLog
  extends ItemBlock
{
  public ItemBlockOliveLog(int id)
  {
    super(id);
    setHasSubtypes(true);
    setMaxStackSize(64);
  }
  
  public int getMetadata(int meta)
  {
    return meta;
  }
  
  public String getUnlocalizedName(ItemStack itemStack)
  {
    return getUnlocalizedName() + "." + itemStack.getItemDamage();
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.block.ItemBlockOliveLog
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */