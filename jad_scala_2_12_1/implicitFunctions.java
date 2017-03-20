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
            Option option;
            boolean flag;
            if(x$1 instanceof ImplicitAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag)
                break MISSING_BLOCK_LABEL_67;
            option = x$1 != null ? ((ImplicitAnyVal)x$1).oa() : null;
            $this;
            if($this != null)
                break MISSING_BLOCK_LABEL_49;
            JVM INSTR pop ;
            if(option != null)
                break MISSING_BLOCK_LABEL_61;
            break MISSING_BLOCK_LABEL_57;
            option;
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

        public static ImplicitAnyVal. MODULE$;

        static 
        {
            new ImplicitAnyVal.();
        }

        public ImplicitAnyVal.()
        {
            MODULE$ = this;
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
            .MODULE.;
            Option option = oa();
            JVM INSTR ifnonnull 13;
               goto _L1 _L2
_L1:
            break MISSING_BLOCK_LABEL_11;
_L2:
            break MISSING_BLOCK_LABEL_13;
            throw null;
            return option.isDefined();
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
            Option option;
            boolean flag;
            if(x$1 instanceof ImplicitInlineAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag)
                break MISSING_BLOCK_LABEL_67;
            option = x$1 != null ? ((ImplicitInlineAnyVal)x$1).oa() : null;
            $this;
            if($this != null)
                break MISSING_BLOCK_LABEL_49;
            JVM INSTR pop ;
            if(option != null)
                break MISSING_BLOCK_LABEL_61;
            break MISSING_BLOCK_LABEL_57;
            option;
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

        public static ImplicitInlineAnyVal. MODULE$;

        static 
        {
            new ImplicitInlineAnyVal.();
        }

        public ImplicitInlineAnyVal.()
        {
            MODULE$ = this;
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
