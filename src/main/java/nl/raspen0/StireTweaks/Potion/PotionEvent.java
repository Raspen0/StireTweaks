package nl.raspen0.StireTweaks.Potion;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import nl.raspen0.StireTweaks.StirecraftTweaks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PotionEvent {
	
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(PotionRegistry.customPotion)) {
			if (event.entityLiving.getActivePotionEffect(
					PotionRegistry.customPotion).getDuration() == 0) {
				event.entityLiving
						.removePotionEffect(PotionRegistry.customPotion.id);
				return;
			}
			if (event.entityLiving.worldObj.rand.nextInt(20) == 0) {
				event.entityLiving.attackEntityFrom(PotionRegistry.Radiation,
						2);
			}
		}
	}

}
