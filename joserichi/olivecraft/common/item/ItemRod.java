package joserichi.olivecraft.common.item;

import joserichi.olivecraft.common.OliveCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRod
  extends Item
{
  public ItemRod(int id)
  {
    super(id);
    setMaxStackSize(1);
    setMaxDamage(59);
    setCreativeTab(OliveCraft.oliveTab);
    setUnlocalizedName("rod");
  }
  
  public boolean isFull3D()
  {
    return false;
  }
  
  public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, 
		  					  World world, int x, int y, int z, int side, 
		  					  float px, float py, float pz)
  {
    if ((world.getBlockId(x, y, z) == OliveCraft.oliveLeaves.blockID) && 
      (world.getBlockMetadata(x, y, z) >= 10))
    {
      world.setBlockMetadataWithNotify(x, y, z, 0, 2);
      itemStack.damageItem(1, entityPlayer);
      if (!world.isRemote)
      {
        EntityItem olive = new EntityItem(world, x + 0.5F, y + 0.5F, z + 0.5F, 
        								  new ItemStack(OliveCraft.olive, 1, 0));
        world.spawnEntityInWorld(olive);
      }
      return true;
    }
    return false;
  }
  
  public void registerIcons(IconRegister iconRegister)
  {
    this.itemIcon = iconRegister.registerIcon("OliveCraft:rod");
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.item.ItemRod
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */