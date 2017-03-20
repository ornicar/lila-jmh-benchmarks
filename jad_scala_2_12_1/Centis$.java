// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DurationConvertTest.scala

package org.openjdk.jmh.samples;

import scala.*;
import scala.collection.Iterator;
import scala.runtime.*;

// Referenced classes of package org.openjdk.jmh.samples:
//            Centis

public final class Centis$ extends AbstractFunction1
    implements Serializable
{

    public final String toString()
    {
        return "Centis";
    }

    public int apply(int cs)
    {
        return cs;
    }

    public Option unapply(int x$0)
    {
        new Centis(x$0);
        return new Some(BoxesRunTime.boxToInteger(x$0));
    }

    private Object readResolve()
    {
        return MODULE$;
    }

    public final int copy$extension(int $this, int cs)
    {
        return cs;
    }

    public final int copy$default$1$extension(int $this)
    {
        return $this;
    }

    public final String productPrefix$extension(int $this)
    {
        return "Centis";
    }

    public final int productArity$extension(int $this)
    {
        return 1;
    }

    public final Object productElement$extension(int $this, int x$1)
    {
        switch(x$1)
        {
        case 0: // '\0'
            return BoxesRunTime.boxToInteger($this);
        }
        throw new IndexOutOfBoundsException(BoxesRunTime.boxToInteger(x$1).toString());
    }

    public final Iterator productIterator$extension(int $this)
    {
        return ScalaRunTime$.MODULE$.typedProductIterator(new Centis($this));
    }

    public final boolean canEqual$extension(int $this, Object x$1)
    {
        return x$1 instanceof Integer;
    }

    public final int hashCode$extension(int $this)
    {
        return BoxesRunTime.boxToInteger($this).hashCode();
    }

    public final boolean equals$extension(int $this, Object x$1)
    {
        boolean flag;
        if(x$1 instanceof Centis)
            flag = true;
        else
            flag = false;
        if(flag)
        {
            int i = ((Centis)x$1).cs();
            if($this == i)
                return true;
        }
        return false;
    }

    public final String toString$extension(int $this)
    {
        return ScalaRunTime$.MODULE$._toString(new Centis($this));
    }

    public volatile Object apply(Object v1)
    {
        return new Centis(apply(BoxesRunTime.unboxToInt(v1)));
    }

    private Centis$()
    {
        MODULE$ = this;
    }

    public static Centis$ MODULE$;

    static 
    {
        new Centis$();
    }
}
