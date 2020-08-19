package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;
  private int afishaLength = 10;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  public void add(PurchaseItem item) {
    repository.save(item);
  }

  public PurchaseItem[] getAll() {
    PurchaseItem[] items = repository.findAll();
    int resultLength = Math.min(afishaLength, items.length);
    PurchaseItem[] result = new PurchaseItem[resultLength];
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

}
