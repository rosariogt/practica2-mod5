package edu.alenasoft.gildedrose;

public class Default implements IItemStrategy {
    @Override
    public Item calculateQuality(Item item) {
        if (item.getQuality() > 0 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() - 1);
            if (item.getSellIn() < 1)
                item.setQuality(item.getQuality() - 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        return item;
    }
}
