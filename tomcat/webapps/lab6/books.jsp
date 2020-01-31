<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import ="java.sql.*" %>
<%@page import ="java.lang.String" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<c:set var="i" value="0" />
<title>Книги</title>
<link rel="stylesheet" href="style.css">
<div>
    <form accept-charset="UTF-8" method="post" style="max-width:200px;">
        <p>Название <input type="text" name="title" maxlength="120"></p>
        <p>Автор <input type="text" name="author" maxlength="1000"></p>
        <p>Тип книги <input type="text" name="book_type" maxlength="120"></p>
        <input type="submit" value="Добавить">
        <br><br>
        <input type="button" value="Назад" onclick="window.location='/'" />
        <br>
    </form>
    <table border="1" width="100%">
        <thead>
        <tr>
            <th>Изменить</th>
            <th>Название</th>
            <th>Автор</th>
            <th>Тип книги</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${books}" var="book">
            <c:set var="i" value="${i + 1}" />
            <tr>
                <td>

                    <form action="/lab6/updateBook?id=${book.getID()}">
                        <div class="dropdown">
                            <button class="dropbtn" type="button" data-toggle="dropdown" aria-expanded="false">
                                Изменение
                            </button>
                            <ul class="dropdown-content" role="menu" aria-labelledby="dropdownMenu">
                                <input style="width:260px" type="hidden" value="${book.getID()}" name="id"
                                       placeholder="ID" required>

                                <label class="w3-text-blue">Название</label>
                                <input style="width:260px" type="text" value="${book.getTitle()}" name="title" maxlength="120"
                                       placeholder="Название" required>

                                <label class="w3-text-blue">Автор</label>
                                <br>
                                <input style="width:260px" type="text" value="${book.getAuthor()}" name="author" maxlength="40"
                                       placeholder="Автор"
                                       required>
                                <br>
                                <label class="w3-text-blue">Тип книги</label>
                                <br>
                                <input style="width:260px" type="text" value="${book.getBookType()}" name="book_type" maxlength="20"
                                       placeholder="Тип книги" required>
                                <br>
                                <input class="submitAdd" type="submit" value="Принять">
                            </ul>
                        </div>
                    </form>

                </td>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
                <td>${book.getBookType()}</td>
                <td>
                    <a href="/lab6/deleteBook?id=${book.getID()}">🗑</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<c:set var="why_am_i_doing_this" value="${fn:split('книг', '')}" /> 
Отрисовано <c:out value="${i}" /> <c:out value="${fn:join(why_am_i_doing_this, '')}" />

<div style="opacity: 0.1">
    fn:subsctringAfter('не так уж и бесполезен', 'и') <c:out value="${fn:substringAfter('не так уж и бесполезен', 'и')}" />
</div>
