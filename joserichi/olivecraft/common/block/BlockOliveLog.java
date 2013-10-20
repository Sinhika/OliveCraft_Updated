package joserichi.olivecraft.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import joserichi.olivecraft.common.OliveCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockOliveLog
  extends Block
{
  private Icon topIcon;
  private Icon deadIcon;
  
  public BlockOliveLog(int par1, Material par2Material)
  {
    super(par1, par2Material);
    setHardness(2.0F);
    setStepSound(Block.soundWoodFootstep);
    setUnlocalizedName("oliveLog");
    setCreativeTab(OliveCraft.oliveTab);
    setTickRandomly(true);
  }
  
  public void updateTick(World world, int x, int y, int z, Random random)
  {
    int meta = world.getBlockMetadata(x, y, z);
    if (meta == 0)
    {
      if ((world.getBlockId(x, y - 1, z) != Block.dirt.blockID) 
    		  && (world.getBlockId(x, y - 1, z) != Block.grass.blockID)) {
        meta = 15;
      }
    }
    else if ((meta == 13) || (meta == 14))
    {
      if ((world.getBlockId(x, y - 1, z) != this.blockID) 
    		  && (world.getBlockId(x + 1, y, z) != this.blockID) 
    		  && (world.getBlockId(x - 1, y, z) != this.blockID) 
    		  && (world.getBlockId(x, y, z + 1) != this.blockID) 
    		  && (world.getBlockId(x, y, z - 1) != this.blockID)) 
      {
        meta = 15;
      }
    }
    else if ((world.getBlockId(x, y - 1, z) != Block.dirt.blockID) 
    		&& (world.getBlockId(x, y - 1, z) != Block.grass.blockID) 
    		&& (world.getBlockId(x, y - 1, z) != this.blockID)) 
    {
      meta = 15;
    }
    if (meta == 4)
    {
      if (world.getBlockId(x, y + 1, z) == 0) {
        world.setBlock(x, y + 1, z, this.blockID, 5, 2);
      }
      world.setBlockMetadataWithNotify(x, y, z, 14, 2);
    }
    else if (meta == 7)
    {
      if (world.getBlockId(x, y + 1, z) == 0) {
        world.setBlock(x, y + 1, z, this.blockID, 9, 2);
      }
      world.setBlockMetadataWithNotify(x, y, z, 14, 2);
    }
    else if (meta == 11)
    {
      if (((world.getBlockId(x, y + 1, z) == 0 ? 1 : 0) 
    		  & (world.getBlockId(x + 1, y, z) == 0 ? 1 : 0) 
    		  & (world.getBlockId(x - 1, y, z) == 0 ? 1 : 0) 
    		  & (world.getBlockId(x, y, z + 1) == 0 ? 1 : 0) 
    		  & (world.getBlockId(x, y, z - 1) == 0 ? 1 : 0)) != 0)
      {
        world.setBlock(x, y + 1, z, this.blockID, 13, 2);
        world.setBlock(x + 1, y, z, this.blockID, 13, 2);
        world.setBlock(x - 1, y, z, this.blockID, 13, 2);
        world.setBlock(x, y, z + 1, this.blockID, 13, 2);
        world.setBlock(x, y, z - 1, this.blockID, 13, 2);
      }
      world.setBlockMetadataWithNotify(x, y, z, 14, 2);
    }
    else if (meta == 13)
    {
      if (world.getBlockId(x, y + 1, z) == 0) {
        world.setBlock(x, y + 1, z, OliveCraft.oliveLeaves.blockID, 1, 2);
      }
      if (world.getBlockId(x + 1, y, z) == 0) {
        world.setBlock(x + 1, y, z, OliveCraft.oliveLeaves.blockID, 1, 2);
      }
      if (world.getBlockId(x - 1, y, z) == 0) {
        world.setBlock(x - 1, y, z, OliveCraft.oliveLeaves.blockID, 1, 2);
      }
      if (world.getBlockId(x, y, z + 1) == 0) {
        world.setBlock(x, y, z + 1, OliveCraft.oliveLeaves.blockID, 1, 2);
      }
      if (world.getBlockId(x, y, z - 1) == 0) {
        world.setBlock(x, y, z - 1, OliveCraft.oliveLeaves.blockID, 1, 2);
      }
      world.setBlockMetadataWithNotify(x, y, z, 14, 2);
    }
    if ((meta < 14) && 
      (random.nextInt(3) == 2))
    {
      meta++;
      world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
  }
  
  @Override
  public int damageDropped(int meta)
  {
    return 15;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
@SideOnly(Side.CLIENT)
  public void getSubBlocks(int par1, CreativeTabs creativeTabs, List list)
  {
    list.add(new ItemStack(par1, 1, 0));
    list.add(new ItemStack(par1, 1, 15));
  }
  
  @SideOnly(Side.CLIENT)
  public Icon getIcon(int side, int meta)
  {
    if ((side == 0) || (side == 1)) {
      return this.topIcon;
    }
    if (meta == 15) {
      return this.deadIcon;
    }
    return this.blockIcon;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconRegister)
  {
    this.topIcon = iconRegister.registerIcon("OliveCraft:oliveLog_top");
    this.blockIcon = iconRegister.registerIcon("OliveCraft:oliveLog_side");
    this.deadIcon = iconRegister.registerIcon("OliveCraft:oliveLog_dead");
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.block.BlockOliveLog
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */