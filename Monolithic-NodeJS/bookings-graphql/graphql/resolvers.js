const userController = require('../controllers/user');
const roomController = require('../controllers/room');
const bookingController = require('../controllers/booking');

module.exports = {
  findAllUsers: userController.findAllUsers,
  findUsersPaginated: userController.findUsersPaginated,
  findUserById: userController.findUserById,
  findUsersFilteredByName: userController.findUsersFilteredByName,
  findUsersOrderedByName: userController.findUsersOrderedByName,
  findUserFilteredByAge: userController.findUserFilteredByAge,
  addUser: userController.addUser,
  updateUser: userController.updateUser,
  deleteUser: userController.deleteUser,
  findAllRooms: roomController.findAllRooms,
  bookingRoom: bookingController.bookingRoom,
  findBookingsByRoom: bookingController.findBookingsByRoom,
  findBookingsBetweenDates: bookingController.findBookingsBetweenDates,
  findBookingsByUser: bookingController.findBookingsByUser,
  findBookingsByReasonNull: bookingController.findBookingsByReasonNull,
  findBookingsAfterDate: bookingController.findBookingsAfterDate,
  findBookingsAccepted: bookingController.findBookingsAccepted,
};
