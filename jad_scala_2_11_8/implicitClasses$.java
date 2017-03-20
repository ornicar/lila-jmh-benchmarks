// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.Option;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses

public final class implicitClasses$
{

    public implicitClasses.ImplicitStandard ImplicitStandard(Option oa)
    {
        return new implicitClasses.ImplicitStandard(oa);
    }

    public Option ImplicitAnyVal(Option oa)
    {
        return oa;
    }

    public Option ImplicitInlineBothAnyVal(Option oa)
    {
        return oa;
    }

    public Option ImplicitInlineFunAnyVal(Option oa)
    {
        return oa;
    }

    public Option ImplicitInlineClassAnyVal(Option oa)
    {
        return oa;
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
