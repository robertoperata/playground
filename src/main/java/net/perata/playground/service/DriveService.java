package net.perata.playground.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import net.perata.playground.domain.Book;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.*;

@Service
@Slf4j
public class DriveService {
    private static final String CSV_FILE_PATH = "input.csv";

    public void listFolder() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {
            CsvToBean<Book> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Book.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            var books = csvToBean.parse();
            books.forEach(out::println);

        }
    }
}
