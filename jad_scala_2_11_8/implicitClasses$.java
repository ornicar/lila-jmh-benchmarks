// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;


// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses

public final class implicitClasses$
{

    public implicitClasses.ImplicitStandard ImplicitStandard(int i)
    {
        return new implicitClasses.ImplicitStandard(i);
    }

    public int ImplicitAnyVal(int i)
    {
        return i;
    }

    public int ImplicitInlineBothAnyVal(int i)
    {
        return i;
    }

    public int ImplicitInlineFunAnyVal(int i)
    {
        return i;
    }

    public int ImplicitInlineClassAnyVal(int i)
    {
        return i;
    }

    private implicitClasses$()
    {
    }

    public static final implicitClasses$ MODULE$ = this;

    static 
    {
        new implicitClasses$();
    }
}
