package net.kaupenjoe.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.item.Item;




import javax.xml.stream.Location;
import java.util.List;
import java.util.Random;

public class EpicBlock extends Block {
    public EpicBlock(Properties properties) {
        super(properties);
    }
    static Item randomItem = Items.STICK;
    Item[] items = {
            Items.COBBLESTONE,
            Items.GRANITE,
            Items.ANDESITE,
            Items.DIORITE,
            Items.SMOOTH_STONE,
            Items.OAK_LOG,
            Items.DARK_OAK_LOG,
            Items.SPRUCE_LOG,
            Items.ACACIA_LOG,
            Items.JUNGLE_LOG,
            Items.BIRCH_LOG,
            Items.PODZOL,
            Items.ICE,
            Items.PACKED_ICE,
            Items.NETHER_WART_BLOCK,
            Items.SAND,
            Items.GRAVEL,
            Items.OBSIDIAN,
            Items.TERRACOTTA,
            Items.DIRT,
            Items.GLASS,
            Items.PRISMARINE_BRICKS,
            Items.PRISMARINE,
            Items.NETHERRACK,
            Items.CLAY,
            Items.BRICKS,
            Items.SOUL_SAND,
            Items.BLACKSTONE,
            Items.BASALT,
            Items.MAGMA_BLOCK,
            Items.END_STONE,
            Items.WHITE_WOOL,
            Items.NETHER_BRICKS,
            Items.PURPUR_BLOCK,
            Items.SNOW_BLOCK,
            Items.DARK_PRISMARINE,
            Items.WHITE_CONCRETE,
            Items.GLOWSTONE_DUST,
            Items.LAPIS_LAZULI,
            Items.CHARCOAL,
            Items.COAL,
            Items.GOLD_INGOT,
            Items.IRON_INGOT,
            Items.REDSTONE,
            Items.DIAMOND,
            Items.EMERALD,
            Items.NETHERITE_SCRAP,
            Items.QUARTZ,
            Items.GUNPOWDER,
            Items.SUGAR_CANE,
            Items.CARROT,
            Items.WHEAT,
            Items.POTATO,
            Items.PUMPKIN,
            Items.MELON,
            Items.BONE,
            Items.ROTTEN_FLESH,
            Items.STRING,
            Items.ENDER_PEARL,
            Items.PORKCHOP,
            Items.BEEF,
            Items.CHICKEN,
            Items.FEATHER,
            Items.CACTUS,
            Items.WHEAT_SEEDS,
            Items.LEATHER,
            Items.SNOWBALL,
            Items.SLIME_BALL,
            Items.COD,
            Items.KELP,
            Items.BAMBOO,
            Items.CHORUS_FRUIT,
            Items.BROWN_MUSHROOM,
            Items.RED_MUSHROOM,
            Items.VINE,
            Items.SUNFLOWER,
            Items.LILAC,
            Items.ROSE_BUSH,
            Items.PEONY,
            Items.HONEY_BOTTLE,
            Items.SWEET_BERRIES,
            Items.APPLE,
            Items.SEA_PICKLE,
            Items.WITHER_ROSE,
            Items.COCOA_BEANS,
            Items.FLINT,
            Items.INK_SAC,
            Items.NETHER_WART,
            Items.BLAZE_ROD,
            Items.NETHER_STAR,
            Items.DRAGON_HEAD,
            Items.SADDLE,
            Items.WITHER_SKELETON_SKULL,
            Items.CAKE,
            Items.NAUTILUS_SHELL,
            Items.HEART_OF_THE_SEA,
            Items.PHANTOM_MEMBRANE,
            Items.TRIDENT,
            Items.TURTLE_EGG,
            //Items.MUSIC_DISC_,
            Items.HONEYCOMB,
            //Items.QUARKSOUL_BEAD,
            //Items.QUARKDIAMOND_HEART,
            Items.POISONOUS_POTATO,
            Items.BELL,
            Items.COBWEB,
    };

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult blockHitResult) {
        // Server: Main Hand & Off Hand
        // Client: Main Hand & Off Hand
        // if (hand == InteractionHand.MAIN_HAND && level.isClientSide()){
        //    player.sendSystemMessage(Component.literal("Right Clicked this!"));
        //}
        if(!level.isClientSide){
            AABB minmax = new AABB(blockPos.getX()-2,blockPos.getY()-2,blockPos.getZ()-2,blockPos.getX()+2,blockPos.getY()+2,blockPos.getZ()+2);
            List<Entity> entities = level.getEntities(null,minmax);

            for (Entity ent : entities){
                if (ent instanceof ItemEntity){
                    ItemEntity itemEntity = (ItemEntity) ent;
                    ItemStack itemStack = itemEntity.getItem();
                    if (!itemStack.isEmpty() && itemStack.getItem() instanceof Item && itemStack.getItem().equals(randomItem)) {
                        player.sendSystemMessage(Component.literal("Detected the required item no shot"));

                        Random random = new Random();
                        randomItem = items[random.nextInt(items.length)];
                        player.sendSystemMessage(Component.literal("The next item needed is " + randomItem));





                    }
                }
            }

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200));
        }

        super.stepOn(level, pos, state, entity);
    }
}
