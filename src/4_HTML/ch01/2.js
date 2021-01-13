// JavaScript source code
/* 동적인 부분(DB와 연동이 없는) */
name = prompt("What's your name?", "HONG");
document.write(name + "~ Welcom<br>");
function chk() {
    if (frm.tel.value.length < 4) {
        alert("전화번호는 뒷 4자리 이상 입력해야해");
        return false;
    }
}