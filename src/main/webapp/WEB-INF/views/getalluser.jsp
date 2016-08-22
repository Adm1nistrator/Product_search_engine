<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <jsp:include page="head.jsp"/>

    <script type="text/javascript">
        var path = "${pageContext.request.contextPath}";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: path + "/rest/users/",
            success: function (data, textStatus, jqXHR) {
                var $resultList = $('.collection');
                if (jqXHR.status == 204) {
                    Materialize.toast('Cписок пуст', 4000);
                    return;
                }

                for (var i = 0; i < data.length; i++) {
                    var item = data[i];
                    var userUrl = path + "/user?login=" + item.login;
                    var deleteLink = path + "/rest/users/" + item.login;
                    var link = $("<a href='" + userUrl + "'>" + item.firstName + " " + item.lastName + "</а>");
                    var row = $("<li class='collection-item'></li>");
                    var button = $("<a href='" + deleteLink + "' class='secondary-content'><i class='small material-icons'>delete</i></a>");

                    button.on("click", { "login": item.login }, function (event) {
                        event.preventDefault();
                        deleteuser(event.data.login, $(this).parent(".collection-item"));
                    });
                    $resultList.append(row.append(link).append(button));
                }
            },
            complete: function () {
                $(".progress").hide();
            }
        });

        function deleteuser(login, row) {
            $.ajax({
                type: "DELETE",
                url: path + "/rest/users/" + login,
                success: function () {
                    row.remove();
                    Materialize.toast('пользователь удален', 4000);
                },
                error: function (jqXHR) {
                    if (jqXHR.status == 404) {
                        Materialize.toast('Пользователь не найден', 4000);

                    }
                }

            })

        }


    </script>
</head>
<body>

<div class="progress">
    <div class="indeterminate"></div>
</div>

<div class="container">
    <a href="${pageContext.request.contextPath}/adduser" class="btn-floating btn-large waves-effect waves-light red"
       style="position: fixed; right: 20px; bottom: 20px;"><i
            class="material-icons">add</i></a>
    <h4>Список пользователей</h4>
    <ul class="collection">

    </ul>
</div>


</body>
</html>