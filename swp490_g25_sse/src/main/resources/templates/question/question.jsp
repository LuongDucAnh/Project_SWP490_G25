
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Create</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/question/submit">
            <h3>Quiz</h3>
            <ol type = "1">
                <c: forEach var = "question" items = "${questions}">
                    <li>${question.content}
                        <input type ="hidden" name="questionId" value="${question.questionId}">
                        <ol type = "a">
                            <c: forEach var = "answer" items="${question.answers}">
                                <li><input type = "radio" name="question_${question.questionId}" value = "${answer.answerId}">${answer.content}</li>
                        </li>
                        </c:forEach>
                    </ol>
                </ol>
                <br>
                <input type="submit" value="Submit">
            </form>
        </body>
    </html>
