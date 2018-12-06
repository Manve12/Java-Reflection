//API JS CONTROLLER
var Request = require("request");

module.exports = {
  login: function(req,res)
  {
    Request.get("http://localhost:8080/rest/login", function(err,response,body){
      if (err){
        return console.dir(err);
      }
      console.log(body);
    });
  },
  logout: function(req,res)
  {
    return res.send("Loaded logout");
  },
  register: function(req,res)
  {
    return res.send("Loaded register");
  }
}
