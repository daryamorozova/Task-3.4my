package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestGetMovie {
  private MovieManager manager = new MovieManager();
  private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
  private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);
  private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
  private PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);
  private PurchaseItem fifth = new PurchaseItem(5, 5, "url5", "name5", "genre2", 12);
  private PurchaseItem sixth = new PurchaseItem(6, 6, "url6", "name6", "genre3", 18);
  private PurchaseItem seventh = new PurchaseItem(7, 7, "url7", "name7", "genre1", 6);
  private PurchaseItem eighth = new PurchaseItem(8, 8, "url8", "name8", "genre2", 12);
  private PurchaseItem ninth = new PurchaseItem(9, 9, "url9", "name9", "genre3", 18);
  private PurchaseItem tenth = new PurchaseItem(10, 10, "url10", "name10", "genre1", 6);
  private PurchaseItem eleventh = new PurchaseItem(11, 11, "url11", "name11", "genre2", 12);
  private PurchaseItem twelfth = new PurchaseItem(12, 12, "url12", "name12", "genre3", 18);

  @Test
  public void shouldGet10Of12() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(forth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eighth);
    manager.add(ninth);
    manager.add(tenth);
    manager.add(eleventh);
    manager.add(twelfth);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldGet10Of10() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(forth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eighth);
    manager.add(ninth);
    manager.add(tenth);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldGet5() {
    MovieManager movieManager = new MovieManager(5);
    movieManager.add(first);
    movieManager.add(second);
    movieManager.add(third);
    movieManager.add(forth);
    movieManager.add(fifth);

    PurchaseItem[] actual = movieManager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{fifth, forth, third, second, first};

    assertArrayEquals(expected, actual);
  }
}