
//datatable
$(document).ready(function () {

    $('#table-user-summary').DataTable(

            );

});

//deactivate and activate
function bouserActivate(username) {
    $('#user-activate').modal('show');
}

function bouserDeactivate(username) {
    $('#user-deactivate').modal('show');
}

//access
function checkAccess(action) {
  $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": action},
        success: function (data) {

        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Access restricted."
            }).then(function () {
                location.reload();
            });
        }
    });
}
//deactivate (access)
function bouserDeactivate(username) {
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "Deactivate"},
        success: function (data) {
            $('#user-deactivate').modal('show');
            $('#user-deactivate-btn').click(function () {
                $('#user-deactivate').modal('hide');
                var userInput = JSON.stringify({
                    username: username
                });

                post('/Nike_E-Commerce_System/BoUserDeactivate',
                        userInput,
                        function (success) {
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: 'Successful',
                                text: success,
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
            });
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Access restricted."
            }).then(function () {
                location.reload();
            });
        }
    });
}

//activate (access)
function bouserActivate(username) {
    $.ajax({
        type: "GET",
        url: "/Nike_E-Commerce_System/CheckAccess",
        data: {"pageName": "Activate"},
        success: function (data) {
            $('#user-activate').modal('show');
            $('#user-activate-btn').click(function () {
                $('#user-activate').modal('hide');
                var userInput = JSON.stringify({
                    username: username
                });

                post('/Nike_E-Commerce_System/BoUserActivate',
                        userInput,
                        function (success) {
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: 'Successful',
                                text: success,
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
            });
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "Access restricted."
            }).then(function () {
                location.reload();
            });
        }
    });
}


//reset password
$(document).ready(function () {

    //user reset pass
    $('#userResetNewPassForm').submit(function (event) {

        event.preventDefault();
        var username = new URLSearchParams(window.location.search).get('username');

        console.log(username);
        console.log($('#userResetNewPass').val());
        console.log($('#userConfirmResetNewPass').val());


        if ($('#userResetNewPass').val() != $('#userConfirmResetNewPass').val()) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: "New Password And Confirm Password Not Match"
            });

        } else {
            var userInput = JSON.stringify({
                username: username,
                newPass: $('#userResetNewPass').val()
            });

            post('/Nike_E-Commerce_System/BoUserEditPass', userInput,
                    function (success) {
                        $('#userChangeNewPass');
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Successful!',
                            text: success,
                            showConfirmButton: false,
                            timer: 1900
                        });

                        setTimeout(function () {
                            window.location.href = "/Nike_E-Commerce_System/Views/BackOffice/User/Bo.UserSummary.jsp";
                        }, 1900);
                    }
            );
        }


    });
    //end of user change pass
});


//login
$(document).ready(function () {

    //user login form js
    $('#userLogin').submit(function (event) {

        event.preventDefault();

        var userInput = JSON.stringify({
            username: $('#userLoginName').val(),
            password: $('#userLoginPassword').val()
        });

        post('/Nike_E-Commerce_System/BoUserLogin', userInput,
                function (success) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Hello!',
                        text: success,
                        showConfirmButton: false,
                        timer: 1900
                    });

                    setTimeout(function () {
                        window.location.href = "/Nike_E-Commerce_System/Views/BackOffice/Bo.Dashboard.jsp";
                    }, 1900);
                }
        );
    });

    //user logout
    $('#userConfirmLogout').submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: "/Nike_E-Commerce_System/BoUserLogout",
            success: function (success) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Bye ',
                    text: success,
                    showConfirmButton: false,
                });

                setTimeout(function () {
                    window.location.href = "/Nike_E-Commerce_System/Views/BackOffice/Bo.Login.jsp";
                }, 1900);
            }
        });
    });




});


function bouserLogout() {
    $('#user-logout').modal('show');
}

