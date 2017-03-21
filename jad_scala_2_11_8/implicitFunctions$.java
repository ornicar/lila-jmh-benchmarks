// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;


// Referenced classes of package org.openjdk.jmh.samples:
//            implicitFunctions

public final class implicitFunctions$
{

    public implicitFunctions.ImplicitStandard toStandard(int i)
    {
        return new implicitFunctions.ImplicitStandard(i);
    }

    public int toAnyVal(int i)
    {
        return i;
    }

    public int toInlineAnyVal(int i)
    {
        return i;
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
