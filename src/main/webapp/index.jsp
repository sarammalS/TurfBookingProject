<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TurfSpot - Book Your Game</title>
        <link rel="stylesheet" href="css/style.css">
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700;800&display=swap" rel="stylesheet">
        <style>
            .hero {
                height: 80vh;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
                padding: 0 2rem;
            }

            .hero h1 {
                font-size: 4.5rem;
                font-weight: 800;
                margin-bottom: 1rem;
                background: linear-gradient(to right, #00ff88, #6366f1);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                line-height: 1.1;
            }

            .hero p {
                font-size: 1.25rem;
                color: var(--text-muted);
                max-width: 600px;
                margin-bottom: 2.5rem;
            }

            .cta-group {
                display: flex;
                gap: 1.5rem;
            }

            .btn-primary {
                background: var(--primary);
                color: #0f172a;
                padding: 1rem 2rem;
                border-radius: 50px;
                text-decoration: none;
                font-weight: 700;
                transition: var(--transition);
            }

            .btn-secondary {
                background: rgba(255, 255, 255, 0.05);
                backdrop-filter: blur(10px);
                border: 1px solid var(--border);
                color: white;
                padding: 1rem 2rem;
                border-radius: 50px;
                text-decoration: none;
                font-weight: 600;
                transition: var(--transition);
            }

            .btn-primary:hover {
                transform: scale(1.05);
                box-shadow: 0 0 30px rgba(0, 255, 136, 0.3);
            }

            .features {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                gap: 2rem;
                padding: 4rem 2rem;
                max-width: 1200px;
                margin: 0 auto;
            }

            .feature-card {
                background: var(--card-bg);
                padding: 2rem;
                border-radius: var(--border-radius);
                border: 1px solid var(--border);
                text-align: center;
            }

            .feature-card h3 {
                color: var(--primary);
                margin-bottom: 1rem;
            }
        </style>
    </head>

    <body>
        <header>
            <nav>
                <div class="logo" style="font-size: 1.5rem; font-weight: 800; color: var(--primary);">TurfSpot</div>
                <div class="nav-links">
                    <a href="index.jsp">Home</a>
                    <a href="jsp/login.jsp">Login</a>
                    <a href="jsp/register.jsp" class="btn-primary"
                        style="padding: 0.5rem 1.2rem; border-radius: 8px;">Join Now</a>
                </div>
            </nav>
        </header>

        <main>
            <section class="hero">
                <h1>Elevate Your Game.</h1>
                <p>The ultimate platform to discover, book, and manage sports turfs with ease. Fast, secure, and built
                    for champions.</p>
                <div class="cta-group">
                    <a href="jsp/login.jsp" class="btn-primary">Get Started</a>
                    <a href="#features" class="btn-secondary">Learn More</a>
                </div>
            </section>

            <section id="features" class="features">
                <div class="feature-card">
                    <h3>Instant Booking</h3>
                    <p>Real-time availability and instant confirmation for your favorite slots.</p>
                </div>
                <div class="feature-card">
                    <h3>Premium Venues</h3>
                    <p>Hand-picked top-quality turfs with detailed reviews and ratings.</p>
                </div>
                <div class="feature-card">
                    <h3>Secure Payments</h3>
                    <p>Encrypted transaction handling for a worry-free booking experience.</p>
                </div>
            </section>
        </main>

        <footer
            style="padding: 4rem 2rem; text-align: center; border-top: 1px solid var(--border); color: var(--text-muted);">
            <p>&copy; 2026 TurfSpot. All rights reserved.</p>
        </footer>
    </body>

    </html>