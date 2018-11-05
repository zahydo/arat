/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.business.interfaces;

import arat.business.rationale.Information;
import arat.business.rationale.Rationale;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author sahydo
 */
public interface Reflection {

    public abstract Set<Method> getMethodsAnnotatedWithRationale();

    public abstract Set<Class<?>> getClasesAnnotatedWhitRationale();

    public abstract HashMap<Information, Rationale> getRationaleInformation();
    
    public abstract void configureReflection(String modelPackage);
}
