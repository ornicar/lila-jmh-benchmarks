// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BitOpsTest.scala

package org.openjdk.jmh.samples;

import org.lila.clockencoder.BitReader;
import scala.Serializable;
import scala.collection.immutable.*;
import scala.package$;
import scala.runtime.BoxesRunTime;
import scala.util.Random;

// Referenced classes of package org.openjdk.jmh.samples:
//            EncodingTestData

public class BitOpsTest
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

    public IndexedSeq testRead()
    {
        BitReader r = new BitReader(encoded());
        return (IndexedSeq)package$.MODULE$.Range().apply(0, 50).map(new Serializable(r) {

            public final int apply(int x$1)
            {
                return r$1.readBits(4);
            }

            public int apply$mcII$sp(int x$1)
            {
                return r$1.readBits(4);
            }

            public final volatile Object apply(Object v1)
            {
                return BoxesRunTime.boxToInteger(apply(BoxesRunTime.unboxToInt(v1)));
            }

            public static final long serialVersionUID = 0L;
            public final BitReader r$1;

            public 
            {
                this.r$1 = r$1;
                super();
            }
        }
, IndexedSeq$.MODULE$.canBuildFrom());
    }

    public BitOpsTest()
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
