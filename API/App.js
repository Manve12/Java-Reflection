const express = require('express');
const app = express();
const port = 8081;

const apiRoutes = require("./Router/API");
app.use(function(req,res,next){
  next();
});

app.use("/api", apiRoutes);

app.listen(port, () => console.log(`Example app listening on port ${port}!`));
