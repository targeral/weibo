App.namespace("Blog");
App.Blog = {
    do : function(blogData) {
        //console.log(blogData);
        var blog = template("blog",blogData);
        var fragment = document.createDocumentFragment();
        var article = document.createElement("article");
        article.innerHTML = blog;
        fragment.appendChild(article);
        var blog = document.getElementById("blog");
        if(blog.firstElementChild) {
            blog.insertBefore(fragment, blog.firstElementChild);
        }
        blog.appendChild(fragment);
        App.addEvent(document.querySelectorAll("article[data-blog]"), 'click', this.Comment);
    },
    Comment : function(event){
        event.preventDefault();
        var clickEle = event.target;
        if(clickEle.tagName === "A" && clickEle.classList.contains("comment")) {
            var article = this;
            var PID = this.getAttribute("data-blogId");
            console.log(PID);
            if(clickEle.getAttribute("data-close") !== "true") {
                var ul = article.querySelector(".comment-data ul");
                var commentPlace = article.querySelector(".commentPlace");
                ul.innerHTML = "";
                commentPlace.classList.add("hidden");
                clickEle.setAttribute("data-close", "true");
            }else {
                App.ajax("GET", "showReply.do?postID="+PID,{}, function(data) {
                    //console.log(JSON.parse(data));
                    var data = JSON.parse(data);
                    var arr = [];
                    for(var index = data['ans'].length, len = data['ans'].length; index > 0; index --) {
                        
                        arr.push({username : data['ans'][index]['userName'], content : data['ans'][index]['instance']});
                    }
                    var html = template("comment", {comment : arr});
                    var fragment = document.createDocumentFragment();
                    var div = article.querySelector("div section.commentPlace") ? article.parentElement.querySelector("article div") : document.createElement("div");
                    div.innerHTML = html;
                    fragment.appendChild(div);
                    article.appendChild(fragment);
                    clickEle.setAttribute("data-close", "false");
                });
            }
        }else if(clickEle.tagName === "A" && clickEle.classList.contains("CommentPost")) {
            var article = this;
            var PID = this.getAttribute("data-blogId");
            var contentNode = event.target.parentElement.querySelector("input");
            var content = contentNode.value;
            App.ajax("post", "addReply.do", "nowpid=" + PID + "&instance=" + content, function(data) {
                if(data !== "fail") {
                    contentNode.value = "";
                    var fragment = document.createDocumentFragment();
                    var li = document.createElement("li"),
                    span = document.createElement("span"),
                    p = document.createElement("p"),
                    spanText = document.createTextNode(data),
                    pText = document.createTextNode(content);
                    span.appendChild(spanText);
                    span.classList.add("comment-user");
                    p.appendChild(pText);
                    p.classList.add("comment-content");
                    li.appendChild(span);
                    li.appendChild(p);
                    fragment.appendChild(li);
                    article.querySelector(".comment-data ul").appendChild(fragment);
                }
            });
        }else if(clickEle.tagName === "A" && clickEle.parentElement.classList.contains("username")) {
            var username = clickEle.textContent;
            //console.log(encodeURIComponent(username));
            window.location.href='personal.html?username=' +decodeURIComponent(username);
            /*App.ajax("GET", "showOtherPost.do?username=" + username,{}, function(data) {
                console.log(data);
                var data = JSON.parse(data);
                var blog = data["ans"];
                for(var index = 0, len = blog.length; index < len; index ++) {
                    console.log(blog[index].dataTime);
                    App.Blog.do({
                        "username" : "官方微博",
                        "data" : blog[index].dataTime,
                        "content" : blog[index].instance,
                        "img" : [],
                        "transmit": blog[index].resendNumber,
                        "comment":blog[index].replyNumber,
                        "good" : blog[index].zan,
                    });
                }
            });*/
        }
    },
    clickUser : function() {

    }
};