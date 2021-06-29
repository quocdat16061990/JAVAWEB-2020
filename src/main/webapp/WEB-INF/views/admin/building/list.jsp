<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<html>
<head>
    <title>Danh sách toà nhà</title>
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
                <li class="active">Danh Sách Toà Nhà</li>
            </ul><!-- /.breadcrumb -->
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
                            <form:form commandName="modelSearch" action="${buildingListURL}" id="listForm"
                                       method="POST">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="name">Tên toà nhà: </label>
                                                <form:input path="name" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label for="floorArea">Diện tích sàn</label>
                                                <input type="number" class="form-control" name="floorArea"
                                                       id="floorArea"
                                                       name="floorArea" value="${modelSearch.floorArea}"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <!-- PAGE CONTENT ENDS -->
                                    </div><!-- /.col -->
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-4">
                                            <form:select path="district" cssClass="form-group">
                                                <form:option value="" label="-- Chọn quận --"/>
                                                <form:options items="${districtmaps}"/>
                                            </form:select>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="ward">Phường: </label>
                                                <input type="text" class="form-control" name="ward" id="ward"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="street">Đường: </label>
                                                <input type="text" class="form-control" name="street" id="street"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <!-- PAGE CONTENT ENDS -->
                                    </div><!-- /.col -->
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="numberOfBasement">Số tầng hầm: </label>
                                                <input type="text" class="form-control" name="numberOfBasement"
                                                       id="numberOfBasement" aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="direction">Hướng: </label>
                                                <input type="text" class="form-control" name="direction" id="direction"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="level">Hạng: </label>
                                                <input type="text" class="form-control" name="level" id="level"
                                                       aria-describedby="helpId" placeholder="">
                                                <small id="helpId" class="form-text text-muted">Help text</small>
                                            </div>
                                        </div>
                                        <!-- PAGE CONTENT ENDS -->
                                    </div><!-- /.col -->
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="rentAreaFrom">Diện tích từ: </label>
                                                <input type="text" class="form-control" name="rentAreaFrom"
                                                       id="rentAreaFrom"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="rentAreaTo">Diện tích đến: </label>
                                                <input type="text" class="form-control" name="rentAreaTo"
                                                       id="rentAreaTo"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="rentCostFrom">Giá thuê từ: </label>
                                                <input type="text" class="form-control" name="rentCostFrom"
                                                       id="rentCostFrom"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="rentCostTo">Giá thuê đến: </label>
                                                <input type="text" class="form-control" name="rentCostTo"
                                                       id="rentCostTo"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <!-- PAGE CONTENT ENDS -->
                                    </div><!-- /.col -->
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="managername">Tên quản lý: </label>
                                                <input type="text" class="form-control" name="managername"
                                                       id="managername"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <label for="managerphone">Điện thoại quản lý: </label>
                                                <input type="text" class="form-control" name="managerphone"
                                                       id="managerphone"
                                                       aria-describedby="helpId" placeholder="">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="form-group">
                                                <form:select path="staffId" cssClass="form-group">
                                                    <form:option value="-1" label="-- Chọn nhân viên phụ trách --"/>
                                                    <form:options items="${staffmaps}"/>
                                                </form:select>
                                            </div>
                                        </div>
                                        <!-- PAGE CONTENT ENDS -->
                                    </div><!-- /.col -->
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                            <label for="type"> Loại toà nhà:</label>
                                            <form:checkboxes path="type" items="${typemaps}"></form:checkboxes>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="col-xs-12 col-sm-12">
                                            <div class="form-group">
                                                <button type="button" class="btn btn-success" id="btnSearch">Tìm kiếm <i
                                                        class="fa fa-arrow-right"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div><!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="pull-right">
                        <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
                                title="Thêm toà nhà" id="btn-add-building">
                            <i class="fa fa-plus-circle"></i>
                        </button>
                        <button class="btn btn-white btn-info btn-bold" id="btnDeleteBuilding" data-toggle="tooltip"
                                title="Xoá toà nhà">
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </button>
                    </div>
                </div><!-- /.span -->
            </div><!-- /.row -->
            </br>
            <div class="row">
                <div class="col-xs-12">
                    <table id="buildingList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Tên toà nhà</th>
                            <th>Số tầng hầm</th>
                            <th>Địa chỉ</th>
                            <th>Tên quản lý</th>
                            <th>Số điện thoại</th>
                            <th>D.T sàn</th>
                            <th>Giá thuê</th>
                            <th>Phí dịch vụ</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${buildings}">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></td>
                                <td>${item.name}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.district}</td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.floorArea}</td>
                                <td>${item.rentCostFrom}</td>
                                <td>${item.serviceCost}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-xs btn-info" id="assignmentBuilding"
                                                onclick="assignmentBuilding(${item.id})">
                                            <i class="ace-icon fa fa-check-square bigger-120" data-toggle="tooltip"
                                               data-placement="top" title="Assignment Building"></i>
                                        </button>
                                    </div>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-xs btn-warning" id="editBuilding"
                                                onclick="editBuilding(${item.id})">
                                            <i class="ace-icon fa fa-pencil bigger-120" data-toggle="tooltip"
                                               data-placement="top" title="Edit Building"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<!-- Assignment Building Modal -->
