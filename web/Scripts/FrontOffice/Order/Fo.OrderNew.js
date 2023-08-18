/*
 Document   : Fo.OrderView
 Created on : 19 Feb 2022, 6:27:10 pm
 Author     : Lim En Xi
 */

$(document).ready(function () {
    console.log($('#txt-courier') + "yiu");
    console.log(typeof $('#txt-courier'));
    console.log($('#txt-courier').val() + "val");
    console.log($('#txt-courier').val().length);
    //form submit button clicked
    $('#new-order').submit(function (event) {
        var addressLine = $('#txt-address').val().replace(/,(?=[^\s])/g, ", ");
        var postCode = $('#txt-address-postcode').val();
        var city = $('#txt-address-city').val();
        var state = $('#txt-address-state').val();

        var deliveryAddress =
                addressLine + "." +
                $('#txt-address-postcode').val() + "." +
                $('#txt-address-city').val() + "." +
                $('#txt-address-state').val();
        console.log(deliveryAddress);
        event.preventDefault();

        console.log($('#txt-courier') + "yiu");
        console.log(typeof $('#txt-courier'));
        console.log($('#txt-courier').val());
        console.log($('#txt-courier').val().length);
        
        if (isNaN(parseInt($('#txt-courier').val()))) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Please select a courier"
            });
        } else if (addressLine.length < 1 ||
                postCode.length < 1 ||
                city.length < 1 ||
                state.length < 1) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Please fill in valid address"
            });
        } else {
            var orderInput = JSON.stringify({
                "recipient": $('#txt-recipient').val(),
                "courierId": $('#txt-courier').val(),
                "cartId": $('#txt-cart-id').val(),
                "deliveryAddress": deliveryAddress
            });

//        call controller
            post('/Nike_E-Commerce_System/FoNewOrder',
                    orderInput,
                    function (success) {
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Successful',
                            text: 'Order is placed. Please proceed to payment.',
                            showConfirmButton: false,
                            timer: 1900
                        }).then(function () {
                            window.location.href = "../../../Views/FrontOffice/Payment/Fo.PaymentNew.jsp?orderId=" + success;
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
    });
});

function dynamicPrice(idParam, subTotal) {
    var cId = idParam.value;
    var fee = idParam[idParam.selectedIndex].id;
    var total = parseInt(fee) + parseInt(subTotal);

    $('#txt-delivery-fee').val(fee);
    $('#txt-delivery-fee').focus();
    $('#txt-order-total-price').val(total);
    $('#txt-order-total-price').focus();
}