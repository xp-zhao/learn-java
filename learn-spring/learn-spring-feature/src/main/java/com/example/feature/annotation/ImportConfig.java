package com.example.feature.annotation;

import org.springframework.context.annotation.Import;

/**
 * @author zhaoxiaoping @Import 注解导入普通类
 * @date 2023-3-2
 */
@Import({SimpleClass.class, ImportRegistry.class, ImportMySelector.class})
public class ImportConfig {}
