
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="customerAPI" value="/api/customer" />
<c:url var="customerEditURL" value="/admin/customer-edit" />

<html>
<head>
    <title>Customer Edit</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form commandName="modelEdit"  class="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="name"> Tên khách hàng </label>

                            <div class="col-sm-9">
                                <input type="text" id="name" name="name" value="" class="form-control" />
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="phone">Di Động</label>

                            <div class="col-sm-9">
                                <input type="text" id="phone" name="phone" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="email">Email</label>

                            <div class="col-sm-9">
                                <input type="text" id="email" name="email" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="staffID"> Nhân Viên Phụ Trách </label>

                            <div class="col-sm-9">
                                <input type="text" id="staffID" name="staffID" class="form-control" />
                            </div>
                        </div>










                        <div class="form-group">
                            <label class="col-sm-3 control-label"> Loại Giao Dịch </label>

                            <div class="form-group">
                                <div class="col-sm-4">
                                        <%--<form:checkboxes path="typeArrays" items="${buildingTypes}"/>--%>
                                </div>
                            </div>
                        </div>
                    </form:form>
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-9">
                            <button type="button" class="btn btn-success"id="btnAddCustomer">Thêm Khác Hàng</button>
                            <button type="button" class="btn btn-danger">Huỷ</button>
                        </div>
                    </div>
                    <!-- PAGE CONTENT ENDS -->
                </div>
            </div>
        </div>
        <div class="hr hr-18 dotted hr-double"></div>
        <div class="pull-right">
            <button class="bigger-150" data-toggle="tooltip" data-placement="top" title="Thêm khách hàng">
                <a class="green" href="<c:url value='/admin/customer-edit'/>">
                    <i class="fa fa-plus-circle" aria-hidden="true"></i>
                </a>
            </button>
            <button class="bigger-150" data-toggle="tooltip" data-placement="top" id="btnDeleteCustomer" title="Xoá khách hàng">
                <a class="red">
                    <i class="fa fa-trash-o" aria-hidden="true"></i>
                </a>
            </button>
        </div>


    </div>
</div><!-- /.main-content -->

<script>
    $('#btnAddCustomer').click(function(e) {
        e.preventDefault();
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            data[""+v.name+""] = v.value;
        });
        data['buildingTypes'] = buildingTypes;
        $.ajax({
            type: 'GET',
            url: '${customerAPI}',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('Success')
                console.log(response)
            },
            error: function (response) {
                console.log('Failed'),
                    console.log(response)
            }
        })
    })
</script>
</body>
</html>