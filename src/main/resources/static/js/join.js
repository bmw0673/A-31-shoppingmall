/**
 * 
 */
document.addEventListener("DOMContentLoaded", function() {
  const form = document.querySelector('#form');

  if (form) { // form이 존재하는지 확인
    form.addEventListener('submit', function(event) {
      event.preventDefault(); // 폼 제출 방지

      var email = document.getElementById('email__jid').value;
      var password = document.getElementById('password__jid').value;
      var passwordCheck = document.getElementById('passwordCheck__jid').value;
      let isValid = true;

	  // 필드에 대한 에러 메시지를 보여주는 함수 정의
      function displayErrorMessage(fieldId, message, isValid) {
        var field = document.getElementById(fieldId);
        var msg = field.parentNode.querySelector('.msg');
        if (isValid==false) {
		    field.style.borderColor = 'red';
		}
        msg.textContent = message;
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
      }

      // 모든 필드의 유효성을 확인하고, isValid 값을 변경
      if (!isValidEmail(email)) {
        isValid = false;
        displayErrorMessage('email__jid', '이메일을 입력하세요.', isValid);
      }

      if (!isValidPassword(password)) {
        isValid = false;
        displayErrorMessage('password__jid', '비밀번호를 입력하세요.', isValid);
      }

      if (!isValidPassword(password)==isValidpasswordCheck(passwordCheck)) {
        isValid = false;
        displayErrorMessage('passwordCheck__jid', '비밀번호확인을 입력하세요.', isValid);
      }

      if (!isValidname(name)) {
        isValid = false;
        displayErrorMessage('name__jid', '이름을 입력하세요.', isValid);
      }
      
      if (!isValidphonenum(phonenum)) {
		 isValid = false;
		 displayErrorMessage('phonenum__jid', '연락처를 입력하세요.', isValid);
	  }
	  
	  if (!isValidnickName(nickName)) {
		 isValid = false;
		 displayErrorMessage('nickName__jid', '닉네임을 입력하세요.', isValid);
	  }
	  
	  if (!isValidbirthDate(birthDate)) {
		 isValid = false;
		 displayErrorMessage('birthDate__jid', '생년월일을 입력하세요.', isValid);
	  }
	  if (!email || !password || !passwordCheck || !name || !phonenum || !nickName || !birthDate) {
	    alert('필수 항목을 모두 입력해주세요!');
	    return; // 폼 제출 방지
	  }
      if (isValid) {
        form.submit(); // 모든 유효성 검사가 통과되면 폼 제출
      }
    });
  } else {
    console.error('폼을 찾을 수 없습니다.');
  }
});
//이메일 유효성
// Function to validate email format
function isValidEmail(email) {
  var emailRegex = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
  return emailRegex.test(email);
}
function emailCheck(tag){
    var emailTag = document.getElementById('email__jid');
    var msg = emailTag.parentNode.querySelector('.msg');

    if(isValidEmail(emailTag.value)){
        msg.textContent = "";
        emailTag.style.borderColor = 'green';
    } else {
		emailTag.style.borderColor = 'red';
        msg.textContent = "이메일 형식이 아닙니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}
//비밀번호 유효성
function isValidPassword(password) {
  var passwordRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
  return passwordRegex.test(password);
}

function passwordCheck(tag){
    var passwordTag = tag;
    var msg = passwordTag.parentNode.querySelector('.msg');

    if(passwordTag.value.trim().length === 0){
        passwordTag.style.borderColor = 'red';
        msg.textContent = "비밀번호를 입력해주세요.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    } else if(isValidPassword(passwordTag.value)){
        msg.textContent = "";
        passwordTag.style.borderColor = 'green';
    } else {
        passwordTag.style.borderColor = 'red';
        msg.textContent = "비밀번호 형식이 아닙니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
    
    var passwordCheckTag = document.getElementById('passwordCheck__jid');
    if (passwordCheckTag.value.trim().length > 0) {
        passwordCheckCheck(passwordCheckTag);
    }
}
//비밀번호 확인 유효성
function isValidpasswordCheck(passwordCheck) {
  let password = document.getElementById('password__jid').value;
  return password === passwordCheck; 
}
function passwordCheckCheck(tag){
    var passwordCheckTag = document.getElementById('passwordCheck__jid');
    var msg = passwordCheckTag.parentNode.querySelector('.msg');

	if(passwordCheckTag.value.trim().length === 0){
        passwordCheckTag.style.borderColor = 'red';
        msg.textContent = "비밀번호를 입력해주세요.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    } else if(isValidpasswordCheck(passwordCheckTag.value)){
        msg.textContent = "";
	    passwordCheckTag.style.borderColor = 'green';
    } else {
		passwordCheckTag.style.borderColor = 'red';
        msg.textContent = "비밀번호가 일치하지 않습니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}
//이름 유효성
function isValidname(name) {
  var nameRegex = /^[가-힣]{2,4}$/;
   return nameRegex.test(name);
}
function nameCheck(tag){
    var nameTag = document.getElementById('name__jid');
    var msg = nameTag.parentNode.querySelector('.msg');

    if(isValidname(nameTag.value)){
        msg.textContent = "";
        nameTag.style.borderColor = 'green';
    } else {
		nameTag.style.borderColor = 'red';
        msg.textContent = "이름 형식이 올바르지 않습니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}
//연락처 유효성
function isValidphonenum(phonenum) {
  var phonenumRegex = /^\d{3}-\d{3,4}-\d{4}$/;
   return phonenumRegex.test(phonenum);
}
function phonenumCheck(tag){
    var phonenumTag = document.getElementById('phonenum__jid');
    var msg = phonenumTag.parentNode.querySelector('.msg');

    if(isValidphonenum(phonenumTag.value)){
        msg.textContent = "";
        phonenumTag.style.borderColor = 'green';
    } else {
		phonenumTag.style.borderColor = 'red';
        msg.textContent = "연락처 형식이 올바르지 않습니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}
//닉네임 유효성
function isValidnickName(nickName) {
  var nickNameRegex = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
   return nickNameRegex.test(nickName);
}
function nickNameCheck(tag){
    var nickNameTag = document.getElementById('nickName__jid');
    var msg = nickNameTag.parentNode.querySelector('.msg');

    if(isValidnickName(nickNameTag.value)){
        msg.textContent = "";
        nickNameTag.style.borderColor = 'green';
    } else {
		nickNameTag.style.borderColor = 'red';
        msg.textContent = "닉네임 형식이 올바르지 않습니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}
//생년월일 유효성
function isValidbirthDate(birthDate) {
  var birthDateRegex = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
   return birthDateRegex.test(birthDate);
}
function birthDateCheck(tag){
    var birthDateTag = document.getElementById('birthDate__jid');
    var msg = birthDateTag.parentNode.querySelector('.msg');

    if(isValidbirthDate(birthDateTag.value)){
        msg.textContent = "";
       	birthDateTag.style.borderColor = 'green';
    } else {
		birthDateTag.style.borderColor = 'red';
        msg.textContent = "생년월일 형식이 올바르지 않습니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}

//이메일 인증
