export function formatDateCustom(date: any) {
  return new Date(
    date.getFullYear() +
      '-' +
      (date.getMonth().toString().length == 1
        ? '0' + date.getMonth()
        : date.getMonth()) +
      '-' +
      (date.getDay().toString().length == 1
        ? '0' + date.getDay()
        : date.getDay())
  );
}
