package net.perata.playground.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @NotNull
    private String id;
    private String authors;
    private LocalDateTime timestamp;
    private String isbn;
    private String identifiers;
    private String languages;
    private String libraryName;
    private LocalDateTime pubdate;
    private String publisher;
    private Long size;
    private String title;
    private String titleSort;
    private String uuid;
}
