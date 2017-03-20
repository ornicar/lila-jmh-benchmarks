// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DurationConvertTest.scala

package org.openjdk.jmh.samples;

import scala.*;
import scala.collection.Iterator;

// Referenced classes of package org.openjdk.jmh.samples:
//            Centis$

public final class Centis
    implements Product, Serializable
{

    public static String toString$extension(int i)
    {
        return Centis$.MODULE$.toString$extension(i);
    }

    public static boolean equals$extension(int i, Object obj)
    {
        return Centis$.MODULE$.equals$extension(i, obj);
    }

    public static int hashCode$extension(int i)
    {
        return Centis$.MODULE$.hashCode$extension(i);
    }

    public static boolean canEqual$extension(int i, Object obj)
    {
        return Centis$.MODULE$.canEqual$extension(i, obj);
    }

    public static Iterator productIterator$extension(int i)
    {
        return Centis$.MODULE$.productIterator$extension(i);
    }

    public static Object productElement$extension(int i, int j)
    {
        return Centis$.MODULE$.productElement$extension(i, j);
    }

    public static int productArity$extension(int i)
    {
        return Centis$.MODULE$.productArity$extension(i);
    }

    public static String productPrefix$extension(int i)
    {
        return Centis$.MODULE$.productPrefix$extension(i);
    }

    public static int copy$default$1$extension(int i)
    {
        return Centis$.MODULE$.copy$default$1$extension(i);
    }

    public static int copy$extension(int i, int j)
    {
        return Centis$.MODULE$.copy$extension(i, j);
    }

    public static Option unapply(int i)
    {
        return Centis$.MODULE$.unapply(i);
    }

    public static int apply(int i)
    {
        return Centis$.MODULE$.apply(i);
    }

    public static Function1 andThen(Function1 function1)
    {
        return Centis$.MODULE$.andThen(function1);
    }

    public static Function1 compose(Function1 function1)
    {
        return Centis$.MODULE$.compose(function1);
    }

    public int cs()
    {
        return cs;
    }

    public int copy(int cs)
    {
        return Centis$.MODULE$.copy$extension(cs(), cs);
    }

    public int copy$default$1()
    {
        return Centis$.MODULE$.copy$default$1$extension(cs());
    }

    public String productPrefix()
    {
        return Centis$.MODULE$.productPrefix$extension(cs());
    }

    public int productArity()
    {
        return Centis$.MODULE$.productArity$extension(cs());
    }

    public Object productElement(int x$1)
    {
        return Centis$.MODULE$.productElement$extension(cs(), x$1);
    }

    public Iterator productIterator()
    {
        return Centis$.MODULE$.productIterator$extension(cs());
    }

    public boolean canEqual(Object x$1)
    {
        return Centis$.MODULE$.canEqual$extension(cs(), x$1);
    }

    public int hashCode()
    {
        return Centis$.MODULE$.hashCode$extension(cs());
    }

    public boolean equals(Object x$1)
    {
        return Centis$.MODULE$.equals$extension(cs(), x$1);
    }

    public String toString()
    {
        return Centis$.MODULE$.toString$extension(cs());
    }

    public Centis(int cs)
    {
        this.cs = cs;
        super();
        scala.Product.class.$init$(this);
    }

    private final int cs;
}
