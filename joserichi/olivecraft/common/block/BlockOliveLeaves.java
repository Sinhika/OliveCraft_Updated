package joserichi.olivecraft.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import joserichi.olivecraft.common.OliveCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockOliveLeaves
  extends Block
  implements IShearable
{
  private Icon fullIcon;
  private Icon halfIcon;
  
  public BlockOliveLeaves(int par1, Material par2Material)
  {
    super(par1, par2Material);
    setHardness(0.2F);
    setStepSound(Block.soundGrassFootstep);
    setUnlocalizedName("oliveLeaves");
    setLightOpacity(1);
    setCreativeTab(OliveCraft.oliveTab);
    setTickRandomly(true);
  }
  
  public void updateTick(World world, int x, int y, int z, Random random)
  {
    int meta = world.getBlockMetadata(x, y, z);
    if (meta == 0) {
      return;
    }
    if (!canBlockStay(world, x, y, z))
    {
      world.setBlockToAir(x, y, z);
      return;
    }
    if (meta <= 11)
    {
      meta++;
      world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
    else
    {
      world.setBlockMetadataWithNotify(x, y, z, 11, 2);
    }
  }
  
  public boolean canBlockStay(World world, int x, int y, int z)
  {
    return (((world.getBlockId(x - 1, y, z) == OliveCraft.oliveLog.blockID) 
    		|| (world.getBlockId(x + 1, y, z) == OliveCraft.oliveLog.blockID) 
    		|| (world.getBlockId(x, y, z - 1) == OliveCraft.oliveLog.blockID) 
    		|| (world.getBlockId(x, y, z + 1) == OliveCraft.oliveLog.blockID) 
    		|| (world.getBlockId(x, y - 1, z) == OliveCraft.oliveLog.blockID))  
    		&& (world.getBlockMetadata(x, y, z) != 0 ));
    
  }
  
  public int quantityDropped(int meta, int fortune, Random random)
  {
    return 0;
  }
  
  @SideOnly(Side.CLIENT)
  public Icon getIcon(int side, int meta)
  {
	  if (meta >= 6 && meta < 11)
	  {
		  return this.halfIcon;
	  }
	  else if (meta >= 11)
	  {
		 return this.fullIcon; 
	  }
	  else {
    	return this.blockIcon;
	  }
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconRegister)
  {
    this.blockIcon = iconRegister.registerIcon("OliveCraft:oliveLeaves");
    this.halfIcon = iconRegister.registerIcon("OliveCraft:oliveLeaves_half");
    this.fullIcon = iconRegister.registerIcon("OliveCraft:oliveLeaves_full");
  }
  
  public boolean isShearable(ItemStack item, World world, int x, int y, int z)
  {
    return true;
  }
  
  public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
  {
    ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    ret.add(new ItemStack(this, 1, 0));
    return ret;
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.block.BlockOliveLeaves
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */