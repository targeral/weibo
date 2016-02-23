App.namespace("Blog");
App.Blog = {
    do : function(blogData) {
        console.log(blogData);
        var blog = template("blog",blogData);
        var fragment = document.createDocumentFragment();
        var article = document.createElement("article");
        article.innerHTML = blog;
        fragment.appendChild(article);
        var blog = document.getElementById("blog");
        blog.appendChild(fragment);
        article.onload = function() {
            //console.log("dasfd");
            this.Comment.do();
        }
    },
    Comment : {
        createXMLHttpRequest : function() {
            var xhr;
            if(window.XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            }else if(window.ActiveXObject) {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xhr;
        },
        do : function() {
            var comment = document.getElementById("comment");
            var self = this;
            console.log(self);
            comment.addEventListener('click', function(e) {
                e.preventDefault();
                var url = "../test/test.json";
                var xhr = self.createXMLHttpRequest(); 
                xhr.open("GET", url, true);
                xhr.onreadystatechange = function() {
                    if(xhr.readyState == 4 && xhr.status == 200) {
                        var comment = xhr.responseText;
                        console.log(comment);
                        var commentShow = document.getElementById("commentShow");
                        var html = ""
                        for(var attr in comment) {
                            console.log(attr + " " + comment[attr])
                        }
                        console.log(comment);
                        commentShow.innerHTML = html;
                    }
                }
                xhr.send(null);
            });
        }
    }
};