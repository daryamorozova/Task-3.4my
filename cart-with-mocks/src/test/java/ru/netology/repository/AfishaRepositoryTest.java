package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository afishaRepository = new AfishaRepository();

    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);
    private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);

    @BeforeEach
    public void setUp() {
        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
    }

    @Test
    public void shouldAdd() {
        PurchaseItem[] actual = afishaRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        afishaRepository.removeById(idToRemove);
        PurchaseItem[] actual = afishaRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {
        int findId = 2;
        PurchaseItem actual = afishaRepository.findById(findId);
        PurchaseItem expected = second;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        PurchaseItem actual = afishaRepository.findById(findId);

        assertEquals(null, actual);
    }

    @Test
    public void shouldRemoveAll() {
        afishaRepository.removeAll();
        PurchaseItem[] actual = afishaRepository.removeAll();
        PurchaseItem[] expected = new PurchaseItem[0];

        assertArrayEquals(expected, actual);
    }

}