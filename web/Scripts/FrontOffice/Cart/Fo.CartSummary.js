$(document).ready(function () {
//    userLoginOrNot();
//    getData();
});

function getData() {
    $.ajax({
        type: 'GET',
        url: '/Nike_E-Commerce_System/GetCartSummary',
        success: function (result) {
            var cart = JSON.parse(result);
            buildCart(cart);
        }
    });

}

function addCart(id, qty) {
    var productId = new URLSearchParams(window.location.search).get('productId');

    var cartAction = JSON.stringify({
        "productDetailId": id,
        "quantity": qty
    });

    post('/Nike_E-Commerce_System/NewCartDetail',
            cartAction,
            function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Successful',
                    text: success,
                    showConfirmButton: false,
                    timer: 1000
                }).then(function () {
                    window.location.href = "../../../Views/FrontOffice/Product/Fo.ProductView.jsp?productId=" + productId;
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


function editCart(cId) {
    var qty = $('#txt-quantity').val();
    var cartAction = JSON.stringify({
        "cartDetailId": cId,
        "quantity": qty
    });

    post('/Nike_E-Commerce_System/EditCartDetail',
            cartAction,
            function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Successful',
                    text: success,
                    showConfirmButton: false,
                    timer: 1900
                }).then(function () {
                    window.location.href = "../../../Views/FrontOffice/Cart/Fo.CartSummary.jsp";
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

function dymamicPrice2(price) {
    console.log("price " + price);
    var quantity = $('#txt-quantity').val;
    var total = quantity * price;
    console.log("sfs" + total);
    $('#txt-price').val(total);

}

function placeOrder(id) {
    window.location.href = '../../../Views/FrontOffice/Order/Fo.OrderNew.jsp?cartId=' + id;
}

function deleteCartDetail(id) {
    $('#delete-cart-detail').modal('show');
    $('#confirm-delete-cart-detail').click(function () {
        var cartAction = JSON.stringify({
            "cartDetailId": id.toString()
        });

        post('/Nike_E-Commerce_System/DeleteCartDetail',
                cartAction,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful',
                        text: success,
                        showConfirmButton: false,
                        timer: 1900
                    }).then(function () {
                        window.location.href = "../../../Views/FrontOffice/Cart/Fo.CartSummary.jsp";
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

function buildCart() {

}


