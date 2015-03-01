var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Spare Change' });
});

router.get('/data', function(req, res, next) {
    res.render('index', { title: 'Spare Change' });
});

module.exports = router;
