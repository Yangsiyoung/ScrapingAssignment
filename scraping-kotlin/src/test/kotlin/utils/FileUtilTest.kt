package utils

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

class FileUtilTest {

    @Test
    fun saveTest(): Unit {
        val savedFilePath = FileUtil.saveAs("test Content",  "testFile")
        assertTrue(Files.readAllLines(Path.of(savedFilePath)).contains("test Content"))
    }
}