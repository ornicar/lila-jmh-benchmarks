// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyValTest.scala

package org.openjdk.jmh.samples;

import scala.*;
import scala.collection.Iterator;

// Referenced classes of package org.openjdk.jmh.samples:
//            Withit$

public final class Withit
    implements Product, Serializable
{

    public static String toString$extension(int i)
    {
        return Withit$.MODULE$.toString$extension(i);
    }

    public static boolean equals$extension(int i, Object obj)
    {
        return Withit$.MODULE$.equals$extension(i, obj);
    }

    public static int hashCode$extension(int i)
    {
        return Withit$.MODULE$.hashCode$extension(i);
    }

    public static boolean canEqual$extension(int i, Object obj)
    {
        return Withit$.MODULE$.canEqual$extension(i, obj);
    }

    public static Iterator productIterator$extension(int i)
    {
        return Withit$.MODULE$.productIterator$extension(i);
    }

    public static Object productElement$extension(int i, int j)
    {
        return Withit$.MODULE$.productElement$extension(i, j);
    }

    public static int productArity$extension(int i)
    {
        return Withit$.MODULE$.productArity$extension(i);
    }

    public static String productPrefix$extension(int i)
    {
        return Withit$.MODULE$.productPrefix$extension(i);
    }

    public static int copy$default$1$extension(int i)
    {
        return Withit$.MODULE$.copy$default$1$extension(i);
    }

    public static int copy$extension(int i, int j)
    {
        return Withit$.MODULE$.copy$extension(i, j);
    }

    public static Option unapply(int i)
    {
        return Withit$.MODULE$.unapply(i);
    }

    public static int apply(int i)
    {
        return Withit$.MODULE$.apply(i);
    }

    public static Function1 andThen(Function1 function1)
    {
        return Withit$.MODULE$.andThen(function1);
    }

    public static Function1 compose(Function1 function1)
    {
        return Withit$.MODULE$.compose(function1);
    }

    public int value()
    {
        return value;
    }

    public int copy(int value)
    {
        return Withit$.MODULE$.copy$extension(value(), value);
    }

    public int copy$default$1()
    {
        return Withit$.MODULE$.copy$default$1$extension(value());
    }

    public String productPrefix()
    {
        return Withit$.MODULE$.productPrefix$extension(value());
    }

    public int productArity()
    {
        return Withit$.MODULE$.productArity$extension(value());
    }

    public Object productElement(int x$1)
    {
        return Withit$.MODULE$.productElement$extension(value(), x$1);
    }

    public Iterator productIterator()
    {
        return Withit$.MODULE$.productIterator$extension(value());
    }

    public boolean canEqual(Object x$1)
    {
        return Withit$.MODULE$.canEqual$extension(value(), x$1);
    }

    public int hashCode()
    {
        return Withit$.MODULE$.hashCode$extension(value());
    }

    public boolean equals(Object x$1)
    {
        return Withit$.MODULE$.equals$extension(value(), x$1);
    }

    public String toString()
    {
        return Withit$.MODULE$.toString$extension(value());
    }

    public Withit(int value)
    {
        this.value = value;
        super();
        scala.Product.class.$init$(this);
    }

    private final int value;
}
