<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="customerAPI" value="/api/customer" />
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<html>
<head>
    <title>Chỉnh sửa khách hàng</title>
    <script>
        $(document).ready(function () {

        });
    </script>
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
                <li class="active">Dashboard</li>
            </ul>
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form commandName="addCustomer" action="${customerEditURL}" id="editForm" method="POST">
                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="fullName">Họ tên khách hàng:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="text" id="fullName" name="fullName"/>
                            </div>
                        </div>

                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="phone">Số điện thoại:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="number" id="phone" name="phone"/>
                            </div>
                        </div>

                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="email">Email:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="email" id="email" name="email"/>
                            </div>
                        </div>

                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="createdDate">Ngày tạo:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="date" id="createdDate" name="createdDate"/>
                            </div>
                        </div>


                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="modifiedDate">Ngày chỉnh sửa:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="date" id="modifiedDate" name="modifiedDate"/>
                            </div>
                        </div>

                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="createdBy">Người tạo:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="text" id="createdBy" name="createdBy"/>
                            </div>
                        </div>

                        <div class="form-group col-md-9">
                            <label class="col-sm-3 control-label no-padding-right" for="modifiedBy"> Người chỉnh sửa:
                            </label>

                            <div class="col-sm-9">
                                <input class="form-control" type="text" id="modifiedBy" name="modifiedBy"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-9">
                                <button type="button" class="btn btn-primary" id="btnAddCustomer">Thêm khách hàng
                                </button>
                                <button type="button" class="btn btn-primary" id="">Huỷ</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div id="assignmentBuildingModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Chọn nhân viên</th>
                        <th>Tên nhân viên</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="checkbox" value="2" id="checkbox_2"></td>
                        <td>Nguyễn Văn B</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="3" id="checkbox_3"></td>
                        <td>Nguyễn Văn C</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="4" id="checkbox_4"></td>
                        <td>Nguyễn Văn D</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<!-- basic scripts -->
<script>
    $('#btnAddCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            data[""+v.name+""] = v.value;
        });
        $.ajax({
            type:'POST',
            url:'${customerAPI}',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (response) {
                console.log('success');
            },
            error:function (response) {
                console.log('failed');
                console.log(response);
            }
        });
        $('#formEdit').submit();
    });
</script>
</body>
</html>
