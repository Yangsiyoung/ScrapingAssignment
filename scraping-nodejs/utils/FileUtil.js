const fileSystem = require('fs');
const DateUtil = require('./DateUtil');

module.exports = class FileUtil {

    saveAs(content, file_name) {
        const filePath = '/Users/yangsiyeong/study/scraping-assignment/scraping-nodejs/files/' + file_name+ new DateUtil().getDate() + '.txt';
        fileSystem.appendFile(filePath, content, function (error) {
            if(error) console.log(error);
        });
    }
}