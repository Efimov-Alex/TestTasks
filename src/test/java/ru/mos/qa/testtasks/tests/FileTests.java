package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    public void textContainsWord() throws UnsupportedEncodingException {
        String fileName = "TraineeCharacteristics.txt";
        boolean isContain = false;
        String needWord = "Упорство";

        ClassLoader classLoader = getClass().getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Файл не найден: " + fileName);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, Charset.forName("Windows-1251")))) {
                String line = reader.readLine();


                while (line != null) {
                    System.out.println(line);
                    if (line.contains(needWord)){
                        isContain = true;
                        break;
                    }
                    line = reader.readLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertTrue(isContain, "Файл должен содержать слово: " + needWord);

    }

}
