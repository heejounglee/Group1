function accountCheck() {
	if (document.frm.acct1.value.length != 3 || isNaN(document.frm.acct1.value)) {
		alert("계좌번호를 확인해주세요");
		frm.acct1.focus();
		return false;
	}
	if (document.frm.acct2.value.length != 2 || isNaN(document.frm.acct2.value)) {
		alert("계좌번호를 확인해주세요");
		frm.acct2.focus();
		return false;
	}
	if (document.frm.acct3.value.length != 3 || isNaN(document.frm.acct3.value)) {
		alert("계좌번호를 확인해주세요");
		frm.acct3.focus();
		return false;
	}	
	if (document.frm.name.value.length == 0) {
		alert("예금주명을 확인해주세요");
		frm.name.focus();
		return false;
	}
	if (document.frm.alias.value.length > 10) {
		alert("계좌별명은 10자리이내까지만 입력 가능합니다.");
		frm.alias.focus();
		return false;
		}	
	if (document.frm.phone.value.length == 0) {
		alert("휴대폰번호를 확인해주세요");
		frm.phone.focus();
		return false;
	}
	if (document.frm.balance.value.length == 0 || document.frm.balance.value <= 0 ) {
		alert("계좌등록시 입금액은 1원 이상 하셔야 합니다.");
		frm.balance.focus();
		return false;
	}
	
	
	return true;
}


/*
function idCheck() {
	if (document.frm.userid.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.formm.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(userid) {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 3) {
		alert("아이디는 3글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}
*/