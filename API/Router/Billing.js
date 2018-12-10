const express = require('express');
const router = express.Router();

//Controllers
var billingController = require("../Controllers/Billing");

router.post("/single", (req,res) => {billingController.single(req,res)});
router.post("/all", (req,res) => {billingController.all(req,res)});

module.exports = router;
