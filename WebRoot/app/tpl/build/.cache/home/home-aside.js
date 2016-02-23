/*TMODJS:{"version":5,"md5":"b56414a5255435862dd0ae102cc9a6aa"}*/
template('home/home-aside',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,username=$data.username,attend=$data.attend,friend=$data.friend,contentNum=$data.contentNum,$out='';$out+='<aside id="home-aside"> <section class="user"> <header> <div class="head-sculpture"> <a href=""><img src="" alt=""></a> </div> <a href="#" class="username">';
$out+=$escape(username);
$out+='</a> </header> <ul class="user-data"> <li><a href="personal.html">';
$out+=$escape(attend);
$out+='</a><span>关注</span></li> <li><a href="">';
$out+=$escape(friend);
$out+='</a><span>粉丝</span></li> <li><a href="">';
$out+=$escape(contentNum);
$out+='</a><span>微博</span></li> </ul> </section> <section class="follow"></section> </aside>';
return new String($out);
});