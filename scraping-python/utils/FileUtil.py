from datetime import datetime


class FileUtil:

    def save_as(self, content, file_name):
        current_date = datetime.today().strftime("%Y%m%d")
        content = "\n\n" + content
        # file = open('/Users/yangsiyeong/study/scraping-python/files/' + file_name + current_date + ".txt", "a")
        file = open('/Users/yangsiyeong/study/scraping-assignment/scraping-python/files/' + file_name + current_date + ".txt", "a")
        file.write(content)
        file.flush()
        file.close()
