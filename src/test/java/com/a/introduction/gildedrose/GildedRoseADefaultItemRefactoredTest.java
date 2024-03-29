package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemRefactoredTest {

  public static final int NOT_EXPIRED_SELL_IN = 15;
  public static final int DEFAULT_QUALITY = 3;
  public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
  public static final int EXPIRED_SELL_IN = -1;

  @Test
  public void unexpiredDefaultItem_qualityDecreasesBy1() {
    GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);

    app.updateQuality();

    Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);

    assertItem(expected, app.items[0]);
  }

  @Test
  public void expiredDefaultItem_qualityDecreasesBy2() {

    GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, EXPIRED_SELL_IN, DEFAULT_QUALITY);

    app.updateQuality();

    Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);

    assertItem(expected, app.items[0]);
  }

  private GildedRose createGildedRoseWithItem(String itemName, int sellIn, int quality) {
    Item item = new Item(itemName, sellIn, quality);
    Item[] items = new Item[] {item};
    GildedRose app = new GildedRose(items);
    return app;
  }

  private void assertItem(Item expected, Item actual) {
    assertEquals(expected.name, actual.name);
    assertEquals(expected.sellIn, actual.sellIn);
    assertEquals(expected.quality, actual.quality);
  }
}
