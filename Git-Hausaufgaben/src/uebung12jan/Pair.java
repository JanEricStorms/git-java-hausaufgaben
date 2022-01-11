package uebung12jan;

public class Pair<T> {
    private T value1;
    private T value2;

    public Pair(T value1,T value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public void set1(T value){
        this.value1 = value;
    }

    public void set2(T value){
        this.value2 = value;
    }

    public T get1(){
        return value1;
    }

    public T get2(){
        return value2;
    }

    public String toString(){
        return "Pair (" + value1 + "|" + value2 + ")";
    }

    @Override
    public boolean equals(Object z){
        if(z instanceof Pair<?>){
            return true;
        }else{
            return false;
        }
    }

//    @Override
//    public boolean equals(Object z){
//        if(z instanceof Pair<?>){
//            if(this.value1 == ((Pair<?>) z).get1() && this.value2 == ((Pair<?>) z).get2()){
//                return true;
//            }
//        }
//
//        return false;
//
//    }
}
