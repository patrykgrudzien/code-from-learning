package com.jurik99.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao implements Dao<User> {

	private final List<User> users = new ArrayList<>();

	public UserDao() {
		users.add(new User("John", "john@domain.com"));
		users.add(new User("Susan", "susan@domain.com"));
	}

	@Override
	public Optional<User> get(final long id) {
		return Optional.ofNullable(users.get((int) id));
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public void save(final User user) {
		users.add(user);
	}

	@Override
	public void update(final User user, final String[] params) {
		user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
		user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));

		users.add(user);
	}

	@Override
	public void delete(final User user) {
		users.remove(user);
	}
}
