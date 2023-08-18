//    Document   : shared.js
//    Created on : Apr 9, 2022, 2:28:38 AM
//    Author     : vinnie chin

function submitData(name, value) {
    return {
        name: name,
        value: value
    };
}

//ajax post written in function for multipart form data
function postMultipart(servlet, dataArr, successHandler, errorHandler) {
    var form = new FormData();
    for (let item of dataArr) {
        form.append(item.name, item.value);
    }

    $.ajax({
        type: 'POST',
        url: servlet,
        data: form,
        enctype: 'multipart/form-data',
        cache: false,
        contentType: false,
        processData: false,
        success: function (success) {
            if (successHandler) {
                successHandler(success);
            } else {
                Swal.fire({
                    icon: 'success',
                    title: 'Successful!',
                    text: success,
                });
            }
        },
        error:
                function (error) {
                    if (errorHandler) {
                        errorHandler(error);
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Oops...',
                            text: error.responseText
                        });
                    }
                }

    });
}

//ajax post written in function for normal form data
function post(servlet, postData, successHandler, errorHandler) {
    $.ajax({
        type: 'POST',
        url: servlet,
        data: postData,
        cache: false,
        contentType: false,
        processData: false,
        success: function (success) {
            if (successHandler) {
                successHandler(success);
            } else {
                Swal.fire({
                    icon: 'success',
                    title: 'Successful!',
                    text: success,
                });
            }
        },
        error: function (error) {
            if (errorHandler) {
                //user-defined error version
                errorHandler(error);
            } else {
                //default error version
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: error.responseText
                });
            }
        }
    });
}

