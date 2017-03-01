//Our Database using nedb
var Datastore = require('nedb');
var db = new Datastore({
  filename: 'betsiq.db', // provide a path to the database file 
  autoload: true, // automatically load the database
  timestampData: true // automatically add and manage the fields createdAt and updatedAt
});

var billboard = require("billboard-top-100").getChart;

//RESTful functions go here
module.exports = {
  CreateUser: function (req, res) {
    console.log(req.body);
    db.find({ name: req.body.name}, function (err, docs) {
    	if (docs.length == 0){
		    db.insert(req.body, function(err, user) {
			    if (err) res.send(err);
			    res.json(user);
			    //res.sendStatus(200)
			});
		}else{
			//The username already exists
			res.sendStatus(401)
		}
	});
  },
  LoginUser: function (req, res) {
  	console.log(req.body);
    db.find({ name: req.body.name, password: req.body.password }, function (err, docs) {
  		if (docs.length > 0){
  			console.log("200");
  			console.log(docs[0]);
  			res.json(docs[0]);
  		}else{
  			console.log("404");
  			res.sendStatus(404);
  		}
	});
  },

  JoinGroup: function (req, res){
  		db.update( {_id: req.body._id}, {groupid: req.params.groupid}, {}, function(){
  			res.sendStatus(200);
  		})
  },

  GetTopSong: function (req, res) {
  	billboard('hot-100',  function(songs, err){
	    res.json(songs);
	});
  },

  GetUserSongs: function (req, res){
  	db.find({_id: req.params.userid}, function (err, user) {
  		if (user.length > 0){
  			console.log("200");
  			res.json(user.songs);
  		}else{
  			console.log("404");
  			res.sendStatus(404);
  		}
	});
  },

  AddUserSongs: function (req, res){
  	console.log("adding!!!!!");
  	console.log(req.params.userid);
  	db.update({_id: req.params.userid}, {songs:req.body.songs} ,{}, function(){
  		console.log("added");
	    res.sendStatus(200)
	});
  }
};