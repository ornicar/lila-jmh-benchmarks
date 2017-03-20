// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EncodingTestData.scala

package org.openjdk.jmh.samples;

import scala.Serializable;
import scala.runtime.BoxesRunTime;
import scala.util.Random;

public interface EncodingTestData
{

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$org$openjdk$jmh$samples$EncodingTestData$$r_$eq(Random random);

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$startTime_$eq(int i);

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$centis_$eq(int ai[]);

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$moves_$eq(int i);

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$trunced_$eq(int ai[]);

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$encodedRounds_$eq(int ai[]);

    public abstract void org$openjdk$jmh$samples$EncodingTestData$_setter_$encoded_$eq(byte abyte0[]);

    public abstract Random org$openjdk$jmh$samples$EncodingTestData$$r();

    public abstract int startTime();

    public abstract int[] centis();

    public abstract int moves();

    public abstract int[] trunced();

    public abstract int[] encodedRounds();

    public abstract byte[] encoded();

    // Unreferenced inner class org/openjdk/jmh/samples/EncodingTestData$$anonfun$1

/* anonymous class */
    public final class .anonfun._cls1 extends scala.runtime.AbstractFunction1.mcII.sp
        implements Serializable
    {

        public final int apply(int x$1)
        {
            return apply$mcII$sp(x$1);
        }

        public int apply$mcII$sp(int x$1)
        {
            return (int)((double)x$1 + $outer.org$openjdk$jmh$samples$EncodingTestData$$r().nextGaussian() * (double)500);
        }

        public final volatile Object apply(Object v1)
        {
            return BoxesRunTime.boxToInteger(apply(BoxesRunTime.unboxToInt(v1)));
        }

        public static final long serialVersionUID = 0L;
        private final EncodingTestData $outer;

            public 
            {
                if(EncodingTestData.this == null)
                {
                    throw null;
                } else
                {
                    this.$outer = EncodingTestData.this;
                    super();
                    return;
                }
            }
    }

}
