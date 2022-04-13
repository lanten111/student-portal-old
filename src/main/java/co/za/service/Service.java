package co.za.service;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service<T> {

    public T get(long id);

    public void add(T dto);

    public List<T> getList();

    public int delete(long id);

}
