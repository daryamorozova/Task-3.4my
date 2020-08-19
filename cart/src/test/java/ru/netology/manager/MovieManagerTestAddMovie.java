package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestAddMovie {
  private MovieManager manager = new MovieManager();
  private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
  private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);


  @Test
  public void shouldAddMovie() {
    manager.add(first);
    manager.add(second);


    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{second, first};

    assertArrayEquals(expected, actual);
  }
}