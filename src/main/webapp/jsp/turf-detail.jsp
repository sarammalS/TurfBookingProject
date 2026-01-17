<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>${turf.name} - TurfSpot</title>
            <link rel="stylesheet" href="../css/style.css">
        </head>

        <body>
            <header>
                <nav>
                    <div style="font-size: 1.5rem; font-weight: bold; color: var(--primary);">TurfSpot</div>
                    <div>
                        <a href="../booking?action=list">Dashboard</a>
                        <a href="../turf?action=list">Book Turf</a>
                        <a href="../user?action=logout">Logout</a>
                    </div>
                </nav>
            </header>

            <div class="container">
                <div style="display: flex; gap: 2rem; margin-top: 2rem;">
                    <div style="flex: 1;">
                        <img src="${turf.imagePath}" alt="${turf.name}" style="width: 100%; border-radius: 12px;"
                            onerror="this.src='https://images.unsplash.com/photo-1551958219-acbc608c6377?w=800&auto=format&fit=crop&q=60'">
                    </div>
                    <div style="flex: 1;">
                        <h1>${turf.name}</h1>
                        <p style="color: var(--primary); font-size: 1.2rem; font-weight: bold;">${turf.location}
                        </p>
                        <div style="margin: 1.5rem 0;">
                            <h3>About this turf</h3>
                            <p>${turf.description}</p>
                        </div>
                        <p class="price">$${turf.pricePerHour} / hour</p>
                        <a href="../slot?turfId=${turf.id}"><button style="margin-top: 1.5rem;">Check
                                Availability</button></a>
                    </div>
                </div>

                <section style="margin-top: 4rem;">
                    <h2>Reviews</h2>
                    <div
                        style="background: var(--card-bg); padding: 2rem; border-radius: var(--border-radius); border: 1px solid var(--border);">
                        <h3>Add a Review</h3>
                        <form action="../review" method="post">
                            <input type="hidden" name="turfId" value="${turf.id}">
                            <div class="form-group">
                                <label>Rating (1-5)</label>
                                <input type="number" name="rating" min="1" max="5" value="5"
                                    style="width: 80px; padding: 0.5rem; background: #333; color: white; border: 1px solid #444; border-radius: 4px;">
                            </div>
                            <div class="form-group">
                                <label>Comment</label>
                                <textarea name="comment" rows="4"
                                    style="width: 100%; padding: 0.8rem; background: #333; color: white; border: 1px solid #444; border-radius: 8px;"></textarea>
                            </div>
                            <button type="submit" style="width: auto; padding: 0.8rem 2rem;">Post Review</button>
                        </form>
                    </div>
                </section>
            </div>
        </body>

        </html>