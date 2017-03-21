// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DurationConvertTest.scala

package org.openjdk.jmh.samples;

import scala.Array$;
import scala.Serializable;
import scala.collection.TraversableOnce;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Range$;
import scala.collection.immutable.Vector;
import scala.collection.immutable.Vector$;
import scala.collection.package$;
import scala.concurrent.duration.FiniteDuration;
import scala.concurrent.duration.package;
import scala.reflect.ClassTag$;
import scala.runtime.AbstractFunction1;
import scala.runtime.BoxesRunTime;

// Referenced classes of package org.openjdk.jmh.samples:
//            Centis$, Centis, implicits$, implicits

public class DurationConvertTest
{

    public Vector data()
    {
        return data;
    }

    public Vector centiData()
    {
        return centiData;
    }

    public Vector intCentiData()
    {
        return intCentiData;
    }

    public int[] intToArray()
    {
        return (int[])intCentiData().toArray(ClassTag$.MODULE$.Int());
    }

    public int[] centiBreakout()
    {
        return (int[])centiData().map(new Serializable() {

            public final int apply(int x$2)
            {
                return x$2;
            }

            public final volatile Object apply(Object v1)
            {
                return BoxesRunTime.boxToInteger(apply(((Centis)v1).cs()));
            }

            public static final long serialVersionUID = 0L;

        }
, package$.MODULE$.breakOut(Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Int())));
    }

    public int[] testToMillis()
    {
        return (int[])((TraversableOnce)data().map(new Serializable() {

            public final int apply(FiniteDuration x$3)
            {
                return (int)x$3.toMillis();
            }

            public final volatile Object apply(Object v1)
            {
                return BoxesRunTime.boxToInteger(apply((FiniteDuration)v1));
            }

            public static final long serialVersionUID = 0L;

        }
, Vector$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.Int());
    }

    public int[] testToHundredths()
    {
        return (int[])((TraversableOnce)data().map(new Serializable() {

            public final int apply(FiniteDuration x$4)
            {
                return (int)implicits.LilaPimpedFiniteDuration..MODULE$.toHundredths$extension(implicits$.MODULE$.LilaPimpedFiniteDuration(x$4));
            }

            public final volatile Object apply(Object v1)
            {
                return BoxesRunTime.boxToInteger(apply((FiniteDuration)v1));
            }

            public static final long serialVersionUID = 0L;

        }
, Vector$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.Int());
    }

    public DurationConvertTest()
    {
        data = ((TraversableOnce)scala.package$.MODULE$.Range().apply(0, 30).map(new Serializable() {

            public final FiniteDuration apply(int x$1)
            {
                return (new scala.concurrent.duration.package.DurationInt(scala.concurrent.duration.package$.MODULE$.DurationInt(x$1))).millis();
            }

            public final volatile Object apply(Object v1)
            {
                return apply(BoxesRunTime.unboxToInt(v1));
            }

            public static final long serialVersionUID = 0L;

        }
, IndexedSeq$.MODULE$.canBuildFrom())).toVector();
        centiData = ((TraversableOnce)scala.package$.MODULE$.Range().apply(0, 30).map(Centis$.MODULE$, IndexedSeq$.MODULE$.canBuildFrom())).toVector();
        intCentiData = scala.package$.MODULE$.Range().apply(0, 30).toVector();
    }

    private final Vector data;
    private final Vector centiData;
    private final Vector intCentiData;
}
