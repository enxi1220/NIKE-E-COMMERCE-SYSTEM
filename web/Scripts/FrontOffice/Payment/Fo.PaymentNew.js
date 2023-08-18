/*
 Created on : 21 Feb 2022, 6:30:51 pm
 Author     : Lim En Xi
 */

function submitPayment(method) {
    let check = true;
    var paymentInput = "";
    var url = '/Nike_E-Commerce_System/NewPayment';

    if (method === 'Online Banking') {
        url = '/Nike_E-Commerce_System/PayWithBank';
        if ($('#txt-bank').val() < 1) {
            check = false;
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Please select a bank"
            });
        } else {
            paymentInput = JSON.stringify({
                "payMethod": method,
                "orderId": new URLSearchParams(window.location.search).get('orderId'),
                "bankType": $('#txt-bank').val()
            });
        }
    } else {
        paymentInput = JSON.stringify({
            "payMethod": method,
            "orderId": new URLSearchParams(window.location.search).get('orderId')
        });

    }
    if (check) {
        //call controller
        post(url,
                paymentInput,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful',
                        text: 'Your order will be prepared soon.',
                        showConfirmButton: false,
                        timer: 1900
                    }).then(function () {
                        window.location.href = "../../../Views/FrontOffice/Product/Fo.ProductSummary.jsp";
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
    }
}