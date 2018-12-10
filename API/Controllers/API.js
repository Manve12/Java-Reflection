//API JS CONTROLLER
var Request = require("request");
var bodyParser = require("body-parser");


function callback(res,body)
{
  res.cookie("body", body);
  return res.send("done");
}

module.exports = {
  login: function(req,res)
  {
    if (req.cookies.body == null){
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
      var loginBody = {};
      if (response.statusCode == 200)
      {
        loginBody = body.session.attributes.user;

      }
      callback(res,loginBody);
    });
  } else {
    res.redirect("/");
  }
  },
  logout: function(req,res)
  {
    res.clearCookie("body");
    return res.redirect("/login");
  },
  register: function(req,res)
  {
    if (req.cookies.body == null){
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
      ///FIXME: Fix the registrationBody
      var registrationBody = {};
      if (response.statusCode == 200)
      {
        registrationBody = body.session.attributes;
      }
      callback(res,registrationBody);
    });
  } else
  {
    res.redirect("/");
  }

  }
}
