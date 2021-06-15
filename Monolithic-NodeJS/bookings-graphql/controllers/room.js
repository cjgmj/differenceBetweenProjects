const Room = require('../models/room');

exports.findAllRooms = async () => {
  return await Room.findAll();
};
