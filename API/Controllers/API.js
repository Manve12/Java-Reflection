//API JS CONTROLLER
var Request = require("request");
var bodyParser = require("body-parser");

module.exports = {
  login: function(req,res)
  {
    Request({
      method:'POST',
      url:"http://localhost:8080/rest/login",
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
      //TODO:mb - Add status code validation
    });
    return res.send("done");
  },
  logout: function(req,res)
  {
    //TODO:mb - Add ability to logout
    return res.send("done");
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
      //TODO:mb - Add status code validation
    });
    return res.send("done");
  }
}
