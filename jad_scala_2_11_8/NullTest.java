// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NullTest.scala

package org.openjdk.jmh.samples;

import scala.Option;
import scala.Option$;

public class NullTest
{
    public class Foo
    {

        public NullTest org$openjdk$jmh$samples$NullTest$Foo$$$outer()
        {
            return $outer;
        }

        public final NullTest $outer;

        public Foo()
        {
            if(NullTest.this == null)
            {
                throw null;
            } else
            {
                this.$outer = NullTest.this;
                super();
                return;
            }
        }
    }


    public Foo a()
    {
        return a;
    }

    public Foo b()
    {
        return b;
    }

    public boolean isNotNull(Object x)
    {
        return x != null;
    }

    public boolean isNotNullInline(Object x)
    {
        return x != null;
    }

    public boolean testNullWithOption()
    {
        return Option$.MODULE$.apply(a()).isDefined();
    }

    public boolean testDefinedWithOption()
    {
        return Option$.MODULE$.apply(b()).isDefined();
    }

    public boolean testNullWithFunction()
    {
        return isNotNull(a());
    }

    public boolean testDefinedWithFunction()
    {
        return isNotNull(b());
    }

    public boolean testNullWithFunctionInline()
    {
        return isNotNullInline(a());
    }

    public boolean testDefinedWithFunctionInline()
    {
        return isNotNullInline(b());
    }

    public NullTest()
    {
    }

    private final Foo a = null;
    private final Foo b = new Foo();
}
