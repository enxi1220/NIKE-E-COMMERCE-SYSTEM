//    Document   : Fo.Header
//    Created on : Feb 20, 2022, 9:50:23 PM
//    Author     : vinnie chin

//call servlet to check if customer has log in
function customerLoginOrNot(url, func){
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/FoCustLoginOrNot",
        //already login can continue access
        success: function(success){
            if(func){
               func();
            }else{
               window.location.href = url
            }
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: error.responseText
                
            }).then(function() {
                 window.location.href = "/Nike_E-Commerce_System/Views/FrontOffice/Fo.CustRegLog.jsp?url="+url;
            });
        }
    });
}

// elements that has this class will be checked login or not
$('.need-login').click(function(event) {
    var url = "";
    event.preventDefault();
    url = $(this).attr('href');
    customerLoginOrNot(url);
   
});

// pass current url as param to the login page
$('.login-link').click(function() {
    url = window.location.href;
    $(this).attr('href', $(this).attr('href')+"?url="+url);
});

//call servlet to remove attributes set when customer log out
$('#custConfirmLogOut').submit(function(e) {
    e.preventDefault();
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/FoCustLogOut",
        success: function (success) {
            Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Byeee ',
                text: success,
                showConfirmButton: false,
            });
            
            $('#logOut-modal').modal("hide");

            setTimeout(function () {
                window.location.href = "/Nike_E-Commerce_System/Views/FrontOffice/Fo.Home.jsp";
            }, 1900);
        }
    });
});

//the starting of almost all error msg are the same
function append(field) {
    return "Please fill in " + field;
}

// call the pop up error prompt
function errorPrompt(errors) {
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: errors
    });
}

//validation for number input only
function validateAlpha(event) {
    const pattern = /^[0-9\s-]$/;
    if (pattern.test(event.key) == false) {
        errorPrompt("Please fill in numbers only");
    }
}



