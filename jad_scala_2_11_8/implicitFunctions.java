// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.Option;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitFunctions$

public final class implicitFunctions
{
    public static final class ImplicitAnyVal
    {

        public Option oa()
        {
            return oa;
        }

        public boolean bar()
        {
            return .MODULE..extension(oa());
        }

        public int hashCode()
        {
            return .MODULE..extension(oa());
        }

        public boolean equals(Object x$1)
        {
            return .MODULE..extension(oa(), x$1);
        }

        private final Option oa;

        public ImplicitAnyVal(Option oa)
        {
            this.oa = oa;
            super();
        }
    }

    public static class ImplicitAnyVal.
    {

        public final boolean bar$extension(Option $this)
        {
            return $this.isDefined();
        }

        public final int hashCode$extension(Option $this)
        {
            return $this.hashCode();
        }

        public final boolean equals$extension(Option $this, Object x$1)
        {
            boolean flag;
            if(x$1 instanceof ImplicitAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            Option option = x$1 != null ? ((ImplicitAnyVal)x$1).oa() : null;
            $this;
            if($this != null) goto _L4; else goto _L3
_L3:
            JVM INSTR pop ;
            if(option == null) goto _L6; else goto _L5
_L4:
            option;
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

        public Option oa()
        {
            return oa;
        }

        public boolean bar()
        {
            return oa().isDefined();
        }

        private final Option oa;

        public ImplicitStandard(Option oa)
        {
            this.oa = oa;
            super();
        }
    }

    public static final class ImplicitInlineAnyVal
    {

        public Option oa()
        {
            return oa;
        }

        public boolean bar()
        {
            return .MODULE..extension(oa());
        }

        public int hashCode()
        {
            return .MODULE..extension(oa());
        }

        public boolean equals(Object x$1)
        {
            return .MODULE..extension(oa(), x$1);
        }

        private final Option oa;

        public ImplicitInlineAnyVal(Option oa)
        {
            this.oa = oa;
            super();
        }
    }

    public static class ImplicitInlineAnyVal.
    {

        public final boolean bar$extension(Option $this)
        {
            return $this.isDefined();
        }

        public final int hashCode$extension(Option $this)
        {
            return $this.hashCode();
        }

        public final boolean equals$extension(Option $this, Object x$1)
        {
            boolean flag;
            if(x$1 instanceof ImplicitInlineAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            Option option = x$1 != null ? ((ImplicitInlineAnyVal)x$1).oa() : null;
            $this;
            if($this != null) goto _L4; else goto _L3
_L3:
            JVM INSTR pop ;
            if(option == null) goto _L6; else goto _L5
_L4:
            option;
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

        public static final ImplicitInlineAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitInlineAnyVal.();
        }

        public ImplicitInlineAnyVal.()
        {
        }
    }


    public static Option toInlineAnyVal(Option option)
    {
        return implicitFunctions$.MODULE$.toInlineAnyVal(option);
    }

    public static Option toAnyVal(Option option)
    {
        return implicitFunctions$.MODULE$.toAnyVal(option);
    }

    public static ImplicitStandard toStandard(Option option)
    {
        return implicitFunctions$.MODULE$.toStandard(option);
    }
}
