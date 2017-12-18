package com.copyblade.ioc;

import com.copyblade.ioc.bean.ClassInfo;
import com.copyblade.ioc.bean.Scanner;

import java.util.Set;

/**
 * 类读取器
 */
public interface ClassReader {
    //既然是类的读取器，读取类放在set容器里
    Set<ClassInfo> readClasses (Scanner scanner) ;
}
