<!DOCTYPE html>
<html>
<head>
    <title>Error - Simple Secure App</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Access Error</h2>

        <div class="error">
            <% if (request.getParameter("type") != null) { %>
                <% if (request.getParameter("type").equals("auth")) { %>
                    <p>You need to login first to access this page!</p>
                <% } else { %>
                    <p>An error occurred. Please try again.</p>
                <% } %>
            <% } else { %>
                <p>You don't have permission to access this page directly.</p>
            <% } %>
        </div>

        <div class="info">
            <p>This is a security feature - all access must go through login.</p>
        </div>

        <a href="login.html" class="edit-btn">Go to Login</a>
    </div>
</body>
</html>