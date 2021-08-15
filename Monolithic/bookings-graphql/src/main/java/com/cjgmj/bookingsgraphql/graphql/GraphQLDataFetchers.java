package com.cjgmj.bookingsgraphql.graphql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.cjgmj.bookingsgraphql.graphql.object.input.BookingInput;
import com.cjgmj.bookingsgraphql.graphql.object.input.UserInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.Booking;
import com.cjgmj.bookingsgraphql.graphql.object.type.Room;
import com.cjgmj.bookingsgraphql.graphql.object.type.User;
import com.cjgmj.bookingsgraphql.graphql.object.type.UserPaged;
import com.cjgmj.bookingsgraphql.graphql.object.type.pagination.OrderType;
import com.cjgmj.bookingsgraphql.graphql.object.type.pagination.PageRequestType;
import com.cjgmj.bookingsgraphql.graphql.object.type.pagination.SortType;
import com.cjgmj.bookingsgraphql.service.IBookingService;
import com.cjgmj.bookingsgraphql.service.IRoomService;
import com.cjgmj.bookingsgraphql.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoomService roomService;

	@Autowired
	private IBookingService bookingService;

	public DataFetcher<List<User>> getFindAllUsersDataFetcher() {
		return dataFetchingEnvironment -> this.userService.getUsers();
	}

	public DataFetcher<UserPaged> getFindUsersPaginatedDataFetcher() {
		return dataFetchingEnvironment -> {
			final Integer page = dataFetchingEnvironment.getArgument("page");
			final Integer size = dataFetchingEnvironment.getArgument("size");

			final Page<User> usersPage = this.userService.getUsersPage(page, size);

			return this.convertToUserPage(usersPage);
		};
	}

	public DataFetcher<User> getFindUserByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			final Integer userId = dataFetchingEnvironment.getArgument("userId");

			return this.userService.getUserById(userId);
		};
	}

	public DataFetcher<List<User>> getFindUsersFilteredByNameDataFetcher() {
		return dataFetchingEnvironment -> {
			final String name = dataFetchingEnvironment.getArgument("name");

			return this.userService.getUserLike(name);
		};
	}

	public DataFetcher<List<User>> getFindUserOrderedByNameDataFetcher() {
		return dataFetchingEnvironment -> this.userService.getUserOrderName();
	}

	public DataFetcher<List<User>> getFindUserFilteredByAgeDataFetcher() {
		return dataFetchingEnvironment -> {
			final Integer age = dataFetchingEnvironment.getArgument("age");

			return this.userService.getUserMinor(age);
		};
	}

	public DataFetcher<User> getAddUserDataFetcher() {
		return dataFetchingEnvironment -> {
			final UserInput userInput = new ObjectMapper().registerModule(new JavaTimeModule())
					.convertValue(dataFetchingEnvironment.getArgument("userInput"), UserInput.class);

			return this.userService.insertUser(userInput);
		};
	}

	public DataFetcher<User> getUpdateUserDataFetcher() {
		return dataFetchingEnvironment -> {
			final Integer userId = dataFetchingEnvironment.getArgument("userId");
			final UserInput userInput = new ObjectMapper().registerModule(new JavaTimeModule())
					.convertValue(dataFetchingEnvironment.getArgument("userInput"), UserInput.class);

			return this.userService.updateUser(userId, userInput);
		};
	}

	public DataFetcher<User> getDeleteUserDataFetcher() {
		return dataFetchingEnvironment -> {
			final Integer userId = dataFetchingEnvironment.getArgument("userId");

			return this.userService.deleteUser(userId);
		};
	}

	public DataFetcher<User> getFindBookingUserDataFetcher() {
		return dataFetchingEnvironment -> {
			final Booking booking = dataFetchingEnvironment.getSource();

			return this.userService.getUserById(booking.getUserId());
		};
	}

	public DataFetcher<List<Room>> getFindAllRoomsDataFetcher() {
		return dataFetchingEnvironment -> this.roomService.getRooms();
	}

	public DataFetcher<Room> getFindBookingRoomDataFetcher() {
		return dataFetchingEnvironment -> {
			final Booking booking = dataFetchingEnvironment.getSource();

			return this.roomService.getRoomById(booking.getRoomId());
		};
	}

	public DataFetcher<Booking> getBookingRoomDataFetcher() {
		return dataFetchingEnvironment -> {
			final BookingInput bookingInput = new ObjectMapper().registerModule(new JavaTimeModule())
					.convertValue(dataFetchingEnvironment.getArgument("bookingInput"), BookingInput.class);

			return this.bookingService.bookingRoom(bookingInput);
		};
	}

	public DataFetcher<List<Booking>> getFindBookingsByRoomDataFetcher() {
		return dataFetchingEnvironment -> {
			final Integer roomId = dataFetchingEnvironment.getArgument("roomId");

			return this.bookingService.getBookingsByRoom(roomId);
		};
	}

	public DataFetcher<List<Booking>> getFindBookingsBetweenDatesDataFetcher() {
		return dataFetchingEnvironment -> {
			final LocalDate from = new ObjectMapper().registerModule(new JavaTimeModule())
					.convertValue(dataFetchingEnvironment.getArgument("from"), LocalDate.class);
			final LocalDate to = new ObjectMapper().registerModule(new JavaTimeModule())
					.convertValue(dataFetchingEnvironment.getArgument("to"), LocalDate.class);

			return this.bookingService.getBookingsBetween(from, to);
		};
	}

	public DataFetcher<List<Booking>> getFindBookingsByUserDataFetcher() {
		return dataFetchingEnvironment -> {
			final String name = dataFetchingEnvironment.getArgument("name");
			final String surname = dataFetchingEnvironment.getArgument("surname");

			return this.bookingService.getBookingsByUser(name, surname);
		};
	}

	public DataFetcher<List<Booking>> getFindBookingsByReasonNullDataFetcher() {
		return dataFetchingEnvironment -> this.bookingService.getBookingsByReasonNull();
	}

	public DataFetcher<List<Booking>> getFindBookingsAfterDateDataFetcher() {
		return dataFetchingEnvironment -> {
			final LocalDate date = new ObjectMapper().registerModule(new JavaTimeModule())
					.convertValue(dataFetchingEnvironment.getArgument("date"), LocalDate.class);

			return this.bookingService.getBookingsAfter(date);
		};
	}

	public DataFetcher<List<Booking>> getFindBookingsAcceptedDataFetcher() {
		return dataFetchingEnvironment -> this.bookingService.getBookingsAccepted();
	}

	private UserPaged convertToUserPage(Page<User> usersPage) {
		final UserPaged userPaged = new UserPaged();
		userPaged.setContent(usersPage.getContent());
		userPaged.setPageable(this.convertToPageable(usersPage.getPageable()));
		userPaged.setTotal((int) usersPage.getTotalElements());

		return userPaged;
	}

	private PageRequestType convertToPageable(Pageable pageable) {
		final PageRequestType pageRequest = new PageRequestType();
		final SortType sort = new SortType();
		final List<OrderType> orders = new ArrayList<>();

		StreamSupport.stream(pageable.getSort().spliterator(), false).forEach(order -> {
			final OrderType orderType = new OrderType();

			orderType.setProperty(order.getProperty());
			orderType.setDirection(order.getDirection().name());

			orders.add(orderType);
		});

		sort.setOrders(orders);

		pageRequest.setPage(pageable.getPageNumber());
		pageRequest.setSize(pageable.getPageSize());
		pageRequest.setSort(sort);

		return pageRequest;
	}

}
