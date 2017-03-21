// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DurationConvertTest.scala

package org.openjdk.jmh.samples;

import scala.concurrent.duration.FiniteDuration;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicits$

public final class implicits
{
    public static final class LilaPimpedFiniteDuration
    {

        public FiniteDuration self()
        {
            return self;
        }

        public long toHundredths()
        {
            return .MODULE..extension(self());
        }

        public int hashCode()
        {
            return .MODULE..extension(self());
        }

        public boolean equals(Object x$1)
        {
            return .MODULE..extension(self(), x$1);
        }

        private final FiniteDuration self;

        public LilaPimpedFiniteDuration(FiniteDuration self)
        {
            this.self = self;
            super();
        }
    }

    public static class LilaPimpedFiniteDuration.
    {

        public final long toHundredths$extension(FiniteDuration $this)
        {
            return $this.toMillis() / 10L;
        }

        public final int hashCode$extension(FiniteDuration $this)
        {
            return $this.hashCode();
        }

        public final boolean equals$extension(FiniteDuration $this, Object x$1)
        {
            FiniteDuration finiteduration;
            boolean flag;
            if(x$1 instanceof LilaPimpedFiniteDuration)
                flag = true;
            else
                flag = false;
            if(!flag)
                break MISSING_BLOCK_LABEL_67;
            finiteduration = x$1 != null ? ((LilaPimpedFiniteDuration)x$1).self() : null;
            $this;
            if($this != null)
                break MISSING_BLOCK_LABEL_49;
            JVM INSTR pop ;
            if(finiteduration != null)
                break MISSING_BLOCK_LABEL_61;
            break MISSING_BLOCK_LABEL_57;
            finiteduration;
            equals();
            JVM INSTR ifeq 61;
               goto _L1 _L2
_L1:
            break MISSING_BLOCK_LABEL_57;
_L2:
            break MISSING_BLOCK_LABEL_61;
            if(false)
                break MISSING_BLOCK_LABEL_67;
            break MISSING_BLOCK_LABEL_65;
            if(true)
                break MISSING_BLOCK_LABEL_67;
            return true;
            return false;
        }

        public static LilaPimpedFiniteDuration. MODULE$;

        static 
        {
            new LilaPimpedFiniteDuration.();
        }

        public LilaPimpedFiniteDuration.()
        {
            MODULE$ = this;
        }
    }


    public static FiniteDuration LilaPimpedFiniteDuration(FiniteDuration finiteduration)
    {
        return implicits$.MODULE$.LilaPimpedFiniteDuration(finiteduration);
    }
}
