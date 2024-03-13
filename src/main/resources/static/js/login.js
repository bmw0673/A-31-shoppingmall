/**
 * 
 */
  document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector('form');

    form.addEventListener('submit', function(event) {
      event.preventDefault(); // Prevents the form from submitting by default
      
      const email = document.getElementById('email__lid').value;
      const password = document.getElementById('password__lid').value;
      let isValid = true;
   
      if (isValid) {
        form.submit(); // Submits the form if all validations pass
      }
    });

    
  });
//이메일 유효성
// Function to validate email format
function isValidEmail(email) {
  var emailRegex = ""; // 정규식을 공백으로 설정
  // 만약 emailRegex가 공백인 경우에는 항상 false를 반환하도록 처리
  return emailRegex !== "" ? true : false;
}
  
function emailCheck(tag){
    const emailTag = document.getElementById('email__lid');
    const msg = emailTag.parentNode.querySelector('.msg');

    if(isValidEmail(emailTag.value)){
        break;
    } else {
        msg.textContent = "이메일을 입력하세요.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}

//비밀번호 유효성
// Function to validate email format
function isValidPassword(password) {
  //const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  var passwordRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
  return passwordRegex.test(password);
}
  
function passwordCheck(tag){
    const passwordTag = document.getElementById('password__lid');
    const msg = passwordTag.parentNode.querySelector('.msg');

    if(isValidPassword(passwordTag.value)){
        msg.textContent = "비밀번호 입력완료.";
        msg.style.color = 'green';
    } else {
        msg.textContent = "비밀번호 형식이 아닙니다.";
        msg.style.color = 'red';
        msg.style.fontSize = '11px';
    }
}