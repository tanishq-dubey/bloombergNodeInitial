var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* GET Hello World page. */
router.get('/helloworld', function(req, res) {
    res.render('helloworld', { title: 'Spare Change' });
});

/*GET home page*/
router.get('/spare_change', function(req, res) {
    res.render('spare_change', { title: 'Spare Change' });
});

module.exports = router;
