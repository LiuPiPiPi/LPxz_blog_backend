package com.lpxz.lpxzblog.utils;

import org.junit.Test;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.util.UUID;

public class IDUtil {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDUtil.getId());
    }
}
