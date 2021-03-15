package mokkacicc.rpweapons;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import mokkacicc.rpweapons.item.DaggerItem;
import mokkacicc.rpweapons.item.SpearItem;

public class RpWeapons implements ModInitializer {
    public static final DaggerItem WOODEN_DAGGER = register("wooden_dagger", new DaggerItem(ToolMaterials.WOOD, 2f, 2f));
    public static final DaggerItem STONE_DAGGER = register("stone_dagger", new DaggerItem(ToolMaterials.STONE, 3f, 2f));
    public static final DaggerItem GOLDEN_DAGGER = register("golden_dagger", new DaggerItem(ToolMaterials.GOLD, 2f, 2f));
    public static final DaggerItem IRON_DAGGER = register("iron_dagger", new DaggerItem(ToolMaterials.IRON, 4f, 2f));
    public static final DaggerItem DIAMOND_DAGGER = register("diamond_dagger", new DaggerItem(ToolMaterials.DIAMOND, 5f, 2f));
    public static final DaggerItem NETHERITE_DAGGER = register("netherite_dagger", new DaggerItem(ToolMaterials.NETHERITE, 6f, 2f));

    public static final SpearItem WOODEN_SPEAR = register("wooden_spear", new SpearItem(ToolMaterials.WOOD, 4f, 0.8f));
    public static final SpearItem STONE_SPEAR = register("stone_spear", new SpearItem(ToolMaterials.STONE, 5f, 0.8f));
    public static final SpearItem GOLDEN_SPEAR = register("golden_spear", new SpearItem(ToolMaterials.GOLD, 4f, 0.8f));
    public static final SpearItem IRON_SPEAR = register("iron_spear", new SpearItem(ToolMaterials.IRON, 6f, 0.8f));
    public static final SpearItem DIAMOND_SPEAR = register("diamond_spear", new SpearItem( ToolMaterials.DIAMOND, 7f, 0.8f));
    public static final SpearItem NETHERITE_SPEAR = register("netherite_spear", new SpearItem(ToolMaterials.NETHERITE, 8f, 0.8f));

    public static Identifier id(String name) {
        return new Identifier("rpweapons", name);
    }

    private static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, RpWeapons.id(name), item);
    }

    @Override
    public void onInitialize() {
        // not used
    }
}
