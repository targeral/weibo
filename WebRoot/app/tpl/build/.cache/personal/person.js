/*TMODJS:{"version":6,"md5":"c1ffbc78d9cd6e09acc341eed256af7b"}*/
template('personal/person',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,username=$data.username,attend=$data.attend,friend=$data.friend,contentNum=$data.contentNum,$out='';$out+='<section id="person" class="container"> <header> <section class="header"> <div class="head-sculpture"><img src="" alt=""></div> <h2>';
$out+=$escape(username);
$out+='</h2> <p>一句话介绍下自己吧,让别人更了解你</p> <a href="#" class="attend">关注</a> </section> <nav> <ul> <li><a href="" class="focus">我的主页</a></li> <li><a href="">我的相册</a></li> <li><a href="">管理中心</a></li> </ul> </nav> </header> <section class="content"> <section class="person-data"> <nav> <ul class="user-data"> <li><a href="">';
$out+=$escape(attend);
$out+='</a><span>关注</span></li> <li><a href="">';
$out+=$escape(friend);
$out+='</a><span>粉丝</span></li> <li><a href="">';
$out+=$escape(contentNum);
$out+='</a><span>微博</span></li> </ul> </nav> <section class="person-pic"> <a href="#">相册</a> <section class="pic"> </section> <a href="#">查看更多<span></span></a> </section> </section> <section class="person-blog"> <nav class="blog-top-nav"> <ul><li><a href="#" class="triangle">全部</a></li><li><a href="#">原创</a></li><li><a href="#">图片</a></li><li><a href="#">视频</a></li><li><a href="#">音乐</a></li> </ul> </nav> <main id="blog"> </main> </section> </section> </section>';
return new String($out);
});