package com.appinterface.app.base.core.freemake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;

import groovy.util.logging.Commons;

/**
 * @ClassName: App 
 * @Description: 标识App转发类 
 * @author xuzhenyao
 * @date 2015-6-5 上午10:02:49 
 *
 */
@Service
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface App {
}
