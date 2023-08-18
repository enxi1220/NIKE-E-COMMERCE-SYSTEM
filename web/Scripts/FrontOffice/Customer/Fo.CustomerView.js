//    Document   : Fo.CustomerView
//    Created on : Feb 20, 2022, 9:51:38 PM
//    Author     : vinnie chin

//picture preview on customer edit profile
function picPreview(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#custEditProPre').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

//convert base64string string to file and upload if customer didn't choose image
function dataURLtoFile(dataurl, filename) {
    var arr = dataurl.split(','),
            mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]),
            n = bstr.length,
            u8arr = new Uint8Array(n);

    while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
    }

    return new File([u8arr], filename, {type: mime});
}

//check if customer has choose image
function checkFileInputExist(ImageURL) {
    if ($('#custEditProPic')[0].files.length === 0) {
        return dataURLtoFile(ImageURL, 'testing');
    } else {
        return $('#custEditProPic')[0].files[0];
    }
}

//ajax post written in the function
function validatedCustEdit(name, mail, phone, deliveryAddress, imageURL){
    var customerInput = JSON.stringify({
            name: name,
            mail: mail,
            phone: phone,
            deliveryAddress: deliveryAddress
        });
        
        //the ajax code written as function in shared.js so all members can share the same method
        postMultipart('/Nike_E-Commerce_System/FoCustEditAcc',
                [
                    submitData('custEditedAcc', customerInput),
                    submitData('custEditedPro', checkFileInputExist(imageURL))
                ],
                function (success) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Successfully Edited Account!',
                        text: success,
                        showConfirmButton: false,
                        timer: 1900
                    });
                     
                    setTimeout(function () {
                        location.reload();
                    }, 1300);
       
                }
        );
}

$(document).ready(function () {

    //customer edit account details
    $('#custEditAcc').submit(function (event) {
        event.preventDefault();
        
        var defaultImgUrl = "data:image/png;base64,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";
        var name = $('#custEditName').val();
        var mail = $('#custEditMail').val();
        var phone = $('#custEditPhone').val();
        var imageURL = $('#custProImg').attr('src');
        var addr = $('#custEditAddress').val();
        var code = $('#custEditPostcode').val();
        var city = $('#custEditCity').val();
        var state = $('#custEditState').val();
        var deliveryAddress = "";
        
        if (!name) {
            errorPrompt(append("your name."));

        } else if (!mail) {
            errorPrompt(append("your email."));

        } else if (!phone) {
            errorPrompt(append("your phone."));
            
        //if one of the address fields is filled, check others
        } else if (addr !== "" || code !== "" || city !== "" || state !== "") {
            
            if (addr === "" || code === "" || city === "" || state === "") {
                errorPrompt(append("all fields for address OR leave all blank."));
            //if all address fields are filled, then concat their value to a full address
            }else{
                deliveryAddress =
                    addr.replace(/,(?=[^\s])/g, ", ").replace(/\./g, ", ") + "." +
                    code + "." +
                    city + "." +
                    state;
            
                //first manual insert customer account (not register with website) don't have image, upload the default one
                if(imageURL.indexOf("icon") !== -1){
                    validatedCustEdit(name, mail, phone, deliveryAddress, defaultImgUrl);
                }else{
                    // else customer register through website
                    validatedCustEdit(name, mail, phone, deliveryAddress, imageURL);
                }
            }
            
        } else { //if all address fields are blank

            if(imageURL.indexOf("icon") !== -1){// same as above
               validatedCustEdit(name, mail, phone, deliveryAddress, defaultImgUrl);
            }else{
               validatedCustEdit(name, mail, phone, deliveryAddress, imageURL);
            }
        }
    });
    

    //customer enter current password to change password
    $('#custChangePass').submit(function (event) {

        event.preventDefault();
        
        if (!$('#custEditOldPass').val()) {
            errorPrompt(append("your current password to continue."));

        }else{
            var customerInput = JSON.stringify({
                currentPass: $('#custEditOldPass').val(),
                action: "checkCurrentPass"
            });

            post('/Nike_E-Commerce_System/FoCustEditPass', customerInput,
                    function (success) {
                        $('#custChangePass')[0].reset();
                        $('#custChangePassBtn').click();
                }
            );
        }
    });
    
    //customer enter new password to change password
    $('#custChangePass-form').submit(function (event) {

        event.preventDefault();
        
        if (!$('#custChangeNewPass').val()) {
            errorPrompt(append("your new password."));
            
        }else{

            var customerInput = JSON.stringify({
                newPass: $('#custChangeNewPass').val(),
                action: "custChangeNewPass"
            });

            post('/Nike_E-Commerce_System/FoCustEditPass', customerInput,
                    function (success) {
                        $('#custChangePass-form')[0].reset();
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Successful!',
                            text: success,
                            showConfirmButton: false,
                            timer: 1900
                        });

                        $('#changePass-modal').modal('hide');
                    }
            );
        }
    });
    
    //customer current password to delete (deactivate) account  
    $('#custDeactivate').submit(function (event) { 

        event.preventDefault();
        
        if (!$('#custDeAccPass').val()) {
            errorPrompt(append("your current password to confirm delete."));
        }else{
            var customerInput = JSON.stringify({
                currentPass: $('#custDeAccPass').val(),
                action: "checkCurrentPass"
            });

            post('/Nike_E-Commerce_System/FoCustDeactivate', customerInput,
                    function (success) {
                        $('#custDeactivate')[0].reset();
                        $('#custDeactivateBtn').click();
                    }
            );
        }
    });
    
    //customer confirm delete (deactivate) account
    $('#custConfirmDeactivate').submit(function (event) {

        event.preventDefault();

        var customerInput = JSON.stringify({
            action: "confirmDeactivate"
        });

        post('/Nike_E-Commerce_System/FoCustDeactivate', customerInput,
                function (success) {
                    $('#custConfirmDeactivate').modal("hide");   
                    
                      Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Thank you for purchasing with us!',
                        text: success,
                        showConfirmButton: true,
                    }).then(function() {
                        window.location.href = "/Nike_E-Commerce_System/Views/FrontOffice/Fo.Home.jsp";
                    });
                }
        );
    });
    
});

