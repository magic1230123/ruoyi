package com.magic.ruoyiapi.redis;

import java.lang.annotation.*;

/**
 * Created by TanJianLin on 2017/9/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RedisCache {
    Class type();
}
