<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Explore Turfs - TurfSpot</title>
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
                <h1>Available Turfs</h1>
                <div class="turf-grid">
                    <c:forEach var="turf" items="${turfs}">
                        <div class="turf-card">
                            <img src="${turf.imagePath}" alt="${turf.name}"
                                onerror="this.src='https://images.unsplash.com/photo-1551958219-acbc608c6377?w=800&auto=format&fit=crop&q=60'">
                            <div class="turf-info">
                                <h3>${turf.name}</h3>
                                <p style="font-size: 0.9rem; color: #aaa;">${turf.location}</p>
                                <p class="price">$${turf.pricePerHour} / hour</p>
                                <a href="../slot?turfId=${turf.id}"><button style="margin-top: 1rem;">View
                                        Slots</button></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </body>

        </html>