<div id="assignmentBuildingModal" class="modal fade" role="dialog">
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
                    <tbody></tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao toà nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Edit Building Modal -->
<div id="editBuildingModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Chỉnh sửa toà nhà</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="formEdit">
                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editName"> Tên toà nhà</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editName" name="name"/>
                        </div>

                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editDistrict">Quận: </label>
                        <div class="col-sm-9">
                            <select name="district" id="editDistrict" class="custom-select mb-3">
                                <option selected>--- Chọn quận ---</option>
                                <option value="QUAN_1">Quận 1</option>
                                <option value="QUAN_2">Quận 2</option>
                                <option value="QUAN_3">Quận 3</option>
                                <option value="QUAN_4">Quận 4</option>
                                <option value="QUAN_5">Quận 5</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editWard"> Phường</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editWard" name="ward"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editStreet"> Đường</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editStreet" name="street"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editStructure"> Kết cấu</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editStructure" name="structure"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editNumberOfBasement"> Số tầng
                            hầm</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="number" id="editNumberOfBasement"
                                   name="numberOfBasement" value=""/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editFloorArea"> Diện tích
                            sàn</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="number" id="editFloorArea" name="floorArea"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editDirection"> Hướng</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editDirection" name="direction"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editLevel"> Hạng</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editLevel" name="level"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editRentArea"> Diện tích
                            thuê</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editRentArea" name="rentArea"
                                   placeholder="100,200,300,..."/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editRentAreaDescription"> Mô tả diện
                            tích</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="5" id="editRentAreaDescription"
                                      name="rentAreaDescription"></textarea>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editRentCost"> Giá thuê</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="number" id="editRentCost" name="rentCost"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editCostDescription"> Mô tả
                            giá</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="5" id="editCostDescription"
                                      name="costDescription"></textarea>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editServiceCost"> Phí dịch
                            vụ</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editServiceCost"
                                   name="serviceCost"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editCarCost"> Phí ô tô</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editCarCost" name="carCost"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editMotorCost"> Phí mô tô</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editMotorCost" name="motorCost"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editOvertimeCost"> Phí ngoài
                            giờ</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editOvertimeCost" name="overtimeCost"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editElectricBill"> Tiền điện</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editElectricBill" name="electricBill"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editDeposit"> Đặt cọc</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editDeposit" name="deposit"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editPayment"> Thanh toán</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editPayment" name="payment"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editTimeRent"> Thời hạn thuể</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editTimeRent" name="timeRent"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editTimeDecorator"> Thời gian trang
                            trí </label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editTimeDecorator" name="timeDecorator"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editManagerName"> Tên quản
                            lý</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editManagerName" name="managerName"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editManagerPhone"> SĐT quản
                            lý</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" id="editManagerPhone" name="managerPhone"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editBrokeragetee"> Phí môi
                            giới</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="number" id="editBrokeragetee" name="brokeragetee"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> Loại toà nhà</label>
                        <div class="col-sm-9">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" name="buildingTypes"
                                           value="TANG_TRET">Tầng trệt
                                </label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" name="buildingTypes"
                                           value="NGUYEN_CAN">Nguyên căn
                                </label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" name="buildingTypes"
                                           value="NOI_THAT">Nội thất
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="editNote">Ghi chú</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="5" id="editNote" name="note"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnEditBuilding">Cập nhật</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
