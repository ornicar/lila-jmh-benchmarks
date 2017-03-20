// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.runtime.BoxesRunTime;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses$

public final class implicitClasses
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

    public static final class ImplicitInlineFunAnyVal
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

        public ImplicitInlineFunAnyVal(int i)
        {
            this.i = i;
            super();
        }
    }

    public static class ImplicitInlineFunAnyVal.
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
            if(x$1 instanceof ImplicitInlineFunAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            int i = ((ImplicitInlineFunAnyVal)x$1).i();
            if($this != i) goto _L2; else goto _L3
_L3:
            true;
              goto _L4
_L2:
            false;
_L4:
            return;
        }

        public static final ImplicitInlineFunAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitInlineFunAnyVal.();
        }

        public ImplicitInlineFunAnyVal.()
        {
        }
    }

    public static final class ImplicitInlineBothAnyVal
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

        public ImplicitInlineBothAnyVal(int i)
        {
            this.i = i;
            super();
        }
    }

    public static class ImplicitInlineBothAnyVal.
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
            if(x$1 instanceof ImplicitInlineBothAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            int i = ((ImplicitInlineBothAnyVal)x$1).i();
            if($this != i) goto _L2; else goto _L3
_L3:
            true;
              goto _L4
_L2:
            false;
_L4:
            return;
        }

        public static final ImplicitInlineBothAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitInlineBothAnyVal.();
        }

        public ImplicitInlineBothAnyVal.()
        {
        }
    }

    public static final class ImplicitInlineClassAnyVal
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

        public ImplicitInlineClassAnyVal(int i)
        {
            this.i = i;
            super();
        }
    }

    public static class ImplicitInlineClassAnyVal.
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
            if(x$1 instanceof ImplicitInlineClassAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            int i = ((ImplicitInlineClassAnyVal)x$1).i();
            if($this != i) goto _L2; else goto _L3
_L3:
            true;
              goto _L4
_L2:
            false;
_L4:
            return;
        }

        public static final ImplicitInlineClassAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitInlineClassAnyVal.();
        }

        public ImplicitInlineClassAnyVal.()
        {
        }
    }


    public static int ImplicitInlineClassAnyVal(int i)
    {
        return implicitClasses$.MODULE$.ImplicitInlineClassAnyVal(i);
    }

    public static int ImplicitInlineFunAnyVal(int i)
    {
        return implicitClasses$.MODULE$.ImplicitInlineFunAnyVal(i);
    }

    public static int ImplicitInlineBothAnyVal(int i)
    {
        return implicitClasses$.MODULE$.ImplicitInlineBothAnyVal(i);
    }

    public static int ImplicitAnyVal(int i)
    {
        return implicitClasses$.MODULE$.ImplicitAnyVal(i);
    }

    public static ImplicitStandard ImplicitStandard(int i)
    {
        return implicitClasses$.MODULE$.ImplicitStandard(i);
    }
}
