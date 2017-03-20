// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;


// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses$, implicitFunctions$, implicitClasses, implicitFunctions

public class ImplicitClassTest
{

    public int option()
    {
        return option;
    }

    public int testClassStandard()
    {
        return implicitClasses$.MODULE$.ImplicitStandard(option()).bar();
    }

    public int testClassAnyVal()
    {
        return implicitClasses.ImplicitAnyVal..MODULE$.bar$extension(implicitClasses$.MODULE$.ImplicitAnyVal(option()));
    }

    public int testClassInlineBothAnyVal()
    {
        int i = option();
        implicitClasses$ implicitclasses$ = implicitClasses$.MODULE$;
        implicitClasses.ImplicitInlineBothAnyVal. 1 = implicitClasses.ImplicitInlineBothAnyVal..MODULE$;
        return i + 2;
    }

    public int testClassImplicitInlineFunAnyVal()
    {
        int i = implicitClasses$.MODULE$.ImplicitInlineFunAnyVal(option());
        implicitClasses.ImplicitInlineFunAnyVal. 1 = implicitClasses.ImplicitInlineFunAnyVal..MODULE$;
        return i + 2;
    }

    public int testClassImplicitInlineClassAnyVal()
    {
        int i = option();
        implicitClasses$ implicitclasses$ = implicitClasses$.MODULE$;
        return implicitClasses.ImplicitInlineClassAnyVal..MODULE$.bar$extension(i);
    }

    public int testFunctionStandard()
    {
        return implicitFunctions$.MODULE$.toStandard(option()).bar();
    }

    public int testFunctionAnyVal()
    {
        return implicitFunctions.ImplicitAnyVal..MODULE$.bar$extension(implicitFunctions$.MODULE$.toAnyVal(option()));
    }

    public int testFunctionInlineAnyVal()
    {
        int i = option();
        implicitFunctions$ implicitfunctions$ = implicitFunctions$.MODULE$;
        implicitFunctions.ImplicitInlineAnyVal. 1 = implicitFunctions.ImplicitInlineAnyVal..MODULE$;
        return i + 2;
    }

    public int baseline()
    {
        return option() + 2;
    }

    public ImplicitClassTest()
    {
    }

    private final int option = 42;
}
