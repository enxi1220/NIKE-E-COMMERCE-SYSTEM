/*
 Document   : Fo.OrderView
 Created on : 19 Feb 2022, 2:05:10 pm
 Author     : Lim En Xi
 */

//user clicked received order
function completeOrder(oId)
{
    console.log(typeof oId);
    var orderAction = JSON.stringify({
        "orderId": oId.toString()
    });

    post('/Nike_E-Commerce_System/FoEditOrder',
            orderAction,
            function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Successful',
                    text: success,
                    showConfirmButton: false,
                    timer: 1900
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