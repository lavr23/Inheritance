package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    public void shouldHaveAllMethodsFromSuper() {
        Book book = new Book();

    }

    @Test
    public void shouldUseEquals() {
        Book book1 = new Book(8, "MacBook", 1000, "xxx");
        Book book2 = new Book(8, "MacBook", 1000, "xxx");


        assertEquals(book1, book2);

    }

}