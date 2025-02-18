package fuzs.spikyspikes.init;

import fuzs.puzzleslib.core.CoreServices;
import fuzs.puzzleslib.init.RegistryManager;
import fuzs.puzzleslib.init.RegistryReference;
import fuzs.spikyspikes.SpikySpikes;
import fuzs.spikyspikes.world.level.block.ForgeSpikeBlock;
import fuzs.spikyspikes.world.level.block.SpikeMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.Locale;

public class ForgeModRegistry {
    public static final BlockPathTypes SPIKE_BLOCK_PATH_TYPE = BlockPathTypes.create(SpikySpikes.MOD_ID.toUpperCase(Locale.ROOT) + "_SPIKE", -1.0F);

    private static final RegistryManager REGISTRY = CoreServices.FACTORIES.registration(SpikySpikes.MOD_ID);
    public static final RegistryReference<Block> WOODEN_SPIKE_BLOCK = REGISTRY.registerBlock("wooden_spike", () -> new ForgeSpikeBlock(SpikeMaterial.WOOD, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryReference<Block> STONE_SPIKE_BLOCK = REGISTRY.registerBlock("stone_spike", () -> new ForgeSpikeBlock(SpikeMaterial.STONE, BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryReference<Block> IRON_SPIKE_BLOCK = REGISTRY.registerBlock("iron_spike", () -> new ForgeSpikeBlock(SpikeMaterial.IRON, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryReference<Block> GOLDEN_SPIKE_BLOCK = REGISTRY.registerBlock("golden_spike", () -> new ForgeSpikeBlock(SpikeMaterial.GOLD, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryReference<Block> DIAMOND_SPIKE_BLOCK = REGISTRY.registerBlock("diamond_spike", () -> new ForgeSpikeBlock(SpikeMaterial.DIAMOND, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryReference<Block> NETHERITE_SPIKE_BLOCK = REGISTRY.registerBlock("netherite_spike", () -> new ForgeSpikeBlock(SpikeMaterial.NETHERITE, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK)));

    public static void touch() {

    }
}
