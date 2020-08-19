package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
  @Mock
  private AfishaRepository afishaRepository;
  @InjectMocks
  private AfishaManager afishaManager;
  private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
  private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);
  private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
  private PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);

  @BeforeEach
  public void setUp() {
    afishaManager.add(first);
    afishaManager.add(second);
    afishaManager.add(third);
  }

  @Test
  public void shouldAdd() {
    afishaManager.add(forth);
    // настройка заглушки
    PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth};
    doReturn(returned).when(afishaRepository).findAll();

    PurchaseItem[] expected = new PurchaseItem[]{first, second, third, forth};
    PurchaseItem[] actual = afishaRepository.findAll();
    assertArrayEquals(expected, actual);

  }

  @Test
  public void shouldGetAll() {
    // настройка заглушки
    PurchaseItem[] returned = new PurchaseItem[]{first, second, third};
    doReturn(returned).when(afishaRepository).findAll();

    PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
    PurchaseItem[] actual = afishaManager.getAll();
    assertArrayEquals(expected, actual);

  }
}