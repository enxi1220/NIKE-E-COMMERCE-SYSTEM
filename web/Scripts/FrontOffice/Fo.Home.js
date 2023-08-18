//    Document   : Fo.Home.js
//    Created on : Feb 20, 2022, 9:50:23 PM
//    Author     : vinnie chin

//--------------------------- Product Slider ---------------------------
$(document).ready(function () {

    $("nav").removeClass("bg-primary");

    
    $(window).scroll(function () {

        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            $("nav").addClass("bg-primary");

        } else {
            $("nav").removeClass("bg-primary");
        }

    });
    
    //slideshow plugin function for best selling products
    $('#bestSales').owlCarousel({
        
        loop: true,
        margin: 10,
        navText: false,
        autoplay: true,
        autoplayTimeout: 2500,
        autoplayHoverPause: true,
        responsiveClass: true,
        responsive: {
            0: {
                items: 1,
                nav: true
            },
            600: {
                items: 2,
                nav: false
            },
            1000: {
                items: 4,
                nav: true
            }
        }
    });

    //slideshow plugin function for latest added products
    $('#latest-collection').owlCarousel({
        loop: true,
        margin: 19,
        nav: true,
        navText: ['<div class="carousel-btn prev-slide d-flex align-items-center"><i class="fa fa-angle-left"></i></div>', '<div class="carousel-btn next-slide d-flex align-items-center justify-content-end"><i class="fa fa-angle-right"></i></div>'],
        autoplay: true,
        autoplayTimeout: 3100,
        autoplayHoverPause: true,
        responsive: {
            0: {
                items: 1
            },
            600: {
                items: 2
            },
            1000: {
                items: 3
            }
        }
    });

    //slideshow plugin function for featured products
    $('#featured').owlCarousel({
        loop: true,
        margin: 38,
        nav: true,
        navText: ['<div class="carousel-btn prev-slide d-flex align-items-center"><i class="fa fa-angle-left"></i></div>', '<div class="carousel-btn next-slide d-flex align-items-center justify-content-end"><i class="fa fa-angle-right"></i></div>'],
        autoplay: true,
        autoplayTimeout: 3100,
        autoplayHoverPause: true,
        responsive: {
            0: {
                items: 1
            },
            600: {
                items: 2
            },
            1000: {
                items: 2
            }
        }
    });
});



