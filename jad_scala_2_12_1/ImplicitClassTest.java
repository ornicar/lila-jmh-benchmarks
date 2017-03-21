// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.Option;
import scala.Option$;
import scala.runtime.BoxesRunTime;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses, implicitFunctions, implicitClasses$, implicitFunctions$

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
        implicitClasses.ImplicitInlineBothAnyVal..MODULE$;
        Option option1 = implicitClasses$.MODULE$.ImplicitInlineBothAnyVal(option());
        JVM INSTR ifnonnull 19;
           goto _L1 _L2
_L1:
        break MISSING_BLOCK_LABEL_17;
_L2:
        break MISSING_BLOCK_LABEL_19;
        throw null;
        return option1.isDefined();
    }

    public boolean testClassImplicitInlineFunAnyVal()
    {
        implicitClasses.ImplicitInlineFunAnyVal..MODULE$;
        Option option1 = implicitClasses$.MODULE$.ImplicitInlineFunAnyVal(option());
        JVM INSTR ifnonnull 19;
           goto _L1 _L2
_L1:
        break MISSING_BLOCK_LABEL_17;
_L2:
        break MISSING_BLOCK_LABEL_19;
        throw null;
        return option1.isDefined();
    }

    public boolean testClassImplicitInlineClassAnyVal()
    {
        return implicitClasses.ImplicitInlineClassAnyVal..MODULE$.bar$extension(implicitClasses$.MODULE$.ImplicitInlineClassAnyVal(option()));
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
        implicitFunctions.ImplicitInlineAnyVal..MODULE$;
        implicitFunctions$.MODULE$;
        Option option1 = option();
        JVM INSTR ifnonnull 16;
           goto _L1 _L2
_L1:
        break MISSING_BLOCK_LABEL_14;
_L2:
        break MISSING_BLOCK_LABEL_16;
        throw null;
        JVM INSTR ifnonnull 21;
           goto _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_19;
_L4:
        break MISSING_BLOCK_LABEL_21;
        throw null;
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
