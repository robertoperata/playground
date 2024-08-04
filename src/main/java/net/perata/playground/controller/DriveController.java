package net.perata.playground.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.perata.playground.domain.Book;
import net.perata.playground.service.DriveService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class DriveController {

    private final DriveService driveService;

    @Operation(summary = "save csv to db")
    @GetMapping("/folder")
    @ResponseStatus(HttpStatus.CREATED)
    public void listFilesInFolder() throws IOException {
        driveService.listFolder();
    }

    @Operation(summary = "get all books paged")
    @GetMapping
    public ResponseEntity<List<Book>> findAll(@RequestParam(required = false) String sortBy,
                                             @RequestParam(required = false, defaultValue = "0") Integer skip,
                                             @RequestParam(required = false, defaultValue = "50") Integer limit) {

        Page<Book> books = driveService.findAll(sortBy, skip, limit);
        return ResponseEntity.ok(books.getContent());
    }

}
