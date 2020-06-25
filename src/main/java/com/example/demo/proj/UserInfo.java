package com.example.demo.proj;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author YeZhiyue
 * @since 2020-06-25
 */
@Data
public class UserInfo implements Serializable {

    private Long idGe;

    private Long idLe;

    private String name;

    private Integer ageGe;

    private Integer ageLe;

    private String email;

    private String crud;
}
