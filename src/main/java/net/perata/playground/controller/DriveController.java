package net.perata.playground.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.perata.playground.service.DriveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class DriveController {

    private final DriveService driveService;

    @Operation(summary = "List books on folder")
    @GetMapping("/folder")
    public void listFilesInFolder() throws IOException {
        driveService.listFolder();
    }
}
