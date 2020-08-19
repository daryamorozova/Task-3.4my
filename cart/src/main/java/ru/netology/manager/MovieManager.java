package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class MovieManager {
  private PurchaseItem[] items = new PurchaseItem[0];

  public MovieManager(int afishaLength) {
    this.afishaLength = afishaLength;
  }

  public MovieManager() {
  }

  private int afishaLength = 10;


  public void add(PurchaseItem item) {
    // создаём новый массив размером на единицу больше
    int length = items.length + 1;
    PurchaseItem[] tmp = new PurchaseItem[length];
    // копируем поэлементно
    System.arraycopy(items, 0, tmp, 0, items.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public PurchaseItem[] getAll() {
    int resultLength = Math.min(afishaLength, items.length);
    PurchaseItem[] result = new PurchaseItem[resultLength];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }
}
