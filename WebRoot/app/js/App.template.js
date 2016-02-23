/*模板组件*/
App.namespace("Template");

App.Template = {
    hash : {},/*存储模板的hash表*/
    Hash : function(jsonName, key) {
        this.addHash(jsonName, key);
        return this.hash[key];
    },
    addHash : function(jsonName, hashString) {
        if(!this.hash[hashString]) {
            this.hash[hashString] = this.makeTemplate(jsonName, hashString);
        }
    },
    makeTemplate : function(jsonName, key) {
        //console.log(key);
        var url = jsonName[key].url;
        var data = jsonName[key].params;
        if(typeof data === "string") {
            var parts = data.split("."),
            object = App,
            i, len;
            for(i = 0, len = parts.length; i < len; i++) {
                if(!object[parts[i]]) {
                    object[parts[i]] = {};
                }
                //console.log(object);
                object = object[parts[i]];
            }
            data = object;
        }
        console.log(data);
        return template(url, data);
    }
}

