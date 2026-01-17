<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register - TurfSpot</title>
        <link rel="stylesheet" href="../css/style.css">
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 2rem;
                min-height: 100vh;
            }

            .auth-card {
                margin: 0;
                width: 100%;
                background: var(--card-bg);
                backdrop-filter: blur(20px);
                border: 1px solid var(--border);
            }
        </style>
    </head>

    <body>
        <div class="auth-card">
            <h1 style="text-align: center; margin-bottom: 0.5rem;">Create Account</h1>
            <p style="text-align: center; color: var(--text-muted); margin-bottom: 2rem;">Join the TurfSpot community
            </p>
            <% if(request.getParameter("error") !=null) { %>
                <p class="error-msg" style="text-align: center;">
                    <%= request.getParameter("error") %>
                </p>
                <% } %>
                    <form action="../user" method="post">
                        <input type="hidden" name="action" value="register">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" name="username" placeholder="Choose a username" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="email" placeholder="email@example.com" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" placeholder="••••••••" required>
                        </div>
                        <button type="submit" style="margin-top: 1rem;">Sign Up</button>
                    </form>
                    <p style="margin-top: 2rem; text-align: center; font-size: 0.9rem; color: var(--text-muted);">
                        Already have an account? <a href="login.jsp"
                            style="color: var(--primary); font-weight: 600; text-decoration: none;">Login</a>
                    </p>
        </div>
    </body>

    </html>