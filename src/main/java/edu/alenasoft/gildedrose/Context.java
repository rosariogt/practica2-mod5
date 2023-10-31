package edu.alenasoft.gildedrose;

public class Context {

    private IItemStrategy strategy = new Default();

    public Item execute(Item item) {
        return strategy.calculateQuality(item);
    }

    public IItemStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IItemStrategy strategy) {
        this.strategy = strategy;
    }
}
