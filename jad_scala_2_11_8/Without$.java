// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyValTest.scala

package org.openjdk.jmh.samples;

import scala.*;
import scala.runtime.AbstractFunction1;
import scala.runtime.BoxesRunTime;

// Referenced classes of package org.openjdk.jmh.samples:
//            Without

public final class Without$ extends AbstractFunction1
    implements Serializable
{

    public final String toString()
    {
        return "Without";
    }

    public Without apply(int value)
    {
        return new Without(value);
    }

    public Option unapply(Without x$0)
    {
        return ((Option) (x$0 != null ? new Some(BoxesRunTime.boxToInteger(x$0.value())) : None$.MODULE$));
    }

    private Object readResolve()
    {
        return MODULE$;
    }

    public volatile Object apply(Object v1)
    {
        return apply(BoxesRunTime.unboxToInt(v1));
    }

    private Without$()
    {
    }

    public static final Without$ MODULE$ = this;

    static 
    {
        new Without$();
    }
}
