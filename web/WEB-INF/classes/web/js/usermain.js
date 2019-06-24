var tab1 = document.getElementById("tab1");
var rows1 = tab1.getElementsByTagName("tr");
for (var i = 0; i < rows1.length; i++) {
    rows1[i].onmouseover = function () {
        this.style.backgroundColor = "yellow";
    };
    rows1[i].onmouseout = function () {
        this.style.backgroundColor = "";
    };
}
var tab2 = document.getElementById("tab2");
var rows2 = tab2.getElementsByTagName("tr");
for (var i = 0; i < rows2.length; i++) {
    rows2[i].onmouseover = function () {
        this.style.backgroundColor = "yellow";
    };
    rows2[i].onmouseout = function () {
        this.style.backgroundColor = "";
    };
}
