package ru.quazar.l06springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.quazar.l06springboot.model.Book;
import ru.quazar.l06springboot.repository.BookRepository;
import ru.quazar.l06springboot.service.LoadFileToList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryRunner implements CommandLineRunner {

    private List< Book > booksCatalog;
    private static final Logger logger = LoggerFactory.getLogger(SpringBootMultithreadApplication.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {
        String strArgs = Arrays.stream(args).collect(Collectors.joining(" "));
        logger.info("Application started with arguments:" + strArgs);
        System.out.println("Loading argument: " + strArgs);
        booksCatalog = new LoadFileToList().makeListFromFile(strArgs);

        booksCatalog.forEach(System.out::println);
        for (Book myBook : booksCatalog) {
            bookRepository.save(myBook);
        }
    }

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            for (Book myBook : booksCatalog) {
                repository.save(myBook);
            }
        };
    }

/*    @Bean
    CommandLineRunner LoadFileToList() {
        CommandLineRunner initDatabase(BookRepository repository) {

        return System.out.println("Welcome to Library!!!");
        return args -> {

            repository.save(new Book(1L,false, "Два капитана", "Вениамин Каверин", new BigDecimal(540)));
            repository.save(new Book(2L,false, "Красное и Черное", "Стендаль", new BigDecimal(310)));
            repository.save(new Book(3L,false, "Собор Парижской богоматери", "Виктор Гюго", new BigDecimal(870)));
            repository.save(new Book(4L,false, "Отверженные", "Виктор Гюго", new BigDecimal(980)));
            repository.save(new Book(5L,false, "Всадник без головы", "Майн Рид", new BigDecimal(925)));
            repository.save(new Book(6L,false, "Охотники за растениями", "Майн Рид", new BigDecimal(820)));
            repository.save(new Book(7L,false, "Из пушки на Луну", "Жюль Верн", new BigDecimal(1470)));
            repository.save(new Book(8L,false, "Вокруг света за 80 дней", "Жюль Верн", new BigDecimal(1875)));
            repository.save(new Book(9L,false, "20000 лье под водой", "Жюль Верн", new BigDecimal(1825)));
            repository.save(new Book(10L,false, "Дети капитана Гранта", "Жюль Верн", new BigDecimal(1950)));
            repository.save(new Book(11L,false, "Пятнадцатилетний капитан", "Жюль Верн", new BigDecimal(1740)));

        };
    }*/

}