<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="buildingListURL" value="/admin/building-list" />
<html>
<head>
    <title>Danh sách toà nhà</title>
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
                    <div class="widget-box">
                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm</h4>
                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="widget-body">
                            <div class="widget-main">
                                <!-- PAGE CONTENT BEGINS -->
                                <form:form commandName="modelSearch" action="${buildingListURL}" id="listForm" method="GET">
                                    <div class="form-horizontal">
                                        <div class="form-group">

                                            <div class="col-sm-6">
                                                <div>
                                                    <label for="name">Tên toà nhà</label>
                                                    <form:input path="name" cssClass="form-control" />
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div>
                                                    <label for="name">Diện tích sàn</label>
                                                    <input type="number" id="floorArea" class="form-control" name="floorArea" value="${modelSearch.floorArea}"/>
                                                </div>
                                            </div>
                                        </div><!-- /.form-group-->
                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <label for="name">Quận</label>
                                                <form:select path="district" class="form-control">
                                                    <form:option value="" label="--- Chọn quận ---"/>
                                                    <form:options items="${districts}"/>
                                                </form:select>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Phường</label>
                                                    <form:input path="ward" cssClass="form-control" />
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Đường</label>
                                                    <form:input path="street" cssClass="form-control" />
                                                </div>
                                            </div>
                                        </div><!-- /.form-group-->
                                        <div class="form-group">

                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Số tầng hầm</label>
                                                    <input type="number" id="numberOfBasement" class="form-control" name="numberOfBasement" value="${modelSearch.numberOfBasement}"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Hướng</label>
                                                        <%--                                                    <input type="text" id="ward" class="form-control" />--%>
                                                    <form:input path="direction" cssClass="form-control" />
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Hạng</label>
                                                    <form:input path="level" cssClass="form-control" />
                                                </div>
                                            </div>
                                        </div><!-- /.form-group-->
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="name">Diện tích từ</label>
                                                    <input type="text" id="rentAreaFrom" class="form-control" name="rentAreaFrom" value="${modelSearch.rentAreaFrom}"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="name">Diện tích đến</label>
                                                    <input type="number" id="rentAreaTo" class="form-control" name="rentAreaTo" value="${modelSearch.rentAreaTo}"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="name">Giá thuê từ</label>
                                                    <input type="text" id="costRentFrom" class="form-control" name="costRentFrom" value="${modelSearch.rentCostFrom}"/>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div>
                                                    <label for="name">Giá thuê đến</label>
                                                    <input type="number" id="costRentTo" class="form-control" name="costRentTo" value="${modelSearch.rentCostTo}"/>
                                                </div>
                                            </div>
                                        </div><!-- /.form-group-->

                                        <div class="form-group">

                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Tên quản lý</label>
                                                        <%--                                                    <input type="text" id="managerName" class="form-control" />--%>
                                                    <form:input path="managerName" cssClass="form-control" />
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Điện thoại quản lý</label>
                                                        <%--                                                    <input type="text" id="managerPhone" class="form-control" />--%>
                                                    <form:input path="managerPhone" cssClass="form-control" />
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <label for="name">Chọn nhân viên phụ trách</label>
                                                <form:select path="staffId" class="form-control">
                                                    <form:option value="" label="--- Chọn nhân viên ---"/>
                                                    <form:options items="${staffmaps}"/>
                                                </form:select>
                                            </div>
                                        </div><!-- /.form-group-->
                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <form:checkboxes path="type" items="${buildingTypes}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <button type="button" class="btn btn-success"id="btnSearch" path="">Tìm kiếm</button>
                                            </div>
                                        </div>
                                    </div><!-- PAGE CONTENT ENDS -->
                                </form:form>

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
                        <c:forEach var="item" items="${buildingSearchCustom}">
                            <tr>
                                <th><label><input type="checkbox" value="1" id="checkbox"></label></th>
                                <td>${item.name}</td>
                                <td>${item.street}, ${item.ward}, ${item.district} </td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.floorArea}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.rentCost}</td>
                                <td>${item.serviceCost}</td>
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
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->




<!-- Assignment Buidlding Modal -->
<div class="modal fade" id="assignmentBuildingModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
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
                    <tr>
                        <td><label><input type="checkbox" value="2" id="checkbox"></label></td>
                        <td>Nguyễn Văn A</td>
                    </tr>
                    <tr>
                        <td><label><input type="checkbox" value="3" id="checkbox"></label></td>
                        <td>Nguyễn Văn B</td>
                    </tr>
                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-success" id="btnAssignBuilding">Giao toà nhà</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
        </div>

    </div>

</div>

<!--Giao toà nhà-->
<script>
    function assignmentBuilding(buildingId) {
        openModalAssignmentBuilding ();
        $('#buildingId').val(buildingId);
        console.log($('#buildingId').val());
    }
    function openModalAssignmentBuilding(){
        $('#assignmentBuildingModal').modal();
    }
    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        var staffs = [];
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        assignStaff(data);
    });
    function assignStaff(data){
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api-user-assignment",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('Success')
            },
            error: function (response) {
                console.log('Failed'),
                    console.log(response)
            }
        });
    }

    $('#btnSearch').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();

    });
    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var buildingIds = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['buildingIds'] = buildingIds;
        deleteBuilding(data);
    });
    function deleteBuilding(data){
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api-building",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('Success')
            },
            error: function (response) {
                console.log('Failed'),
                    console.log(response)
            }
        });
    }
</script>

<!--Giao toà nhà-->
<script>
    $('#btnAddBuilding').click(function() {
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            if(v.name == 'buildingTypes'){
                buildingTypes.push(v.value);
            } else {
                data[""+v.name+""] = v.value;
            }
        });
        data['buildingTypes'] = buildingTypes;
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api-building",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('Success')
            },
            error: function (response) {
                console.log('Failed'),
                    console.log(response)
            }
        });
    })

</script>
</body>
</html>
