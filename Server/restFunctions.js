//Our Database using nedb
var Datastore = require('nedb');
var db = new Datastore({
  filename: 'betsiq.db', // provide a path to the database file 
  autoload: true, // automatically load the database
  timestampData: true // automatically add and manage the fields createdAt and updatedAt
});

//RESTful functions go here
module.exports = {
  CreateUser: function (req, res) {
  	console.log("made it!!!");
    console.log(req.body);
    db.insert(req.body, function(err, user) {
	    if (err) res.send(err);
	    // res.json(user);
	    res.sendStatus(200)
	});
  },
  LoginUser: function (req, res) {
    db.find({ name: req.body.name, password: req.body.password }, function (err, docs) {
  		if (docs.length > 0){
  			res.sendstatus(200);
  		}else{
  			res.sendStatus(404);
  		}
	});
  }
};