package joserichi.olivecraft.common.worldgen;

import java.util.Random;
import joserichi.olivecraft.common.OliveCraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OliveTreeStructure  extends WorldGenerator
{
  public boolean generate(World world, Random random, int x, int y, int z)
  {
    while ((world.isAirBlock(x, y, z)) && (y > 2)) {
      y--;
    }
    if ((world.getBlockId(x, y, z) == Block.dirt.blockID) 
    		|| (world.getBlockId(x, y, z) == Block.grass.blockID))
    {
      y++;
      world.setBlock(x, y, z, OliveCraft.oliveLog.blockID, 14, 2);
      
      y++;
      world.setBlock(x, y, z, OliveCraft.oliveLog.blockID, 14, 2);
      
      y++;
      world.setBlock(x, y, z, OliveCraft.oliveLog.blockID, 14, 2);
      
      world.setBlock(x + 1, y, z, OliveCraft.oliveLog.blockID, 14, 2);
      world.setBlock(x - 1, y, z, OliveCraft.oliveLog.blockID, 14, 2);
      world.setBlock(x, y, z + 1, OliveCraft.oliveLog.blockID, 14, 2);
      world.setBlock(x, y, z - 1, OliveCraft.oliveLog.blockID, 14, 2);
      
      world.setBlock(x + 2, y, z, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x - 2, y, z, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x, y, z + 2, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x, y, z - 2, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x + 1, y, z + 1, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x + 1, y, z - 1, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x - 1, y, z + 1, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x - 1, y, z - 1, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      
      y++;
      world.setBlock(x, y, z, OliveCraft.oliveLog.blockID, 14, 2);
      
      world.setBlock(x + 1, y, z, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x - 1, y, z, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x, y, z + 1, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      world.setBlock(x, y, z - 1, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      
      y++;
      world.setBlock(x, y, z, OliveCraft.oliveLeaves.blockID, random.nextInt(10) + 1, 2);
      
      return true;
    }
    return false;
  }
}


/* Location:           C:\Projects\Minecraft\mc_mod_src\OliveCraft_deobfuscated\
 * Qualified Name:     joserichi.olivecraft.common.worldgen.OliveTreeStructure
 * JD-Core Version:    0.7.0-SNAPSHOT-20130926
 */