package fuzs.spikyspikes.data;

import fuzs.spikyspikes.init.ModRegistry;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.getBuilder("template_spike")
                .parent(new ModelFile.UncheckedModelFile("builtin/entity"))
                .transforms()
                .transform(ItemTransforms.TransformType.GUI)
                .rotation(30, 45, 0)
                .translation(0, 0, 0)
                .scale(0.625F, 0.625F, 0.625F)
                .end()
                .transform(ItemTransforms.TransformType.GROUND)
                .rotation(0, 0, 0)
                .translation(0, 3, 0)
                .scale(0.25F, 0.25F, 0.25F)
                .end()
                .transform(ItemTransforms.TransformType.HEAD)
                .rotation(0, 180, 0)
                .translation(0, 0, 0)
                .scale(1, 1, 1)
                .end()
                .transform(ItemTransforms.TransformType.FIXED)
                .rotation(0, 180, 0)
                .translation(0, 0, 0)
                .scale(0.5F, 0.5F, 0.5F)
                .end()
                .transform(ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND)
                .rotation(75, 315, 0)
                .translation(0, 2.5F, 0)
                .scale(0.375F, 0.375F, 0.375F)
                .end()
                .transform(ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, 315, 0)
                .translation(0, 0, 0)
                .scale(0.4F, 0.4F, 0.4F)
                .end()
                .end();
        this.builtInItem(ModRegistry.WOODEN_SPIKE_ITEM.get(), Blocks.OAK_PLANKS);
        this.builtInItem(ModRegistry.STONE_SPIKE_ITEM.get(), Blocks.SMOOTH_STONE);
        this.builtInItem(ModRegistry.IRON_SPIKE_ITEM.get(), Blocks.IRON_BLOCK);
        this.builtInItem(ModRegistry.GOLDEN_SPIKE_ITEM.get(), Blocks.GOLD_BLOCK);
        this.builtInItem(ModRegistry.DIAMOND_SPIKE_ITEM.get(), Blocks.DIAMOND_BLOCK);
        this.builtInItem(ModRegistry.NETHERITE_SPIKE_ITEM.get(), Blocks.NETHERITE_BLOCK);
    }

    private void builtInItem(Item item, Block texture) {
        this.getBuilder(this.name(item))
                .parent(this.getExistingFile(this.modLoc("template_spike")))
                .texture("particle", this.blockTexture(texture));
    }

    public String name(Item item) {
        return Registry.ITEM.getKey(item).getPath();
    }

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = Registry.BLOCK.getKey(block);
        return new ResourceLocation(name.getNamespace(), BLOCK_FOLDER + "/" + name.getPath());
    }
}
