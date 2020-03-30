package com.soft1851.spring.web.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseObject
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private  Integer code;
    private  String msg;
    private  Object data;
}