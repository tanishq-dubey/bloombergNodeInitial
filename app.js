var express = require('express');
var fs = require('fs');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var https = require('https');
var fs = require('fs');

//var routes = require('./routes/index');
//var users = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// uncomment after placing your favicon in /public
//app.use(favicon(__dirname + '/public/favicon.ico'));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

//app.use('/', routes);
//app.use('/users', users);

var jsonResponse = '';
app.get('/', function(req, res) {res.render('index')});
var host = process.argv[2] || "http-api.openbloomberg.com";
var port = 443;

app.get('/:data', function (req, res) {

//var server = app.listen(8080, function () {
    //console.log("securities: " , req.securities.toString());
    var options = {
        host: host,
        port: port,
        path: '/request?ns=blp&service=refdata&type=HistoricalDataRequest',
        method: 'POST',
        key: fs.readFileSync('hackillinois_spring_2015_035.key'),
        cert: fs.readFileSync('hackillinois_spring_2015_035.crt'),
        ca: fs.readFileSync('bloomberg.crt')
    };

    var req1 = https.request(options, function(res) {
        //console.log("statusCode: ", res.statusCode);
        //console.log("headers: ", res.headers);
        //console.log("params: ", req.securities);

        res.on('data', function(d) {
            jsonResponse += d;
            //console.log(jsonResponse);
        });
    });

    req1.write(JSON.stringify( {
        "securities": ["FB US Equity", "AAPL US Equity"],
        "fields": ["PX_LAST", "OPEN"],
        "startDate": "20130101",
        "endDate": "20140301",
        "periodicitySelection": "DAILY"
    }));
    req1.end();

    req1.on('error', function(e) {
        console.error(e);
    });
//});
    var data = jsonResponse;
    var parsedJson = JSON.parse(data);
    var pxLastString = "";
    //alert(data);
    for(i = 0; i <parsedJson.data[0].securityData.fieldData.length; i++){
        pxLastString += parsedJson.data[0].securityData.fieldData[i].PX_LAST + "\n";
    }
    var file = fs.createWriteStream('pxLastData.txt');
    //alert(pxLastString);
    file.write(pxLastString);
    require("child_process").exec('java -jar musicGen.jar').unref();
    console.log("Played Audio");
    res.send(jsonResponse);
});

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});


module.exports = app;
