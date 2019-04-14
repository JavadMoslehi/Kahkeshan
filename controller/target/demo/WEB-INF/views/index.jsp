<%@ page    language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8"%>
<%@ taglib  prefix="form"   uri="http://www.springframework.org/tags/form"                      %>
<%@ taglib  prefix="spring"   uri="http://www.springframework.org/tags"                      %>

<!DOCTYPE html PUBLIC   "-//W3C//DTD HTML 4.01 Transitional//EN"
                        "http://www.w3.org/TR/html4/loose.dtd"  >
<html>

    <head>
        <link rel="stylesheet" href="/static/css/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
            .error {
                color: #ff070c; font-weight: bold;
            }
        </style>
    </head>

    <body>
        <div align="center" class="backGround">
            <h2><spring:message code="form.title" /></h2>
            <table border="0" width="90%">
                <form:form action="save" method="post" modelAttribute="person">
                    <tr>
                        <td align="left" width="20%"><spring:message code="form.name"/>: </td>
                        <td align="left" width="40%">   <form:input     path="name" size="30"       /></td>
                        <td align="left">               <form:errors    path="name" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Family: </td>
                        <td><form:input     path="family" size="30"         /></td>
                        <td><form:errors    path="family" cssClass="error"  /></td>
                    </tr>
                    <tr>
                        <td>Age: </td>
                        <td><form:input     path="age" size="30"            /></td>
                        <td><form:errors    path="age" cssClass="error"     /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="center"><input type="submit" value="Save"/></td>
                        <td></td>
                    </tr>
                </form:form>
            </table>
        </div>
    </body>
</html>