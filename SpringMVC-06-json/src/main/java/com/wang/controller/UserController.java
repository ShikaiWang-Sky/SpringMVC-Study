package com.wang.controller;



import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wang.pojo.User;
import com.wang.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//@Controller
@RestController
public class UserController {

    //@ResponseBody: 它就不会走视图解析器, 会直接返回一个字符串到当前页面!
    //@ResponseBody
    @RequestMapping(value = "/j1")
    public String json1() throws JsonProcessingException {

        //jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("wang_sky_1", 3, "男");

        String string = mapper.writeValueAsString(user);

        return string;
    }

    @RequestMapping(value = "/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("wang_sky_1", 3, "男");
        User user2 = new User("wang_sky_2", 4, "男");
        User user3 = new User("wang_sky_3", 5, "男");
        User user4 = new User("wang_sky_4", 6, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        String user = mapper.writeValueAsString(users);
        return user;
    }

    @RequestMapping(value = "/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return mapper.writeValueAsString(sdf.format(date));
    }

    @RequestMapping(value = "/j4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //使用ObjectMapper格式化输出, 关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(sdf);

        Date date = new Date();

        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/j5")
    public String json5() {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        return JsonUtils.getJson(new Date(), dateFormat);
    }

    @RequestMapping(value = "/j6")
    public String json6() throws JsonProcessingException {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("wang_sky_1", 3, "男");
        User user2 = new User("wang_sky_2", 4, "男");
        User user3 = new User("wang_sky_3", 5, "男");
        User user4 = new User("wang_sky_4", 6, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return JSON.toJSONString(users);
    }

}
