<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="warranties" required="true" type="java.util.List" %>

<c:choose>
    <c:when test="${warranties != null && warranties[0]!= null}">
        <h5>Warranty</h5>
        <div class="war_det">Duration: ${warranties[0].length} months<br/>
            <div class="hide_desc">Description: ${warranties[0].description}</div><br/>
        </div>
    </c:when>
    <c:otherwise>
        <h5>No Warranty</h5>
    </c:otherwise>
</c:choose>