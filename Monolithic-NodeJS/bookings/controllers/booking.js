const { Sequelize } = require('sequelize');

const Booking = require('../models/booking');
const User = require('../models/user');
const Room = require('../models/room');

exports.postBookingRoom = (req, res, next) => {
  const userId = req.body.user.id;
  const roomId = req.body.room.id;

  const { date, reason } = req.body;

  Booking.create({
    date,
    reason,
    accepted: false,
    booking: new Date(),
    userId,
    roomId,
  })
    .then((bookingCreate) =>
      Booking.findByPk(bookingCreate.id, {
        include: [User, Room],
        attributes: {
          exclude: ['userId', 'roomId'],
        },
      })
    )
    .then((booking) => res.json({ booking }))
    .catch((err) => console.log(err));
};

exports.getBookingsByRoom = (req, res, next) => {
  const roomId = req.params.id;

  Booking.findAll({
    where: { roomId },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  })
    .then((bookings) => res.json(bookings))
    .catch((err) => console.log(err));
};

exports.getBookingsBetween = (req, res, next) => {
  const from = Date.parse(req.query.from);
  const to = Date.parse(req.query.to);

  Booking.findAll({
    where: { date: { [Sequelize.Op.between]: [from, to] } },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  })
    .then((bookings) => res.json({ bookings }))
    .catch((err) => console.log(err));
};

exports.getBookingsByUser = (req, res, next) => {
  const name = req.query.name;
  const surname = req.query.surname;

  Booking.findAll({
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
  })
    .then((bookings) => res.json({ bookings }))
    .catch((err) => console.log(err));
};

exports.getBookingsByReasonNull = (req, res, next) => {
  Booking.findAll({
    where: {
      reason: {
        [Sequelize.Op.is]: null,
      },
    },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  })
    .then((bookings) => res.json({ bookings }))
    .catch((err) => console.log(err));
};

exports.getBookingsAfter = (req, res, next) => {
  const date = req.params.date;

  Booking.findAll({
    where: {
      date: {
        [Sequelize.Op.gt]: date,
      },
    },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  })
    .then((bookings) => res.json({ bookings }))
    .catch((err) => console.log(err));
};

exports.getBookingsAccepted = (req, res, next) => {
  Booking.findAll({
    where: {
      accepted: {
        [Sequelize.Op.is]: true,
      },
    },
    include: [User, Room],
    attributes: {
      exclude: ['userId', 'roomId'],
    },
  })
    .then((bookings) => res.json({ bookings }))
    .catch((err) => console.log(err));
};
