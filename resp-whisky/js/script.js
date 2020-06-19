
var _containerMenu = $('[data-container="menu"]');

$(window).scroll(function(){
  if($ (this).scrollTop() > 70){
    _containerMenu.fadeIn(500);
    _containerMenu.addClass('menu-fixo')
  } else {
    _containerMenu.fadeOut(0);
    _containerMenu.removeClass('menu-fixo')
  }
});
