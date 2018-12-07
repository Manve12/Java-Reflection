const express = require('express');
const path = require('path');
const app = express();
const port = 8081;

const apiRoutes = require("./Router/API");
app.use(function(req,res,next){
  next();
});

app.use("/register", function(req,res){
  res.sendFile(path.join(__dirname+'/Views/register.html'));
});
app.use("/api", apiRoutes);

app.listen(port, () => console.log(`Example app listening on port ${port}!`));
