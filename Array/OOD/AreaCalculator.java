/*• S – Single responsibility principle 一个类应该有且只有一个去改变他的理由,这意味着一个类应该只有一项工作。
• O – Open close principle 对象或实体应该对扩展开放,对修改封闭 (Open to extension, close to modification)。
• L – Liskov substitution principle 任何一个子类或派生类应该可以替换它们的基类或父类
• I – Interface segregation principle 不应该强迫一个类实现它用不上的接口
• D – Dependency inversion principle 抽象不应该依赖于具体实现,具体实现应该依赖于抽象*/


public class AreaCalculator{
    public float calculateArea(ShapeInterface s){
        //calculate area
    }
}
Interface ShapeInterface{
    public float area{

    }
}

public class Retangle implements ShapeInterface{
    private float length;
    private float width;
    public float area(){
        return length*width;
    }
}
public class Triangle implements ShapeInterface{
    private float height;
    private float width;
    public float area(){
        return (height*width)/2;
    }
}