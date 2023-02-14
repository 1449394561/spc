package com.example.spc.controller;

import com.example.spc.entity.Children;
import com.example.spc.entity.Menu;
import com.example.spc.entity.MenuVo;
import com.example.spc.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping
    public List<MenuVo> mmenulist(){
        List<Menu> menu = menuMapper.selectList(null);
        List<MenuVo> menuvo = new ArrayList<>();
        for (Menu m : menu){
            MenuVo menuVos = new MenuVo();
            Children c1=new Children();
            List children =new ArrayList();

            c1.setPath(m.getChildrenpath());
            c1.setName(m.getChildrenname());
            c1.setComponent1(m.getChildrencomponent());

            children.add(c1);



            menuVos.setPath(m.getPath());
            menuVos.setName(m.getName());
            menuVos.setRedirect(m.getRedirect());
            menuVos.setComponent1(m.getComponent1());
            menuVos.setChildren1(children);
            menuvo.add(menuVos);
        }

        return menuvo;
    }
}
