<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerListURL" value="/admin/customer-list"/>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<html>
<head>
    <title>Danh sách khách hàng</title>
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
                            <h4 class="widget-title">Tìm Kiếm</h4>
                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="widget-body">
                            <form:form commandName="customerSearch" action="${customerListURL}" id="listForm"
                                       method="POST">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="fullName">Họ tên: </label>
                                                <input type="text" class="form-control" name="fullName"
                                                       id="fullName" name="fullName">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="phone">Số điện thoại: </label>
                                                <input type="number" class="form-control" name="phone"
                                                       id="phone" name="phone">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="email">Email: </label>
                                                <input type="email" class="form-control" name="email"
                                                       id="email" name="email">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <form:select path="staffId" cssClass="form-group">
                                                    <form:option value="-1" label="-- Chọn nhân viên phụ trách --"/>
                                                    <form:options items="${staffmaps}"/>
                                                </form:select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="col-xs-12 col-sm-12">
                                            <div class="form-group">
                                                <button type="button" class="btn btn-success" id="btnSearchCustomer">Tìm
                                                    kiếm <i class="fa fa-arrow-right"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="pull-right">
                        <button type="button" class="btn btn-white btn-info btn-bold" id="btnAdd" data-toggle="tooltip"
                                title="Thêm khách hàng">
                            <i class="fa fa-plus-circle"></i>
                        </button>
                        <button type="button" class="btn btn-white btn-info btn-bold" id="btnDeleteCustomer"
                                data-toggle="tooltip"
                                title="Xoá khách hàng">
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
            </div>
            </br>
            <div class="row">
                <div class="col-xs-12">
                    <table id="customerlist" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Họ tên</th>
                            <th>Di dộng</th>
                            <th>Email</th>
                            <th>Nhu cầu</th>
                            <th>Người nhập</th>
                            <th>Ngày nhập</th>
                            <th>Tình trạng</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${customerList}">
                            <form:form action="${customerEditURL}" method="GET">
                                <tr>
                                    <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></td>
                                    <td>${item.fullName}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.email}</td>
                                    <td>${item.request}</td>
                                    <td>${item.createdBy}</td>
                                    <td>${item.createdDate}</td>
                                    <td></td>
                                    <input type="hidden" value="${item.id}" name="id" id="customerId">
                                    <td>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button type="button" class="btn btn-xs btn-info" onclick="openAssignment(${item.id})">
                                                <i class="ace-icon fa fa-check-square bigger-120" data-toggle="tooltip"
                                                   data-placement="top" title="Assignment Customer"></i>
                                            </button>
                                        </div>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button type="submit" class="btn btn-xs btn-warning"
                                                    onclick="editCustomer(${item.id})">
                                                <i class="ace-icon fa fa-pencil bigger-120" data-toggle="tooltip"
                                                   data-placement="top" title="Edit Customer"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </form:form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Assignment Customer Modal -->
<div id="assignmentModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered" id="staffList">
                    <thead>
                    <tr>
                        <th>Chọn nhân viên</th>
                        <th>Tên nhân viên</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
            </div>
        </div>
    </div>
</div>
<script>
    function openAssignment(customerId){
        $("#assignmentModal").modal();
        $('#customerId').val(customerId);

        $.ajax({
            method: "GET",
            url: 'http://localhost:8080/api/customer/' + customerId + '/staffs',
            contentType: "application/json",
            success: function (res) {
                console.log("success");
                var row = "";
                $.each(res.data, function (i, v) {
                    row += '<tr>';
                    row += '<td class="text-center"><input type="checkbox" value=' + v.staffId + ' id="checkbox_' + v.staffId + '" class="check-box-element" ' + v.checked + '/></td>';
                    row += '<td class="text-center">' + v.fullName + '</td>';
                    row += '</tr>';
                });
                $('#staffList tbody').html(row);
            },
            fail: function (res) {
                console.log("fail");
                console.log(res);
            }
        })
    }

    $("#btnAssignCustomer").click(function (e) {
        e.preventDefault();
        var data = {};
        data['customerId'] = $('#customerId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffs'] = staffs;

        $.ajax({
            type: "PUT",
            url: 'http://localhost:8080/api/customer/assignment',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (res) {
                console.log("success");
                $("#assignmentModal .close").trigger("click");
            },
            fail: function (res) {
                console.log("fail");
                console.log(res);
            }
        });
    });

    $("#btnDeleteCustomer").click(function (e) {
        e.preventDefault();
        var ids = $('#customerlist').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();

        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api/customer",
            data: JSON.stringify(ids),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log("success");
                location.reload();
            },
            error: function (response) {
                console.log("fail");
                console.log(response);
            }
        });
    });

    $("#btnSearchCustomer").click(function (e) {
        e.preventDefault();
        $("#listForm").submit();
    });

    $("#btnAdd").click(function (e) {
        e.preventDefault();
        location.href = "http://localhost:8080/admin/customer-edit";
    })
</script>
</body>
</html>
