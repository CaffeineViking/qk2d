package se.sciion.quake2d.ai.behaviour.nodes;

import se.sciion.quake2d.enums.ComponentTypes;
import se.sciion.quake2d.level.Level;
import se.sciion.quake2d.level.components.BotInputComponent;
import se.sciion.quake2d.level.components.HealthComponent;

public class PickupArmor extends PickupConsumable {

	private int previousArmor;
	
	public PickupArmor(BotInputComponent input, Level level, String tag) {
		super(input, level, tag);
		previousArmor = 0;
	}

	@Override
	protected boolean restored() {
		HealthComponent health = input.getParent().getComponent(ComponentTypes.Health);
		boolean restored = false;
		if(health != null){
			restored = health.getArmor() > previousArmor;
		}
		
		previousArmor = health.getArmor();
		return restored;
	}

}