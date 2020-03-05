function check() {
    if (document.getElementById("name").value===""||
        document.getElementById("email").value===""||
        document.getElementById("country").value===""){
        alert("ban phai dien het giu lieu vao cac o khong duoc de trong")
    }
}
function checkkitu() {
    if (document.getElementById("country").value===""){
        alert("khong duoc de trong hay nhap du lieu can tim kiem")
    }
}