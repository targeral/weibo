/*TMODJS:{"version":26,"md5":"a8477dd86f0d9b20f3fe0b3722e12e12"}*/
template('blog',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,PostId=$data.PostId,username=$data.username,data=$data.data,content=$data.content,img=$data.img,$each=$utils.$each,value=$data.value,i=$data.i,transmit=$data.transmit,comment=$data.comment,good=$data.good,$out='';$out+='<article data-blog data-blogid=';
$out+=$escape(PostId);
$out+='> <header class="blog-header"> <div class="headImg"><img src="images/user1.jpg" alt=""></div> <section class="usrMsg"> <div class="username"><a href="">';
$out+=$escape(username);
$out+='</a></div> <div class="message"><time>';
$out+=$escape(data);
$out+='</time>来自<address><p>微博 weibo.com</p></address></div> </section> </header> <section class="blog-content"> <p>';
$out+=$escape(content);
$out+='</p> </section> <section class="blog-media"> ';
if(img){
$out+=' ';
$each(img,function(value,i){
$out+=' <img src=';
$out+=$escape(value.url);
$out+=' alt=""> ';
});
$out+=' ';
}
$out+=' </section> <nav> <ul class="blog-nav"> <li class="line"><a href="#">收藏</a></li><li class="line"><a href="#">转发';
$out+=$escape(transmit);
$out+='</a></li><li class="line"><a href="#" class="comment" data-close="true">评论';
$out+=$escape(comment);
$out+='</a></li><li><a href="#">赞';
$out+=$escape(good);
$out+='</a></li> </ul> </nav> </article> ';
return new String($out);
});