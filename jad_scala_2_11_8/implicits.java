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
            boolean flag;
            if(x$1 instanceof LilaPimpedFiniteDuration)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            FiniteDuration finiteduration = x$1 != null ? ((LilaPimpedFiniteDuration)x$1).self() : null;
            $this;
            if($this != null) goto _L4; else goto _L3
_L3:
            JVM INSTR pop ;
            if(finiteduration == null) goto _L6; else goto _L5
_L4:
            finiteduration;
            equals();
            JVM INSTR ifeq 61;
               goto _L6 _L5
_L6:
            if(true) goto _L7; else goto _L2
_L5:
            if(true) goto _L2; else goto _L7
_L7:
            true;
              goto _L8
_L2:
            false;
_L8:
            return;
        }

        public static final LilaPimpedFiniteDuration. MODULE$ = this;

        static 
        {
            new LilaPimpedFiniteDuration.();
        }

        public LilaPimpedFiniteDuration.()
        {
        }
    }


    public static FiniteDuration LilaPimpedFiniteDuration(FiniteDuration finiteduration)
    {
        return implicits$.MODULE$.LilaPimpedFiniteDuration(finiteduration);
    }
}
