const checkPasswords = () => {
    if (document.getElementById('password').value ===
        document.getElementById('confirmPassword').value) {
        document.getElementById('password').style.borderColor = 'green';
        document.getElementById('confirmPassword').style.borderColor = 'green';
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Your passwords match!';
    } else {
        document.getElementById('password').style.borderColor = 'red';
        document.getElementById('confirmPassword').style.borderColor = 'red';
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Ruh-roh! These passwords don\'t match!';
    }
};
