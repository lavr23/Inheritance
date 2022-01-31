package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);

    }



    public Product[] searchBy(String text) {
        Product[] products = repository.findAll();
        Product[] result = new Product[0];
        for (Product product : products) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) { //Проверка на наличие поискового слова в данных о названии
            return true;
        }
        if (product instanceof Book) {// если в параметре product лежит объект класса Book
            Book book = (Book) product;// положим его в переменную типа Book, чтобы пользоваться методами класса Book

            if (book.getAuthor().contains(search)) {// проверим, есть ли поисковое слово в данных об авторе
                return true;
            }
        }

        if (product instanceof Smartphone) {// если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product;// положим его в переменную типа Smartphone, чтобы пользоваться методами класса Smartphone

            if (smartphone.getManufacture().contains(search)) {// проверим, есть ли поисковое слово в данных о производителе
                return true;
            }
        }
        return false;
    }


}