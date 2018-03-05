$(function(){
    var wwww = $(window).width(),
        hhhh = $(window).height();
    $("body").css({
        "width":wwww,
        "height":hhhh,
        "overflow":"hidden"
    });
    Resize = function(){
        wwww = $(window).width();//这里用Jquery  
        if(wwww<=1000){
            $("body").css({
                "overflow":"auto"
            });
        }     
    };
});