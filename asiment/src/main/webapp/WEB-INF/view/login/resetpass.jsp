<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2>Reset Your Password</h2>
</div>
<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<form action="/reset_password" method="post" style="max-width: 350px; margin: 0 auto;">
    <input type="hidden" name="token" value="${token}"/>
    <div class="border border-secondary rounded p-3">
        <div>
            <p>
                <input type="text" name="matKhau" id="matKhau" class="form-control"
                       placeholder="Enter your new password" required autofocus/>
            </p>
            <p>
                <input type="text" class="form-control" placeholder="Confirm your new password"
                       required oninput="checkPasswordMatch(this);"/>
            </p>
            <p class="text-center">
                <input type="submit" class="btn btn-primary"/>
            </p>
        </div>
    </div>
</form>

<script>
    function checkPasswordMatch(fieldConfirmPassword) {
        if (fieldConfirmPassword.value !== document.getElementById("ten").value) {
            fieldConfirmPassword.setCustomValidity("Passwords do not match!");
        } else {
            fieldConfirmPassword.setCustomValidity("");
        }
    }
</script>
