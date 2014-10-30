<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Servlet task</title>
<script src="js/jquery.min.js"></script>
<script src="js/script.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form action="index.html" method="post">
		<!-- Create fields for new employee -->
      <p>
          <label> <input type="text" name="fname"/> First name:</label>

          <label> <input type="text" name="lname"/>Last name:</label>

          <label> <input type="text" name="email"/>Your e-mail:</label>

          <label> <input name="подт. ввод:" type="submit"  value="к чертям собачим">Submit:</label>

      </p>

	</form>
	<div class="errMsg">
		<c:out value="${errMsg}" />
	</div>
	<div class="empTable">
		<c:choose>
			<c:when test="${empty applicationScope.employees}">
				<!-- Inform user that there's no employee yet -->
                Value off!
                			</c:when>
			<c:otherwise>
				<!--  Display table with employees
					For example, you can use jstl foreach loop:-->
                <table>
                <tr>
                    <td>First Name:</td>
                    <td>Last Name:</td>
                    <td>e-mail:</td>
                </tr>

					<c:forEach var="employee" items="${applicationScope.employees}">
						<tr>
							<td><c:out value="${employee.fname}" /></td>
                            <td><c:out value="${employee.lname}" /></td>
                            <td><c:out value="${employee.email}" /></td>
						</tr>
					</c:forEach>
                </table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>