//Billing JS CONTROLLER
var Request = require("request");
var bodyParser = require("body-parser");

function callback(res,message)
{
  return res.send(message);
}

module.exports = {
  single: function(req,res)
  {
    Request({
      method:'POST',
      url:"http://localhost:8080/rest/billing/all",
      json: true,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: {}
    }, function(error,response,body){
      //TODO:mb - Add status code validation
      callback(res,body);
    });
  },
  all: function(req,res)
  {
    console.dir(req.cookies["body"]);
    Request({
      method:'POST',
      url:"http://localhost:8080/rest/billing/all",
      json: true,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: req.cookies["body"]
    }, function(error,response,body){
      //TODO:mb - Add status code validation
      callback(res,body);
    });
  }
}
