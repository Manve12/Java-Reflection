const express = require('express');
const router = express.Router();

//Controllers
var billingController = require("../Controllers/Billing");

router.get("/single", (req,res) => {billingController.single(req,res)});

module.exports = router;
