package basicJavaPractice;

/**
 * inner class
 * non-static nested class (inner class)
 * member inner class
 * anonymous inner class
 * local inner class
 * static nested class
 * nested interface
 */

public class InnerClassPractice {
    private int data = 40;
    static int data1 = 10;
    static int data2 = 20;
    static class StaticInnerClass {
        void msg() {
            System.out.println("static inner class data = " + data1);
        }
    }

    static class StaticInnerClass1 {
        static void msg() {
            System.out.println("static inner class data = " + data2);
        }
    }

    public static void main(String[] args) {
        memberInnerClassEx();
        anonymousInnerClassEx();

        InnerClassPractice innerClassPractice = new InnerClassPractice();
        innerClassPractice.localInnerClassEx();

        staticNestedClassEx();

        nestedInterfaceEx();
    }

    private static void nestedInterfaceEx() {
        Showable.Message message = new Showable.Message() {
            @Override
            public void msg() {
                System.out.println("hello nested interface");
            }
        };
        message.msg();

        ClassInterface.Message classInterface = new ClassInterface.Message() {
            @Override
            public void msg() {
                System.out.println("hello nested class interface");
            }
        };
        classInterface.msg();
    }

    private static void staticNestedClassEx() {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.msg();

        StaticInnerClass1.msg();
    }

    void localInnerClassEx() {
        class Local {
            int value = 50;
            void msg() {
                System.out.println("local inner class data = " + data + " , " + value);
            }
        }
        Local local = new Local();
        local.msg();
    }

    private static void anonymousInnerClassEx() {
        Person p = new Person() {
            void eat() {
                System.out.println("nice fruits");
            }
        };
        p.eat();

        Eatable e = new Eatable() {
            @Override
            public void eat() {
                System.out.println("eatable nice fruits");
            }
        };
        e.eat();
    }

    private static void memberInnerClassEx() {
        InnerClassPractice innerClassPractice = new InnerClassPractice();
        InnerClassPractice.InnerMemberClass innerMemberClass = innerClassPractice.new InnerMemberClass();
        innerMemberClass.msg();
    }

    class InnerMemberClass {
        void msg() {
            System.out.println("data = " + data);
        }
    }
}


abstract class Person {
    abstract void eat();
}

interface Eatable {
    void eat();
}

interface Showable {
    void show();

    interface Message {
        void msg();
    }
}

class ClassInterface {
    interface Message {
        void msg();
    }
}