package com.wyait.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyait.boot.dao.CatRepository;
import com.wyait.boot.pojo.Cat;

@Service
public class CatServiceImpl implements CatService {
	@Autowired
	private CatRepository catRepository;

	@Override
	public Cat findCat(String name) {
		/*
		 * this.catRepository.save(new Cat("张三", 27));
		 * this.catRepository.save(new Cat("王五", 27));
		 * this.catRepository.save(new Cat("赵六", 26));
		 * this.catRepository.save(new Cat("呵呵", 27));
		 * this.catRepository.save(new Cat("哈哈", 29));
		 * this.catRepository.save(new Cat("李白", 7));
		 * this.catRepository.save(new Cat("张三1", 27));
		 * this.catRepository.save(new Cat("王五1", 27));
		 * this.catRepository.save(new Cat("赵六1", 26));
		 * this.catRepository.save(new Cat("呵呵1", 27));
		 * this.catRepository.save(new Cat("哈哈1", 29));
		 * this.catRepository.save(new Cat("李白1", 7));
		 * this.catRepository.save(new Cat("韩信", 21));
		 */

		return this.catRepository.findCat(name);
	}

	@Override
	public Cat findByName(String name) {
		return this.catRepository.findByName(name);
	}

	@Override
	public Cat update(Cat cat) {
		return this.catRepository.save(cat);
	}

	@Override
	public void delete(Long id) {
		this.catRepository.delete(id);
	}
}
