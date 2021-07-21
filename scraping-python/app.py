from utils.ScrapingUtil import ScrapingUtil
from utils.FileUtil import FileUtil


content = ScrapingUtil().scraping("035720")
FileUtil().save_as(content, "035720")
print(ScrapingUtil().scraping("035720"))
