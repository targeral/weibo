/*TMODJS:{"version":14,"md5":"864e0328f68904b82fb280a0366f8c8d"}*/
template('home/home-header',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,username=$data.username,$out='';$out+='<header id="home-header"> <div class="header-h"><h1>微博</h1></div> <div class="header-nav w73"> <div class="search"> <label class="home-search"> <input type="text" placeholder="搜索微博、找人"> <a href="#">搜索</a> </label> </div> <nav> <ul> <li><span class="icon-home">E</span><a href="home.html">首页</a></li><li><span class="icon-find">F</span><a href="#">发现</a></li><li><span class="icon-game">G</span><a href="#">游戏</a></li><li><span class="icon-user">H</span><a href="#">';
$out+=$escape(username);
$out+='</a></li> </ul> </nav> </div> <div class="other-fn"> <section class="line"> <a href="" class="icon-mes">I</a> <ul style="display:none"> <li><a href="#">@我的</a></li> <li><a href="#">评论</a></li> <li><a href="#">赞</a></li> </ul> <ul style="display:none"> <li><a href="#">私信</a></li> <li><a href="#">未关注人私信</a></li> <li><a href="#">群通知</a></li> </ul> <a href="#" style="display:none">消息设置</a> </section> <section> <a href="#" class="set">退出</a> </section> <a href="#" title="试一下键盘N键" class="icon-write">ß</a> </div> </header>';
return new String($out);
});