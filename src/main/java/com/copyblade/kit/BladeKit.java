package com.copyblade.kit;

import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Blade kit
 *
 * @author biezhi
 * 2017/5/31
 */
@NoArgsConstructor
public class BladeKit {



    public static boolean isNotEmpty(Collection<?> c) {
        return null != c && !c.isEmpty();
    }



}
