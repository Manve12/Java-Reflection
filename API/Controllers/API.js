//API JS CONTROLLER
var Request = require("request");
var bodyParser = require("body-parser");

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
				'username':req.body.username,
				'password':req.body.password
			}
    }, function(error,response,body){
      if (response.statusCode != 409){
        console.log("body:\n\n\n",body);
        console.log(response.statusCode);
      } else {
        console.log(response.statusCode);
      }
    });
    return res.send("done");
  }
}
