var buildingId;

function assignmentBuilding(id) {
    $("#assignmentBuildingModal").modal();
    buildingId = id;

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/building/' + id + '/staffs',
        success: function (response) {
            console.log('success');
            var row = "";
            $.each(response.data, function (i, v) {
                row += '<tr>';
                row += '<td class="text-center"><input type="checkbox" value=' + v.staffId + ' id="checkbox_' + v.staffId + '" class="check-box-element" ' + v.checked + '/></td>';
                row += '<td class="text-center">' + v.fullName + '</td>';
                row += '</tr>';
            });
            $('#staffList tbody').html(row);
        },
        error: function (response) {
            console.log('failed');
            console.log(response);
        }
    });
};

$("#btnAssignBuilding").click(function (e) {
    e.preventDefault();
    //Call Api
    var data = {};
    data['buildingId'] = buildingId;
    var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    data['staffs'] = staffs;

    $.ajax({
        type: "PUT",
        url: 'http://localhost:8080/api/building/assignment',
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log("success");
        },
        error: function (response) {
            console.log("fail");
            console.log(response);
        }
    });
});

$("#btnDeleteBuilding").click(function (e) {
    e.preventDefault();
    var ids = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();

    $.ajax({
        type: "DELETE",
        url: 'http://localhost:8080/api/building',
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

$("#btnSearch").click(function (e) {
    e.preventDefault();
    $("#listForm").submit();
});

$("#btn-add-building").click(function (e) {
    e.preventDefault();
    location.assign('http://localhost:8080/admin/building-edit');
})

function editBuilding(buildingId) {
    $('#editBuildingModal').modal();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/building/' + buildingId,
        success: function (response) {
            console.log('success');
        },
        error: function (response) {
            console.log('failed');
            console.log(response);
        }
    });

    $('body').delegate('#btnEditBuilding', 'click', function (e) {
        e.preventDefault();
        var data = {};
        var buildingTypes = [];
        var id = buildingId;
        var formData = $('#formEdit').serializeArray();

        $.each(formData, function (index, v) {
            if (v.name == 'buildingTypes') {
                buildingTypes.push(v.value);
            } else {
                data["" + v.name + ""] = v.value;
            }
        });
        data['id'] = id;
        data['buildingTypes'] = buildingTypes;

        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/api/building/',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log("success");
                location.reload();
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    });
}




