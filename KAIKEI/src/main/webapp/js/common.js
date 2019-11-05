/**
 * 
 

var setCompanyCookie = function(value, day) {
    var date = new Date();
    date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
    console.log(date.toUTCString());
    document.cookie = "CompanyName=" + value + ";expires=" + date.toUTCString() + ";path=/kaikei/";
};

var getCompanyCookie = function(name) {
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
};

var deleteComapnyCookie = function(name) {
    var date = new Date();
    document.cookie = name + "= " + "; expires=" + date.toUTCString() + "; path=/kaikei/";
}
*/