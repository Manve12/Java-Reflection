const express = require('express');
const router = express.Router();

//Controllers
var apiController = require("../Controllers/API");

router.get("/login", (req,res) => {apiController.login(req,res)});
router.get("/logout", (req,res) => {apiController.logout(req,res)});
router.get("/register", (req,res) => {apiController.register(req,res)});

module.exports = router;
