const dateOptions = {weekday: 'short', year: 'numeric', month: 'short', day: 'numeric'};

const format_date = function(date) {

    var parsedDate = new Date(Date.parse(date));
    return parsedDate.toLocaleString('en-us', dateOptions);
} 

export default format_date