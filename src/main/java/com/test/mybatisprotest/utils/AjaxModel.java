package com.test.mybatisprotest.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AjaxModel<T> {
    private int code;
    private T data;
    private String msg;
}
