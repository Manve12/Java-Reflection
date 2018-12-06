const express = require('express');
const router = express.Router();

//Controllers
var apiController = require("../Controllers/API");

router.get("/", (req,res) => {apiController.getAllData(res)});

module.exports = router;
