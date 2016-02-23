var App = {
    EventsArr : [],
    /*命名空间方法
    *@param ns {string}
    *@return object {object}
    */
    namespace : function(ns) {
        var parts = ns.split("."),
            object = this,
            i, len;

        for(i = 0, len = parts.length; i < len; i++) {
            if(!object[parts[i]]) {
                object[parts[i]] = {};
            }
            object = object[parts[i]];
        }

        return object;
    },
    /*绑定事件
    *@param objArr {object}
    */
    on : function(objArr) {
        if(document.addEventListener) {
            objArr.forEach(function(obj, index, arr) {
                [].forEach.call(obj['ele'],function(ele) {
                    ele.addEventListener(obj['type'], function(event){
                        obj['callback'](event, obj['parameter']);
                    }, false);
                });
            });
        }else if(document.attachEvent) {
            objArr.forEach(function(obj, index, arr) {
                [].forEach.call(obj['ele'],function(ele) {
                    ele.attachEvent('on' + obj['type'], function(event) {
                        obj['callback'](event, obj['parameter']);
                    });
                });
            });
        }
    },
    addEvent : function(eles, type, listener) {
        console.log(eles);
        [].forEach.call(eles, function(ele, index, arr) {
            ele.addEventListener(type, listener, false);
        });
    },
    only : function(obj) {
        var objarr = [];
        if(this.EventsArr.indexOf(obj) == -1) {
            objarr.push(obj)
            this.on(objarr);
        }
    },
    /*要绑定的事件列表
    *@param e {element}
    *@param t {type}
    *@param c {callback}
     */
    addToEventTable : function(e, t, c, p) {
        this.EventsArr.push({ele:e, type:t, callback:c, parameter : p || {}});
    },
    /*事件委托*/
    delegate : function(goal, event) {
        var fn = function(e, param) {
            if(e.target.tagName === goal.toUpperCase()) {
                
            }
        }.bind(event);
        return fn;
    },
    /*调用模板
    *@param templateName {string}
    *@return template {string}
    */
    templateCache : function(templateName) {
        return App.Template.Hash(Config.template, templateName);
    },
    render : function(strings) {
        var fragElement = document.createDocumentFragment(),
            fragElements = [];
        var parameter = Page[strings],
            html = "", div;
        for(var name in parameter) {
            fragElements[name] = document.createDocumentFragment();
            html = App.Template.Hash(Page[strings], name);
            div = document.createElement("div");
            div.innerHTML = html;
            fragElements[name].appendChild(div);
            fragElement.appendChild(fragElements[name]);
        }
        document.body.insertBefore(fragElement, document.body.firstElementChild);
    },
    /*启动函数
    *遍历所有有do方法的组件，并调用相应的do方法
    */
    start : function() {
        for(var attr in App) {
            if(App[attr].hasOwnProperty("do")) {
                console.log(App[attr]);
                App[attr].do();
            }
        }
        App.on(this.EventsArr);
    },
    ajax : function(method, url, sendData, callback) {
        var data;
        function createXHR(){
            var xhr;
            if(window.XMLHttpRequest) {
                xhr = new XMLHttpRequest()
            }else if(window.ActiveXObject) {
                xhr = new ActiveXObject();
            }
            return xhr;
        }
        var xhr = createXHR();
        xhr.onreadystatechange = function() {
            if(xhr.readyState === 4) {
                console.log(xhr.status);
                if(xhr.status === 200 || xhr.status === 304) {
                    data = JSON.parse(xhr.responseText);
                    callback(data);
                }else {
                    console.log(xhr.statusText);
                }
            }
        }
        xhr.onerror = function(e) {
            console.log(xhr.statusText);
            console.log("130");
        }
        xhr.onsuccess = function() {
            callback(data);
        }
        xhr.open(method, url, true);
        if(method.toUpperCase() === "GET") {
            xhr.send();
        }else {
            xhr.send(sendData);
        }
    }
};