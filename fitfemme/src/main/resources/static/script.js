document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username: username, password: password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            localStorage.setItem('jwtToken', data.token);
            document.getElementById('message').textContent = 'Login successful!';
            document.getElementById('message').style.color = 'green';
            // Redirect to another page or perform other actions
        } else {
            document.getElementById('message').textContent = 'Login failed!';
            document.getElementById('message').style.color = 'red';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('message').textContent = 'An error occurred!';
        document.getElementById('message').style.color = 'red';
    });
});
