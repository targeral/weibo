App.namespace("Textarea");
App.Textarea = {
    event : {
        BlogPost : function(event) {
            console.log("DDDDD");
            var content = document.getElementById("postContent").value;
            var posting = document.getElementById("posting");
            console.log(posting);
            posting.classList.toggle("show");
            App.Textarea.logic.post(content, posting);
        },
        limitWord : function(event) {
            var ele = event.target;
            var blogTextarea = this;
            if(ele.tagName === "TEXTAREA") {
                var content = event.target.value;
                var obj = App.Textarea.logic.limitWord(140,content);
                event.target.value = obj['content'];
                blogTextarea.querySelector(".wordNum").textContent = obj['wordNum'];
            }
        }
    },
    logic : {
        post : function(content, posting) {
            App.ajax("post", "addPost.do", "instance=" + content, function(data) {
                if(data !== "fail") {
                    var blog = JSON.parse(data);
                    App.Blog.do({
                        "username" : blog['username'],
                        "data" : new Date(),
                        "content" : content,
                        "img" : [],
                        "transmit": 0,
                        "comment":0,
                        "good" : 0,
                        "PostId" : blog['postId']
                    });
                    posting.classList.toggle("show");
                    document.getElementById("postContent").value = "";
                }else {
                    console.log("F");
                }
            });
        },
        limitWord : function(num, content) {
            console.log(content.length);
            if(content.length <= num) {
                return {
                    wordNum : num - content.length,
                    content : content
                };
            }
            return {
                wordNum : 0,
                content : content.substr(0, num)
            };
        }
    },
    on : function() {
        App.addEvent(document.getElementsByClassName("textarea-btn"),'click', App.Textarea.event.BlogPost);
        App.addEvent(document.querySelectorAll(".blog-textarea"), 'keyup', App.Textarea.event.limitWord);
    }
};