// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.runtime.BoxesRunTime;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitFunctions$

public final class implicitFunctions
{
    public static final class ImplicitAnyVal
    {

        public int i()
        {
            return i;
        }

        public int bar()
        {
            return .MODULE..extension(i());
        }

        public int hashCode()
        {
            return .MODULE..extension(i());
        }

        public boolean equals(Object x$1)
        {
            return .MODULE..extension(i(), x$1);
        }

        private final int i;

        public ImplicitAnyVal(int i)
        {
            this.i = i;
            super();
        }
    }

    public static class ImplicitAnyVal.
    {

        public final int bar$extension(int $this)
        {
            return $this + 2;
        }

        public final int hashCode$extension(int $this)
        {
            return BoxesRunTime.boxToInteger($this).hashCode();
        }

        public final boolean equals$extension(int $this, Object x$1)
        {
            boolean flag;
            if(x$1 instanceof ImplicitAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            int i = ((ImplicitAnyVal)x$1).i();
            if($this != i) goto _L2; else goto _L3
_L3:
            true;
              goto _L4
_L2:
            false;
_L4:
            return;
        }

        public static final ImplicitAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitAnyVal.();
        }

        public ImplicitAnyVal.()
        {
        }
    }

    public static final class ImplicitStandard
    {

        public int i()
        {
            return i;
        }

        public int bar()
        {
            return i() + 2;
        }

        private final int i;

        public ImplicitStandard(int i)
        {
            this.i = i;
            super();
        }
    }

    public static final class ImplicitInlineAnyVal
    {

        public int i()
        {
            return i;
        }

        public int bar()
        {
            return .MODULE..extension(i());
        }

        public int hashCode()
        {
            return .MODULE..extension(i());
        }

        public boolean equals(Object x$1)
        {
            return .MODULE..extension(i(), x$1);
        }

        private final int i;

        public ImplicitInlineAnyVal(int i)
        {
            this.i = i;
            super();
        }
    }

    public static class ImplicitInlineAnyVal.
    {

        public final int bar$extension(int $this)
        {
            return $this + 2;
        }

        public final int hashCode$extension(int $this)
        {
            return BoxesRunTime.boxToInteger($this).hashCode();
        }

        public final boolean equals$extension(int $this, Object x$1)
        {
            boolean flag;
            if(x$1 instanceof ImplicitInlineAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            int i = ((ImplicitInlineAnyVal)x$1).i();
            if($this != i) goto _L2; else goto _L3
_L3:
            true;
              goto _L4
_L2:
            false;
_L4:
            return;
        }

        public static final ImplicitInlineAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitInlineAnyVal.();
        }

        public ImplicitInlineAnyVal.()
        {
        }
    }


    public static int toInlineAnyVal(int i)
    {
        return implicitFunctions$.MODULE$.toInlineAnyVal(i);
    }

    public static int toAnyVal(int i)
    {
        return implicitFunctions$.MODULE$.toAnyVal(i);
    }

    public static ImplicitStandard toStandard(int i)
    {
        return implicitFunctions$.MODULE$.toStandard(i);
    }
}
