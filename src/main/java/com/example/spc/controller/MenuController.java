package com.example.spc.controller;

import com.example.spc.entity.Children;
import com.example.spc.entity.Menu;
import com.example.spc.entity.MenuVo;
import com.example.spc.entity.Wcha;
import com.example.spc.mapper.MenuMapper;

import com.example.spc.mapper.WchaMapper;
import com.example.spc.util.ExportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private WchaMapper wchaMapper;

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

    /**
     * 导出excel文件
     */
    @RequestMapping(value = "/export")
    public List<Wcha> exportExcel(@RequestBody Map<String,Object> params, HttpServletResponse response){
        List<Wcha> userList = wchaMapper.selectList(null);
        List<HashMap> checkBox = (List<HashMap>) params.get("checkBox");
//        List<String> optionCn=new ArrayList<>();
//        List<String> optionEn=new ArrayList<>();
//        for(HashMap option :checkBox){
//            optionCn.add(option.get("label").toString());
//            optionEn.add(option.get("value").toString());
//        }
        LinkedHashMap<String,String> fieldMap = new LinkedHashMap<String,String>();
        fieldMap.put("id","id");
        fieldMap.put("name","名字");
        fieldMap.put("age","年龄");
        fieldMap.put("password","性别");
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("id")){
//                fieldMap.put("id","序号");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("name")){
//                fieldMap.put("name","姓名");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("age")){
//                fieldMap.put("age","性别");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("password")){
//                fieldMap.put("password","出生日期");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("picture")){
//                fieldMap.put("picture","政治面貌");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("pid")){
//                fieldMap.put("pid","身份证");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("school")){
//                fieldMap.put("school","学校");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("major")){
//                fieldMap.put("major","专业");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("time")){
//                fieldMap.put("gTime","毕业时间");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("education")){
//                fieldMap.put("education","学历");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("gStatus")){
//                fieldMap.put("gStatus","毕业情况");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("homeAddress")){
//                fieldMap.put("homeAddress","家庭住址");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("currentAddress")){
//                fieldMap.put("currentAddress","当前住址");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("tel")){
//                fieldMap.put("tel","电话");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("wechat")){
//                fieldMap.put("wechat","微信号");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("email")){
//                fieldMap.put("email","邮箱");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("intentPlace")){
//                fieldMap.put("intentPlace","意向城市");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("intentJob")){
//                fieldMap.put("intentJob","意向工作");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("parentName")){
//                fieldMap.put("parentName","父母姓名");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("parentTel")){
//                fieldMap.put("parentTel","父母电话");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("type")){
//                fieldMap.put("type","学生来源");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("className")){
//                fieldMap.put("className","班级");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("sStatus")){
//                fieldMap.put("sStatus","学习状态");
//
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("remark")){
//                fieldMap.put("remark","备注");
//                break;
//            }
//        }
//        for (int i = 0; i < optionEn.size(); i++) {
//            if (optionEn.get(i).equals("createTime")){
//                fieldMap.put("createTime","入学时间");
//                break;
//            }
//        }
        String title = "学生信息表";
        ExportExcelUtils.export(title,userList,fieldMap,response);
        return userList;
    }

}
