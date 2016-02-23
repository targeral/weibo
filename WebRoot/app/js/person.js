(function() {
    var search = window.location.search;
    var username = search.substr(search.indexOf("=")+1);

    App.ajax("GET", "showBa.do",{}, function(data) {
        var data = JSON.parse(data);
        console.log(data["ans"]);
        App.User.do({
            "username" : username,
            "attend" : data["ans"].attentNumber,
            "friend": data["ans"].attentedNumber,
            "contentNum":data["ans"].postNumber
        });
        App.User.doUser({
            "username" : data['ans'].userName
        });
        /*加载模板*/
        App.render("person");
        var user = document.querySelector("section.header h2").textContent;
        App.ajax("GET", "showOtherPost.do?username="+username,{}, function(data) {
            console.log(data);
            var data = JSON.parse(data);
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
                });
            }
        });
        App.ajax("GET", "checkAttent.do?attend=" + username, {}, function(data) {
            if(data === "true") {
                document.querySelector(".attend").classList.add("hidden");
            }
        })
    });


})();