package utils

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.time.LocalDate
import java.time.LocalDateTime

class FileUtil {

    companion object {
        val FILE_PATH = "/Users/yangsiyeong/study/scraping-kotlin/src/main/resources/files"

        fun saveAs(content: String, fileName: String): String {
            val currentDate = LocalDate.now()
            val saveFileName = fileName + currentDate
            val path = Path.of("$FILE_PATH/$saveFileName.txt")
            val option = if(Files.exists(path)) StandardOpenOption.APPEND else StandardOpenOption.CREATE
            Files.write(path, content.encodeToByteArray(), option)
            return path.toString()
        }
    }
}