module.exports = class DateUtil {
    getDate() {
        const currentDate = new Date();
        let currentYear = currentDate.getFullYear();
        let currentMonth = currentDate.getMonth() + 1;
        let currentDay = currentDate.getDate();
        currentMonth = currentMonth < 10 ? '0' + currentMonth : currentMonth
        currentDay = currentDay < 10 ? '0' + currentDay : currentDay
        return currentYear + currentMonth + currentDay
    }
}