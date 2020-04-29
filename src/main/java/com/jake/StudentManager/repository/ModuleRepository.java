package com.jake.StudentManager.repository;

import com.jake.StudentManager.pojo.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
}
