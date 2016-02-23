/*加载模板*/
App.render("index");
/*事件绑定*/
App.Login.on();
/*数据加载*/
App.ajax("GET", "test.json", {}, function(data) {
    App.Blog.do(JSON.parse(data));
});
App.ajax("GET", "showOtherPost.do?username=admin",{}, function(data) {
    console.log(data);
    var data = JSON.parse(data);
    var blog = data["ans"];
    for(var index = blog.length-1, len = blog.length; index < 0; index --) {
        console.log(blog[index].dataTime);
        App.Blog.do({
            "username" : blog[index].userName,
            "data" : blog[index].dataTime,
            "content" : blog[index].instance,
            "img" : [],
            "transmit": blog[index].resendNumber,
            "comment":blog[index].replyNumber,
            "good" : blog[index].zan,
        });
    }
});

/*{
    "username" : "八哥专用",
    "data" : "2015",
    "content" : "haha",
    "img" : [{"url" : "images/user/test.jpg"}],
    "transmit" : 12313,
    "comment" : 123,
    "good" : 1
}*/