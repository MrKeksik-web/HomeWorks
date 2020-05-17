package FirstHomeWorks.First;

public class Pair<T1,T2> {
    private T1 value1;
    private T2 value2;

    public Pair(T1 value1,T2 value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public void setValue1(T1 value){
        this.value1 = value;
    }

    public void setValue2(T2 value){
        this.value2 = value;
    }

    public Class getType1(){
        return value1.getClass();
    }

    public Class getType2(){
        return value2.getClass();
    }
}
