package com.br.myfood.cadastro.controller;


import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertMenu(@RequestBody MenuDto menuDto){

        try{
            Menu menu = menuService.insertMenu(menuDto);
            MenuDto dto = new MenuDto();
            if(menu !=  null){
                dto.setName(menu.getName());
                dto.setPrice(menu.getPrice());
                dto.setIdRestaurant(menu.getRestaurant().getId());
            }
            return Objects.nonNull(menu) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(menuDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMenu(@PathVariable("id") Long id, @RequestBody MenuDto menuDto){
        Menu menu = Menu.create(menuDto);
        menu.setId(id);
        Menu updatedMenu = menuService.updateMenu(menu);

        return Objects.nonNull(updatedMenu) ? ResponseEntity.ok(updatedMenu) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMenu(@PathVariable("id") Long id){
        return menuService.deleteMenu(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }



    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        final Optional<Menu> menu = menuService.findById(id);

        if (menu.isPresent()) {
            MenuDto menuDto = MenuDto.create(menu.get());
            //menuDto.setRestaurant(menu.get().getRestaurant().getId());
            return ResponseEntity.ok(menuDto);
        }

        return ResponseEntity.notFound().build();

    }





}
