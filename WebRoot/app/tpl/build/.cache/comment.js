/*TMODJS:{"version":6,"md5":"7630e2fb11cda408cedf6b16a375efce"}*/
template('comment',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,comment=$data.comment,value=$data.value,i=$data.i,$escape=$utils.$escape,$out='';$out+='<section class="commentPlace"> <section class="comment-textarea"> <label for=""><input type="text"></label> <a href="#" class="CommentPost">评论</a> </section> <section class="comment-data"> <ul> ';
$each(comment,function(value,i){
$out+=' <li><span class="comment-user">';
$out+=$escape(value.username);
$out+='</span>:<p class="comment-content">';
$out+=$escape(value.content);
$out+='</p></li> ';
});
$out+=' </ul> </section> </section>';
return new String($out);
});