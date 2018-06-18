package it.uniroma3.siw.repository;

import java.util.List;

public abstract interface Repository<T> {

	public abstract T save(T paramT);

	public abstract T findByPrimaryKey(Long paramLong);

	public abstract List<T> findAll();

	public abstract void update(T paramT);

	public abstract void delete(T paramT);
}
