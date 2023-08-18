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


$(document).ready(function () {

    console.log($('#isFeatured:checked').val());
    
  
    //form submit button clicked
    $('#addProductForm').submit(function (event) {

        console.log($('#productName').val().length);
        console.log($('#productDesc').val().length);
        console.log($('#productPrice').val().length);
        console.log($('#productCategory').val());
        
        var isFeatured = "";
        
        
        if ($('input[name="isFeatured"]:checked').length>0) {
            isFeatured = '1';
        } else {
            isFeatured = '0';
        }
      
        var pdName = $('#productName').val();
        var pdDesc = $('#productDesc').val();
        var pdCategory = $('#productCategory').val();
        var pdPrice = $('#productPrice').val();

        event.preventDefault();
        
        if (pdName.length < 1 || pdDesc.length < 1  || pdCategory === "Category" || pdPrice.length < 1){
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Please do not leave blank"
            });
        } else{
            var productInput = JSON.stringify({
            "productName": $('#productName').val(),
            "productPrice": $('#productPrice').val().replace(/,/g, ''),
            "productCategory": $('#productCategory').val(),
            "productDesc": $('#productDesc').val(),
            "isFeatured": isFeatured
            });
            
            post('/Nike_E-Commerce_System/ProductNew',
                productInput,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successful',
                        text: 'Product is added successfully.',
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
        
       
//        var productInput = JSON.stringify({
//            "productName": $('#productName').val(),
//            "productPrice": $('#productPrice').val().replace(/,/g, ''),
//            "productCategory": $('#productCategory').val(),
//            "productDesc": $('#productDesc').val(),
//            "isFeatured": isFeatured
//        });

        //call controller
        
    });
});


function validateNumber(e) {
            const pattern = /^[a-zA-Z]$/;

            return pattern.test(e.key )
}

function validateAlpha(e) {
            const pattern = /^[0-9]*\.?[0-9]*$/; 

             if(pattern.test(e.key)==false){
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: "Please fill in numbers only"
                });
            }
            //return pattern.test(e.key )
}

function validatePrice(price)
{
    if (price.value.trim() === "") {
        //alert("Please enter a price");
        price.focus();
        return false;
    }
    if (price.value !== "") {
        if (! (/^\d*(?:\.\d{0,2})?$/.test(price.value))) {
            //alert("Please enter a valid price");
            price.focus();
            return false;
        }
    }
    return true;       
}




