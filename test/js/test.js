var Comment = {
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
        comment.addEventListener('click', function(e) {
            e.preventDefault();
            var url = "../test/test.json";
            var xhr = Comment.createXMLHttpRequest(); 
            xhr.open("GET", url, true);
            xhr.onreadystatechange = function() {
                if(xhr.readyState == 4 && xhr.status == 200) {
                    var comment = xhr.responseText;
                    var commentShow = document.getElementById("commentShow");
                    var html = ""
                    for(var attr in comment) {
                        html += "<h2>" + attr + "</h2>" + "<p>" + comment[attr] + "</p>";
                    }
                    console.log(comment);
                    commentShow.innerHTML = html;
                }
            }
            xhr.send(null);
        });
    }
}