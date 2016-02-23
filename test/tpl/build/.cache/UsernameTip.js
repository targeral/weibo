/*TMODJS:{"version":1,"md5":"9352ce76f4cf413d6237ccd6c53d8ce9"}*/
template('UsernameTip',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,content=$data.content,$out='';$out+='<span class="login-tip"><p>';
$out+=$escape(content);
$out+='</p><a class="login-tip-close">X</a></span>';
return new String($out);
});