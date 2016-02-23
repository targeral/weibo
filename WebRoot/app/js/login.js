App.namespace("Login");
App.namespace("Login.event");
App.namespace("Login.logic");
/*Login组件的事件处理程序*/
App.Login.event = {
    tipShow : false,
    tipParameter : {removeNode : document.querySelector("[data-template]")},
    loginTitleChange : function(event) {
        console.log("here");
        App.Login.logic.loginTitleChange(event.target);
    },
    loginBtnClick : function(event) {
        var input = App.Login.logic.TipShow();
        console.log(input);
        if(input !== null) {
            event.preventDefault();
            App.Login.event.tipShow = true;
            input.focus();
            App.Login.logic.addClass(input.parentElement, "focus");
            App.only({
                ele : document.querySelectorAll(".login-tip-close"),
                type: 'click',
                callback: App.Login.event.tipCloseClick,
                parameter: {removeNode : document.querySelector("[data-template]")}
            });
        }
    },
    tipCloseClick : function(event, parameter) {
        console.log("here");
        console.log(parameter);
        App.Login.logic.TipDisappear(parameter);
    },
    InputFocus : function(event) {
        /*if(App.Login.event.tipShow) {
            App.Login.event.tipShow = false;
            console.log(App.Login.event.tipParameter);
            App.Login.logic.TipDisappear(App.Login.event.tipParameter);
        }*/
        App.Login.logic.addClass(event.target.parentElement, "focus");
    },
    InputBlur : function(event) {
        App.Login.logic.removeClass(event.target.parentElement, "focus");
    }
};
/*Login组件的逻辑应用
* @辅助函数有$前缀
*/
App.Login.logic = {
    loginTitleChange : function(target) {
        var loginHeader = document.querySelector(".login-header");
        var current = target;
        var currentDataModel = loginHeader.getAttribute(Config.Login.data_model);
        var clickDataModel = current.getAttribute(Config.Login.data_msg);
        if(current.tagName == Config.Login.currentTargetTagName && currentDataModel != clickDataModel) {
            var p = current.parentElement;
            var nextNode = p[p.previousElementSibling != null ? "previousElementSibling" : "nextElementSibling"].querySelector(Config.Login.currentTargetTagName.toLowerCase());
            currentDataModel = currentDataModel != Config.Login.dataModel_Message ? Config.Login.dataModel_Message : Config.Login.dataModel_Default;
            current.classList.toggle(Config.Login.CSS_Class_focus);
            nextNode.classList.toggle(Config.Login.CSS_Class_focus);
            loginHeader.setAttribute("data-model", currentDataModel);
        }
    },
    /*提示框出现*/
    TipShow : function() {
        var model = document.querySelector(".login-header").getAttribute(Config.Login.data_model);
        var inputs = document.querySelectorAll("." + model + "-login input");
        var focusInput;
        if(model == Config.Login.dataModel_Default) {
            focusInput = this.$tipShow(inputs[0].value === '' ? inputs[0] : inputs[1].value === '' ? inputs[1] : null);
        }else if(model == Config.Login.dataModel_Message) {
            focusInput = this.$tipShow(inputs[0].value === '' ? inputs[0] : null);
        }
        return focusInput;
    },
    $tipShow : function(show) {
        if(show === null) return null;
        var Fragment = document.createDocumentFragment(),
            span = document.createElement("span"),
            html = show["type"] == "text" ? App.templateCache("UsernameTip") : show["type"] == "password" ? App.templateCache("PasswordTip") : App.templateCache("TelephoneTip");
        span.innerHTML = html;
        Fragment.appendChild(span);
        show.parentElement.appendChild(Fragment);
        return show;
    },
    /*给一个元素添加className*/
    addClass : function(ele, className) {
        ele.classList.add(className);
    },
    /*给一个元素移除className*/
    removeClass : function(ele, className) {
        ele.classList.remove(className);
    },
    /*提示框消失*/
    TipDisappear : function(param) {
        console.log(param);
        var rmNode = param["removeNode"];
        rmNode.parentNode.removeChild(rmNode);
    }
};

App.Login.on = function() {
    console.log("d");
    App.addEvent(document.querySelectorAll(".login-nav"), 'click', App.Login.event.loginTitleChange);
    App.addEvent(document.querySelectorAll(".login-footer input[type=submit]"), 'click', App.Login.event.loginBtnClick);
    App.addEvent(document.querySelectorAll(".login-content > label > input"), 'focus', App.Login.event.InputFocus);
    App.addEvent(document.querySelectorAll(".login-content > label > input"), 'blur', App.Login.event.InputBlur);
}
App.Login.eventTable = {
    loginTitleChange : function() {
        App.addToEventTable(document.querySelectorAll(".login-nav"), 'click', App.Login.event.loginTitleChange);
        App.addToEventTable(document.querySelectorAll(".login-footer input[type=submit]"), 'click', App.Login.event.loginBtnClick);
        App.addToEventTable(document.querySelectorAll(".login-content > label > input"), 'focus', App.Login.event.InputFocus);
        App.addToEventTable(document.querySelectorAll(".login-content > label > input"), 'blur', App.Login.event.InputBlur);
    }
}

App.Login.do = function() {
    var E = App.Login.eventTable;
    for(var attr in E) {
        if(E.hasOwnProperty(attr)) {
            E[attr]();
        }
    }
};
