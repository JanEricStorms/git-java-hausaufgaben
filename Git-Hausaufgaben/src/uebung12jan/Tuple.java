package uebung12jan;

public class Tuple <T,U>{

    private T value1;
    private U value2;

    public Tuple(T value1, U value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public void set1(T value){
        this.value1 = value;
    }

    public void set2(U value){
        this.value2 = value;
    }

    public T get1(){
        return value1;
    }

    public U get2(){
        return value2;
    }

    public String toString(){
        return "Tupel (" + value1 + "|" + value2 + ")";
    }

    @Override
    public boolean equals(Object z){
        if(z instanceof Tuple<?,?>){
            return true;
        }else{
            return false;
        }
    }

//    @Override
//    public boolean equals(Object z){
//        if(z instanceof Tuple<?,?>){
//            if(this.value1 == ((Tuple<?, ?>) z).get1() && this.value2 == ((Tuple<?, ?>) z).get2()){
//                return true;
//            }
//        }
//
//        return false;
//
//    }
}
