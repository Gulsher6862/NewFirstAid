package com.example.firstaid;

public class quiz_model {

    String id, que, opt1, opt2, opt3, ans;

    public quiz_model(String id, String que, String opt1, String opt2, String opt3, String ans) {
        this.id = id;
        this.que = que;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.ans = ans;
    }

    public String getId() {
        return id;
    }

    public String getQue() {
        return que;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getAns() {
        return ans;
    }
}
