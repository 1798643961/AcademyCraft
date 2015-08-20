package cn.academy.misc.achievements.aches;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import cn.academy.ability.api.Category;
import cn.academy.misc.achievements.DispatcherAch;

/**
 * @author EAirPeter
 */
public final class AchEvLevelChange extends AchAbility {

	private final int level;
	
	public AchEvLevelChange(int lv, Category cat, String id, int x, int y, Item display, Achievement parent) {
		super(cat, id, x, y, display, parent);
		level = lv;
	}
	public AchEvLevelChange(int lv, Category cat, String id, int x, int y, Block display, Achievement parent) {
		super(cat, id, x, y, display, parent);
		level = lv;
	}
	public AchEvLevelChange(int lv, Category cat, String id, int x, int y, ItemStack display, Achievement parent) {
		super(cat, id, x, y, display, parent);
		level = lv;
	}
	
	@Override
	public void registerAll() {
		DispatcherAch.INSTANCE.rgLevelChange(category, level, this);
	}
	
	@Override
	public void unregisterAll() {
		DispatcherAch.INSTANCE.urLevelChange(category, level);
	}

}
