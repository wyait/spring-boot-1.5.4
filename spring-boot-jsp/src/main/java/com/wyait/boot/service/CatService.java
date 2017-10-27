package com.wyait.boot.service;

import com.wyait.boot.pojo.Cat;

public interface CatService {

	Cat findCat(String name);

	Cat findByName(String name);

	Cat update(Cat cat);

	void delete(Long id);

}
