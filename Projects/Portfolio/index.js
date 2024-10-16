// Smooth Scrolling for navigation
document.querySelectorAll('.nav-links a').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
      e.preventDefault();
  
      document.querySelector(this.getAttribute('href')).scrollIntoView({
        behavior: 'smooth'
      });
    });
  });
  
  // // Simple form validation
  // document.getElementById('contactForm').addEventListener('submit', function (e) {
  //   e.preventDefault();
  
  //   const name = document.getElementById('name').value.trim();
  //   const email = document.getElementById('email').value.trim();
  //   const message = document.getElementById('message').value.trim();
  
  //   if (name === '' || email === '' || message === '') {
  //     alert('Please fill out all fields.');
  //   } else {
  //     alert('Message sent successfully!');
  //   }
  // });
  