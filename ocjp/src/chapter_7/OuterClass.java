package chapter_7;

public class OuterClass {
    private static String outerStatic = "Outer Static";
    
    private String outerField = "Outer Field";
    
    private static String doOuterStaticMethod() {
        return "Outer Static Method";
    }
    
    private String doOuterMethod() {
        return "Outer Method";
    }

    public static class StaticInnerClass {
        public String getOuterStatic() {
            return outerStatic;
        }

        public String doOuterStaticMethod() {
            return OuterClass.doOuterStaticMethod();
        }
    }

    public class InnerClass {
        public String getOuterStatic() {
            return outerStatic;
        }

        public String getOuterField() {
            return outerField;
        }

        public String doOuterStaticMethod() {
            return OuterClass.doOuterStaticMethod();
        }

        // 外部クラスのメソッドに対するアクセス方法が分からないので
        // とりあえず名前を変えている。
        public String doOuterMethod1() {
            return  doOuterMethod();
        }
    }
}
