package com.br.myfood.cadastro.repository;

import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {


}
