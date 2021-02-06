const express = require('express');

const userController = require('../controllers/user');

const router = express.Router();

router.get('/page', userController.getUsersPage);

router.get('/like/:text', userController.getUserLike);

router.get('/order/name', userController.getUserOrderName);

router.get('/minor/:age', userController.getUserMinor);

router.get('/:id', userController.getUserById);

router.get('/', userController.getUsers);

router.post('/', userController.postUser);

router.put('/', userController.putUser);

router.delete('/:id', userController.deleteUser);

module.exports = router;
