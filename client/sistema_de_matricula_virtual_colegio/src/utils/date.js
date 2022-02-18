const getDayDate = (date) => getDigitDateWith2DigitsMinutes(date.getDate());
const getMonthDate = (date) => getDigitDateWith2DigitsMinutes(date.getMonth() + 1);
const getDigitDateWith2DigitsMinutes = (value) => {
    const valueWithZero = `0${value}`;
    return valueWithZero.substring(valueWithZero.length - 2);
}
export const getDate = (valueDate) => {
    const date = new Date(valueDate);
    date.setMinutes(date.getMinutes() + date.getTimezoneOffset());
    return `${getDayDate(date)}/${getMonthDate(date)}/${date.getFullYear()}`;
}