// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.Option;
import scala.Option$;
import scala.runtime.BoxesRunTime;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses$, implicitFunctions$, implicitClasses, implicitFunctions

public class ImplicitClassTest
{

    public Option option()
    {
        return option;
    }

    public boolean testClassStandard()
    {
        return implicitClasses$.MODULE$.ImplicitStandard(option()).bar();
    }

    public boolean testClassAnyVal()
    {
        return implicitClasses.ImplicitAnyVal..MODULE$.bar$extension(implicitClasses$.MODULE$.ImplicitAnyVal(option()));
    }

    public boolean testClassInlineBothAnyVal()
    {
        Option option1 = option();
        implicitClasses$ implicitclasses$ = implicitClasses$.MODULE$;
        implicitClasses.ImplicitInlineBothAnyVal. 1 = implicitClasses.ImplicitInlineBothAnyVal..MODULE$;
        return option1.isDefined();
    }

    public boolean testClassImplicitInlineFunAnyVal()
    {
        Option option1 = implicitClasses$.MODULE$.ImplicitInlineFunAnyVal(option());
        implicitClasses.ImplicitInlineFunAnyVal. 1 = implicitClasses.ImplicitInlineFunAnyVal..MODULE$;
        return option1.isDefined();
    }

    public boolean testClassImplicitInlineClassAnyVal()
    {
        Option option1 = option();
        implicitClasses$ implicitclasses$ = implicitClasses$.MODULE$;
        return implicitClasses.ImplicitInlineClassAnyVal..MODULE$.bar$extension(option1);
    }

    public boolean testFunctionStandard()
    {
        return implicitFunctions$.MODULE$.toStandard(option()).bar();
    }

    public boolean testFunctionAnyVal()
    {
        return implicitFunctions.ImplicitAnyVal..MODULE$.bar$extension(implicitFunctions$.MODULE$.toAnyVal(option()));
    }

    public boolean testFunctionInlineAnyVal()
    {
        Option option1 = option();
        implicitFunctions$ implicitfunctions$ = implicitFunctions$.MODULE$;
        implicitFunctions.ImplicitInlineAnyVal. 1 = implicitFunctions.ImplicitInlineAnyVal..MODULE$;
        return option1.isDefined();
    }

    public boolean baseline()
    {
        return option().isDefined();
    }

    public ImplicitClassTest()
    {
        option = Option$.MODULE$.apply(BoxesRunTime.boxToInteger(42));
    }

    private final Option option;
}
