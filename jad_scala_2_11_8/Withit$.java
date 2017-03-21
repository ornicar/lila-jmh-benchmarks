// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyValTest.scala

package org.openjdk.jmh.samples;

import scala.*;
import scala.collection.Iterator;
import scala.runtime.*;

// Referenced classes of package org.openjdk.jmh.samples:
//            Withit

public final class Withit$ extends AbstractFunction1
    implements Serializable
{

    public final String toString()
    {
        return "Withit";
    }

    public int apply(int value)
    {
        return value;
    }

    public Option unapply(int x$0)
    {
        new Withit(x$0);
        return new Some(BoxesRunTime.boxToInteger(x$0));
    }

    private Object readResolve()
    {
        return MODULE$;
    }

    public final int copy$extension(int $this, int value)
    {
        return value;
    }

    public final int copy$default$1$extension(int $this)
    {
        return $this;
    }

    public final String productPrefix$extension(int $this)
    {
        return "Withit";
    }

    public final int productArity$extension(int $this)
    {
        return 1;
    }

    public final Object productElement$extension(int $this, int x$1)
    {
        switch(x$1)
        {
        default:
            throw new IndexOutOfBoundsException(BoxesRunTime.boxToInteger(x$1).toString());

        case 0: // '\0'
            return BoxesRunTime.boxToInteger($this);
        }
    }

    public final Iterator productIterator$extension(int $this)
    {
        return ScalaRunTime$.MODULE$.typedProductIterator(new Withit($this));
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
        if(x$1 instanceof Withit)
            flag = true;
        else
            flag = false;
        if(!flag) goto _L2; else goto _L1
_L1:
        int i = ((Withit)x$1).value();
        if($this != i) goto _L2; else goto _L3
_L3:
        true;
          goto _L4
_L2:
        false;
_L4:
        return;
    }

    public final String toString$extension(int $this)
    {
        return ScalaRunTime$.MODULE$._toString(new Withit($this));
    }

    public volatile Object apply(Object v1)
    {
        return new Withit(apply(BoxesRunTime.unboxToInt(v1)));
    }

    private Withit$()
    {
    }

    public static final Withit$ MODULE$ = this;

    static 
    {
        new Withit$();
    }
}
