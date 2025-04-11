function showMessage(message) {
    alert(message);
  }
  
  // Simulate login (example only)
  function loginUser() {
    const email = document.getElementById("email").value;
    showMessage("Welcome, " + email);
    window.location.href = "dashboard.html";
  }
  