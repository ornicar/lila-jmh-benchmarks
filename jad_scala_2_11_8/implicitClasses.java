// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitClassTest.scala

package org.openjdk.jmh.samples;

import scala.Option;

// Referenced classes of package org.openjdk.jmh.samples:
//            implicitClasses$

public final class implicitClasses
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

    public static final class ImplicitInlineFunAnyVal
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

        public ImplicitInlineFunAnyVal(Option oa)
        {
            this.oa = oa;
            super();
        }
    }

    public static class ImplicitInlineFunAnyVal.
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
            if(x$1 instanceof ImplicitInlineFunAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            Option option = x$1 != null ? ((ImplicitInlineFunAnyVal)x$1).oa() : null;
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

        public ImplicitInlineBothAnyVal(Option oa)
        {
            this.oa = oa;
            super();
        }
    }

    public static class ImplicitInlineBothAnyVal.
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
            if(x$1 instanceof ImplicitInlineBothAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            Option option = x$1 != null ? ((ImplicitInlineBothAnyVal)x$1).oa() : null;
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

        public ImplicitInlineClassAnyVal(Option oa)
        {
            this.oa = oa;
            super();
        }
    }

    public static class ImplicitInlineClassAnyVal.
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
            if(x$1 instanceof ImplicitInlineClassAnyVal)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            Option option = x$1 != null ? ((ImplicitInlineClassAnyVal)x$1).oa() : null;
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

        public static final ImplicitInlineClassAnyVal. MODULE$ = this;

        static 
        {
            new ImplicitInlineClassAnyVal.();
        }

        public ImplicitInlineClassAnyVal.()
        {
        }
    }


    public static Option ImplicitInlineClassAnyVal(Option option)
    {
        return implicitClasses$.MODULE$.ImplicitInlineClassAnyVal(option);
    }

    public static Option ImplicitInlineFunAnyVal(Option option)
    {
        return implicitClasses$.MODULE$.ImplicitInlineFunAnyVal(option);
    }

    public static Option ImplicitInlineBothAnyVal(Option option)
    {
        return implicitClasses$.MODULE$.ImplicitInlineBothAnyVal(option);
    }

    public static Option ImplicitAnyVal(Option option)
    {
        return implicitClasses$.MODULE$.ImplicitAnyVal(option);
    }

    public static ImplicitStandard ImplicitStandard(Option option)
    {
        return implicitClasses$.MODULE$.ImplicitStandard(option);
    }
}
