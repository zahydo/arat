/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.business.model.interfaces;

import java.lang.reflect.Method;
import java.util.Set;

/**
 *
 * @author sahydo
 */
public interface Reflection {

    public Set<Method> getMethodsAnnotatedWithRationale();

    public Set<Class<?>> getClasesAnnotatedWhitRationale();
}
