<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Available Slots - ${turf.name}</title>
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
                <h1>Book a Slot at ${turf.name}</h1>
                <p>${turf.description}</p>

                <h2 style="margin-top: 2rem;">Available Slots</h2>
                <div class="slot-list">
                    <c:if test="${empty slots}">
                        <p>No available slots for this turf at the moment.</p>
                    </c:if>
                    <c:forEach var="slot" items="${slots}">
                        <div class="slot-item">
                            <p><strong>Date:</strong> ${slot.date}</p>
                            <p>${slot.startTime} - ${slot.endTime}</p>
                            <form action="../booking" method="post" style="margin-top: 1rem;">
                                <input type="hidden" name="slotId" value="${slot.id}">
                                <button type="submit">Book This Slot</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </body>

        </html>