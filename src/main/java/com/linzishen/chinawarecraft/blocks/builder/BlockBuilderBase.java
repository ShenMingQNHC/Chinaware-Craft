package com.linzishen.chinawarecraft.blocks.builder;

import com.linzishen.chinawarecraft.blocks.tileEntity.builder.TileEntityBuilderBase;
import com.linzishen.chinawarecraft.init.ModCreativeTab;
import com.linzishen.chinawarecraft.IdlFramework;
import com.linzishen.chinawarecraft.blocks.BlockBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockBuilderBase extends BlockBase implements ITileEntityProvider {

    Class<? extends TileEntityBuilderBase> tileEntity;

    public BlockBuilderBase(String name, Material material, Class<? extends TileEntityBuilderBase> tileEntity) {
        super(name, material);
        this.tileEntity = tileEntity;
        setCreativeTab(ModCreativeTab.CHIPMOD_BLOCK);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 3);
        setLightOpacity(1);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntityBuilderBase createNewTileEntity(World worldIn, int meta) {
        TileEntityBuilderBase t = null;
        try {
            t = tileEntity.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            IdlFramework.Log("Instantiate failed");
        }
        return t;
    }
}
