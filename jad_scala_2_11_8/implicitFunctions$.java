// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.Option;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitFunctions

public final class implicitFunctions$
{

    public implicitFunctions.ImplicitStandard toStandard(Option oa)
    {
        return new implicitFunctions.ImplicitStandard(oa);
    }

    public Option toAnyVal(Option oa)
    {
        return oa;
    }

    public Option toInlineAnyVal(Option oa)
    {
        return oa;
    }

    private implicitFunctions$()
    {
    }

    public static final implicitFunctions$ MODULE$ = this;

    static 
    {
        new implicitFunctions$();
    }
}
