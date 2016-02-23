/*TMODJS:{"version":2,"md5":"f676694fd2410062e0e09ba8997169a3"}*/
template('tip',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,content=$data.content,$out='';$out+='<span class="login-tip" data-template><p>';
$out+=$escape(content);
$out+='</p><a class="login-tip-close">X</a></span>';
return new String($out);
});