App.ajax("GET", "showBa.do" ,{}, function(data) {
    var data = JSON.parse(data);
    //console.log(data["ans"]);
    App.User.do({
        "username" : data["ans"].userName,
        "attend" : data["ans"].attentNumber,
        "friend": data["ans"].attentedNumber,
        "contentNum":data["ans"].postNumber
    });

    /*加载模板*/
    App.render("home");
    App.addEvent(document.querySelectorAll(".set"), 'click', function(event) {
        event.preventDefault();
        //console.log("D");
        App.ajax("GET", "logoff.do", {}, function() {
            window.location.href = "index.html";
        });
    });
    App.Textarea.on();
    App.ajax("GET", "addPost.do",{}, function(data) {
        var data = JSON.parse(data);
        console.log(data);
        var blog = data["ans"];
        for(var index = blog.length-1, len = blog.length; index > 0; index --) {
        //console.log(blog[index].dataTime);
            App.Blog.do({
                "username" : blog[index].userName,
                "data" : blog[index].dataTime,
                "content" : blog[index].instance,
                "img" : [],
                "transmit": blog[index].resendNumber,
                "comment":blog[index].replyNumber,
                "good" : blog[index].zan,
                "PostId" :blog[index].postID
            });
        }
    });
});
/*App.ajax("GET", "test.json", {}, function(data) {
    App.Blog.do(data);
});
*/
