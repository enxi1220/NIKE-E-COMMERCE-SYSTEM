/* 
 Created on : 22 Feb 2022, 8:32:11 pm
 Author     : Alvin Chan Ee Aun
 */

$(document).ready(function () {
//    table id
    $('#table-courier-summary').DataTable(
            //  load json data that retrieve from db into table
            );
});

$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "CourierSummary"},
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

function courierActivate(courierId) {
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "Activate"},
        success: function (data) {
            $('#courier-activate').modal('show');
            $('#courier-activate-btn').click(function () {
                $('#courier-activate').modal('hide');
                var courierActivate = JSON.stringify({
                    courierId: courierId.toString()
                });

                post('/Nike_E-Commerce_System/BoCourierActivate',
                        courierActivate,
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

function courierDeactivate(courierId) {
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "Deactivate"},
        success: function (data) {
            $('#courier-deactivate').modal('show');
            $('#courier-deactivate-btn').click(function () {
                $('#courier-deactivate').modal('hide');
                var courierDeactivate = JSON.stringify({
                    courierId: courierId.toString()
                });

                post('/Nike_E-Commerce_System/BoCourierDeactivate',
                        courierDeactivate,
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