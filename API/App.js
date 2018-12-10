const express = require('express');
const bodyParser = require("body-parser");
const path = require('path');
const app = express();
const port = 8081;

var cookieParser = require("cookie-parser");
app.use(cookieParser());

const apiRoutes = require("./Router/API");
const billingRoutes = require("./Router/Billing");
app.use(function(req,res,next){
  next();
});

app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
}));

app.use("/register", function(req,res){
  if (!(req.cookies.length > 0)){
    res.sendFile(path.join(__dirname+'/Views/register.html'));
  }
});

app.use("/login", function(req,res){
  if (!(req.cookies.length > 0)){
    res.sendFile(path.join(__dirname+'/Views/login.html'));
  }
});

app.use("/billing", function(req,res){
  if (!(req.cookies.length > 0)){
    res.sendFile(path.join(__dirname+'/Views/billing.html'));
  }
});

app.use("/api", apiRoutes);
app.use("/api/billing", billingRoutes);

app.listen(port, () => console.log(`Example app listening on port ${port}!`));
