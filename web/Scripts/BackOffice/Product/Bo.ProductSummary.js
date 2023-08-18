$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "ProductSummary"},
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


$(document).ready(function () {
//    table id
    $('#table-product-summary').DataTable(
            //  load json data that retrieve from db into table
    );
});

function productActivate(productId) {

    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "Activate"},
        success: function (data) {
            $('#product-activate').modal('show');
            $('#product-activate-btn').click(function () {
                $('#product-activate').modal('hide');
                var productActivate = JSON.stringify({
                    "productId": productId.toString()
                });

                post('/Nike_E-Commerce_System/ProductActivate',
                        productActivate,
                        function (success) {
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: 'Successful',
                                text: success,
                                showConfirmButton: false,
                                timer: 1900
                            }).then(function () {
                                location.reload();
                            });
                        },
                        function (error) {
                            Swal.fire({
                                icon: 'error',
                                title: 'Oops...',
                                text: error.responseText
                            });
                        }
                );
            });
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Access restricted."
            }).then(function () {
                location.reload();
            });
        }
    });




}

function productDeactivate(productId) {

    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "Deactivate"},
        success: function (data) {
            $('#product-deactivate').modal('show');
            $('#product-deactivate-btn').click(function () {
                $('#product-deactivate').modal('hide');
                var productDeactivate = JSON.stringify({
                    "productId": productId.toString()
                });

                post('/Nike_E-Commerce_System/ProductDeactivate',
                        productDeactivate,
                        function (success) {
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: 'Successful',
                                text: success,
                                showConfirmButton: false,
                                timer: 1900
                            }).then(function () {
                                location.reload();
                            });
                        },
                        function (error) {
                            Swal.fire({
                                icon: 'error',
                                title: 'Oops...',
                                text: error.responseText
                            });
                        }
                );
            });
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Access restricted."
            }).then(function () {
                location.reload();
            });
        }
    });
}


