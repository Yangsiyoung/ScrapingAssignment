package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.lang.StringBuilder
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.stream.Stream

class ScrapingUtil {
    companion object {
        val NAVER_SFINANCE_API_URL = "https://api.finance.naver.com/siseJson.naver"
        val params = mutableMapOf("requestType" to "1", "timeframe" to "day")

        fun scraping(code: String): String {
            val objectMapper = ObjectMapper()
            params["symbol"] = code
            params["startTime"] = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
            params["endTime"] = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))

            val queryParams = params.map { (key, value) -> "$key=$value" }.joinToString("&")

            val httpClient = HttpClient.newBuilder().build()
            val request = HttpRequest.newBuilder()
                            .uri(URI.create("$NAVER_SFINANCE_API_URL?$queryParams"))
                            .build()
            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
            val stringBuilder = StringBuilder("\n ### $code 주가정보 ### \n")

            if(response.statusCode() in 200..299) {
                val responseBody = response.body().replace('\'', '"')
                val menu = objectMapper.readTree(responseBody)[0].map { it.toString() }.toMutableList()
                val values = objectMapper.readTree(responseBody)[1].map { it.toString() }.toMutableList()
                menu.forEachIndexed { index, value ->  stringBuilder.append("$value : ${values[index]} \n")}
            }

            return stringBuilder.toString()
        }
    }
}