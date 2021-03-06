<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Поиск товаров в прайс-листе</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script type="text/javascript" src="/resources/js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="/resources/js/materialize.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            Materialize.updateTextFields();
        });
    </script>
</head>
<body>
<div class="container">
    <h4>Прайс лист</h4>

    <div class="row">
        <form:form method="GET" modelAttribute="filter">
            <div class="col s12">
                <div class="row">
                    <div class="input-field col s3">
                        <form:input id="category" path="category" type="text" class="validate"/>
                        <label for="category">Категория</label>
                    </div>
                    <div class="input-field col s3">
                        <form:input id="productName" path="product" type="text" class="validate"/>
                        <label for="productName">Наименование</label>
                    </div>

                    <div class="input-field col s3">
                        <form:input id="priceFrom" path="priceFrom" type="number" step="any" min="0" class="validate"/>
                        <label for="priceFrom">Цена от:</label>
                    </div>
                    <div class="input-field col s3">
                        <form:input id="priceTo" path="priceTo" type="number" step="any" min="0" class="validate"/>
                        <label for="priceTo">Цена до:</label>
                    </div>
                </div>
            </div>
            <div style="text-align: right">
                <button class="btn waves-effect waves-light" type="submit" name="action">Найти
                    <i class="material-icons right">search</i>
                </button>
            </div>
        </form:form>
    </div>
    <table>
        <thead>
        <tr>
            <th data-field="category">Категория</th>
            <th data-field="name_product">Наименование</th>
            <th data-field="price">Цена</th>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty products}">
                <tbody>
                <c:forEach var="current" items="${products}">
                    <tr>
                        <td><c:out value="${current.category.name}"/></td>
                        <td><c:out value="${current.name}"/></td>
                        <td><c:out value="${current.price}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:when>
            <c:when test="${emptyFilter}">
                <tbody>
                <tr>
                    <td colspan="3">Для поиска товаров заполните хотя бы одно поле фильтра</td>
                </tr>
                </tbody>
            </c:when>
            <c:otherwise>
                <tbody>
                <tr>
                    <td colspan="3">Товары не найдены</td>
                </tr>
                </tbody>
            </c:otherwise>
        </c:choose>
    </table>
</div>
</body>
</html>