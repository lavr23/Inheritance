package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Снигурочка", 1000, "Островский");
    Product second = new Book(2, "Волки и овцы", 1100, "Островский");
    Product third = new Book(3, "Три толстяка", 800, "Олеша");
    Product fourth = new Smartphone(4, "Apple", 4100, "IND");
    Product fifth = new Smartphone(5, "Honor", 3300, "RTF");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }


    @Test
    void searchByName() {

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Три толстяка");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Волки и овцы");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Олеша");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("RTF");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {

        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    //    поиск всех книг одного автора
    @Test
    void searchAllByAuthor() {

        Product[] expected = {third};
        Product[] actual = manager.searchBy("Олеша");
        assertArrayEquals(expected, actual);
    }

    //    Запрос, на который нет ответа
    @Test
    void searchAll() {

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("null");
        assertArrayEquals(expected, actual);
    }

}