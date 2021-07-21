package utils

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ScrapingUtilTest {

    @Test
    fun scrapingTest(): Unit {
        assertNotNull(ScrapingUtil.scraping("035720"))
    }
}