const express = require('express');

const bookingController = require('../controllers/booking');

const router = express.Router();

router.post('/', bookingController.postBookingRoom);

router.get('/between', bookingController.getBookingsBetween);

router.get('/user', bookingController.getBookingsByUser);

router.get('/reason-null', bookingController.getBookingsByReasonNull);

router.get('/after/:date', bookingController.getBookingsAfter);

router.get('/accepteds', bookingController.getBookingsAccepted);

router.get('/:id', bookingController.getBookingsByRoom);

module.exports = router;
