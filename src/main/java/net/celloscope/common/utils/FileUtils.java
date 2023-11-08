package net.celloscope.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
public class FileUtils {
    public static void saveAudioFile(MultipartFile file,
                                       String pathToSave,
                                       String savedAudioFileName,
                                       String fileExtension) throws IOException {
        byte[] bytes = file.getBytes();
        String fileName = savedAudioFileName + "." + fileExtension;
        Path path = Paths.get(pathToSave + fileName);
        Files.write(path, bytes);
        log.info("Saving file {} at location {}", fileName, pathToSave);
    }
}
