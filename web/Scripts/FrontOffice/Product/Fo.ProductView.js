//    Document   : Fo.ProductView
//    Created on : Mar 26, 2022, 03:46:01 AM
//    Author     : vinnie chin

$(document).ready(function () {

    //if no related products hide the container
    if ($('.relProducts').length == 0) {
        $('#relProContainer').hide();
    }

    $('#add-cart-btn').click(function () {
        //get current url and pass to function written
        url = window.location.href;
        customerLoginOrNot(url, addCart);
    });

    $('#buy-now-btn').click(function () {
        //get current url and pass to function written
        url = window.location.href;
        customerLoginOrNot(url, buyNow);
    });
});

function buyNow() {
    var productDetailId = $('input[type=radio][name=details-option]:checked').attr('id');

    var buyAction = JSON.stringify({
        productDetailId: productDetailId,
        quantity: parseInt($('#quantity').val()).toString()
    });

    post('/Nike_E-Commerce_System/BuyNow',
            buyAction,
            function (success) {
                window.location.href = "../../../Views/FrontOffice/Order/Fo.OrderNew.jsp?cartId=" + success;
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

function addCart() {
    var productId = new URLSearchParams(window.location.search).get('productId');

    var productDetailId = $('input[type=radio][name=details-option]:checked').attr('id');

    console.log(productDetailId);

    var cartAction = JSON.stringify({
        productDetailId: productDetailId,
        quantity: parseInt($('#quantity').val()).toString()
    });

    post('/Nike_E-Commerce_System/NewCartDetail',
            cartAction,
            function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Successful',
                    text: "The item is added into cart",
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
}
