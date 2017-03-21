// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinearEstimateTest.scala

package org.openjdk.jmh.samples;

import org.lila.clockencoder.LinearEstimator;
import scala.util.Random;

// Referenced classes of package org.openjdk.jmh.samples:
//            EncodingTestData

public class LinearEstimateTest
    implements EncodingTestData
{

    public Random org$openjdk$jmh$samples$EncodingTestData$$r()
    {
        return org$openjdk$jmh$samples$EncodingTestData$$r;
    }

    public int startTime()
    {
        return startTime;
    }

    public int[] centis()
    {
        return centis;
    }

    public int moves()
    {
        return moves;
    }

    public int[] trunced()
    {
        return trunced;
    }

    public int[] encodedRounds()
    {
        return encodedRounds;
    }

    public byte[] encoded()
    {
        return encoded;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$org$openjdk$jmh$samples$EncodingTestData$$r_$eq(Random x$1)
    {
        org$openjdk$jmh$samples$EncodingTestData$$r = x$1;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$startTime_$eq(int x$1)
    {
        startTime = x$1;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$centis_$eq(int x$1[])
    {
        centis = x$1;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$moves_$eq(int x$1)
    {
        moves = x$1;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$trunced_$eq(int x$1[])
    {
        trunced = x$1;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$encodedRounds_$eq(int x$1[])
    {
        encodedRounds = x$1;
    }

    public void org$openjdk$jmh$samples$EncodingTestData$_setter_$encoded_$eq(byte x$1[])
    {
        encoded = x$1;
    }

    public void testEncode()
    {
        LinearEstimator.encode(trunced(), startTime());
    }

    public LinearEstimateTest()
    {
        EncodingTestData.class.$init$(this);
    }

    private final Random org$openjdk$jmh$samples$EncodingTestData$$r;
    private final int startTime;
    private final int centis[];
    private final int moves;
    private final int trunced[];
    private final int encodedRounds[];
    private final byte encoded[];
}
