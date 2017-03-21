// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyValTest.scala

package org.openjdk.jmh.samples;

import scala.*;
import scala.collection.Iterator;
import scala.runtime.*;

// Referenced classes of package org.openjdk.jmh.samples:
//            Without$

public class Without
    implements Product, Serializable
{

    public static Option unapply(Without without)
    {
        return Without$.MODULE$.unapply(without);
    }

    public static Without apply(int i)
    {
        return Without$.MODULE$.apply(i);
    }

    public static Function1 andThen(Function1 function1)
    {
        return Without$.MODULE$.andThen(function1);
    }

    public static Function1 compose(Function1 function1)
    {
        return Without$.MODULE$.compose(function1);
    }

    public int value()
    {
        return value;
    }

    public Without copy(int value)
    {
        return new Without(value);
    }

    public int copy$default$1()
    {
        return value();
    }

    public String productPrefix()
    {
        return "Without";
    }

    public int productArity()
    {
        return 1;
    }

    public Object productElement(int x$1)
    {
        switch(x$1)
        {
        default:
            throw new IndexOutOfBoundsException(BoxesRunTime.boxToInteger(x$1).toString());

        case 0: // '\0'
            return BoxesRunTime.boxToInteger(value());
        }
    }

    public Iterator productIterator()
    {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    public boolean canEqual(Object x$1)
    {
        return x$1 instanceof Without;
    }

    public int hashCode()
    {
        return Statics.finalizeHash(Statics.mix(0xcafebabe, value()), 1);
    }

    public String toString()
    {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    public boolean equals(Object x$1)
    {
        if(this == x$1) goto _L2; else goto _L1
_L1:
        boolean flag;
        if(x$1 instanceof Without)
            flag = true;
        else
            flag = false;
        if(!flag) goto _L4; else goto _L3
_L3:
        Without without = (Without)x$1;
        if(value() != without.value() || !without.canEqual(this)) goto _L4; else goto _L2
_L2:
        true;
          goto _L5
_L4:
        false;
_L5:
        return;
    }

    public Without(int value)
    {
        this.value = value;
        super();
        scala.Product.class.$init$(this);
    }

    private final int value;
}
