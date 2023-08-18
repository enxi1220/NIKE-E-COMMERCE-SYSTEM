$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "StockReport"},
        success: function (data) {},
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Access restricted."
            }).then(function () {
                history.back();
            });
        }
    });
});
