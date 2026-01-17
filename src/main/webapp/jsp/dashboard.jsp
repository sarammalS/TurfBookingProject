<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Dashboard - TurfSpot</title>
            <link rel="stylesheet" href="../css/style.css">
        </head>

        <body>
            <header>
                <nav>
                    <div style="font-size: 1.5rem; font-weight: bold; color: var(--primary);">TurfSpot</div>
                    <div>
                        <a href="dashboard.jsp">Dashboard</a>
                        <a href="../turf?action=list">Book Turf</a>
                        <a href="../user?action=logout">Logout</a>
                    </div>
                </nav>
            </header>

            <div class="container">
                <h1>Welcome, ${sessionScope.user.username}!</h1>

                <section>
                    <h2>Your Bookings</h2>
                    <c:if test="${empty bookings}">
                        <p>You have no active bookings. <a href="../turf?action=list"
                                style="color: var(--primary);">Book a turf now!</a></p>
                    </c:if>
                    <c:if test="${not empty bookings}">
                        <table style="width: 100%; border-collapse: collapse; margin-top: 1rem;">
                            <thead>
                                <tr style="border-bottom: 2px solid #333; text-align: left;">
                                    <th style="padding: 1rem;">Booking ID</th>
                                    <th style="padding: 1rem;">Booking Date</th>
                                    <th style="padding: 1rem;">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="booking" items="${bookings}">
                                    <tr style="border-bottom: 1px solid var(--border);">
                                        <td style="padding: 1rem;">${booking.id}</td>
                                        <td style="padding: 1rem;">${booking.bookingDate}</td>
                                        <td style="padding: 1rem;">
                                            <span class="status-badge"
                                                style="background: ${booking.status == 'CONFIRMED' ? 'rgba(0, 255, 136, 0.2)' : 'rgba(249, 115, 22, 0.2)'}; color: ${booking.status == 'CONFIRMED' ? 'var(--primary)' : '#f97316'}; padding: 0.4rem 1rem; border-radius: 50px; font-size: 0.85rem; font-weight: 600; border: 1px solid ${booking.status == 'CONFIRMED' ? 'rgba(0, 255, 136, 0.3)' : 'rgba(249, 115, 22, 0.3)'}">
                                                ${booking.status}
                                            </span>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </section>
            </div>
        </body>

        </html>