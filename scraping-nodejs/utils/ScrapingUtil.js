const request = require('request');
const DateUtil = require('./DateUtil');
const FileUtil = require('./FileUtil');
module.exports = class ScrapingUtil {
    static NAVER_FINANCE_URL = 'https://api.finance.naver.com/siseJson.naver';

    scraping(code) {
        const requestOptions = {
            uri: ScrapingUtil.NAVER_FINANCE_URL,
            qs: {
                symbol : code,
                requestType : 1,
                timeframe : 'day',
                startTime : new DateUtil().getDate(),
                endTime : new DateUtil().getDate()
            }
        }
        let result = ['code : ' + code];
        request(requestOptions, function (error, response, body) {
            body = body.replace(/'/g, '"');
            const menu = JSON.parse(body)[0];
            const values = JSON.parse(body)[1];

            for(let index = 0; index < menu.length; index++) {
                result.push(' ' + menu[index] + " : " + values[index]);
            }
            new FileUtil().saveAs(result.toString() + "\n", code);
        });

    }


}
