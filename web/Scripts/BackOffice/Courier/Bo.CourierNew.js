$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "CourierNew"},
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

function validateAlpha(e) {
    const pattern = /^[-+]?[0-9]*\.?[0-9]*$/;
    if (pattern.test(e.key) == false) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: "Please fill in numbers only"
        });
    }
}
