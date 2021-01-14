// JavaScript source code
function chk() {
    if (frm.name.value.length < 2) {
        alert("이름은 2글자 이상 입력해 주세요");
        frm.name.focus();
        return false;
    } else if (frm.id.value.length < 4) {
        alert("아이디는 4글자 이상 입력해 주세요");
        frm.id.focus();
        return false;
    } else if (frm.pw.value.length < 1) {
        alert("비밀번호는 1글자 이상 입력해 주세요");
        frm.pw.focus();
        return false;
    } else if (frm.pw.value != frm.pwC.value) {
        alert("비밀번호를 확인해 주세요");
        frm.pwc.focus();
        return false;
    }
}