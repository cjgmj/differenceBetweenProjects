package com.cjgmj.bookingsgraphql.graphql;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.Function;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

public class CustomScalars {

	public static final GraphQLScalarType LOCAL_DATE_TIME = GraphQLScalarType.newScalar().name("LocalDateTime")
			.description("Scalar for LocalDateTime").coercing(new Coercing<LocalDateTime, String>() {

				@Override
				public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
					LocalDateTime localDateTime;

					if (dataFetcherResult instanceof LocalDateTime) {
						localDateTime = (LocalDateTime) dataFetcherResult;
					} else if (dataFetcherResult instanceof String) {
						localDateTime = this.parseLocalDateTime(dataFetcherResult.toString(),
								CoercingSerializeException::new);
					} else {
						throw new CoercingSerializeException("Cannot convert to LocalDateTime");
					}

					try {
						return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
					} catch (final DateTimeException e) {
						throw new CoercingSerializeException("Invalid date");
					}
				}

				@Override
				public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
					LocalDateTime localDateTime;

					if (input instanceof LocalDateTime) {
						localDateTime = (LocalDateTime) input;
					} else if (input instanceof String) {
						localDateTime = this.parseLocalDateTime(input.toString(), CoercingParseValueException::new);
					} else {
						throw new CoercingParseValueException("Cannot convert to LocalDateTime");
					}

					return localDateTime;
				}

				@Override
				public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
					if (!(input instanceof StringValue)) {
						throw new CoercingParseLiteralException("The value is not a StringValue");
					}

					return this.parseLocalDateTime(((StringValue) input).getValue(),
							CoercingParseLiteralException::new);
				}

				private LocalDateTime parseLocalDateTime(String s, Function<String, RuntimeException> exceptionMaker) {
					try {
						return LocalDateTime.parse(s);
					} catch (final DateTimeParseException e) {
						throw exceptionMaker.apply("Invalid value");
					}
				}

			}).build();

	public static final GraphQLScalarType LOCAL_DATE = GraphQLScalarType.newScalar().name("LocalDate")
			.description("Scalar for LocalDate").coercing(new Coercing<LocalDate, String>() {

				@Override
				public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
					LocalDate localDate;

					if (dataFetcherResult instanceof LocalDate) {
						localDate = (LocalDate) dataFetcherResult;
					} else if (dataFetcherResult instanceof String) {
						localDate = this.parseLocalDate(dataFetcherResult.toString(), CoercingSerializeException::new);
					} else {
						throw new CoercingSerializeException("Cannot convert to LocalDate");
					}

					try {
						return DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);
					} catch (final DateTimeException e) {
						throw new CoercingSerializeException("Invalid date");
					}
				}

				@Override
				public LocalDate parseValue(Object input) throws CoercingParseValueException {
					LocalDate localDate;

					if (input instanceof LocalDate) {
						localDate = (LocalDate) input;
					} else if (input instanceof String) {
						localDate = this.parseLocalDate(input.toString(), CoercingParseValueException::new);
					} else {
						throw new CoercingParseValueException("Cannot convert to LocalDate");
					}

					return localDate;
				}

				@Override
				public LocalDate parseLiteral(Object input) throws CoercingParseLiteralException {
					if (!(input instanceof StringValue)) {
						throw new CoercingParseLiteralException("The value is not a StringValue");
					}

					return this.parseLocalDate(((StringValue) input).getValue(), CoercingParseLiteralException::new);
				}

				private LocalDate parseLocalDate(String s, Function<String, RuntimeException> exceptionMaker) {
					try {
						return LocalDate.parse(s);
					} catch (final DateTimeParseException e) {
						throw exceptionMaker.apply("Invalid value");
					}
				}

			}).build();

}
