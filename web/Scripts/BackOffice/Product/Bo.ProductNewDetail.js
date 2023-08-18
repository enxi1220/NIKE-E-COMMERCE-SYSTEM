$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "ProductNew"},
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

function picPreview(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#productImgPre').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}


var images = [];

function image_select() {
    var image = document.getElementById('productImage').files;
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
        image = `<div class="image_container d-flex justify-content-center position-relative">
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





function image_insert(){
    var productId = JSON.stringify({
        productId: new URLSearchParams(window.location.search).get('productId')
        });
        
        postMultipart('/Nike_E-Commerce_System/NewProductImage',
                [
                    submitData('productId', productId),
                    submitData('productImg', $('#productImage')[0].files[0])
                ],
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful!',
                        text: 'Product Image added!',
                        showConfirmButton: false,
                        timer: 1000
                    }).then(function () {
                        window.location.href = "../../../Views/BackOffice/Product/Bo.ProductNewDetail.jsp?productId=" + success;
                    });
                }
        );
}

$(document).ready(function () {

    //form submit button clicked
    $('#addProductDetailForm').submit(function (event) {


        var pdColor = $('#color').val();
        var pdSize = $('#size').val();
        var pdPhy = $('#phyQty').val();
        var pdMin = $('#minQty').val();
        
        event.preventDefault();
        
        if(pdColor.length < 1 || pdSize.length < 1  || pdPhy.length < 1 || pdMin.length < 1){
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Please do not leave blank"
            });
        }else{
            var productInput = JSON.stringify({
            "color": $('#color').val(),
            "size": $('#size').val(),
            "phyQty": $('#phyQty').val().toString(),
            "minQty": $('#minQty').val().toString(),
            "productId": new URLSearchParams(window.location.search).get('productId')
        });

        //call controller
        post('/Nike_E-Commerce_System/NewProductDetail',
                productInput,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful',
                        text: 'Product detail is added successfully.',
                        showConfirmButton: false,
                        timer: 1900
                    }).then(function () {
                        window.location.href = "../../../Views/BackOffice/Product/Bo.ProductNewDetail.jsp?productId=" + success;
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