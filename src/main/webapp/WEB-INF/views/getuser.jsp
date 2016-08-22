<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="head.jsp"/>


    <script type="text/javascript">
        $(function () {
            var login = "${login}";
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "${pageContext.request.contextPath}/rest/users/" + login,
                success: function (item) {
                    setTimeout(function () {
                        $('#firstName').val(item.firstName);
                        $('#lastName').val(item.lastName);
                        $('#password').val(item.password);
                        $('#login').val(item.login);
                        $('#birthDay').val(item.birthDay);
                        $('#address').val(item.address);
                        $('#aBout').val(item.aBout);
                    }, 0);
                },
                error: function () {
                    alert("Пользователя нет ");
                },
                complete: function () {
                    $(".waiting").hide();
                }
            });

            <!--Обновлякем данные пользователя-->
            $(function () {
                $("form").submit(function (event) {
                    event.preventDefault();
                    var formDataObject = $(this).serializeObject();
                    formDataObject["login"] = "${login}";
                    var formData = JSON.stringify(formDataObject);
                    $.ajax({
                        url: "${pageContext.request.contextPath}/rest/users/" + login,
                        type: 'PUT',
                        contentType: "application/json; charset=utf-8",
                        data: formData,
                        success: function () {
                            Materialize.toast('Пользователь обновлен', 4000);
                        },
                        error: function (jqXHR) {
                            if (jqXHR.status == 500) {
                                Materialize.toast('500 status code.', 4000);
                            }
                        }
                    });

                    return false;
                });

                $.fn.serializeObject = function () {
                    var o = {};
                    var a = this.serializeArray();
                    $.each(a, function () {
                        if (o[this.name] !== undefined) {
                            if (!o[this.name].push) {
                                o[this.name] = [o[this.name]];
                            }
                            o[this.name].push(this.value || '');
                        } else {
                            o[this.name] = this.value || '';
                        }
                    });
                    return o;
                };

            });

        });


    </script>
</head>
<body>
<div class="container">
    <h3>Обновление данных пользователя, с логином ${login}</h3>

    <div class="row">
        <form id="addUserForm" class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input id="firstName" name="firstName" type="text" class="validate">
                    <label class="active" for="firstName">First Name</label>
                </div>
                <div class="input-field col s6">
                    <input id="lastName" name="lastName" type="text" class="validate">
                    <label class="active" for="lastName">Last Name</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s6">
                    <input id="login" name="login" type="text" class="validate" disabled="disabled">
                    <label class="active" for="login">Login</label>
                </div>
                <div class="input-field col s6">
                    <input id="password" name="password" type="password" class="validate">
                    <label class="active" for="password">Password</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s2">
                    <input class="active" id="birthDay" name="birthDay" type="date" class="datepicker">
                </div>
                <div class="input-field col s4">
                    <input id="address" name="address" type="text" class="validate">
                    <label class="active" for="address">address</label>
                </div>
                <div class="input-field col s6">
                    <textarea id="aBout" name="aBout" class="materialize-textarea" length="120"></textarea>
                    <label class="active" for="aBout">about</label>
                </div>
            </div>


            <button class="btn waves-effect waves-light" type="submit">Обновить
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>
</div>


</body>
</html>