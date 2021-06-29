<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<html>
<head>
    <title>Cập nhật khách hàng</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Danh Sách Khách Hàng</li>
            </ul>
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box">
                        <div class="widget-header">
                            <h4 class="widget-title">Cập nhật khách hàng</h4>
                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="widget-body">
                            <form:form action="${customerEditURL}" commandName="customerEdit" id="formEditCustomer">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="fullName">Họ tên khách hàng:</label>
                                                <input type="text" class="form-control" name="fullName" id="fullName">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="phone">Số điện thoại:</label>
                                                <input type="number" class="form-control" name="phone" id="phone">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="email">Email: </label>
                                                <input type="email" class="form-control" name="email" id="email">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="company">Tên công ty:</label>
                                                <input type="text" class="form-control" name="company" id="company">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="request">Yêu cầu:</label>
                                                <input type="text" class="form-control" name="request" id="request">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-12">
                                            <div class="form-group">
                                                <label for="note">Ghi chú:</label>
                                                <textarea class="form-control" rows="5" name="note"
                                                          id="note"></textarea>
                                            </div>
                                        </div>
                                        <form:input path="id" id="customerId" type="hidden"/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-xs-12 col-sm-12">
                                            <div class="form-group">
                                                <button type="button" class="btn btn-success" id="btnAddNewCustomer">Cập
                                                    nhật khách hàng
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${not empty customerEdit.id}">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">Thêm giao dịch</h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <form id="formAddTransaction">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="col-xs-12 col-sm-6">
                                                <div class="form-group">
                                                    <label for="code">Mã giao dịch:</label>
                                                    <input type="text" class="form-control" name="codeTransaction"
                                                           id="code">
                                                </div>
                                            </div>
                                            <div class="col-xs-12 col-sm-6">
                                                <div class="form-group">
                                                    <label for="note">Ghi chú:</label>
                                                    <input type="number" class="form-control" id="noteTransaction"
                                                           name="note">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="col-xs-12 col-sm-12">
                                                <div class="form-group">
                                                    <button type="button" class="btn btn-success"
                                                            id="btnAddNewTransaction">
                                                        Thêm mới giao dịch
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <c:if test="${not empty transactions}">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="widget-box">
                                <div class="widget-header">
                                    <h4 class="widget-title">Cập nhật giao dịch</h4>
                                    <div class="widget-toolbar">
                                        <a href="#" data-action="collapse">
                                            <i class="ace-icon fa fa-chevron-up"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="widget-body">
                                    <c:forEach var="item1" items="${transactions}">
                                        <div><h5>${item.code}</h5></div>
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th>Ngày tạo</th>
                                                <th>Ghi chú</th>
                                            </tr>
                                            </thead>
                                            <c:forEach var="item2" items="${transactions}">
                                                <c:if test="${item1.code == item2.code}">
                                                    <tbody>
                                                    <tr>
                                                        <td>${item2.createdDate}</td>
                                                        <td>${item2.note}</td>
                                                    </tr>
                                                    </tbody>
                                                </c:if>
                                            </c:forEach>
                                        </table>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:if>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        findCustomerById();
    })

    function findCustomerById() {
        var customerId = $('#customerId').val();

        $.ajax({
            method: "GET",
            url: 'http://localhost:8080/api/customer/' + customerId,
            success: function (res) {
                console.log("success");
                $('#fullName').val(res.data.fullName);
                $('#phone').val(res.data.phone);
                $('#email').val(res.data.email);
                $('#company').val(res.data.company);
                $('#request').val(res.data.request);
                $('#note').val(res.data.note);
            },
            fail: function (res) {
                console.log("fail");
                console.log(res);
            }
        });
    };

    $("#btnAddNewCustomer").click(function (e) {
        e.preventDefault();
        var id = $("#customerId").val();
        var data = {};
        var formData = $('#formEditCustomer').serializeArray();
        $.each(formData, function (index, value) {
            data["" + value.name + ""] = value.value;
        })
        data["id"] = id;
        if (id == "") {
            addNewCustomer(data);
        } else {
            editCustomer(data);
        }
    });

    function addNewCustomer(data) {
        $.ajax({
            method: "POST",
            url: 'http://localhost:8080/api/customer',
            data: JSON.stringify(data),
            datatype: "json",
            contentType: "application/json",
            success: function (res) {
                console.log("success");
                location.reload();
            },
            error: function (res) {
                console.log("error");
                console.log(res);
            }
        })
    }

    function editCustomer(data) {
        $.ajax({
            method: "PUT",
            url: 'http://localhost:8080/api/customer',
            data: JSON.stringify(data),
            datatype: "json",
            contentType: "application/json",
            success: function (res) {
                console.log("success");
                location.reload();
            },
            error: function (res) {
                console.log("error");
                console.log(res);
            }
        })
    }

    $('btnAddNewTransaction').click(function (e) {
        var data = {};
        var customerId = $("#customerId").val();
        var formData = $('#formEditCustomer').serializeArray();
        $.each(formData, function (index, value) {
            data["" + value.name + ""] = value.value;
        })
        data["customerId"] = customerId;
        createTransaction(data);
    })

    function createTransaction(data) {
        $.ajax({
            method: "POST",
            url: 'http://localhost:8080/api/transaction',
            data: JSON.stringify(data),
            datatype: "json",
            contentType: "application/json",
            success: function (res) {
                console.log("sucess");
                console.log(res);
            },
            fail: function (res) {
                console.log("fail");
                console.log(res);
            }
        })
    }
</script>
</body>
</html>
