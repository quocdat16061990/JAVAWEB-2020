<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="buildingUpdateURL" value="/admin/building-update" />
<html>
<head>
    <title>Building Update</title>
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

                    <form:form commandName="updateBuilding" action="buildingUpdateURL" class="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="name"> Tên toà nhà </label>

                            <div class="col-sm-9">
                                <input type="text" id="name" name="name" value="" class="form-control" />
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <label class="col-sm-3 control-label"> Người quản lý sản phẩm </label>
                            <div class="col-sm-9">
                                <form:select path="staffId" class="form-control">
                                    <form:option value="" label="--- Chọn nhân viên ---"/>
                                    <form:options items="${staffmaps}"/>
                                </form:select>
                            </div>
                        </div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"> Quận </label>
                            <div class="col-sm-9">
                                <form:select path="district" class="form-control">
                                    <form:option value="" label="--- Chọn quận ---"/>
                                    <form:options items="${district}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="ward">Phường</label>

                            <div class="col-sm-9">
                                <input type="text" id="ward" name="ward" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="street">Đường</label>

                            <div class="col-sm-9">
                                <input type="text" id="street" name="street" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="structure"> Kết cấu </label>

                            <div class="col-sm-9">
                                <input type="text" id="structure" name="structure" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="numberOfBasement"> Số tầng hầm </label>

                            <div class="col-sm-9">
                                <input type="number" id="numberOfBasement" name="numberOfBasement" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="floorArea"> Diện tích sàn </label>

                            <div class="col-sm-9">
                                <input type="number" id="floorArea" name="floorArea" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="direction">Hướng</label>

                            <div class="col-sm-9">
                                <input type="text" id="direction" name="direction" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="level"> Hạng </label>

                            <div class="col-sm-9">
                                <input type="text" id="level" name="level" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="rentArea"> Diện tích thuê </label>

                            <div class="col-sm-9">
                                <input type="number" id="rentArea" name="rentArea" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="rentAreaDescription"> Mô tả diện tích thuê </label>

                            <div class="col-sm-9">
                                <input type="text" id="rentAreaDescription" name="rentAreaDescription" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="rentPriceDescription"> Mô tả giá </label>

                            <div class="col-sm-9">
                                <input type="text" id="rentPriceDescription" name="rentPriceDescription" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="serviceFee"> Phí dịch vụ </label>

                            <div class="col-sm-9">
                                <input type="text" id="serviceFee" name="serviceFee" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="carFee"> Phí ô tô </label>

                            <div class="col-sm-9">
                                <input type="text" id="carFee" name="carFee" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="motorbikeFee"> Phí mô tô</label>

                            <div class="col-sm-9">
                                <input type="text" id="motorbikeFee" name="motorbikeFee" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="overtimeFee"> Phí ngoài giờ </label>

                            <div class="col-sm-9">
                                <input type="text" id="overtimeFee" name="overtimeFee" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="electricityFee"> Tiền điện </label>

                            <div class="col-sm-9">
                                <input type="number" id="electricityFee" name="electricityFee" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="deposit"> Đặt cọc </label>

                            <div class="col-sm-9">
                                <input type="number" id="deposit" name="deposit" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="payment"> Thanh toán </label>

                            <div class="col-sm-9">
                                <input type="number" id="payment" name="payment" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="rentTime"> Thời gian thuê </label>

                            <div class="col-sm-9">
                                <input type="text" id="rentTime" name="rentTime" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="decorationTime"> Thời gian trang trí </label>

                            <div class="col-sm-9">
                                <input type="text" id="decorationTime" name="decorationTime" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="managerName"> Tên quản lý </label>

                            <div class="col-sm-9">
                                <input type="text" id="managerName" name="managerName" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="managerPhone"> Số điện thoại quản lý </label>

                            <div class="col-sm-9">
                                <input type="text" id="managerPhone" name="managerPhone" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="brokerageFee">Phí môi giới </label>

                            <div class="col-sm-9">
                                <input type="text" id="brokerageFee" name="brokerageFee" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"> Loại toà nhà </label>

                            <div class="form-group">
                                <div class="col-sm-4">
                                    <form:checkboxes path="typeArrays" items="${buildingTypes}"/>
                                </div>
                            </div>
                        </div>
                    </form:form>
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-9">
                            <button type="button" class="btn btn-success"id="btnAddBuilding">Thêm toà nhà</button>
                            <button type="button" class="btn btn-danger">Huỷ</button>
                        </div>
                    </div>
                    <!-- PAGE CONTENT ENDS -->
                </div>
            </div>
        </div>
        <div class="hr hr-18 dotted hr-double"></div>
        <div class="pull-right">
            <button class="bigger-150" data-toggle="tooltip" data-placement="top" title="Thêm toà nhà">
                <a class="green" href="<c:url value='/admin/building-edit'/>">
                    <i class="fa fa-plus-circle" aria-hidden="true"></i>
                </a>
            </button>
            <button class="bigger-150" data-toggle="tooltip" data-placement="top" id="btnDeleteBuilding" title="Xoá toà nhà">
                <a class="red">
                    <i class="fa fa-trash-o" aria-hidden="true"></i>
                </a>
            </button>
        </div>

        <table id="buildingList" class="table  table-bordered table-hover">
            <thead>
            <tr>
                <th></th>
                <th>Tên toà nhà</th>
                <th>Địa chỉ</th>
                <th>Tên quản lý</th>
                <th>Số điện thoại</th>
                <th>Diện tích sàn</th>
                <th>Số tầng hầm</th>
                <th>Giá thuê</th>
                <th>Phí dịch vụ</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${editBuilding}">
                <tr>
                    <th><label><input type="checkbox" value="1" id="checkbox"></label></th>
                    <td>${item.name}</td>
                    <td>${item.street}, ${item.ward}, ${item.district} </td>
                    <td>${item.managerName}</td>
                    <td>${item.managerPhone}</td>
                    <td>${item.floorArea}</td>
                    <td>${item.numberOfBasement}</td>
                    <td>${item.rentPrice}</td>
                    <td>${item.serviceFee}</td>
                    <td>
                        <div class="hidden-sm hidden-xs action-buttons">
                            <a class ="blue" data-toggle="tooltip" data-placement="top" title="Giao toà nhà" onclick="assignmentBuilding(1)">
                                <i class="ace-icon fa fa-exchange bigger-130" ></i>
                            </a>
                            <a class="green" href="#">
                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                            </a>

                            <a class="red" href="#">
                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div><!-- /.main-content -->

<script>
    $('#btnAddBuilding').click(function(e) {
        e.preventDefault();
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            data[""+v.name+""] = v.value;
        });
        data['buildingTypes'] = buildingTypes;
        $.ajax({
            type: 'POST',
            url: '${buildingAPI}',
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