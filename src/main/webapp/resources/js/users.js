$.fn.formToJSON = function () {
    var result = {};
    var array = this.serializeArray();
    $.each(array, function () {
        if (result[this.name] !== undefined) {
            if (!result[this.name].push) {
                result[this.name] = [result[this.name]];
            }
            result[this.name].push(this.value || '');
        } else {
            result[this.name] = this.value || '';
        }
    });
    return JSON.stringify(result);
};