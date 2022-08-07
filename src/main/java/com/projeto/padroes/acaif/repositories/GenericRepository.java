package com.projeto.padroes.acaif.repositories;

import java.util.List;

public interface GenericRepository<E, T> {
	public void create(E e);
    public void update(E e);
    public E read(T t);
    public void delete(T t);
    public List<E> readAll();
}
