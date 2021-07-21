import requests, json
from datetime import datetime

class ScrapingUtil:

    def __init__(self):
        self.params = {'requestType' : '1', 'timeframe' : 'day'}
        self.NAVER_FINANCE_URL = 'https://api.finance.naver.com/siseJson.naver'

    def scraping(self, code):
        self.params['symbol'] = code
        self.params['startTime'] = datetime.today().strftime("%Y%m%d")
        self.params['endTime'] = datetime.today().strftime("%Y%m%d")
        response = requests.get(self.NAVER_FINANCE_URL, params= self.params)
        json_data = json.loads(response.text.replace('\'', '"'))
        result = {"code" : code}
        for index, value in enumerate(json_data[0]):
            result[value] = json_data[1][index]

        return str(result)
