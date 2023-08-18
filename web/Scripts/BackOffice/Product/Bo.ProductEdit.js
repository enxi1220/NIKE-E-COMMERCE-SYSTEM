var images = [];

function image_select() {
    var image = document.getElementById('newimage').files;
    for (i = 0; i < image.length; i++) {
        if (check_duplicate(image[i].name)) {
            images.push({
                "name": image[i].name,
                "url": window.URL.createObjectURL(image[i]),
                "file": image[i]
            });
        } else
        {
            alert(image[i].name + " is already added to the list");
        }
    }

    document.getElementById('form').reset();
    document.getElementById('container').innerHTML = image_show();
}

function image_show() {
    var image = "";
    images.forEach((i) => {
        image += `<div class="image_container d-flex justify-content-center position-relative">
   	  	  	  	  <img src="` + i.url + `" alt="Image">
   	  	  	  	  <span class="position-absolute" onclick="delete_image(` + images.indexOf(i) + `)">&times;</span>
   	  	  	  </div>`;
    });
    return image;
}

function delete_image(e) {
    images.splice(e, 1);
    document.getElementById('container').innerHTML = image_show();
}

function check_duplicate(name) {
    var image = true;
    if (images.length > 0) {
        for (e = 0; e < images.length; e++) {
            if (images[e].name === name) {
                image = false;
                break;
            }
        }
    }
    return image;
}

function get_image_data() {
    var form = new FormData();
    for (let index = 0; index < images.length; index++) {
        form.append("file[" + index + "]", images[index]['file']);
    }
    return form;
}

function passData(color,size,physicalQty,minStockQty,salesOutQty, productDetailId){
    
    $('#color').val(color);
    $('#size').val(size);
    $('#phyQty').val(physicalQty);
    $('#minQty').val(minStockQty);
    $('#salesQty').val(salesOutQty);
    $('#productDetailId').val(productDetailId);
    
    $('#size').focus();
    $('#phyQty').focus();
    $('#minQty').focus();
    $('#salesQty').focus();
    $('#color').focus();
}

$(document).ready(function(){
//    table id
    $('#table-product-edit-summary').DataTable(
        //  load json data that retrieve from db into table
    );
});

$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "ProductEdit"},
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

function editProduct(){
    
    var isFeatured = "";
    var productId = new URLSearchParams(window.location.search).get('productId');
        
    if ($('input[name="isFeatured"]:checked').length>0) {
        isFeatured = '1';
    } else {
        isFeatured = '0';
    }

    event.preventDefault();
    var productEdit = JSON.stringify({
        "productId": new URLSearchParams(window.location.search).get('productId'),
        "productName": $('#productName').val(),
        "productPrice": $('#price').val(),
        "productCategory": $('#category').val(),
        "productDesc": $('#productDesc').val(),
        "isFeatured": isFeatured
    });

    //call controller
    post('/Nike_E-Commerce_System/EditProduct',
            productEdit,
            function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Successful',
                    text: 'Product is edited successfully.',
                    showConfirmButton: false,
                    timer: 1900
                }).then(function () {
                    window.location.href = "../../../Views/BackOffice/Product/Bo.ProductEdit.jsp?productId=" + productId;
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

function editProductDetail(){
    
    var productId = new URLSearchParams(window.location.search).get('productId');
    
    if ($('#productDetailId').val().length < 1 ){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: "Please select product detail"
        });
    }else{
        var productInput = JSON.stringify({
            "color": $('#color').val(),
            "size": $('#size').val(),
            "phyQty": $('#phyQty').val().toString(),
            "minQty": $('#minQty').val().toString(),
            "productDetailId" : $('#productDetailId').val(),
            "productId": new URLSearchParams(window.location.search).get('productId')
    });

    //call controller
    post('/Nike_E-Commerce_System/EditProductDetail',
            productInput,
            function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Successful',
                    text: 'Product detail is edited successfully.',
                    showConfirmButton: false,
                    timer: 1900
                }).then(function () {
                    window.location.href = "../../../Views/BackOffice/Product/Bo.ProductEdit.jsp?productId=" + productId;
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

function deleteProductImage(id) {
    
    var productId = new URLSearchParams(window.location.search).get('productId');
    
    $('#delete-product-image').modal('show');
    $('#confirm-delete-product-image').click(function () {
        var productImage = JSON.stringify({
            "productImageId": id.toString()
        });

        post('/Nike_E-Commerce_System/DeleteProductImage',
                productImage,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful',
                        text: "Image deleted successfully !",
                        showConfirmButton: false,
                        timer: 1900
                    }).then(function () {
                        window.location.href = "../../../Views/BackOffice/Product/Bo.ProductEdit.jsp?productId=" + productId;
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

function validateAlpha(e) {
            const pattern = /^[a-zA-Z\s]$/;

             if(pattern.test(e.key)==false){
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: "Please fill in alphabets only"
                });
            }
            //return pattern.test(e.key )
}

function validateNumber(e) {
            const pattern = /^[0-9]$/; 

             if(pattern.test(e.key)==false){
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: "Please fill in numbers only"
                });
            }
            //return pattern.test(e.key )
}

