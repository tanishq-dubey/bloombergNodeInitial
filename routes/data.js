// usage: node HistoricalDataRequest.js [<host>]
var https = require('https');
var fs = require('fs');
var express = require('express');
var app = express();

var host = process.argv[2] || "http-api.openbloomberg.com";
var port = 443;

var jsonResponse = '';

app.get('/:data', function (req, res) {
  res.send(jsonResponse);
});

var server = app.listen(3000, function () {

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

        res.on('data', function(d) {
          jsonResponse += d;
          console.log(jsonResponse);
        });
    });

    req1.write(JSON.stringify( {
        "securities": [req.block.form.wordLead + " US Equity"],
        "fields": ["PX_LAST", "OPEN"],
        "startDate": "20080101",
        "endDate": "20120301",
        "periodicitySelection": "DAILY"
    }));
    req1.end();

    req1.on('error', function(e) {
        console.error(e);
});
});