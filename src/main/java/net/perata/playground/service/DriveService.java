package net.perata.playground.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.perata.playground.domain.Book;
import net.perata.playground.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


@Service
@Slf4j
@AllArgsConstructor
public class DriveService {

    private final BookRepository bookRepository;
    private static final String CSV_FILE_PATH = "imports.csv";

    public void listFolder() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {

            CsvToBean<Book> csvToBean = new CsvToBeanBuilder<Book>(reader)
                    .withType(Book.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            var books = csvToBean.parse();
            bookRepository.saveAll(books);
        }
    }

    public Page<Book> findAll(String sortBy, Integer skip, Integer limit) {
        int pageSize = Math.abs(limit);
        int pageNumber = Math.abs(Math.floorDiv(skip, limit));
        return bookRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)));
    }
}
