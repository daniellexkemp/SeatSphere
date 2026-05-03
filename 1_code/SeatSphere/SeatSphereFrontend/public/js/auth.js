function checkUserLogin() {
    const statusArea = document.getElementById('nav-auth-status');
    const userData = localStorage.getItem('user');

    console.log("Checking Auth Status..."); // Debug message

    if (statusArea && userData) {
        try {
            const user = JSON.parse(userData);
            console.log("Found User:", user.firstName);

           // Check if we are currently on the dashboard page
const isDashboard = window.location.pathname.includes('dashboard.html');

// Determine text color based on the page
const textColorClass = isDashboard ? 'text-white' : 'text-dark';
const linkColorClass = isDashboard ? 'text-white-50' : 'text-muted';

statusArea.innerHTML = `
    <span class="fw-bold ${textColorClass}">welcome, ${user.firstName.toLowerCase()}</span> 
    <span class="${textColorClass}">|</span> 
    <a href="javascript:void(0)" onclick="logout()" class="${linkColorClass} small text-decoration-none">sign out</a>
`;
        } catch (e) {
            console.error("Error reading user data", e);
        }
    } else {
        console.log("No user found in storage or ID missing in HTML");
    }
}

// Global logout
window.logout = function() {
    localStorage.removeItem('user');
    window.location.href = "index.html";
};

// Run when the page is fully loaded
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', checkUserLogin);
} else {
    checkUserLogin();
}
