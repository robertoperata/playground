package net.perata.playground.domain;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.perata.playground.mapper.LocalDateConverter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
public class Book {
    @CsvBindByPosition(position = 0)
    private String authors;
    @Id
    @NotNull
    @CsvBindByPosition(position = 1)
    private Long id;
    @CsvCustomBindByPosition(position = 2, converter = LocalDateConverter.class)
    private LocalDate pubdate;
    @CsvBindByPosition(position = 3)
    private String publisher;
    @CsvBindByPosition(position = 4)
    private Long size;
    @CsvBindByPosition(position = 5)
    private String title;
}
