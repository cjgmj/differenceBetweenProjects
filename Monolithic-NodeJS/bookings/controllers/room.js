const Room = require('../models/room');

exports.getRooms = (req, res, next) => {
  Room.findAll()
    .then((rooms) => res.json({ rooms }))
    .catch((err) => console.log(err));
};
