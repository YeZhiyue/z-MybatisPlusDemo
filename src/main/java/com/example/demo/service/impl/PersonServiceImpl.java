package com.example.demo.service.impl;

import com.example.demo.proj.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YeZhiyue
 * @since 2020-06-25
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
