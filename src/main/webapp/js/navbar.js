const toggleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.navbar_menu')
const signup = document.querySelector('.navbar_signup');
const icons = document.querySelector('.navbar_icons');

toggleBtn.addEventListener('click', ()=>{
    menu.classList.toggle('active');
    signup.classList.toggle('active');
    icons.classList.toggle('active');
})