$('#btnAddbuilding').click(function (e) {
    e.preventDefault();
    //Call API add building
    var data = {};
    var buildingTypes = [];
    var formData = $('#formEdit').serializeArray();

    $.each(formData, function (index, v) {
        if (v.name == 'buildingTypes') {
            buildingTypes.push(v.value);
        } else {
            data["" + v.name + ""] = v.value;
        }
    });
    data['buildingTypes'] = buildingTypes;
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/building',
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log('success');
            location.reload();
        },
        error: function (response) {
            console.log('failed');
            console.log(response);
        }
    });
})

$("#btnAddbuilding").click(function (e) {
    e.preventDefault();
    $("#editForm").submit();
});