package mokkacicc.rpweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import mokkacicc.rpweapons.api.EnchantmentHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;

import java.util.Collections;
import java.util.List;

public class SpearItem extends ToolItem implements EnchantmentHandler {
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public SpearItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, new Item.Settings().group(ItemGroup.COMBAT));
        attackDamage = attackDamage - 1.0F;
        attackSpeed = -4 + attackSpeed;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Attack range", 1.0D, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public List<EnchantmentTarget> getEnchantmentTypes() {
        return Collections.singletonList(EnchantmentTarget.WEAPON);
    }

    @Override
    public boolean isInvalid(Enchantment enchantment) {
        return enchantment == Enchantments.SWEEPING;
    }
}
