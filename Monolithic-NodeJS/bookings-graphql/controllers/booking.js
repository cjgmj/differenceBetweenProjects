const { Sequelize } = require('sequelize');

const Booking = require('../models/booking');
const User = require('../models/user');
const Room = require('../models/room');

exports.bookingRoom = async ({ bookingInput }) => {
  const { userId, roomId, date, reason } = bookingInput;

  return await Booking.create({
    date,
    reason,
    accepted: false,
    booking: new Date(),
    userId,
    roomId,
  }).then((bookingCreate) =>
    Booking.findByPk(bookingCreate.id, {
      include: [User, Room],
      attributes: {
        exclude: ['userId', 'roomId'],
      },
    })
  );
};

exports.findBookingsByRoom = async ({ roomId }) => {
  return await Booking.findAll({
    where: { roomId },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  });
};

exports.findBookingsBetweenDates = async ({ from, to }) => {
  return await Booking.findAll({
    where: { date: { [Sequelize.Op.between]: [from, to] } },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  });
};

exports.findBookingsByUser = async ({ name, surname }) => {
  return await Booking.findAll({
    attributes: {
      exclude: ['userId', 'roomId'],
    },
    include: [
      {
        model: User,
        where: { name, surname },
      },
      Room,
    ],
  });
};

exports.findBookingsByReasonNull = async () => {
  return await Booking.findAll({
    where: {
      reason: {
        [Sequelize.Op.is]: null,
      },
    },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  });
};

exports.findBookingsAfterDate = async ({ date }) => {
  return await Booking.findAll({
    where: {
      date: {
        [Sequelize.Op.gt]: date,
      },
    },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  });
};

exports.findBookingsAccepted = async () => {
  return await Booking.findAll({
    where: {
      accepted: {
        [Sequelize.Op.is]: true,
      },
    },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  });
};
