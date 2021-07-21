import utils.FileUtil
import utils.ScrapingUtil
import java.nio.file.Files
import java.nio.file.Path

fun main(): Unit {
    val result = ScrapingUtil.scraping("035720")
    val savedFilePath = FileUtil.saveAs(result, "035720")
    println(Files.readAllLines(Path.of(savedFilePath)))
}