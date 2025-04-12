// edumentor.js

document.addEventListener("DOMContentLoaded", () => {
    // Login form submission
    const loginForm = document.querySelector("form[action='login']");
    if (loginForm) {
      loginForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const email = loginForm.querySelector("input[type='email']").value;
        const password = loginForm.querySelector("input[type='password']").value;
  
        if (!email || !password) {
          alert("Please enter both email and password.");
        } else {
          alert("Login successful!");
          // Add login logic here
        }
      });
    }
  
    // Registration form
    const registerForm = document.querySelector("form[action='register']");
    if (registerForm) {
      registerForm.addEventListener("submit", (e) => {
        e.preventDefault();
        alert("Registration completed. Welcome to EduMentor!");
        // Add registration logic here
      });
    }
  
    // Mentor chat button functionality
    const chatButtons = document.querySelectorAll(".btn-chat");
    chatButtons.forEach((btn) => {
      btn.addEventListener("click", () => {
        const mentorName = btn.getAttribute("data-mentor");
        alert(`Chat started with ${mentorName}`);
      });
    });
  
    // Chart rendering (if dashboard is loaded)
    const chartElement = document.getElementById("gradesChart");
    if (chartElement) {
      new Chart(chartElement, {
        type: "bar",
        data: {
          labels: ["Math", "Science", "English", "History"],
          datasets: [{
            label: "Your Grades",
            data: [85, 92, 78, 88],
            backgroundColor: ["#5e35b1", "#43a047", "#1e88e5", "#fbc02d"],
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          },
          responsive: true,
          plugins: {
            legend: {
              labels: {
                font: {
                  size: 14
                }
              }
            }
          }
        }
      });
    }
  });
  