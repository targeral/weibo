App.namespace("User");
App.User = {
    Userdata : {},
    data : {},
    doUser : function(Userdata) {
        this.Userdata = Userdata;
    },
    do : function(data) {
        this.data = data;
    }
};