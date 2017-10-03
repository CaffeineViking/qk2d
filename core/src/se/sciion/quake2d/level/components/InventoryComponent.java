package se.sciion.quake2d.level.components;

import com.badlogic.gdx.utils.Array;

import se.sciion.quake2d.enums.ComponentTypes;
import se.sciion.quake2d.graphics.RenderModel;
import se.sciion.quake2d.level.items.Item;

public class InventoryComponent extends EntityComponent {

	private Array<Item> items;
	
	public InventoryComponent(Item ...items) {
		this.items = Array.with(items);
	}
	
	@Override
	public void render(RenderModel batch) {
		
	}

	@Override
	public void tick(float delta) {
		
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		if(items.contains(item, false)) {
			items.removeValue(item,false);
		}
	}
	
	public boolean containsItem(Item item) {
		return items.contains(item, false);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Item> Array<T> getItems(Class<T> type) {
		Array<T> ret = new Array<T>();
		for(Item i: items) {
			if(type.isInstance(i)) {
				ret.add((T)i);
			}
		}
		return ret;
	}

	
	@Override
	public ComponentTypes getType() {
		return ComponentTypes.Inventory;
	}

}
