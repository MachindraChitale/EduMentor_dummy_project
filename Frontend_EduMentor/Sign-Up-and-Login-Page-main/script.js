document.getElementById('requestForm').addEventListener('submit', function (e) {
    e.preventDefault();
  
    const name = document.getElementById('studentName').value;
    const id = document.getElementById('studentId').value;
  
    // Simulate backend POST
    document.getElementById('statusOutput').textContent = `Request sent by ${name} (ID: ${id}). Waiting for mentor...`;
  
    // Here you’d use fetch() to connect to backend if needed
  });
  