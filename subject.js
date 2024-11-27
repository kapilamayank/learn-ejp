subCodes = [];
const rating = 0;
subCodes.forEach((subCode) => {
  document
    .querySelectorAll(`select[name^="subjects[${subCode}]"]`)
    .forEach(function (e) {
      e.value = rating;
    });
});
