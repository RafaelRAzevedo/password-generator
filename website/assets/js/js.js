$(document).ready(function () {

    $("form").submit(function () { return false; });

    $("#button").click(function () {
        var $form = $("#form");
        var data = getFormData($form);


        sendData(data);

    });

    var sendData = function (data) {
        console.log(data)
        $.ajax({
            url: 'http://localhost:8080/generate',
            async: true,
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (msg) {
                console.log(msg);
            },
            error: console.log("error")
        });
    }

    console.log("ready");
});

function getFormData($form) {
    var unindexed_array = $form.serializeArray();

    unindexed_array = unindexed_array.concat(
        jQuery('#form input[type=checkbox]:not(:checked)').map(
            function () {
                return { "name": this.name, "value": "false" }
            }).get());

    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}