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
    Request({
      method:'POST',
      url:"http://localhost:8080/rest/register",
      json: true,
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: {
				'username':'pineapple',
				'password':'tikrinam'
			}
    }, function(error,response,body){
      console.log("body:\n\n\n",body);
    });
    return res.send("done");
  }
}
