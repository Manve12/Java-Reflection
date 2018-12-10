//Billing JS CONTROLLER
var Request = require("request");
var bodyParser = require("body-parser");

module.exports = {
  single: function(req,res)
  {
    Request({
      method:'POST',
      url:"http://localhost:8080/rest/billing/single",
      json: true,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: {
        'username':req.body.username
      }
    }, function(error,response,body){
      //TODO:mb - Add status code validation
    });
    return res.send("done");
  }
}
