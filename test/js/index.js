/*加载模板*/
App.render("index");
/*事件绑定*/
App.Login.on();
/*数据加载*/
App.ajax("GET", "test.json", {}, function(data) {
    App.Blog.do(data);
});