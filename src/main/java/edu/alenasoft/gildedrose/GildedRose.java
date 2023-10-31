package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static List<Item> items = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();

        System.out.println(items);
    }

    public static void updateQuality3() {
        for (Item item : items) {
            if ("Aged Brie".equals(item.getName())) {
                if (item.getQuality() > 0 && item.getQuality() < 50)
                    item.setQuality(item.getQuality() + 2);
            }
            if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                if (item.getQuality() > 0 && item.getQuality() < 50)
                    item.setQuality(item.getQuality() + 2);
                if (item.getSellIn() < 11)
                    item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 6)
                    item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 1)
                    item.setQuality(item.getQuality() - item.getQuality());
            }
            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                if (item.getQuality() > 0 && item.getQuality() < 50) {
                    item.setQuality(item.getQuality() - 1);
                    System.out.println(item.getQuality());
                }
                if (item.getSellIn() == 0 && item.getQuality() > 0 && item.getQuality() < 50) {
                    item.setQuality(item.getQuality() - 1);
                    System.out.println(" = " + item.getQuality());
                }
                item.setSellIn(item.getSellIn() - 1);
            }

        }
    }

    //oficial
    public static void updateQuality5() {
        for (Item item : items) {
            if ("Aged Brie".equals(item.getName())) {
                if (item.getQuality() > 0 && item.getQuality() < 50)
                    item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 1)
                    item.setQuality(item.getQuality() + 1);
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                if (item.getQuality() > 0 && item.getQuality() < 50)
                    item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 11)
                    item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 6)
                    item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 1)
                    item.setQuality(item.getQuality() - item.getQuality());
            } else if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                continue;
            } else {
                if (item.getQuality() > 0 && item.getQuality() < 50)
                    item.setQuality(item.getQuality() - 1);
                if (item.getSellIn() == 0 && item.getQuality() > 0 && item.getQuality() < 50)
                    item.setQuality(item.getQuality() - 1);
            }
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    public static void updateQuality() {
        Context context = new Context();
        for (Item item : items) {
            if ("Aged Brie".equals(item.getName())) {
                context.setStrategy(new AgedBrie());
                context.execute(item);
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                context.setStrategy(new Backstage());
                context.execute(item);
            } else if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                context.setStrategy(new Sulfuras());
                context.execute(item);
            } else {
                context.setStrategy(new Default());
                context.execute(item);
            }
        }
    }

    //final
    public static void updateQuality7() {
        for (Item item : items) {
            if (item.getQuality() > 0 && item.getQuality() < 50) {
                if ("Aged Brie".equals(item.getName())) {
                    item.setQuality(item.getQuality() + 1);
                    if (item.getSellIn() < 1)
                        item.setQuality(item.getQuality() + 1);
                } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    item.setQuality(item.getQuality() + 1);
                    if (item.getSellIn() < 11)
                        item.setQuality(item.getQuality() + 1);
                    if (item.getSellIn() < 6)
                        item.setQuality(item.getQuality() + 1);
                    if (item.getSellIn() < 1)
                        item.setQuality(0);
                } else if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                    continue;
                } else {
                    item.setQuality(item.getQuality() - 1);
                    if (item.getSellIn() < 1)
                        item.setQuality(item.getQuality() - 1);
                }
            }
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    public static void updateQuality4() {
        for (int i = 0; i < items.size(); i++) {
            if ((!"Aged Brie".equals(items.get(i).getName()))
                    && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                if (items.get(i).getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            } else {
                if (items.get(i).getQuality() < 50) {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        if (items.get(i).getSellIn() < 11) {
                            if (items.get(i).getQuality() < 50) {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6) {
                            if (items.get(i).getQuality() < 50) {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0) {
                if (!"Aged Brie".equals(items.get(i).getName())) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        if (items.get(i).getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    } else {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                } else {
                    if (items.get(i).getQuality() < 50) {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }
}
