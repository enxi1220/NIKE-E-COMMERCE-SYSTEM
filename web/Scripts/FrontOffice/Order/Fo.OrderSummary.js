/*
 Document   : OrderSummary
 Created on: 13 Feb 2022, 6: 20: 53 pm
 Author: Lim En Xi
 */

function copyToClipboard(id) {

    console.log(typeof id);
    console.log(id);
    var dummy = $('<input>').val(id).appendTo('body').select();
    document.execCommand('copy');
    $(dummy).remove();

    $('#copy-tracking-no').modal('show');
}

function cancelOrder(oId) {
    $('#cancel-order').modal('show');
    $('#confirm-cancel-order').click(function () {
        var orderAction = JSON.stringify({
            "orderId": oId.toString()
        });
        post('/Nike_E-Commerce_System/CancelOrder',
                orderAction,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful',
                        text: success,
                        showConfirmButton: false,
                        timer: 1900
                    }).then(function () {
                        window.location.href = "../../../Views/FrontOffice/Order/Fo.OrderSummary.jsp";
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



}
function showCancelOrderModal(oId) {
}
