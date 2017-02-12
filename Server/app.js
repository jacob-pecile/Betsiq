var express = require('express');
var app = express();
var rest = require('./restFunctions.js');

var  bodyParser = require('body-parser'); // Middleware to read POST data

// Set up body-parser.
// To parse JSON:
app.use(bodyParser.json());
// To parse form data:
app.use(bodyParser.urlencoded({
  extended: true
}));

// respond with "hello world" when a GET request is made to the homepage
app.get('/', function (req, res) {
  res.send('hello world')
});

app.post('/signup', rest.CreateUser);

app.post('/login', rest.LoginUser);

app.get('/songs', rest.GetTopSong);

app.get('/songs/:userid', rest.GetUserSongs);

app.post('/songs/:userid', rest.AddUserSongs)

app.post('/users/:groupid', rest.JoinGroup)

app.listen(3000, function () {
  console.log('Example app listening on port 3000!')
});