// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DurationConvertTest.scala

package org.openjdk.jmh.samples;

import scala.concurrent.duration.FiniteDuration;

public final class implicits$
{

    public FiniteDuration LilaPimpedFiniteDuration(FiniteDuration self)
    {
        return self;
    }

    private implicits$()
    {
    }

    public static final implicits$ MODULE$ = this;

    static 
    {
        new implicits$();
    }
}
