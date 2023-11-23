package task1;

import java.util.Date;

public abstract class A {
    String varA1 = "aaa";
    int varA2;

    public int getVarA2() {
        return varA2;
    }

    public String getVarA1() {
        return varA1;
    }

    public void setVarA1(String varA1) {
        this.varA1 = varA1;
    }

    public void setVarA2(int varA2) {
        if (varA2 < 0) varA2 = 0;
        if (varA2 >= 100) varA2 = 99;
        this.varA2 = varA2;
    }

    public int foo(Date dt){

    }

    public void buzz(){

    }
}
